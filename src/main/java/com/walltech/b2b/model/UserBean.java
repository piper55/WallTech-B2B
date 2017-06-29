package com.walltech.b2b.model;

import java.util.*;

/**
 * Created by zedd on 2017/5/31.
 */
public class UserBean {
    private String name;
    private char sex;
    private int age;
    private String address;
    private String[] phone;
    private List<String> career;
    private boolean active;
    private Date brithday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getPhone() {
        return phone;
    }

    public void setPhone(String[] phone) {
        this.phone = phone;
    }

    public List<String> getCareer() {
        return career;
    }

    public void setCareer(List<String> carrer) {
        this.career = carrer;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }
}
