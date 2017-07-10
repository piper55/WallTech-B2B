package com.walltech.b2b.entrance;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.FileType;
import com.walltech.b2b.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by zeddwang on 2017/7/4.
 */
public class FileAnalysisEntrance {
    private static final Logger logger = LoggerFactory.getLogger(FileAnalysisEntrance.class);

    public static JSONObject beginParsing(FileInputStream inputStream , FileType type) throws IOException, BadLocationException {
        try {
            GetFileContentFactory getFileContentFactory = null;
            switch (type){
                case DOC:
                    break;
                case DOCX:
                    break;
                case RTF:
                    getFileContentFactory = new GetRTFContentImpl();
                    break;
                case EXCEL:
                    getFileContentFactory = new GetExcelContentImpl();
                    break;
                case PDF:
                    getFileContentFactory = new GetPDFContentImpl();
                    break;
                default:
                    break;
            }
            return getFileContentFactory.getFileContents(inputStream);
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return null;
    }
}
