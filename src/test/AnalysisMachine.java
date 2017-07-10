import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.enumeration.FileType;
import com.walltech.b2b.service.AbstractIdentifyMachine;
import com.walltech.b2b.service.IdentifyMachineByText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by zeddwang on 2017/7/6.
 */
public class AnalysisMachine {
    private static final StringBuffer baseAddress = new StringBuffer("C:/Users/zeddwang/Desktop/new_demo/");
    private static final Logger logger = LoggerFactory.getLogger(AnalysisMachine.class);
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream(new File(baseAddress.append("BSYX151218264.pdf").toString()));
            AbstractIdentifyMachine machine = new IdentifyMachineByText();
            machine.setFileType(FileType.PDF);
            String data = machine.getContents(inputStream);
            if ("".equals(data)){
                return;
            }
            JSONObject res = machine.identifyContents(data);
            machine.organizeData(data, res);
            System.out.println(res);
            inputStream.close();
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
    }
}
