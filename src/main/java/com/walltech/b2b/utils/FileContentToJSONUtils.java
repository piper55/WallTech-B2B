package com.walltech.b2b.utils;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnEXCEL;
import com.walltech.b2b.enumeration.ColumnPDF;
import com.walltech.b2b.enumeration.ColumnRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class FileContentToJSONUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileContentToJSONUtils.class);
    private static final String shipperLine = "shipperLine";
    private static final String consigneeLine = "consigneeLine";
    private static final String notifyLine = "notifyLine";

    /**
     * Excel 数据格式转换
     * @param data
     * @param column
     * @param res
     */
    public static void FileContentToJSON(String data, String column, JSONObject res){
        try {
            String staticVariable = null;
            if ("shipper".equals(column)){
                staticVariable = shipperLine;
            }else if ("consignee".equals(column)){
                staticVariable = consigneeLine;
            }else if ("notify".equals(column)){
                staticVariable = notifyLine;
            }else {
               res.put(column,data);
            }
            if (null != staticVariable){
                res.put(column, putsContents(data.split("\n"), staticVariable));
            }

        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }

    /**
     * PDF 数据格式转换
     * @param data
     * @param column
     * @param res
     */
    public static void FileContentToJSON(String[] data, String column, JSONObject res){
        try {
            String staticVariable = null;
            if ("shipper".equals(column)){
                staticVariable = shipperLine;
            }else if ("consignee".equals(column)){
                staticVariable = consigneeLine;
            }else if ("notify".equals(column)){
                staticVariable = notifyLine;
            }else {
                putsContexts2(data, column, res);
            }
            if (null != staticVariable){
                res.put(column, putsContents3(data, staticVariable));
            }
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }

    }

    /**
     * 字段截取
     * @param templateStart
     * @param contents
     * @param templateEnd
     * @return
     */
    public static String getPartContents(String templateStart, String contents, String templateEnd){
        int start = contents.indexOf(templateStart);
        int end = contents.indexOf(templateEnd);
        String resStr = contents.substring(start, end);
        return resStr;
    }


    private static JSONObject putsContents(String[] temp,String name) throws RuntimeException{
        JSONObject res = new JSONObject();
        int i = 1;
        for (String str : temp){
            res.put(name + i, str);
            i++;
        }
        return res;
    }

    private static JSONObject putsContexts2(String temp[], String name, JSONObject res) throws RuntimeException{
        StringBuffer tempRes = new StringBuffer();
        int i = 0;
        ColumnRules rules = ColumnRules.getColumnRulesByName(name);
        for (String tt : rules.getIdentify().split(",") ){
            if (tt.equals(temp[0].trim())){
                i++;
                break;
            }
        }
        if (i == 0){
            for (String tt : rules.getEndIdentify().split(",") ){
                if (tt.equals(temp[0].trim())){
                    i++;
                    break;
                }
            }
        }
        for (; i < temp.length; i++){
            if (i > 1){
                tempRes.append(",");
            }
            tempRes.append(temp[i]);
        }
        res.put(name, tempRes.toString());
        return res;
    }

    private static JSONObject putsContents3(String temp[],String name) throws RuntimeException{
        JSONObject res = new JSONObject();
        int i = 1, j = 0;
        StringBuffer tempStr = new StringBuffer();
        for (String str : temp){
            if (j == 0){
                int flag =0 ;
                if (shipperLine.equals(name)){
                    name = "shipper";
                }else if (consigneeLine.equals(name)){
                    name = "consignee";
                }else if (notifyLine.equals(name)){
                    name = "notify";
                }else {
                }
                ColumnRules rules = ColumnRules.getColumnRulesByName(name);
                for (String tt : rules.getIdentify().split(",") ){
                    if (tt.equals(temp[0])){
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1){
                    j++;
                    continue;
                }
                j++;
            }
            if (j > 0){
                if (i < 7){
                    res.put(name + i, str);
                    i++;
                }else{
                    tempStr.append(str);
                }
            }
            j++;
        }
        if (!"".equals(tempStr.toString())){
            res.put(name + "7", tempStr);
        }
        return res;
    }
}
