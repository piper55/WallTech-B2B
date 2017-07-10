package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;

import javax.swing.text.BadLocationException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class GetWordContentImpl implements GetFileContentFactory {
    public JSONObject getFileContents(FileInputStream inputStream) throws IOException, BadLocationException {
        getAnalysis2(inputStream);
        return null;
    }
    /**
     * 读DOC文本
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static String getAnalysis1(FileInputStream inputStream) throws IOException {
        HWPFDocument document = new HWPFDocument(inputStream);
        String text = document.getDocumentText();
        System.out.println(text);
        document.close();
        return text;
    }

    /**
     * 读DOC表格
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static String getAnalysis2(FileInputStream inputStream) throws IOException{
        HWPFDocument document = new HWPFDocument(inputStream);
        Range range = document.getRange();
        TableIterator iterator = new TableIterator(range);
        while (iterator.hasNext()){
            Table tb = iterator.next();
            for (int i = 0; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);
                //迭代列，默认从0开始
                for (int j = 0; j < tr.numCells(); j++) {
                    TableCell td = tr.getCell(j);
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);
                        String s = para.text();
                        System.out.println(s);
                    }
                }
            }
        }
        document.close();
        return "";
    }
    /**
     * 判断是RTF还是DOC
     * @param inputStream
     * @return
     * @throws Exception
     */
    private boolean isRTFOrDOC(FileInputStream inputStream) throws Exception{

        byte[] bytes = new byte[5];
        inputStream.read(bytes, 0, bytes.length);
        StringBuffer header = new StringBuffer();
        for (byte b : bytes) {
            String hex=Integer.toHexString(b);
            if(hex.length()<2){// 两位以下补〇
                header.append('0');
            }
            header.append(hex);
        }
        boolean isRTF="7b5c727466".contentEquals(header);
        return isRTF;
    }
}
