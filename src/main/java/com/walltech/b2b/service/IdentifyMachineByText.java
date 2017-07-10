package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnRules;
import com.walltech.b2b.enumeration.FileType;
import com.walltech.b2b.utils.FileContentToJSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public class IdentifyMachineByText extends AbstractIdentifyMachine<String> {
    private static final Logger logger = LoggerFactory.getLogger(IdentifyMachineByText.class);


    public IdentifyMachineByText(){
        identifyContentsFactory = new IdentifyContentsByTextImpl();
    }
    @Override
    public String getContents(InputStream inputStream) {
        return super.getContents(inputStream);
    }

    @Override
    public JSONObject identifyContents(String s) {
        JSONObject res = super.identifyContents(s);
        return res;
    }

    @Override
    public void setFileType(FileType fileType) {
        switch (fileType){
            case PDF:
                getContentFactory = new GetPDFContentsImpl();
                break;
            case EXCEL:
                getContentFactory = new GetExcelContentsImpl();
                break;
            case RTF:
                getContentFactory = new GetRTFContentsImpl();
                break;
            case DOCX:
            case DOC:
            default:
        }
    }

    @Override
    public void organizeData(String data, JSONObject res) {
        int start =-1 , end = -1;
        for (ColumnRules temp : ColumnRules.values()){
            String str = res.get(temp.getName())== null ? null : res.get(temp.getName()).toString();
            if (null == str || "".equals(str)){
                res.put(temp.getName(), str);
                continue;
            }
            start = Integer.valueOf(str.split(",")[0]);
            end = Integer.valueOf(str.split(",")[1]);
            str = data.substring(start,end);
            String[] strGroup = {};
            if (str.indexOf("\r\n") > -1){
                strGroup = str.split("\r\n");
            }else if (str.indexOf("\n") > -1){
                strGroup = str.split("\n");
            }else{
                strGroup = str.split("\r");
            }
            FileContentToJSONUtils.FileContentToJSON(strGroup, temp.getName(), res);
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
}
