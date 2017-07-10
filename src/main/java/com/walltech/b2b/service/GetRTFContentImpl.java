package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnRTF;
import com.walltech.b2b.utils.FileContentToJSONUtils;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zeddwang on 2017/7/5.
 */
public class GetRTFContentImpl implements GetFileContentFactory {
    public JSONObject getFileContents(FileInputStream inputStream) throws IOException, BadLocationException {
        String text = getAnalysis3(inputStream);
        if (null == text || "".equals(text)){
            return null;
        }
        JSONObject res = new JSONObject();
        for (ColumnRTF value : ColumnRTF.values()){
            if ("".equals(value.getStartPosition())){
                continue;
            }
            String temp = FileContentToJSONUtils.getPartContents(value.getStartPosition(), text, value.getEndPosition());
            FileContentToJSONUtils.FileContentToJSON(temp.split("\n"), value.getName(), res);
        }
        return res;
    }

    /**
     * 读RTF文本
     * @param inputStream
     * @return
     * @throws IOException
     * @throws BadLocationException
     */
    private static String getAnalysis3(FileInputStream inputStream) throws IOException, BadLocationException {
        RTFEditorKit rtfEditorKit = new RTFEditorKit();
        DefaultStyledDocument document  = new DefaultStyledDocument();
        rtfEditorKit.read(inputStream, document, 0);
        String text = new String(document.getText(0,document.getLength()).getBytes("ISO-8859-1"),"GB2312");
        return text;
    }
}
