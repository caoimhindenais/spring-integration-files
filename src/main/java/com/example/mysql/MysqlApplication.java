package com.example.mysql;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class MysqlApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MysqlApplication.class, args);

		ApplicationContext ctx =
				new ClassPathXmlApplicationContext("context.xml");


	}
}
