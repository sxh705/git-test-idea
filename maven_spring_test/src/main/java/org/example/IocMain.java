package org.example;

public class IocMain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        var s = new Student();
        s.setId(1L);
        s.setName("张三");
        s.setAge(2);
        System.out.println("s = " + s);
    }
}