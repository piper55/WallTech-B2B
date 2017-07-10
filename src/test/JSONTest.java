import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSONObject;
import com.walltech.b2b.model.UserBean;

/**
 * About JSONTest
 *
 * Created by zedd on 2017/6/5.
 */
public class JSONTest {
    private static final int DEFAULT_LENGTH_LIST=4;

    public static void main(String[] args) {
//        String[] temp = {"1","2","3"};
//        List<String> tempCareer = new ArrayList<String>(4);
//        tempCareer.add("aaaaaaa");
//        tempCareer.add("vvvvvvvv");
//        tempCareer.add("ddddddddd");
//        UserBean user = new UserBean();
//        user.setSex('b');
//        user.setName("name");
//        user.setAge(11);
//        user.setAddress("century park");
//        user.setPhone(temp);
//        user.setCareer(tempCareer);
//        System.out.println(user.isActive());
//        System.out.println(JSON.toJSONString(user));
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("res",true);
//        if (true == (Boolean) jsonObject.get("res")){
//            System.out.println("sdsfsdf");
//        }
//        List<Integer> list = new ArrayList<Integer>(DEFAULT_LENGTH_LIST);
//        for (int i=0; i < 10; i++){
//            list.add(i);
//        }
//        System.out.println("success");
//        System.out.println();
//        Calendar calendar = Calendar.getInstance();
//        System.out.println(calendar.getTime());
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH);
//        int date = calendar.get(calendar.DATE);
//        calendar.clear();
//        calendar.set(year, month, date);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar.getTimeInMillis());
//        System.out.println(new Date().toString());
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(dateFormat.format(new Date()));
//        String temp1 = "asdf123";
//        System.out.println(Arrays.asList(temp1.split(",")));

//        String temp = "{\"data\":[{\"ETD\":1498492800000,\"actualBerthPlanPlace\":\"\",\"addressEIR\":\"\",\"advance\":false,\"agentEDI\":false,\"agentLevel\":\"\",\"agentPrice\":false,\"agentRefNo\":\"\",\"alsoNotify\":\"\",\"amount\":0,\"apCode\":\"\",\"apName\":\"\",\"bLEDI\":false,\"barge\":false,\"bargePOD\":\"\",\"bargePOL\":\"\",\"bargeVessel\":\"\",\"bargeVoyage\":\"\",\"berthPlanPlace\":\"\",\"blocked\":false,\"bookAgentChineseName\":\"\",\"bookAgentEnglishName\":\"\",\"booking\":false,\"bookingAgent\":0,\"bookingAgents\":\"\",\"bookingEDI\":false,\"bookingNo\":\"\",\"bookingRefuseNote\":\"\",\"bookingTerm\":\"\",\"cargoDesc\":\"WFSGSGSFSFS\",\"cargoDoc\":[],\"cargoId\":\"\",\"cargoLocalDesc\":\"\",\"cargoSource\":\"SC\",\"carrier\":0,\"carrierChineseName\":\"\",\"carrierEnglishName\":\"\",\"carrierId\":0,\"carrierShortName\":\"\",\"chargeCubage\":0,\"chargeWeight\":12,\"charges\":[],\"checkData\":false,\"clp\":[{\"containerNo\":\"\",\"eQid\":0,\"eQquantity\":1,\"eQsize\":\"20\",\"eQtype\":\"GP\",\"job\":{\"$ref\":\"$.data[0]\"},\"sealNo\":\"\",\"tenantId\":-1}],\"comission\":0,\"consigneeCode\":\"\",\"consigneeId\":0,\"contactEIR\":\"\",\"contactEmail\":\"158@163.com\",\"contactTelephone\":\"15862071073\",\"containerDesc\":\"\",\"containerLoadType\":\"FCL\",\"csrDepartment\":0,\"csrOffice\":0,\"csrUser\":4532,\"cubageActual\":12,\"cubageContract\":12,\"currency\":\"\",\"customClaim\":0,\"customerContact\":\"simon\",\"customerId\":18073,\"customerRefNo\":\"\",\"customsBroker\":0,\"customsInfo\":[],\"customsRemarks\":\"\",\"dc\":0,\"declareCustomsState\":0,\"delCode\":\"NGAPP\",\"designationAgent\":0,\"destPlace\":\"\",\"destinationAgent\":0,\"entrustChineseName\":\"\",\"entrustEnglishName\":\"\",\"estimateAccountsPayable\":0,\"estimateAccountsReceivable\":0,\"estimateGrossProfit\":0,\"express\":false,\"freightTerm\":\"\",\"freightTermHBL\":\"CFS-CY\",\"hSCODE\":\"\",\"hblNoNumber\":\"\",\"hds\":false,\"insidePacking\":\"\",\"insideQuantity\":0,\"international\":false,\"isAMS\":false,\"isBatch\":false,\"isCanceled\":false,\"isCustoms\":false,\"isDangerousGoods\":false,\"isHeating\":false,\"isInspectation\":false,\"isLandTrans\":false,\"isMaster\":false,\"isMultiplePickups\":false,\"isSelfDeliver\":false,\"isSignHBL\":false,\"isSignMBL\":false,\"isTranship\":false,\"isWarehousing\":false,\"isWmsInboundPrited\":false,\"jobNo\":\"HQSEAPP7600056\",\"joinFlagHBL\":false,\"joinFlagMBL\":false,\"key\":\"NXcgMiUUeZO4RZ-u2eebkQ\",\"loadingTerm\":\"\",\"lob\":\"SE\",\"localAgent\":0,\"marks\":\"NVS123\",\"masterAgent\":false,\"mbl\":\"\",\"mblNo5\":\"\",\"mblOnly\":false,\"measurements\":\"\",\"notifyCode\":\"\",\"notifyId\":0,\"notifyLine1\":\"SAME AS CONSIGNEE\",\"oceanFreightPrice\":0,\"oceanFreightQuantity\":0,\"oceanFreightType\":\"\",\"opDepartment\":18,\"opOffice\":26,\"opUser\":1292,\"orderNo\":\"HQSEAPP7600056\",\"packingChineseName\":\"\",\"packingCode\":\"PLT\",\"packingEnglishName\":\"\",\"packingType\":\"PLT\",\"payablesState\":0,\"paymentTermHBL\":\"CFS-CY\",\"paymentTermMBL\":\"PP\",\"phoneEIR\":\"\",\"planner\":0,\"plannerDepartment\":0,\"podCode\":\"NGAPP\",\"polCode\":\"NGAPP\",\"porPlace\":\"\",\"preverifyState\":0,\"priceNo\":\"\",\"priceOwner\":0,\"priceTier\":0,\"profit\":0,\"quantityActual\":12,\"quantityContract\":12,\"quotationNo\":\"\",\"receivableState\":0,\"relatedJob\":\"\",\"relatedJob2\":\"\",\"remarks\":\"\",\"remarksBooking\":\"\",\"remarksShipping\":\"\",\"retrievalKey\":\"HQSEAPP7600056\",\"sOC\":false,\"sailingDay\":\"\",\"sales\":5567,\"salesChannel\":\"\",\"salesDepartment\":0,\"salesOffice\":2,\"satisfiedRequests\":\"\",\"scNo\":\"\",\"secondVesselVoyage\":\"\",\"selfConsolidation\":false,\"shipperCode\":\"\",\"shipperId\":0,\"shutOut\":false,\"situation\":\"\",\"soNo\":\"\",\"state\":0,\"tenantEnglishName\":\"\",\"tenantId\":99,\"tenantName\":\"\",\"terminal\":\"\",\"teu\":0,\"thirdVesselVoyage\":\"\",\"transPortCode\":\"\",\"transferPort\":\"\",\"truckingInfo\":[],\"trustFromJob\":\"\",\"typeHBL\":0,\"typeMBL\":0,\"vessel\":\"\",\"vesselCode\":\"\",\"via\":\"\",\"viaChineseName\":\"\",\"viaEnglishName\":\"\",\"virtualHBL\":false,\"voyageFlight\":\"\",\"warehouseNo\":\"\",\"warehouseNoFormat\":\"\",\"weightActual\":12,\"weightContract\":12,\"yardCode\":\"\"}]}";
//        JSONObject jsonObject = JSON.parseObject(temp);
//        System.out.println(jsonObject);
        String str = "abcdefghijklmn";
        System.out.println(str.indexOf("abc") +"," + str.indexOf("ghijk"));
        System.out.println(str.charAt(3));
//        String[] t = "\r\nBOT ULUS.TAS.VE DIS.TIC.LTD.STI.\r\nACIBADEM CD.SAMFISTIGI SK. NO : 55/2\r\nACIBADEM - KADIKOY- ISTANBUL,TURKEY\r\nTEL : +90 216 339 6565 (PBX) FAX: +90 216 327 3535\r\nZIP:34718\r\nTAX ID NO.1810302660(KADIKOY)\r\n".split("\r\n");
//        System.out.println(t);
//
//        String tt = "宁波亚细亚集装箱货运有限公司 委托书ShipperYIWU GODSEND TRADE CO.,LTD\n" +
//                "ADD:ROOM 407,YINHAI INTERNATIONAL BUILDING,NO1377 CHOUZHOU NORTH ROAD CHOUCHENG STREET YIWU ZHEJIANG.\n" +
//                "TEL:0579-85299500 FAX:0579-85299553Booking NoteConsigneeVINI CONTAINER LINES PVT.LTD\n" +
//                "ADDRESS:OLD#26,NEW#49,1ST FLOOR,\n" +
//                "CORAL MERCHANT STREET,\n" +
//                "CHENNAI 600 001.INDIA.\n" +
//                "D:+91 44 49012312\n" +
//                "T:+91 44 49012345\n" +
//                "F:+91 44 49012333 EXT:30托运编号：AMSH16110238TO：Notify Party(Carrier not to be responsible for falfure to notify)FROM:吕圆SAME AS CONSIGNEETEL:FAX:87345538Pre carriage byPlace of receipt预配船期：2016-12-06Ocean vesselVoy.no备注：TO 巴士悦信，NYK 12.6 USD475/40' ALL IN EIS/PCS. 目的港申请14天Part of LoadingPort of DischargerSHANGHAI,CHINACHENNAI,INDIAPlace of DeliveryFinal DestinationCHENNAI,INDIAMarks & Nos. container seel No.No.of containers or Pkgs.Kind of Packages:Description of GoodsGross Weight (KGS)Measurement (CBM)N/M76 BALESMEMBRANCE FILTER AND PIMPS18000.0KGS68.0CBMFREIGHT PREPAIDCY/CY40'HQ×1TOTAL NO.CONTAINERS OR PACKAGES(IN WORDS)SAY SEVENTY-SIX ONLYFREIGHT & CHARGERevenue TonsRateprePrepaidCollectEx.ReatePrepaid atPayable atPlace and Date of IssureNINGBOTotal prepaid inNo.of Original B(s)Signed for the CarrierTHREE(3)DateBy";
//        String ttt = tt.toLowerCase();
//        System.out.println(ttt);
//        System.out.println(tt);

