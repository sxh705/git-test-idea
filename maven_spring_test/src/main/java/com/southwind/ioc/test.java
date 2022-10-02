package com.southwind.ioc;


import com.southwind.entity.Student;

public class test {
    public static void main(String[] args) {
        AppContext applicationContext = new ClassPathXmlApplicationContext("maven_spring_test/src/main/resources/spring.xml");

        var s = (Student) applicationContext.getBean("student");
        System.out.println("s = " + s);
    }

}
