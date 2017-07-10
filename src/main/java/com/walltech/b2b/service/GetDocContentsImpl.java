package com.walltech.b2b.service;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/7.
 */
public class GetDocContentsImpl implements GetContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetDocContentsImpl.class);
    public String getContents(InputStream inputStream) {
        try {
            StringBuffer text = new StringBuffer();
            HWPFDocument document = new HWPFDocument(inputStream);
            /** 先尝试读表格 **/
            Range range = document.getRange();
            TableIterator iterator = new TableIterator(range);
            if (!iterator.hasNext()){
                return document.getDocumentText();
            }
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
                            text.append(s);
                        }
                    }
                }
            }
        }catch (IOException ex){
            logger.error(ex.getMessage());
        }
        return null;
    }
}
