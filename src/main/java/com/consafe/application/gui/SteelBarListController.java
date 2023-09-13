package com.consafe.application.gui;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.consafe.application.InterfaceApplication;
import com.consafe.application.entities.SteelBar;
import com.consafe.application.gui.listener.DataChangeListener;
import com.consafe.application.services.SteelBarService;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

@Component
public class SteelBarListController implements Initializable, DataChangeListener {

	private SteelBarService service;

	@FXML
	private TableView<SteelBar> tableViewSteelBar;

	@FXML
	private TableColumn<SteelBar, String> tableColumnCategory;

	@FXML
	private TableColumn<SteelBar, String> tableColumnName;

	@FXML
	private TableColumn<SteelBar, Double> tableColumnKgPerMeter;

	@FXML
	private TableColumn<SteelBar, SteelBar> tableColumnEDIT;

	@FXML
	private TableColumn<SteelBar, SteelBar> tableColumnREMOVE;

	@FXML
	private Button btNew;

	private ObservableList<SteelBar> obsList;

	public void setSteelBarService(SteelBarService service) {
		this.service = service;
	}

	@FXML
	public void onBtNewAction(ActionEvent event) {
//		Stage parentStage = Utils.currentStage(event);
//		SteelBar obj = new SteelBar();
//		createDialogForm(obj, "/com/exercise/consafe/gui/SteelBarForm.fxml", parentStage);
		System.out.println("Button new pressed.");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}

	private void initializeNodes() {
		tableColumnCategory.setCellValueFactory(new PropertyValueFactory<>("stellBarCategory"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		tableColumnKgPerMeter.setCellValueFactory(new PropertyValueFactory<>("kgPerMeter"));

		Stage stage = (Stage) InterfaceApplication.getMainScene().getWindow();
		tableViewSteelBar.prefHeightProperty().bind(stage.heightProperty());
	}

//	public void updateTableView() {
//		List<SteelBar> list = service.findAll();
//		obsList = FXCollections.observableArrayList(list);
//		tableViewSteelBar.setItems(obsList);
//		initEditButtons();
//		initRemoveButtons();
//	}
//
//	private void createDialogForm(SteelBar obj, String absoluteName, Stage parentStage) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//			Pane pane = loader.load();
//
//			SteelBarFormController controller = loader.getController();
//			controller.setMateriaPria(obj);
//			controller.setSteelBarService(service);
//			controller.subscribeDataChangeListener(this);
//			controller.updateFormData();
//
//			Stage dialogStage = new Stage();
//			dialogStage.setTitle("Entre com dados da matéria prima");
//			dialogStage.setScene(new Scene(pane));
//			dialogStage.setResizable(false);
//			dialogStage.initOwner(parentStage);
//			dialogStage.initModality(Modality.WINDOW_MODAL);
//			dialogStage.showAndWait();
//
//		} catch (IOException e) {
//			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
//		}
//	}
//
	@Override
	public void onDataChanged() {
//		updateTableView();
	}
//
//	private void initEditButtons() {
//		tableColumnEDIT.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
//		tableColumnEDIT.setCellFactory(param -> new TableCell<SteelBar, SteelBar>() {
//			private final Button button = new Button("edit");
//
//			@Override
//			protected void updateItem(SteelBar obj, boolean empty) {
//				super.updateItem(obj, empty);
//				if (obj == null) {
//					setGraphic(null);
//					return;
//				}
//				setGraphic(button);
//				button.setOnAction(event -> createDialogForm(obj, "/com/exercise/consafe/gui/SteelBarForm.fxml",
//						Utils.currentStage(event)));
//			}
//		});
//	}
//
//	private void initRemoveButtons() {
//		tableColumnREMOVE.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
//		tableColumnREMOVE.setCellFactory(param -> new TableCell<SteelBar, SteelBar>() {
//			private final Button button = new Button("remove");
//
//			@Override
//			protected void updateItem(SteelBar obj, boolean empty) {
//				super.updateItem(obj, empty);
//				if (obj == null) {
//					setGraphic(null);
//					return;
//				}
//				setGraphic(button);
//				button.setOnAction(event -> removeEntity(obj));
//			}
//		});
//	}
//
//	private Object removeEntity(SteelBar obj) {
//		Optional<ButtonType> result = Alerts.showConfirmation("Confirmação", "Deseja deletar?");
//		
//		if (result.get() == ButtonType.OK) {
//			if (service == null) {
//				throw new IllegalStateException("Service was null");
//			}
//				service.remove(obj);
//				updateTableView();
//		}
//		return null;
//	}
}
