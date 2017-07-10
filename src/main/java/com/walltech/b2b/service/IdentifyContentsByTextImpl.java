package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnRules;

import static com.walltech.b2b.enumeration.ColumnRules.WEIGTHTCONTRACT;


/**
 * Created by zeddwang on 2017/7/6.
 */
public class IdentifyContentsByTextImpl implements IdentifyContentsFactory<String>{

    private static char[] charNum = {'1','2','3','4','5','6','7','8','9','0'};
    private static String[] xiangLiang= {"GP","HC", "HQ"};
    public JSONObject identifyContents(String data) {
        String tempData = data.toLowerCase();
        int start,end = -1;
        String contentKeyword = "", startContents = "";
        JSONObject res = new JSONObject();
        ColumnRules[] columnRules = ColumnRules.values();
        for (int j = 0; j < columnRules.length; j++){
            /** 寻找开始结点**/
            startContents = getIndexOfStartPosition(columnRules[j], tempData);
            start = indexOfStrInData(startContents, tempData);
            /** 有开始点 **/
            if (!"".equals(startContents)){
                /** 寻找内容关键字 **/
                contentKeyword = getIndexOfKeywordsPosition(columnRules[j],tempData);
                /** 有内容关键字 **/
                if ("" != contentKeyword){
                    start = indexOfStrInData(contentKeyword, tempData);
                    end = start + contentKeyword.length();
                }else {
                    /** 没有内容关键字,采用部分内容识别点 **/
                    contentKeyword = getIndexOfSecondPosition(columnRules[j], tempData);
                    if ("" != contentKeyword){
                        /** 此开始点实际为内容中间的部分点 **/
                        start = findLastContentKeyword(contentKeyword, tempData);
                        /** 内容最终开始位置**/
                        end = getEndOfContentsKeyword(start, tempData, columnRules[j], contentKeyword);
                        /** 内容最终结束位置 **/
                        start = deepIdentifyContents(columnRules[j], start, tempData);
                    }else {
                        /** 没有部分内容识别点，推算内容位置单词库查找**/
                        start = thirdIdentifyContents(columnRules[j], startContents, tempData, start);
                        end = thirdIdentifyContentsEnd(columnRules[j],tempData, start);
                        if (end < 0 ){
                            /** 根据规则终点截取点，寻找识别点 **/
                            end = getIndexOfEndPosition(columnRules[j],tempData);
                            if (end < 0){
                                /** 没有结束关键字，向后截取30个字符 **/
                                end = start + startContents.length() + 20;
                            }
                        }
                    }
                }
            }
            setStartAndEndPosition(res, columnRules[j].getName(), start, end);
        }
        return res;
    }

