package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.utils.FileContentToJSONUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class GetExcleContentsImpl implements GetFileContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetExcleContentsImpl.class);

    public JSONObject getFileContents(FileInputStream inputStream) {
        try {
            return getFileExcle(inputStream);
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        } catch (InvalidFormatException e) {
           logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    private  JSONObject getFileExcle(InputStream inputStream) throws RuntimeException, IOException, InvalidFormatException {
        JSONObject res = new JSONObject();
        Workbook workbook = WorkbookFactory.create(inputStream);
        int sheetsNumbers = workbook.getNumberOfSheets();
        System.out.println(sheetsNumbers);
        for (int i =0; i< sheetsNumbers; i++){
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getLastRowNum() > 1){
                res = getContents(sheet);
            }
        }
        return res;
    }
    private JSONObject getContents(Sheet sheet) throws RuntimeException {
        JSONObject res = new JSONObject();
        String tempSHIPPER = sheet.getRow(2).getCell(0).getStringCellValue();
        String tempCONSIGNEE = sheet.getRow(8).getCell(0).getStringCellValue();
        String NORTIFY_PARTY = sheet.getRow(13).getCell(1).getStringCellValue();
        String pol = sheet.getRow(16).getCell(1).getStringCellValue();
        String pod = sheet.getRow(16).getCell(3).getStringCellValue();
        String MARKS = sheet.getRow(20).getCell(1).getStringCellValue();
        String SHIPPER[] = tempSHIPPER.trim().split("\n");
        String CONSIGNEE[] = tempCONSIGNEE.trim().split("\n");
        String NORTIFY[] = NORTIFY_PARTY.trim().split("\n");
        return FileContentToJSONUtils.FileContentToJSON(SHIPPER,CONSIGNEE,NORTIFY,pol,pod,MARKS);
    }
}
