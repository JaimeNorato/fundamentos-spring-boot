package com.findamentosplatzi.springboot.fundamentos.bean;

public class MyBean2Implement implements MyBean {
    @Override
    public void print() {
        System.out.println("Hola desde la implementación de un bean propia #2");
    }
}
