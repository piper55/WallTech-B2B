package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zeddwang on 2017/7/6.
 */
public interface IdentifyContentsFactory<T>{
    JSONObject identifyContents(T t);
}
