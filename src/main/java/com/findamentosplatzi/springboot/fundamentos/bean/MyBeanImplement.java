package com.findamentosplatzi.springboot.fundamentos.bean;

public class MyBeanImplement implements MyBean {
    @Override
    public void print() {
        System.out.println("Hola desde la implementación de un bean propio");
    }
}
