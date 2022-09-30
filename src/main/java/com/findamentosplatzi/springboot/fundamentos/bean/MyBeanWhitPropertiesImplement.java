package com.findamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWhitPropertiesImplement implements MyBeanWhitProperties {
    private String name;
    private String lastName;

    public MyBeanWhitPropertiesImplement(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String function() {
        return name + "-" + lastName;
    }

}
