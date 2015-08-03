package me.localtest.customersapp.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.util.Callback;
import me.localtest.customersapp.domain.entities.CustomerTblModel;
import me.localtest.customersapp.model.rest.RESTClient;
import me.localtest.customersapp.model.util.ButtonCell;
import me.localtest.customersapp.model.util.Convert;
import me.localtest.customersapp.model.util.DialogUtil;
import me.localtest.customersapp.model.util.StageUtil;

/**
 *
 * @author gus
 */
public class MainController implements Initializable {
	@FXML private Pane pnlServerStatus;
	@FXML private Label lblServerStatus;
	@FXML private TextField txtSearch;
	private ObservableList<CustomerTblModel> customerList = FXCollections.observableArrayList();
	private ObservableList<CustomerTblModel> customerBak = FXCollections.observableArrayList();
	@FXML private TableView<CustomerTblModel> customersTable;
	@FXML private TableColumn<CustomerTblModel, Number> id;
	@FXML private TableColumn<CustomerTblModel, String> names;
	@FXML private TableColumn<CustomerTblModel, String> surnames;
	@FXML private TableColumn<CustomerTblModel, String> dni;
	@FXML private TableColumn<CustomerTblModel, String> birthDate;
	@FXML private TableColumn<CustomerTblModel, String> address;
	@FXML private TableColumn<CustomerTblModel, Boolean> phones;
	@FXML private TableColumn<CustomerTblModel, String> email;
	@FXML private TableColumn<CustomerTblModel, String> state;
	private final MainController THIS = this;

	@FXML
	private void searchAction() {
		try {
			CustomerTblModel found = Convert.toCustomerTblModel
					(RESTClient.findCustomer(txtSearch.getText()));
			customerBak.setAll(customerList); // make a backup of original table
			customerList.clear(); // clear list
			customerList.add(found); // add the fund customer
		} catch (RuntimeException e) {
			DialogUtil.buildSimpleDialog("Búsqueda de usuarios", 
					null,"No se han encontrado coincidencias",AlertType.INFORMATION).showAndWait();
		}
	}
	@FXML
	private void updateAction() {
		StageUtil.loadEditCustomer(THIS, Modality.APPLICATION_MODAL).showAndWait();
	}
	@FXML
	private void removeAction() {
		Optional<ButtonType> decision = DialogUtil.buildConfirmationDialog(
				"Eliminar usuario", null, "¿Está seguro de eliminar al usuario?").showAndWait();
		if (decision.get() == ButtonType.OK) {
			try {
				CustomerTblModel selectedCustomer = customersTable.getSelectionModel().getSelectedItem();
				RESTClient.removeCustomer(selectedCustomer.getId());
				customerList.remove(selectedCustomer);
			} catch (RuntimeException e) {
				DialogUtil.buildExceptionDialog("Ha ocurrido un error","Error al eliminar usuario", e).showAndWait();
			}
		}
	}
	@FXML
	private void newAction() {
		StageUtil.loadNewCustomer(THIS, Modality.APPLICATION_MODAL).showAndWait();
	}
	public TableView<CustomerTblModel> getTable() {
		return customersTable;
	}
	/* **************************************************
	 * 				INIT METHODS
	 * *************************************************/
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeTable();
		attachTxtSearchListener();
		retrieveAllCustomers();
	}
	private void retrieveAllCustomers() {
		try {
			customerList = FXCollections.observableArrayList(RESTClient.findAllCustomers());
			customersTable.setItems(customerList);
		} catch (RuntimeException e) {
			DialogUtil.buildExceptionDialog("Ha ocurrido un error","Error al conectar al servicio web", e).showAndWait();
			System.exit(-1);
		}
	}
	private void initializeTable() {
		id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());
		names.setCellValueFactory(cellData -> cellData.getValue().getNamesProperty());
		surnames.setCellValueFactory(cellData -> cellData.getValue().getSurnamesProperty());
		dni.setCellValueFactory(cellData -> cellData.getValue().getDniProperty());
		birthDate.setCellValueFactory(cellData -> cellData.getValue().getBirthDateProperty());
		address.setCellValueFactory(cellData -> cellData.getValue().getAddressProperty());
		createCellPhone();
		email.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
		state.setCellValueFactory(cellData -> cellData.getValue().getActiveProperty());
	}
	private void attachTxtSearchListener() {
		txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(newValue.isEmpty() && !customerBak.isEmpty()) {
		    	customerList.setAll(customerBak); // restore original cusomer list
		    }
		});
	}
	private void createCellPhone() {
		// define a simple boolean cell value for the action column so that the
		// column will only be shown for non-empty rows.
		phones.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CustomerTblModel, Boolean>, ObservableValue<Boolean>>() {
			@Override
			public ObservableValue<Boolean> call(
					TableColumn.CellDataFeatures<CustomerTblModel, Boolean> features) {
				return new SimpleBooleanProperty(features.getValue() != null);
			}
		});
		// create a cell value factory with an add button for each row in the table.
		phones.setCellFactory(new Callback<TableColumn<CustomerTblModel, Boolean>, TableCell<CustomerTblModel, Boolean>>() {
			@Override
			public TableCell<CustomerTblModel, Boolean> call(
					TableColumn<CustomerTblModel, Boolean> booleanTableColumn) {
				return new ButtonCell(THIS, Modality.APPLICATION_MODAL);
			}
		});
	}
}
