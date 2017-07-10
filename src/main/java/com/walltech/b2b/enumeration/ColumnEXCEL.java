package com.walltech.b2b.enumeration;

/**
 * Created by zeddwang on 2017/7/4.
 */
public enum ColumnEXCEL {
    SHIPPER("shipper", 5, 1),                            // 发件人
    CONSIGNEE("consignee", 9, 1),                        // 收件人
    NOTIFY("notify", 14, 1),                             // 通知人
    POL("pol", 23, 1),                                   // 起始港
    DESTIONATIONPlACE("destinationPlace",23 , 5),        // 收货地点
    POD("pod", 25, 1),                                   // 目的港
    MARK("mark", 29, 1),                                 // 唛头
    QUANTITY("quantityContract",29 , 5),                 // 件数包装
    CUBAGE("cubageContract", 29, 12),                    // 体积
    ENGLISNAME("cargoEnglishName", 29, 7),               // 英文品名
    WEIGTH("weightContract",29, 15);                     // 毛重

    private String name;
    private int row;
    private int cell;

    ColumnEXCEL(String name, int row, int cell) {
        this.name = name;
        this.row = row;
        this.cell = cell;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }
}
