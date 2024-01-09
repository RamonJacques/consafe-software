package com.consafe.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.consafe.application.entities.SteelBar;
import com.consafe.application.entities.enums.SteelBarCategory;
import com.consafe.application.services.SteelBarService;

import javafx.application.Application;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CsfApplication implements CommandLineRunner{
			
	public static void main(String[] args) {
		Application.launch(InterfaceApplication.class, args);
		

	}

	@Override
	public void run(String... args) throws Exception {
		SteelBarService service = new SteelBarService();
		
		SteelBar tb1 = new SteelBar(null, "Tubo 4 x 2,75mm", 6.8, SteelBarCategory.TUBO);
		service.saveOrUpdate(tb1);		
	}
}