import com.walltech.b2b.model.Rectangle;
import com.walltech.b2b.model.Round;
import com.walltech.b2b.model.Shape;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.IOException;
import java.util.*;

/**
 * Created by zedd on 2017/6/13.
 */
public class ExtendsTest {

    public static void main(String[] args) {
        Shape shape = new Round();
        shape.soutl();
        shape = new Rectangle();
        shape.soutl();
        StringBuffer temp = new StringBuffer();
        temp.append("?");
        List<String> strings = new ArrayList<String>();
        Map<String, List<String>> tmp = new LinkedHashMap<String, List<String>>();
        strings.add("111");
        tmp.put("SSss", strings);
        tmp.put("111",strings);
        tmp.put("111a",strings);
        Iterator iterator = tmp.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            if (null != value){
                value = value.replaceAll("\\[", "").replaceAll("]","");
            }
            temp.append(key).append("=").append(value);
            if (iterator.hasNext()){
                temp.append("&");
            }
        }
        System.out.println(temp.toString());
    }
    private static String getContentsByArea(PDFTextStripperByArea pdfTextStripperByArea,
                                            PDPage pdPage, java.awt.Rectangle rectangle, String name) throws IOException {
        pdfTextStripperByArea.addRegion(name, rectangle);
        pdfTextStripperByArea.extractRegions(pdPage);
        return pdfTextStripperByArea.getTextForRegion(name);
    }
}
