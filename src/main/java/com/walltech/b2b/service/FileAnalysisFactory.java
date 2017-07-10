package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zeddwang on 2017/6/30.
 */
public interface FileAnalysisFactory {
    JSONObject analysisContents(StringBuffer contents);
}
