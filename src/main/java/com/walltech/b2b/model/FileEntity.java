package com.walltech.b2b.model;

import com.alibaba.fastjson.JSONObject;

import java.io.InputStream;

/**
 * Created by zeddwang on 2017/6/26.
 */
public abstract class FileEntity {

    public JSONObject getFileContents(InputStream inputStream){

        return null;
    }
}