        String tttt= "sea freight shipping instructions\n" +
                "to: 东方国际物流(集团)有限公司\n" +
                "shipper(full name & address)(托运人):\n" +
                "consignee(收货人):\n" +
                "bot ulus.tas.ve dis.tic.ltd.sti.\n" +
                "acibadem cd.samfistigi sk. no : 55/2\n" +
                "acibadem - kadikoy- istanbul,turkey\n" +
                "tel : +90 216 339 6565 (pbx) fax: +90 216 327 3535\n" +
                "zip:34718\n" +
                "tax id no.1810302660(kadikoy)\n" +
                "notify party(通知人):\n" +
                "same as consignee\n" +
                "ocean vessel/voy(船名航次): port of loading(起运港):\n" +
                "ym welcome v.005w shanghai\n" +
                "part of discharge(卸货港): place of delivery(交货地):\n" +
                "istanbul istanbul\n" +
                "marks & nos quantity & packaging description of goods(品名) gross weight(kilos) measurement(cbm)\n" +
                "(标志和号码) (件数及包装) 毛重(公斤) 体积(立方米)\n" +
                "bhm 167 case enternal feeding bag 668.00 kgs 4.040 cbm\n";
        String ttttt = tttt.toLowerCase();
        String t = "Shipping Instructions";
        System.out.println(ttttt.indexOf(t.toLowerCase()));
        System.out.println(tttt.indexOf(t));
        System.out.println(tttt.substring(425,449));


