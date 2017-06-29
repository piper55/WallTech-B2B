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

        String temp = "{\"data\":[{\"ETD\":1498492800000,\"actualBerthPlanPlace\":\"\",\"addressEIR\":\"\",\"advance\":false,\"agentEDI\":false,\"agentLevel\":\"\",\"agentPrice\":false,\"agentRefNo\":\"\",\"alsoNotify\":\"\",\"amount\":0,\"apCode\":\"\",\"apName\":\"\",\"bLEDI\":false,\"barge\":false,\"bargePOD\":\"\",\"bargePOL\":\"\",\"bargeVessel\":\"\",\"bargeVoyage\":\"\",\"berthPlanPlace\":\"\",\"blocked\":false,\"bookAgentChineseName\":\"\",\"bookAgentEnglishName\":\"\",\"booking\":false,\"bookingAgent\":0,\"bookingAgents\":\"\",\"bookingEDI\":false,\"bookingNo\":\"\",\"bookingRefuseNote\":\"\",\"bookingTerm\":\"\",\"cargoDesc\":\"WFSGSGSFSFS\",\"cargoDoc\":[],\"cargoId\":\"\",\"cargoLocalDesc\":\"\",\"cargoSource\":\"SC\",\"carrier\":0,\"carrierChineseName\":\"\",\"carrierEnglishName\":\"\",\"carrierId\":0,\"carrierShortName\":\"\",\"chargeCubage\":0,\"chargeWeight\":12,\"charges\":[],\"checkData\":false,\"clp\":[{\"containerNo\":\"\",\"eQid\":0,\"eQquantity\":1,\"eQsize\":\"20\",\"eQtype\":\"GP\",\"job\":{\"$ref\":\"$.data[0]\"},\"sealNo\":\"\",\"tenantId\":-1}],\"comission\":0,\"consigneeCode\":\"\",\"consigneeId\":0,\"contactEIR\":\"\",\"contactEmail\":\"158@163.com\",\"contactTelephone\":\"15862071073\",\"containerDesc\":\"\",\"containerLoadType\":\"FCL\",\"csrDepartment\":0,\"csrOffice\":0,\"csrUser\":4532,\"cubageActual\":12,\"cubageContract\":12,\"currency\":\"\",\"customClaim\":0,\"customerContact\":\"simon\",\"customerId\":18073,\"customerRefNo\":\"\",\"customsBroker\":0,\"customsInfo\":[],\"customsRemarks\":\"\",\"dc\":0,\"declareCustomsState\":0,\"delCode\":\"NGAPP\",\"designationAgent\":0,\"destPlace\":\"\",\"destinationAgent\":0,\"entrustChineseName\":\"\",\"entrustEnglishName\":\"\",\"estimateAccountsPayable\":0,\"estimateAccountsReceivable\":0,\"estimateGrossProfit\":0,\"express\":false,\"freightTerm\":\"\",\"freightTermHBL\":\"CFS-CY\",\"hSCODE\":\"\",\"hblNoNumber\":\"\",\"hds\":false,\"insidePacking\":\"\",\"insideQuantity\":0,\"international\":false,\"isAMS\":false,\"isBatch\":false,\"isCanceled\":false,\"isCustoms\":false,\"isDangerousGoods\":false,\"isHeating\":false,\"isInspectation\":false,\"isLandTrans\":false,\"isMaster\":false,\"isMultiplePickups\":false,\"isSelfDeliver\":false,\"isSignHBL\":false,\"isSignMBL\":false,\"isTranship\":false,\"isWarehousing\":false,\"isWmsInboundPrited\":false,\"jobNo\":\"HQSEAPP7600056\",\"joinFlagHBL\":false,\"joinFlagMBL\":false,\"key\":\"NXcgMiUUeZO4RZ-u2eebkQ\",\"loadingTerm\":\"\",\"lob\":\"SE\",\"localAgent\":0,\"marks\":\"NVS123\",\"masterAgent\":false,\"mbl\":\"\",\"mblNo5\":\"\",\"mblOnly\":false,\"measurements\":\"\",\"notifyCode\":\"\",\"notifyId\":0,\"notifyLine1\":\"SAME AS CONSIGNEE\",\"oceanFreightPrice\":0,\"oceanFreightQuantity\":0,\"oceanFreightType\":\"\",\"opDepartment\":18,\"opOffice\":26,\"opUser\":1292,\"orderNo\":\"HQSEAPP7600056\",\"packingChineseName\":\"\",\"packingCode\":\"PLT\",\"packingEnglishName\":\"\",\"packingType\":\"PLT\",\"payablesState\":0,\"paymentTermHBL\":\"CFS-CY\",\"paymentTermMBL\":\"PP\",\"phoneEIR\":\"\",\"planner\":0,\"plannerDepartment\":0,\"podCode\":\"NGAPP\",\"polCode\":\"NGAPP\",\"porPlace\":\"\",\"preverifyState\":0,\"priceNo\":\"\",\"priceOwner\":0,\"priceTier\":0,\"profit\":0,\"quantityActual\":12,\"quantityContract\":12,\"quotationNo\":\"\",\"receivableState\":0,\"relatedJob\":\"\",\"relatedJob2\":\"\",\"remarks\":\"\",\"remarksBooking\":\"\",\"remarksShipping\":\"\",\"retrievalKey\":\"HQSEAPP7600056\",\"sOC\":false,\"sailingDay\":\"\",\"sales\":5567,\"salesChannel\":\"\",\"salesDepartment\":0,\"salesOffice\":2,\"satisfiedRequests\":\"\",\"scNo\":\"\",\"secondVesselVoyage\":\"\",\"selfConsolidation\":false,\"shipperCode\":\"\",\"shipperId\":0,\"shutOut\":false,\"situation\":\"\",\"soNo\":\"\",\"state\":0,\"tenantEnglishName\":\"\",\"tenantId\":99,\"tenantName\":\"\",\"terminal\":\"\",\"teu\":0,\"thirdVesselVoyage\":\"\",\"transPortCode\":\"\",\"transferPort\":\"\",\"truckingInfo\":[],\"trustFromJob\":\"\",\"typeHBL\":0,\"typeMBL\":0,\"vessel\":\"\",\"vesselCode\":\"\",\"via\":\"\",\"viaChineseName\":\"\",\"viaEnglishName\":\"\",\"virtualHBL\":false,\"voyageFlight\":\"\",\"warehouseNo\":\"\",\"warehouseNoFormat\":\"\",\"weightActual\":12,\"weightContract\":12,\"yardCode\":\"\"}]}";
        JSONObject jsonObject = JSON.parseObject(temp);
        System.out.println(jsonObject);
    }
}
