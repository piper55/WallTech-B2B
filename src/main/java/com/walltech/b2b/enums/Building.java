package com.walltech.b2b.enums;

/**
 * Created by zedd on 2017/6/2.
 */
public enum  Building {
    A("a",1),B("b",2);
    private String name;
    private int index;

    private Building(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