        String xlsx = "宁波亚细亚集装箱货运有限公司 委托书ShipperYIWU GODSEND TRADE CO.,LTD\n" +
                "ADD:ROOM 407,YINHAI INTERNATIONAL BUILDING,NO1377 CHOUZHOU NORTH ROAD CHOUCHENG STREET YIWU ZHEJIANG.\n" +
                "TEL:0579-85299500 FAX:0579-85299553Booking NoteConsigneeVINI CONTAINER LINES PVT.LTD\n" +
                "ADDRESS:OLD#26,NEW#49,1ST FLOOR,\n" +
                "CORAL MERCHANT STREET,\n" +
                "CHENNAI 600 001.INDIA.\n" +
                "D:+91 44 49012312\n" +
                "T:+91 44 49012345\n" +
                "F:+91 44 49012333 " +
                "EXT:30" +
                "托运编号：AMSH16110238TO：Notify Party(Carrier not to be responsible for falfure to notify)FROM:" +
                "吕圆SAME AS CONSIGNEETEL:FAX:87345538Pre carriage byPlace of receipt" +
                "预配船期：2016-12-06Ocean vesselVoy.no备注：TO" +
                " 巴士悦信，NYK 12.6 USD475/40' ALL IN EIS/PCS. " +
                "目的港申请14天" +
                "Part of Loading" +
                "Port of Discharger" +
                "SHANGHAI," +
                "CHINACHENNAI,INDIA" +
                "Place of Delivery" +
                "Final DestinationCHENNAI," +
                "INDIAMarks & Nos. container seel No.No.of containers or Pkgs.Kind of Packages:" +
                "Description of GoodsGross " +
                "Weight (KGS)" +
                "Measurement (CBM)" +
                "N/M" +
                "76 BALESMEMBRANCE FILTER AND PIMPS" +
                "18000.0KGS" +
                "68.0CBM" +
                "FREIGHT PREPAIDCY/CY" +
                "40'HQ×1" +
                "TOTAL NO.CONTAINERS OR P" +
                "ACKAGES(IN WORDS)SAY SEVENTY-SIX " +
                "ONLYFREIGHT & CHARGERevenue TonsRateprePrepaidCollectEx.ReatePrepaid atPayable atPlace and Date of IssureNINGBOTotal prepaid" +
                " inNo.of Original B(s)Signed for the CarrierTHREE(3)DateBy";


