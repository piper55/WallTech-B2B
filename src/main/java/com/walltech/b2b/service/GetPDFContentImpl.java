package com.walltech.b2b.service;

import com.alibaba.fastjson.JSONObject;
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

/**
 * Created by zeddwang on 2017/6/26.
 */
public class GetPDFContentImpl implements GetFileContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetPDFContentImpl.class);
    private static final String shipperStatic = "SHIPPER";
    private static final String consigneeStatic = "CONSIGNEE";
    private static final String notifyStatic = "NOTIFY";
    private static final String polStatic = "POL";
    private static final String podStatic = "POD";

    public JSONObject getFileContents(FileInputStream inputStream) {
        try {
            PDDocument document = PDDocument.load(inputStream);
            PDPageTree pdPageTree = document.getPages();
            PDPage pdPage = pdPageTree.get(0);
            PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
            stripperByArea.setSortByPosition(true);
            Rectangle rectangle = new Rectangle(0, 60, 310, 70);
            //取数据
            String[] SHIPPER = getContentsByArea(stripperByArea, pdPage, rectangle, shipperStatic).split("\r\n");
            rectangle = new Rectangle(0, 138, 310, 75);
            String[] CONSIGNEE = getContentsByArea(stripperByArea, pdPage, rectangle, consigneeStatic).split("\r\n");
            rectangle = new Rectangle(0, 222, 310, 75);
            String[] NORTIFY = getContentsByArea(stripperByArea, pdPage, rectangle, notifyStatic).split("\r\n");
            rectangle = new Rectangle(183, 336, 133, 27);
            String pol = getContentsByArea(stripperByArea, pdPage, rectangle, polStatic).replaceAll("\r\n", "");
            rectangle = new Rectangle(183, 364, 182, 27);
            String pod = getContentsByArea(stripperByArea, pdPage, rectangle, podStatic).replaceAll("\r\n", "");
            document.close();
            /** pdf 暂时不支持取唛头 **/
            return  FileContentToJSONUtils.FileContentToJSON(SHIPPER,CONSIGNEE,NORTIFY,pol,pod,"");
        } catch (Exception ex){
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

}
