package com.walltech.b2b.model;

/**
 * Created by zedd on 2017/6/13.
 */
public class Round extends Shape {
    private  SchoolBean schoolBean;

    public SchoolBean getSchoolBean() {
        return schoolBean;
    }

    public void setSchoolBean(SchoolBean schoolBean) {
        this.schoolBean = schoolBean;
    }

    public void soutl(){
        System.out.println("Round!");
    }
}
