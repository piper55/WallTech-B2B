package com.walltech.b2b.enumeration;

/**
 * Created by zeddwang on 2017/7/3.
 */
public enum  ColumnPDF {
    SHIPPER("shipper",0, 68, 320, 113, "Shipper(Full Name & Address)(托运人):", "Consignee(收货人):"),             // 发件人
    CONSIGNEE("consignee",0, 181, 320, 99, "Consignee(收货人):", "Notify Party(通知人):"),                            // 收件人
    NOTIFY("notify", 0, 266, 320, 118, "Notify Party(通知人):", "Port of Loading(起运港):"),                             // 通知人
    POL("pol", 160,380,164,39, "Port of Loading(起运港):", "Place of Delivery(交货地):"),                                  // 起始港
    DESTIONATIONPlACE("destinationPlace",160,419,164,39, "Place of Delivery(交货地):", "Part of Discharge(卸货港):"),      // 收货地点
    POD("pod", 0, 401, 164, 57, "Part of Discharge(卸货港):", ""),                               // 目的港
    MARK("mark", 0, 458, 150, 205, "号码)", ""),                                                 // 唛头
    QUANTITY("quantityContract",150, 458, 99, 205, "包装)", ""),                                 // 件数包装
    CUBAGE("cubageContract", 474, 458, 92, 205, "立方米)", ""),                                  // 体积
    ENGLISNAME("cargoEnglishName", 249, 458, 143, 205, "品名)", ""),                             // 英文品名
    WEIGTH("weightContract",382, 458, 92, 205, "公斤)", "");                                     // 毛重

    ColumnPDF(String name, int x, int y, int width, int height, String startPosition) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startPosition = startPosition;
    }

    ColumnPDF(String name, int x, int y, int width, int height, String startPosition, String endPosition) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private String startPosition;
    private String endPosition;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
