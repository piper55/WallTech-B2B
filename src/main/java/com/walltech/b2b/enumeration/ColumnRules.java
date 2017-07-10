package com.walltech.b2b.enumeration;

/**
 * Created by zeddwang on 2017/7/6.
 * ORC识别规则，identify为开始标记如果没有开始标记默认为没有该选项
 *             contentKeyword 为内容关键字识别（正确的内容）1
 *             secondKeyword 为次级内容识别关键字（包含部分需要向前或者向后截取一定字符）2
 *             endIdentify 为结束点标记截取中间内容（权重最低除收发通以外，出错率极高） 3
 *             在此规则之外的默认截取identify之后的30个字符；
 *             同一权重下的规则依照其顺序定其权重
 *             多个条件用','隔开
 */
public enum ColumnRules {
    SHIPPER("shipper","Shipper(Full Name & Address)(托运人):,发货人,托运人,Shipper,shipper发货人,发货人shipper,托运人/shipper,经营单位shipper",
            "",
            "",
            "Consignee(收货人):,收货人,收货人consignee,consignee收货人,收货人/consignee,收货人或指示consignee,consignee,Notify Party(Carrier not to be responsible for falfure to notify)"),
    CONSIGNEE("consignee","Consignee(收货人):,收货人,收货人consignee,consignee收货人,收货人/consignee,收货人或指示consignee,consignee,Notify Party(Carrier not to be responsible for falfure to notify)",
            "",
            "",
            "Notify Party(通知人):,通知人,通知人notify party，notify party通知人,通知人/notify party，notify party"),
    NOTIFY("notify","Notify Party(通知人):,通知人,通知人notify party,notify party通知人,通知人/notify party，notify party",
            "SAME AS CONSIGNEE",
            "",
            "Ocean Vessel/Voy(船名航次):,Port of Loading(起运港):,起运港/port of loading,起运港,出口港,装运港"),
    POL("pol","Port of Loading(起运港):,起运港/port of loading,起运港,出口港,装运港",
            "SHANGHAI,NINGBO,SHENZHEN,TIANJIN,QINGDAO,DALIAN",
            "",
            "Part of Discharge(卸货港):,卸货港/port of discharge,目的港,目的港port of discharge"),
    POD("pod","Part of Discharge(卸货港):,卸货港/port of discharge,目的港,目的港port of discharge",
            "",
            "",
            "Place of Delivery(交货地):,交货地点/place of delivery,交货地点 place of delivery"),
    DESTINATIONPLACE("destinationPlace","Place of Delivery(交货地):,交货地点/place of delivery,交货地点 place of delivery",
            "",
            "",
            ""),
    MARK("mark","标记与号码 markes&no.,标记唛头,唛头,Marks & Nos",
            "N/M,BHM",
            "",
            ""),
    QUANTITYCONTRACT("quantityContract","件数与包装 packages,件数及包装式样,件数",
            "",
            "CASE,CARTONS",
            ""),
    CARGOENGLISHNAME("cargoEnglishName","品名 description of goods,品名描述 description of goods,品名",
            "",
            "",
            ""),
    WEIGTHTCONTRACT("weightContract","重量 gross weight,毛重（公斤）,毛重",
            "",
            "KGS",
            ""),
    CUBAGECCONTRACT("cubageContract","体积 measurement,尺码（立方米）,体积",
            "",
            "CBM",
            ""),
    SEAEQ("20',30',40',",
            "",
            "20', 40'",
            "",
            ""),
    VESSEL("vessel,Voy",
            "",
            "V.,v.",
            "",
            ""),
    VOYAGEFlight("voyageFlight,Ocean Vessel",
            "",
            "",
            "V.,V.",
            "");

    private String name;
    private String identify;
    private String contentKeyword;
    private String secondIdentify;
    private String endIdentify;

    ColumnRules(String name, String identify, String contentKeyword, String secondIdentify, String endIdentify) {
        this.name = name;
        this.identify = identify;
        this.contentKeyword = contentKeyword;
        this.secondIdentify = secondIdentify;
        this.endIdentify = endIdentify;
    }

    public static ColumnRules getColumnRulesByName(String name){
        for (ColumnRules rules : ColumnRules.values()){
            if (name.equals(rules.name)){
                return rules;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getContentKeyword() {
        return contentKeyword;
    }

    public void setContentKeyword(String contentKeyword) {
        this.contentKeyword = contentKeyword;
    }

    public String getSecondIdentify() {
        return secondIdentify;
    }

    public void setSecondIdentify(String secondIdentify) {
        this.secondIdentify = secondIdentify;
    }

    public String getEndIdentify() {
        return endIdentify;
    }

    public void setEndIdentify(String endIdentify) {
        this.endIdentify = endIdentify;
    }
}
