package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnEXCEL;
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
public class GetExcelContentImpl implements GetFileContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetExcelContentImpl.class);

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
        Row row = null;
        for (ColumnEXCEL value : ColumnEXCEL.values()) {
            row = sheet.getRow(value.getRow());
            Cell cell = row.getCell(value.getCell());
            String tempValue = "";
            switch (cell.getCellTypeEnum()) {
                case STRING:
                    tempValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    tempValue = Double.toString(cell.getNumericCellValue());
                    break;
            }
            FileContentToJSONUtils.FileContentToJSON(tempValue, value.getName(), res);
        }
        return res;
    }

    private StringBuffer getAllContents(Sheet sheet) throws RuntimeException {
        StringBuffer contents = new StringBuffer();
        Row tempRow = null;
        Cell tempCell = null;
        String temValue = "";
        for (int i = 0; i <= sheet.getLastRowNum(); i++){
            tempRow= sheet.getRow(i);
            int cellMax = tempRow.getLastCellNum();
            for (int j =0; j <= cellMax; j++){
                tempCell = tempRow.getCell(j);
                if (null != tempCell){
                    temValue = tempCell.getStringCellValue();
                    if (!"".equals(temValue.trim())){
                       contents.append(temValue);
                    }
                }
            }
        }

        return contents;
    }

    /** 暂时不要删除 **/
    //        String tempSHIPPER = sheet.getRow(5).getCell(1).getStringCellValue();
//        String tempCONSIGNEE = sheet.getRow(9).getCell(1).getStringCellValue();
//        String NORTIFY_PARTY = sheet.getRow(14).getCell(1).getStringCellValue();
//        String pol = sheet.getRow(23).getCell(1).getStringCellValue();
//        String pod = sheet.getRow(23).getCell(5).getStringCellValue();
//        String devi = sheet.getRow(25).getCell(1).getStringCellValue();
//        String MARKS = sheet.getRow(29).getCell(1).getStringCellValue();
//        String quantityContract = sheet.getRow(29).getCell(5).getStringCellValue();
//        String cargoEnglishName = sheet.getRow(29).getCell(7).getStringCellValue();
//        String cubageContract = sheet.getRow(29).getCell(12).getStringCellValue() + "KGS";
//        String weightContract = sheet.getRow(29).getCell(15).getStringCellValue() + "CBM";
//
//        String SHIPPER[] = tempSHIPPER.trim().split("\n");
//        String CONSIGNEE[] = tempCONSIGNEE.trim().split("\n");
//        String NORTIFY[] = NORTIFY_PARTY.trim().split("\n");
//        return FileContentToJSONUtils.FileContentToJSON(SHIPPER,CONSIGNEE,NORTIFY,pol,pod,MARKS);
}
