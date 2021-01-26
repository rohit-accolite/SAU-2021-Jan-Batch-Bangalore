package com.au.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {

		ApplicationContext factory = new FileSystemXmlApplicationContext("springDI.xml");
		Triangle triangle = (Triangle)factory.getBean("triangle");
		triangle.draw();
	}

}
