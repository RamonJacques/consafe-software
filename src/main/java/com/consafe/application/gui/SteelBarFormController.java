package com.consafe.application.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.consafe.application.entities.enums.SteelBarCategory;
import com.consafe.application.gui.utils.Alerts;
import com.consafe.application.gui.utils.Utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SteelBarFormController implements Initializable {

	@FXML
	private ComboBox<SteelBarCategory> comboBoxSteelBarCategory;

	@FXML
	private Button registerButton;

	@FXML
	public void onBtRegisterButton(ActionEvent event) {
		String path = pathGenerator();
		Stage parentStage = Utils.currentStage(event);
		createDialogForm(path, parentStage);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		loadComboBoxItens();
	}

	public void loadComboBoxItens() {
		comboBoxSteelBarCategory.getItems().setAll(SteelBarCategory.values());
		comboBoxSteelBarCategory.getSelectionModel().selectFirst();
	}
	
	private void createDialogForm(String absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();
			

//			SteelBarFormController controller = loader.getController();
//			controller.setMateriaPria(obj);
//			controller.setSteelBarService(service);
//			controller.subscribeDataChangeListener(this);
//			controller.updateFormData();

			Stage dialogStage = new Stage();
			dialogStage.setTitle("Nova barra");
			dialogStage.setScene(new Scene(pane));
			dialogStage.setResizable(false);
			dialogStage.initOwner(parentStage);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	public String pathGenerator() {
		String path = "/com/consafe/application/gui/calculators/" +
				comboBoxSteelBarCategory.getValue().toString() +
				"Calculator.fxml";
		return path;
	}
}
