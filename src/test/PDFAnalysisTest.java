import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.FileType;
import com.walltech.b2b.service.GetFileContentFactory;
import com.walltech.b2b.service.GetPDFContentImpl;
import org.apache.pdfbox.cos.*;
import org.apache.pdfbox.pdfwriter.COSWriter;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.color.PDPattern;
import org.apache.pdfbox.pdmodel.graphics.image.PDImage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.pattern.PDAbstractPattern;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.*;
import java.util.Map;
import java.util.Set;

/**
 * Created by zeddwang on 2017/6/27.
 */
public class PDFAnalysisTest {
    private static final Logger logger = LoggerFactory.getLogger(FileAnalysisTest.class);
    private static final StringBuffer baseAddress = new StringBuffer("C:\\Users\\zeddwang\\Desktop\\new_demo\\");

    public static void main(String[] args) {
        try {
            File file  = new File(baseAddress.append("1.pdf").toString());
            FileInputStream inputStream = new FileInputStream(file);

             PDDocument pdDocument =PDDocument.load(inputStream);
             //PDFParser  pdfParser = new PDFParser(new RandomAccessBuffer(inputStream));
            //pdfParser.parse();
            //PDDocument pdDocument = pdfParser.getPDDocument();

             //获取页码
//            int pages = pdDocument.getNumberOfPages();
//            // 读文本内容
//            PDFTextStripper stripper=new PDFTextStripper();
//            stripper.setSortByPosition(true);
//            stripper.setStartPage(1);
//            stripper.setEndPage(pages);
//            String content = stripper.getText(pdDocument);
//            //System.out.println(content);
//            //坐标区域读
            PDFTextStripperByArea stripperByArea = new PDFTextStripperByArea();
            stripperByArea.setSortByPosition(true);
            PDPageTree pdPageTree  =  pdDocument.getDocumentCatalog().getPages();
            PDPage firstPage = pdPageTree.get(0);
            Rectangle react = new Rectangle(0, 458, 640, 205);
            String value = getContentsByArea(stripperByArea, firstPage, react, "BSIC");
            //String[] shipper = getPartContents("Shipper(Full Name & Address)(托运人):", value, "Consignee(收货人):")
            //        .split("\r\n");
            //String[] consinee = getPartContents("Consignee(收货人):", value, "Notify Party(通知人):").split("\r\n");
            //String[] noticy = getPartContents("Notify Party(通知人):", value, "Ocean Vessel/Voy(船名航次):").split("\r\n");

            //pol
            //String[] pol = getPartContents("Port of Loading(起运港):", value, "Place of Delivery(交货地):").split("\r\n");
            //交货地点
            //String[] delivery = getPartContents("Place of Delivery(交货地):", value).split("\r\n");
            //pod
            //String[] pod = value.split("\r\n");

            // 委托件数

            // 委托毛重
            // String[] maozhong = getPartContents("公斤)", value).split("\r\n");
            // 委托体积
//            String[] tiji = getPartContents("立方米)", value).split("\r\n");
            // 英文品名
            //String[] englishName = getPartContents(")", value).split("\r\n");
            // 唛头
            //String[] maitou = getPartContents(")", value).split("\r\n");
            // 箱型

            // 箱种

            // 箱量
//
            System.out.println(value);
            pdDocument.close();

            /** 导出pdf处理 **/
//            GetFileContentFactory factory = new GetPDFContentImpl();
//            JSONObject res = factory.getFileContents(inputStream);
//            System.out.println(res);
            /** 图片pdf处理 **/
            /** 文档页面信息 **/
            //获取PDDocumentCatalog文档目录对象
//            PDDocumentCatalog catalog = pdDocument.getDocumentCatalog();
//            //获取文档页面PDPage列表
//            PDPageTree tree = catalog.getPages();
//            //文档页数
//            int pageNum = tree.getCount();
//            //遍历每一页
//            for( int i = 0; i < pageNum; i++ ){
//                //取得第i页
//                PDPage page = tree.get( i );
//                if( null != page ){
//                    PDResources resource = page.getResources();
//                    Map<String, PDImageXObject> imageMap = (Map<String, PDImageXObject>) resource.getCOSObject().entrySet();
//                    for (Map.Entry<String, PDImageXObject> imageEntry : imageMap.entrySet()){
//                        PDImageXObject image = imageEntry.getValue();
//                        System.out.println(image.getImage());
//                    }
//                    //获取页面图片信息
//                    PDXObject pdxObject = resource.getXObject(COSName.IMAGE);
//                    boolean t = resource.isImageXObject(COSName.IMAGE);
//                    System.out.println("aaaaa");
////                    for(Map.Entry<String,PDXObjectImage> me: imgs.entrySet()){
////                        //System.out.println(me.getKey());
////                        PDXObjectImage img = me.getValue();
////                        //保存图片，会自动添加图片后缀类型
////                        img.write2file( imgSavePath + count );
////                        count++;
////                    }
//                }
//            }
            //pdDocument.close();
            //System.out.println(getAnalysis1(inputStream));



            inputStream.close();
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }
    private static String getAnalysis1(FileInputStream inputStream) throws IOException {
        PDDocument document = PDDocument.load(inputStream);
        int pages = document.getNumberOfPages();
        PDFTextStripper stripper=new PDFTextStripper();
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pages);
        String content = stripper.getText(document);
        document.close();
        return content;
    }


    private static String getContentsByArea(PDFTextStripperByArea pdfTextStripperByArea,
                                            PDPage pdPage, Rectangle rectangle, String name) throws IOException {
        pdfTextStripperByArea.addRegion(name, rectangle);
        pdfTextStripperByArea.extractRegions(pdPage);
        return pdfTextStripperByArea.getTextForRegion(name);
    }

    private static String getPartContents(String templateStart, String contents, String templateEnd){
        int start = contents.indexOf(templateStart);
        int end = contents.indexOf(templateEnd);
        String resStr = contents.substring(start, end);
        return resStr;
    }

    private static String getPartContents(String templateStart, String contents){
        int start = contents.indexOf(templateStart);
        String resStr = contents.substring(start);
        return resStr;
    }
}
