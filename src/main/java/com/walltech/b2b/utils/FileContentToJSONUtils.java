package com.walltech.b2b.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class FileContentToJSONUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileContentToJSONUtils.class);
    private static final String shipperLine = "shipperLine";
    private static final String consigneeLine = "consigneeLine";
    private static final String notifyLine = "consigneeLine";

    public static JSONObject FileContentToJSON(String[] SHIPPER, String[] CONSIGNEE,
                                               String[] NORTIFY_PARTY, String pol, String pod, String MARKS) throws RuntimeException{
        JSONObject res = new JSONObject();
        res.put("shipper", putsContents(SHIPPER, shipperLine));
        res.put("consignee", putsContents(CONSIGNEE, consigneeLine));
        res.put("notify", putsContents(NORTIFY_PARTY, notifyLine));
        res.put("pol", pol);
        res.put("pod", pod);
        res.put("mark", MARKS);
        return res;
    }
    private static JSONObject putsContents(String temp[],String name) throws RuntimeException{
        JSONObject res = new JSONObject();
        int i = 1;
        for (String str : temp){
            res.put(name + i, str);
            i++;
        }
        return res;
    }
}
