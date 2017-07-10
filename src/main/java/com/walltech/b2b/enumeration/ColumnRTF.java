package com.walltech.b2b.enumeration;

/**
 * Created by zeddwang on 2017/7/5.
 */
public enum ColumnRTF {
    SHIPPER("shipper", "托运人/SHIPPER:", "�货物托运单"),                                                   // 发件人
    CONSIGNEE("consignee", "收货人/CONSIGNEE:", "通知人/NOTIFY PARTY:"),                                    // 收件人
    NOTIFY("notify", "通知人/NOTIFY PARTY:", "委托日期/BOOKING"),                                           // 通知人
    POL("pol", "起运港/PORT OF LOADING", "提单份数/NO."),                                                   // 起始港
    DESTIONATIONPlACE("destinationPlace", "交货地点/PLACE OF DELIVERY", "目的地/FINAL DESTINATION"),        // 收货地点
    POD("pod", "卸货港/PORT OF DISCHARGE", "交货地点/PLACE OF DELIVERY"),                                   // 目的港
    MARK("mark", "", ""),                                                                                  // 唛头
    QUANTITY("quantityContract", "", ""),                                                                  // 件数包装
    CUBAGE("cubageContract", "", ""),                                                                      // 体积
    ENGLISNAME("cargoEnglishName", "", ""),                                                                // 英文品名
    WEIGTH("weightContract", "", "");                                                                      // 毛重

    private String name;
    private String startPosition;
    private String endPosition;

    ColumnRTF(String name, String startPosition, String endPosition) {
        this.name = name;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }
}
