package com.walltech.b2b.model;

import java.util.List;

/**
 * Created by zedd on 2017/6/1.
 */
public class BookBean {
    private String name ;
    private String author;
    private List<UserBean> userBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<UserBean> getUserBean() {
        return userBean;
    }

    public void setUserBean(List<UserBean> userBean) {
        this.userBean = userBean;
    }
}
