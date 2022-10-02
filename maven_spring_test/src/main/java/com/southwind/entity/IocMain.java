package com.southwind.entity;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocMain {

    public static void main(String[] args) {
        //加载配置
        var applitionContext = new ClassPathXmlApplicationContext("spring.xml");
        //获取对象
        var s = (Student) applitionContext.getBean("student");
        System.out.println("s = " + s);
    }
}