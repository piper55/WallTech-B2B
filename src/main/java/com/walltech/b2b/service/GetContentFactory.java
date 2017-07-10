package com.walltech.b2b.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public interface GetContentFactory{
    String getContents(InputStream inputStream);
}
