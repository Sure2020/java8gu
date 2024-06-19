package com.sure.java8gu.javabasic.single;

public enum Singleton {
    INSTANCE;
    public void fuc(){
        System.out.println("do something");
    }
    private int value;
    public int getValue(){
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }
}