    /**
     * 没有部分内容识别点，推算内容位置单词库查找
     * @param rules
     * @param contents
     * @param data
     * @param initStart
     * @return
     */
    public int thirdIdentifyContents(ColumnRules rules, String contents, String data, int initStart) {
        int tempPosition = initStart;
        StringBuffer tempStr = new StringBuffer();
        switch (rules){
            case POD:
            case DESTINATIONPLACE:case VOYAGEFlight:case VESSEL:
                /** 先向前找看是否有内容**/
                tempPosition = findCharFromIndex(tempPosition, ':', -1, 3, data);
                if (tempPosition == initStart){
                    tempPosition = findCharFromIndex(tempPosition, ' ', -1, 3, data);
                }
                /** 前面有内容 **/
                if (tempPosition == initStart){
                    tempPosition = data.indexOf("\n", initStart + contents.length());
                    if (tempPosition == -1){
                        tempPosition = data.indexOf(":",initStart+contents.length());
                    }
                    if (tempPosition == -1){
                        tempPosition = tempPosition + contents.length();
                    }
                    return tempPosition + 1;
                }else {
                    /** 前面没有内容 **/
                    tempPosition = data.indexOf("\n",initStart + contents.length() + 2);
                    tempPosition = findCharFromIndex(tempPosition, ' ', -1, 0, data);
                    //没找到
                    if (tempPosition == initStart + contents.length() +1){
                    }
                    return tempPosition;
                }
            default:
                break;
        }
        return initStart;
    }
    public int thirdIdentifyContentsEnd(ColumnRules rules, String data, int initStart) {
        int end = -1, i = 0, tempInitStart = 0;
        StringBuffer tempStr = new StringBuffer();
        char tempChar = data.charAt(initStart);
        switch (rules){
            case POD: case DESTINATIONPLACE:case VOYAGEFlight:case VESSEL:
                while (i < 2){
                    while (' ' != tempChar){
                        initStart++;
                        tempChar = data.charAt(initStart);
                        if ('\r' == tempChar || '\n' == tempChar){
                            i = 2;
                            break;
                        }
                        tempStr.append(tempChar);
                    }
                    if (tempInitStart == 0)
                        tempInitStart = initStart;
                    if (haveThisWordInDatabase(tempStr.toString())){
                        break;
                    }
                    i++;
                    initStart++;
                    tempChar = data.charAt(initStart);
                }
                // 数据库查找，找不到
                return tempInitStart;
            default:
                break;
        }
        return end;
    }
    /**
     * 寻找开始截取点
     */
    public String getIndexOfStartPosition(ColumnRules rules, String data){
        if (null == rules.getIdentify() || "".equals(rules.getIdentify().trim())){
            return "";
        }
        String[] temp = rules.getIdentify().split(",");
        for (int i = 0; i < temp.length; i++){
            if (haveThisStr(temp[i], data)){
                return temp[i];
            }
        }
        return "";
    }

    /**
     * 关键字内容识别点
     * @param rules
     * @param data
     * @return
     */
    public String getIndexOfKeywordsPosition(ColumnRules rules, String data){
        if (null == rules.getContentKeyword() || "".equals(rules.getContentKeyword().trim())){
            return "";
        }
        String[] temp = rules.getContentKeyword().split(",");
        for (int i = 0; i < temp.length; i++){
            if (haveThisStr(temp[i], data)){
                return temp[i];
            }
        }
        return "";
    }

    /**
     * 第二识别点
     * @param rules
     * @param data
     * @return
     */
    public String getIndexOfSecondPosition(ColumnRules rules, String data){
        if (null == rules.getContentKeyword() || "".equals(rules.getSecondIdentify().trim())){
            return "";
        }
        String[] temp = rules.getSecondIdentify().split(",");
        for (int i = 0; i < temp.length; i++){
            if (haveThisStr(temp[i], data)){
                return temp[i];
            }
        }
        return "";
    }

    /**
     * 结束识别点
     * @param rules
     * @param data
     * @return
     */
    public int getIndexOfEndPosition(ColumnRules rules, String data){
        int position = -1;
        if (null == rules.getEndIdentify() || "".equals(rules.getEndIdentify().trim())){
            return position;
        }
        String[] temp = rules.getEndIdentify().split(",");
        for (int i = 0; i < temp.length; i++){
            if (haveThisStr(temp[i], data)){
                position = indexOfStrInData(temp[i], data);
                return position;
            }
        }
        return position;
    }
    /**
     * 设置返回结果
      * @param res
     * @param name
     * @param start
     * @param end
     */
    public void setStartAndEndPosition(JSONObject res, String name, int start, int end){
        if ( 0 >= start || 0 >= end || start >= end){
            res.put(name, null);
            return;
        }
        StringBuffer tempStr = new StringBuffer();
        tempStr.append(start).append(",").append(end);
        res.put(name, tempStr);
    }

