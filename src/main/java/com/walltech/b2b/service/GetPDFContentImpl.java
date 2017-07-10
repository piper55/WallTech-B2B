package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.ColumnPDF;
import com.walltech.b2b.enumeration.FileType;
import com.walltech.b2b.utils.FileContentToJSONUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/6/26.
 */
public class GetPDFContentImpl implements GetFileContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetPDFContentImpl.class);
//    private static final String shipperStatic = "SHIPPER";
//    private static final String consigneeStatic = "CONSIGNEE";
//    private static final String notifyStatic = "NOTIFY";
//    private static final String polStatic = "POL";
//    private static final String podStatic = "POD";

    public JSONObject getFileContents(FileInputStream inputStream) {
        InputStream inputStream1 = inputStream;
        try{
            PDDocument document = PDDocument.load(inputStream1);
            PDPageTree pdPageTree = document.getPages();
            PDPage pdPage = pdPageTree.get(0);
            PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
            stripperByArea.setSortByPosition(true);
            Rectangle rectangle = new Rectangle(0, 68, 320, 458);
            String temp = getContentsByArea(stripperByArea, pdPage, rectangle,"basic");
            JSONObject res = new JSONObject();
            for (ColumnPDF value : ColumnPDF.values()){
                if (null == temp || "".equals(temp)){
                    continue;
                }
                temp = FileContentToJSONUtils.getPartContents(value.getStartPosition(),value.getEndPosition(),temp);
                FileContentToJSONUtils.FileContentToJSON(temp.split("\r\n"), value.getName(), res);
            }
            return res;

        }catch (IOException ex){
            logger.error(ex.getMessage());
        }

        return null;
    }

    public String getContentsByArea(PDFTextStripperByArea pdfTextStripperByArea,
                                    PDPage pdPage, Rectangle rectangle, String name) throws IOException {
        pdfTextStripperByArea.addRegion(name, rectangle);
        pdfTextStripperByArea.extractRegions(pdPage);
        return pdfTextStripperByArea.getTextForRegion(name);
    }

    private static String getPartContents(String templateStart, String contents){
        int start = contents.indexOf(templateStart);
        contents = contents.substring(start);
        return contents;
    }


    /** 暂时不要删除 **/

    //    public JSONObject getFileContents(FileInputStream inputStream) {
//        try {
//            PDDocument document = PDDocument.load(inputStream);
//            PDPageTree pdPageTree = document.getPages();
//            PDPage pdPage = pdPageTree.get(0);
//            PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
//            stripperByArea.setSortByPosition(true);
//            Rectangle rectangle = new Rectangle(0, 60, 310, 70);
//            //取数据
//            String[] SHIPPER = getContentsByArea(stripperByArea, pdPage, rectangle, shipperStatic).split("\r\n");
//            rectangle = new Rectangle(0, 138, 310, 75);
//            String[] CONSIGNEE = getContentsByArea(stripperByArea, pdPage, rectangle, consigneeStatic).split("\r\n");
//            rectangle = new Rectangle(0, 222, 310, 75);
//            String[] NORTIFY = getContentsByArea(stripperByArea, pdPage, rectangle, notifyStatic).split("\r\n");
//            rectangle = new Rectangle(183, 336, 133, 27);
//            String pol = getContentsByArea(stripperByArea, pdPage, rectangle, polStatic).replaceAll("\r\n", "");
//            rectangle = new Rectangle(183, 364, 182, 27);
//            String pod = getContentsByArea(stripperByArea, pdPage, rectangle, podStatic).replaceAll("\r\n", "");
//            document.close();
//            /** pdf 暂时不支持取唛头 **/
//            return  FileContentToJSONUtils.FileContentToJSON(SHIPPER,CONSIGNEE,NORTIFY,pol,pod,"");
//        } catch (Exception ex){
//            logger.error(ex.getMessage());
//        }
//        return null;
//    }

    //            // 依次取出收发通数据
//            String temp1 = getContentsByArea(stripperByArea, pdPage, rectangle, "basic");
//            String[] shipper = getPartContents("Shipper(Full Name & Address)(托运人):", temp1, "Consignee(收货人):")
//                    .split("\r\n");
//            String[] consinee = getPartContents("Consignee(收货人):", temp1, "Notify Party(通知人):").split("\r\n");
//            String[] noticy = getPartContents("Notify Party(通知人):", temp1).split("\r\n");
//            // 依次取出起运港，交货地
//            rectangle = new Rectangle(160,380,164,78);
//            String temp2 = getContentsByArea(stripperByArea, pdPage, rectangle, "pol");
//            String[] pol = getPartContents("Port of Loading(起运港):", temp2, "Place of Delivery(交货地):").split("\r\n");
//            String[] delivery = getPartContents("Place of Delivery(交货地):", temp2).split("\r\n");
//            // 取出目的港
//            rectangle = new Rectangle(0, 401, 164, 57);
//            String temp3 = getContentsByArea(stripperByArea, pdPage, rectangle, "pod");
//            String[] pod = temp3.split("\r\n");
//            // 唛头
//            rectangle = new Rectangle(0, 458, 150, 205);
//            String marks = getContentsByArea(stripperByArea, pdPage, rectangle, "marks");
//            String[] mark = getPartContents(")", marks).split("\r\n");
//            // 件数包装
//            rectangle = new Rectangle(150, 458, 99, 205);
//            String quantityContracts = getContentsByArea(stripperByArea,pdPage,rectangle, "quantityContract");
//            String[] quantityContract = getPartContents("包装)", quantityContracts).split("\r\n");
//            // 品名
//            rectangle = new Rectangle(249, 458, 143, 205);
//            String englishNames = getContentsByArea(stripperByArea, pdPage, rectangle, "EnglishName");
//            String[] englishName = getPartContents("品名)", englishNames).split("\r\n");
//            // 体积
//            rectangle = new Rectangle(474, 458, 92, 205);
//            String cubageContracts = getContentsByArea(stripperByArea, pdPage, rectangle, "cubageContracts");
//            String[] cubageContract =  getPartContents("立方米)", cubageContracts).split("\r\n");
//            // 毛重
//            rectangle = new Rectangle(382, 458, 92, 205);
//            String weights = getContentsByArea(stripperByArea, pdPage, rectangle,"weigths");
//            String[] weight = getPartContents("公斤)", weights).split("\r\n");
//            document.close();
//            return FileContentToJSONUtils.FileContentToJSON(shipper, consinee, noticy, pol, delivery, pod, mark, quantityContract, englishName, cubageContract, weight);
}
