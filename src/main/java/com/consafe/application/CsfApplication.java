package com.consafe.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.consafe.application.entities.SteelBar;
import com.consafe.application.entities.enums.SteelBarCategory;
import com.consafe.application.services.SteelBarService;

import javafx.application.Application;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CsfApplication {
			
	public static void main(String[] args) {
		Application.launch(InterfaceApplication.class, args);
		
		SteelBarService service = new SteelBarService();
		
		SteelBar mt1 = new SteelBar(1, "Metalon x40 x40 x3.0", 2.8, SteelBarCategory.FERRO_CHATO);
		service.saveOrUpdate(mt1);
	}
}