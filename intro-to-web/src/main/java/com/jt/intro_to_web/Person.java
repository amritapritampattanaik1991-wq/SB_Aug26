package com.jt.intro_to_web;

public class Person {
    private String name1;
    private String phone;
    public String getName() {
        return name1;
    }
    public void setName1(String name1) {
        this.name1 = name1;
        System.out.println("Name setter");
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
        System.out.println("phone setter");
    }


    
}
