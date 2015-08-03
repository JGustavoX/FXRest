package me.localtest.customersapp.controllers;

import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.Phone;
import me.localtest.customersapp.model.rest.RESTClient;
import me.localtest.customersapp.model.util.DialogUtil;

public class CustomerPhonesController {
	@FXML private ListView<Phone> phoneListView;
	private ObservableList<Phone> phoneList;
	private MainController fatherGUI;
	
	public CustomerPhonesController() {
		
	}
	public void setFatherGUI(MainController fatherGUI) {
		this.fatherGUI = fatherGUI;
	}
	@FXML private void addAction() {
		try {
			Optional<String> phoneNumber = DialogUtil.
					buildInputDialog("Registro de teléfonos", null, "Ingrese un teléfono").showAndWait();
			if(phoneNumber.isPresent() && !phoneNumber.get().isEmpty()) {
				Customer found = RESTClient.findCustomer(getDniOfSelectedUser());
				Phone phone = new Phone();
				phone.setCustomer(found);
				phone.setPhoneNumber(phoneNumber.get());
				RESTClient.savePhone(phone);
				appendPhoneToList(phone);
			}
		} catch(RuntimeException e) {
			DialogUtil.buildExceptionDialog("Respuesta del servidor", "Ha ocurrido un error", e).showAndWait();
		}
	}
	@FXML private void removeAction() {
		try {
			Phone selected = phoneListView.getSelectionModel().getSelectedItem();
			RESTClient.removePhone(selected.getId());
			phoneList.remove(selected);
		} catch(RuntimeException e) {
			DialogUtil.buildExceptionDialog("Respuesta del servidor", "Ha ocurrido un error...", e).showAndWait();
		}
	}
	@FXML private void acceptAction() {
		((Stage) phoneListView.getScene().getWindow()).close();
	}
	private String getDniOfSelectedUser() {
		return fatherGUI.getTable().getSelectionModel().getSelectedItem().getDni();
	}
	private void appendPhoneToList(Phone phone) {
		phoneList.add(phone);
		phoneListView.setItems(phoneList);
	}
	public void retrievePhones() {
		phoneListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // single selection
		try {
			String dni = getDniOfSelectedUser();
			phoneList = FXCollections.observableArrayList(RESTClient.findCustomerPhones(dni));
			phoneListView.setItems(phoneList);
		} catch(RuntimeException e) {
			phoneList = FXCollections.observableArrayList(); // if something fails, initialize the phone collection
		}
	}
}
