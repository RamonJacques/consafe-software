package com.consafe.application;

import java.io.IOException;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class InterfaceApplication extends Application{

	private ConfigurableApplicationContext applicationContext;
	
	private static Scene mainScene;

	@Override
	public void init() {
		applicationContext = new SpringApplicationBuilder(CsfApplication.class).run();
		applicationContext
	    .getAutowireCapableBeanFactory()
	    .autowireBeanProperties(
	        this,
	        AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, 
	        true
	    );
	}

	@Override
	public void start(Stage stage) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/consafe/application/gui/views/MainView.fxml"));
			ScrollPane scrollPane = fxmlLoader.load();
			fxmlLoader.setControllerFactory(applicationContext::getBean);
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);

			mainScene = new Scene(scrollPane);
			stage.setScene(mainScene);
			stage.setTitle("Consafe application.");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void stop() {
		applicationContext.close();
		Platform.exit();
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}
}
