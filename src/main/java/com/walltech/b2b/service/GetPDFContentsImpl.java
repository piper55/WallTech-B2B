package com.walltech.b2b.service;

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
 * Created by zeddwang on 2017/7/6.
 */
public class GetPDFContentsImpl implements GetContentFactory {
    private static final Logger logger = LoggerFactory.getLogger(GetPDFContentsImpl.class);
    public String getContents(InputStream inputStream) {
        try {
            PDDocument document = PDDocument.load(inputStream);
            PDPageTree pdPageTree = document.getPages();
            PDPage pdPage = pdPageTree.get(0);
            PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
            stripperByArea.setSortByPosition(true);
            Rectangle rectangle = new Rectangle(0, 0, 320, 458);
            String temp = getContentsByArea(stripperByArea, pdPage, rectangle, "basic");
            rectangle = new Rectangle(0, 458, 640, 205);
            String temp2 = getContentsByArea(stripperByArea, pdPage, rectangle, "detail");
            return temp + temp2;
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
        return "";
    }

    public String getContentsByArea(PDFTextStripperByArea pdfTextStripperByArea,
                                    PDPage pdPage, Rectangle rectangle, String name) throws IOException {
        pdfTextStripperByArea.addRegion(name, rectangle);
        pdfTextStripperByArea.extractRegions(pdPage);
        return pdfTextStripperByArea.getTextForRegion(name);
    }
}
