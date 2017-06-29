package com.walltech.b2b.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zedd on 2017/5/12.
 */
public class ApplicationContextUtils implements ApplicationContextAware  {
    private  ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

    private ApplicationContextUtils() {
    }

    public  ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
