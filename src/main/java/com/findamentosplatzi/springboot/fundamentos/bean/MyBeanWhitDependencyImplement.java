package com.findamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWhitDependencyImplement implements MyBeanWhitDependency {

    private MyOperation myOperation;

    public MyBeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 1;
        System.out.println(myOperation.sum(number));
        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
