package com.consafe.application.gui.calculators;

import java.net.URL;
import java.util.ResourceBundle;

import com.consafe.application.entities.SteelBar;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MetalonCalculatorController implements Initializable{

	private SteelBar entity;
	
	@FXML
	private TextField txtLado1;
	
	@FXML
	private TextField txtLado2;
	
	@FXML
	private TextField txtEspessura;
	
	@FXML
	private Label labelErrorLado1;
	
	@FXML
	private Label labelErrorLado2;
	
	@FXML
	private Label labelErrorEspessura;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("Save");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("Cancel");
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {		
	}
}
