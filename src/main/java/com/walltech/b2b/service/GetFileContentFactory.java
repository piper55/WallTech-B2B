package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.FileType;

import javax.swing.text.BadLocationException;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Created by zeddwang on 2017/6/26.
 */
public interface GetFileContentFactory {
    JSONObject getFileContents(FileInputStream inputStream) throws IOException, BadLocationException;
}
