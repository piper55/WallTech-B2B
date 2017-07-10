package com.walltech.b2b.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public class GetRTFContentsImpl implements GetContentFactory{
    private static final Logger logger = LoggerFactory.getLogger(GetPDFContentsImpl.class);
    public String getContents(InputStream inputStream) {
        try{
            RTFEditorKit rtfEditorKit = new RTFEditorKit();
            DefaultStyledDocument document  = new DefaultStyledDocument();
            rtfEditorKit.read(inputStream, document, 0);
            String text = new String(document.getText(0,document.getLength()).getBytes("ISO-8859-1"),"GB2312");
            return text;
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return null;
    }

}
