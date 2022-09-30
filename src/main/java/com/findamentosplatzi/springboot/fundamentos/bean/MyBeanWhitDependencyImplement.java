package com.findamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWhitDependencyImplement implements MyBeanWhitDependency {

    private Log LOGGER = LogFactory.getLog(MyBeanWhitDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWhitDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Se ha ingresado al metodo printWithDependency");
        int number = 1;
        LOGGER.debug("El numero enviado a la operacion es: " + number);
        System.out.println(myOperation.sum(number));

        System.out.println("Hola desde la implementación de un bean con dependencia");
    }
}
