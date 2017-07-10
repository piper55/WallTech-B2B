package com.walltech.b2b.service;

import com.walltech.b2b.enumeration.ColumnEXCEL;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public class GetExcelContentsImpl implements GetContentFactory{
    private static final Logger logger = LoggerFactory.getLogger(GetExcelContentsImpl.class);

    public String getContents(InputStream inputStream) {
        try {
            return getFileExcel(inputStream).toString();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
        } catch (InvalidFormatException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
    private StringBuffer getFileExcel(InputStream inputStream) throws RuntimeException, IOException, InvalidFormatException {
        StringBuffer contents = new StringBuffer();
        Workbook workbook = WorkbookFactory.create(inputStream);
        int sheetsNumbers = workbook.getNumberOfSheets();
        System.out.println(sheetsNumbers);
        for (int i =0; i< sheetsNumbers; i++){
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getLastRowNum() > 1){
                contents.append(getContents(sheet));
            }
        }
        return contents;
    }
    private StringBuffer getContents(Sheet sheet) throws RuntimeException {
        StringBuffer contents = new StringBuffer();
        Row tempRow = null;
        Cell tempCell = null;
        String temValue = "";
        for (int i = 0; i <= sheet.getLastRowNum(); i++){
            tempRow= sheet.getRow(i);
            int cellMax = tempRow.getLastCellNum();
            for (int j =0; j <= cellMax; j++){
                temValue = "";
                tempCell = tempRow.getCell(j);
                if (null != tempCell){
                    switch (tempCell.getCellTypeEnum()){
                        case NUMERIC:
                            double intValue = tempCell.getNumericCellValue();
                            temValue = Double.toString(intValue);
                            break;
                        case STRING:
                            temValue = tempCell.getStringCellValue();
                            break;
                    }
                    contents.append(temValue);
                }
            }
        }
        return contents;
    }
}
