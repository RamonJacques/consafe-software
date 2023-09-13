package com.consafe.application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.consafe.application.InterfaceApplication;
import com.consafe.application.gui.utils.Alerts;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable{
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	public synchronized <T> void setCenterView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVbox = loader.load();
			
			Scene mainScene = InterfaceApplication.getMainScene();
			
			VBox mainVbox = (VBox) ((BorderPane) ((ScrollPane) mainScene.getRoot()).getContent()).getCenter();

			mainVbox.getChildren().clear();
			mainVbox.getChildren().addAll(newVbox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);

		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