    /**
     * 内容关键字（CBM,KGS,箱形，箱种，箱量）截取关键字开始点
     * @param rules
     * @param start
     * @param data
     * @return
     */
    public int deepIdentifyContents(ColumnRules rules, int start, String data){
//        /** 先判断是否真的为开始点（有可能是括号单位） **/
//        char c1 = data.charAt(start - 1);
//        char c2 = data.charAt(start + contentKeyword.length());
//        if ('(' == c1 && c2 == ')'){
//            start = data.indexOf(contentKeyword.toLowerCase(), start + contentKeyword.length() + 1);
//        }
        int temp = start - 1, i = 0;
        char tempChar = data.charAt(temp);
        switch (rules){
            case CUBAGECCONTRACT:case QUANTITYCONTRACT:case WEIGTHTCONTRACT:case SEAEQ:
                switch (rules){
                    case SEAEQ:
                        if ('X'== tempChar || 'x' == tempChar || '*' == tempChar){
                            tempChar = '.';
                        }
                        break;
                    default:
                        break;
                }
                while (!isNumber(tempChar)){
                    temp --;
                    tempChar = data.charAt(temp);
                }
                while (isNumber(tempChar)){
                    temp --;
                    tempChar = data.charAt(temp);
                }
                return temp;
            case VESSEL:
                return start;
            case VOYAGEFlight:
                while (tempChar != '\n' && i < 30){
                    temp--;
                    tempChar = data.charAt(temp);
                    i++;
                }
                return temp + 1;
            default:
                break;
        }
        return temp;
    }

    /**
     * 寻找箱形，箱种，箱量结束点
     * @return
     */
    private int getEndOfContentsKeyword(int initStart, String data, ColumnRules rules, String contentKeyword){
        int end = -1;
        switch (rules){
            case SEAEQ:
                for (String str : xiangLiang){
                    end  = data.indexOf(str, initStart);
                    if (end > 0){
                        end += str.length();
                        return end;
                    }
                }
                break;
            case VESSEL:
                char tempChar = data.charAt(initStart);
                while (' ' != tempChar){
                    initStart++;
                    tempChar = data.charAt(initStart);
                }
                return tempChar;
            case VOYAGEFlight:
                return initStart;
            case WEIGTHTCONTRACT:case QUANTITYCONTRACT:case CUBAGECCONTRACT:
                return initStart + contentKeyword.length();
            default:
                break;
        }
        return initStart;
    }

    private boolean haveThisWordInDatabase(String word){
        boolean res = false;
        return res;
    }

    /**
     * 查看内容关键字最后一个有效位置
     */
    private int findLastContentKeyword(String contentKeyword, String data){
         int temp = 0;
        int start = data.indexOf(contentKeyword.toLowerCase());
        while (temp != -1){
            temp = data.indexOf(contentKeyword.toLowerCase(), start + contentKeyword.length());
            if (temp > 0 ){
                start = temp;
            }
        }
        return start;
    }

    /**
     * data中是否有该字段search
     * @param search
     * @param data
     * @return
     */
    private boolean haveThisStr(String search, String data){
        return data.indexOf(search.toLowerCase()) > -1;
    }

    /**
     * search在data中的位置
     * @param search
     * @param data
     * @return
     */
    private int indexOfStrInData(String search, String data){
        return data.indexOf(search.toLowerCase());
    }

    /**
     * 是不是数字
     * @param c
     * @return
     */
    private boolean isNumber(char c){
        boolean res = false;
        for (char v : charNum){
            if (c == v || '.' == c){
                res = true;
                break;
            }
        }
        return res;
    }

    /**
     * 从某个位置向前向后寻找是否有某个字符
     * @param initStart 起始点
     * @param c         要找的字符
     * @param direct    方向 -1 前先找，1向后找
     * @param range     向前向后找的最大范围（0，默认为没有范围直到找到为止）
     * @param data      基础字符串
     * @return
     */
    private int findCharFromIndex(int initStart, char c, int direct, int range, String data){
        int position = initStart, tempRange = range ;
        char tempChar = data.charAt(position);
        if (tempRange <= 0){
            tempRange = 1;
        }
        while (tempRange > 0){
            if (c == tempChar){
                return position;
            }
            position += direct;
            tempChar = data.charAt(position);
            if (range > 0){
                tempRange--;
            }
        }
        return initStart;
    }

}
