import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xerces.internal.parsers.XMLDocumentParser;
import com.sun.xml.internal.xsom.parser.XMLParser;
import com.walltech.b2b.service.GetExcleContentsImpl;
import com.walltech.b2b.service.GetFileContentFactory;
import org.apache.poi.POIDocument;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.xmlbeans.XmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.List;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class FileAnalysisTest {
    private static final StringBuffer baseAddress = new StringBuffer("C:/Users/zeddwang/Desktop/FileAnalysiDemo/");
    private static final Logger logger = LoggerFactory.getLogger(FileAnalysisTest.class);

    public static void main(String[] args) throws IOException, OpenXML4JException, XmlException {
        try{
            //Excle
            File file  = new File(baseAddress.append("EXCLE 系统导出格式兼容格式.xls").toString());
            FileInputStream inputStream = new FileInputStream(file);
            getFileExcle(inputStream);
            GetFileContentFactory factory = new GetExcleContentsImpl();
            JSONObject jsonObject = factory.getFileContents(inputStream);
            inputStream.close();
        }catch (RuntimeException e){
            logger.error(e.getMessage());
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
                tempCell = tempRow.getCell(j);
                if (null != tempCell){
                    temValue = tempCell.getStringCellValue();
                    if (!"".equals(temValue.trim())){
                        System.out.println("    cell(" + j + ")" +":" + temValue);
                    }
                }
            }
        }
        return  res;
    }

}
