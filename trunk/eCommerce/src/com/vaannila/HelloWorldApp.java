package com.vaannila;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
		helloWorld.display();
	}

}
