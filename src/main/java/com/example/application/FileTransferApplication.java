package com.example.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FileTransferApplication {

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("context.xml");
	}
}
