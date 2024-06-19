package com.sure.java8gu.javabasic.single;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("testing");
        Singleton singleton = Singleton.INSTANCE;
        singleton.setValue(1);
        singleton.fuc();
        System.out.println(singleton.getValue());
    }
}
