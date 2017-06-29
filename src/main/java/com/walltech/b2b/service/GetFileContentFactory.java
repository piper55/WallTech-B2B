package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;

import java.io.FileInputStream;


/**
 * Created by zeddwang on 2017/6/26.
 */
public interface GetFileContentFactory {
    JSONObject getFileContents(FileInputStream inputStream);
}
