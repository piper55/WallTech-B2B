package com.walltech.b2b.model;

/**
 * Created by zedd on 2017/6/13.
 */
public class Rectangle extends Shape {
    private UserBean userBean;

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
    public void soutl(){
        System.out.println("Rectangle");
    }
}
