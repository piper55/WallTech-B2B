package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.FileType;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public class AbstractIdentifyMachine<T>{
    protected FileType fileType;
    protected GetContentFactory getContentFactory;
    protected IdentifyContentsFactory  identifyContentsFactory;

    public String getContents(InputStream inputStream){
       return getContentFactory.getContents(inputStream);
    }

    public JSONObject identifyContents(T t){
        return identifyContentsFactory.identifyContents(t);
    }

    public void organizeData(String data, JSONObject res){}

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}
