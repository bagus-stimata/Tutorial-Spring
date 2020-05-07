package com.example.springboot2thymeleaf.model;

public class Foo {
    private int ID = 0;
    private String foo = "";

    public Foo(int iD, String foo) {
        ID = iD;
        this.foo = foo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }
    
}