import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.service.GetExcelContentImpl;
import com.walltech.b2b.service.GetFileContentFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.BadLocationException;
import java.io.*;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class FileAnalysisTest {
    private static final StringBuffer baseAddress = new StringBuffer("C:/Users/zeddwang/Desktop/new_demo/");
    private static final Logger logger = LoggerFactory.getLogger(FileAnalysisTest.class);

    public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
        try{
            //Excle
            File file  = new File(baseAddress.append("111.xlsx").toString());
            FileInputStream inputStream = new FileInputStream(file);
            getFileExcle(inputStream);
            //GetFileContentFactory factory = new GetExcelContentImpl();
            //JSONObject jsonObject = factory.getFileContents(inputStream);
            //System.out.println(jsonObject);
            inputStream.close();
        }catch (RuntimeException e){
            logger.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //解析Excle
    private static JSONObject getFileExcle(InputStream inputStream) throws IOException, InvalidFormatException {
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

    //方法读取xls文件内容（）
    private static JSONObject getContents(Sheet sheet) throws IOException{
        JSONObject res = new JSONObject();
        Row tempRow = null;
        Cell tempCell = null;
        String temValue = "";
        for (int i = 0; i <= sheet.getLastRowNum(); i++){
            System.out.println("Row(" + i + ")");
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
                    System.out.println("cell("+ j + ")"+temValue);
                }
            }
        }
        return  res;
    }

}
