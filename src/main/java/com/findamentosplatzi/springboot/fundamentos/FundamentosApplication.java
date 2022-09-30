package com.findamentosplatzi.springboot.fundamentos;

import com.findamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitDependency;
import com.findamentosplatzi.springboot.fundamentos.bean.MyBeanWhitProperties;
import com.findamentosplatzi.springboot.fundamentos.component.ComponentDependency;
import com.findamentosplatzi.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWhitDependency myBeanWhitDependency;

	private MyBeanWhitProperties myBeanWhitProperties;

	private UserPojo userPojo;

	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWhitDependency myBeanWhitDependency, MyBeanWhitProperties myBeanWhitProperties, UserPojo userPojo) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWhitDependency = myBeanWhitDependency;
		this.myBeanWhitProperties = myBeanWhitProperties;
		this.userPojo = userPojo;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.saludar();
		myBean.print();
		myBeanWhitDependency.printWithDependency();
		System.out.println(myBeanWhitProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassword()+"-" + userPojo.getAge());
	}
}