        String rtftt = "托运人/SHIPPER:\n" +
                "SHANGHAI�BLOSSOM�INTERNATIONAL�TRADING�CO.,LTD.RM.202,Goldenland�Business�Bldg.No.773,Siping�Rd.Shanghai,ChinaTEL:+86-21-65023265�FAX:+86-21-65021512�货物托运单\n" +
                "SHIPPING ORDER收货人/CONSIGNEE:\n" +
                "COOLMA SAMOA LTD\n" +
                "FUGALEI STREET，SAVALALO APIA, SAMOA\n" +
                "TEL: 0685-33133联系人/ATTN:何小姐电话/TEL:65023265\n" +
                "传真/FAX:65021512委托单号/SIPPING ORDER NO.:SSK1609001通知人/NOTIFY PARTY:\n" +
                "SAME AS CONSIGNEE委托日期/BOOKING DATE:运输方式/TRANSPORTATION METHOD:BY VESSEL运输条款/PAYTYPE DESCRIPTION:CY TO CY船名VESSEL/航次VOYNO\n" +
                " 起运港/PORT OF LOADING\n" +
                "SHANGHAI,CHINA提单份数/NO. OF ORIGINAL B(S):3卸货港/PORT OF DISCHARGE\n" +
                "APIA,WESTERN SAMOA交货地点/PLACE OF DELIVERY\n" +
                "APIA,WESTERN SAMOA目的地/FINAL DESTINATION\n" +
                "标记与号码\n" +
                "MARKES&NO.件数和包装\n" +
                "PACKAGES品名\n" +
                "DESCRIPTION OF GOODS重量\n" +
                "GROSS WEIGHT体积\n" +
                "MEASUREMENT\n" +
                "                                   4X40'HQ (F.C.L) CY/CY                                         \n" +
                "N/M                                CAN BODY 206                        6200.00KGS  238.08CBM   \n" +
                "                                   SOT END                             2000.00KGS  5.6000CBM   \n" +
                "                  ---------                                            -----------  ----------   \n" +
                "                    66PLTS                                             8200.00KGS    243.680CBM  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "FREIGHT PREPAID件数大写:备注: \n" +
                "TO：朱丹小姐\n" +
                "  订11月3日船期，4*40HQ，\n" +
                " NYK� 4450/40HQ� 周四� VIA:BUSAN� 航程35天左右rmb:订舱费：360，THC:1195，文件费：400，封子费：40SHANGHAI�BLOSSOM�INTERNATIONAL�TRADING�CO.,LTD.RM.202,Goldenland�Business�Bldg.No.773,Siping�Rd.Shanghai,ChinaTEL:+86-21-65023265�FAX:+86-21-65021512�\n";

        String at = "ab:\ncdd\ncd";
        System.out.println(at.indexOf("\n",4));
        int start = at.indexOf("\n");
        char ac = at.charAt(start);
        System.out.println(ac);
        int p = 5;
        System.out.println(p += -1);
        System.out.println(tttt.indexOf("place of delivery(交货地):"));

    }
}
