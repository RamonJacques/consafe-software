package com.consafe.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javafx.application.Application;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CsfApplication{
		
	public static void main(String[] args) {
		Application.launch(InterfaceApplication.class, args);
	}	
}
