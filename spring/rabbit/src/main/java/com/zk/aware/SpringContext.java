package com.zk.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {
    ApplicationContext ioc;

    @Autowired
    ApplicationContext ooo;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("hello "+ applicationContext);
        System.out.println("ioc "+ooo);
        this.ioc=  applicationContext;
    }
}
