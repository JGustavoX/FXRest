package me.localtest.customersapp.controllers;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.CustomerTblModel;
import me.localtest.customersapp.model.rest.RESTClient;
import me.localtest.customersapp.model.util.Convert;
import me.localtest.customersapp.model.util.DialogUtil;
import me.localtest.customersapp.model.util.FormUtil;

import java.text.ParseException;
import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Gus Garsaky
 */
public class EditCustomerController extends AbstractCustomerController {
    @FXML private TextField txtNames;
    @FXML private TextField txtSurnames;
    @FXML private TextField txtDni;
    @FXML private DatePicker dpBirthDate;
    @FXML private TextField txtAddress;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;
    @FXML private CheckBox cbxState;
    private MainController fatherGUI;
    
    public void setFatherGUI(MainController fatherGUI) {
        this.fatherGUI = fatherGUI;
        showData();
    }
    @FXML private void updateAction() {
        try {
            Customer updated = null;
            if(FormUtil.isValid(txtNames, txtSurnames, txtDni, txtAddress, txtEmail)) {
            	updated = updateCustomer();
            	closeStage();
                updateUserInTable(Convert.toCustomerTblModel(updated));
            } else {
            	DialogUtil.buildSimpleDialog("Importante", null, "No deje campos vacíos", AlertType.WARNING).showAndWait();
            }
        } catch(RuntimeException | ParseException e) {
            DialogUtil.buildExceptionDialog
            ("Ha ocurrido un error", "Error al actualizar usuario", e).showAndWait();
        }
    }
    @FXML private void cancelAction() {
        closeStage();
    }
    private Customer updateCustomer() throws RuntimeException, ParseException {
        Customer customerToUpdate = buildCustomer();
        customerToUpdate.setId(getSelected().getId());
        Customer updated = RESTClient.updateCustomer(customerToUpdate);
        return updated;
    }
    private void showData() {
        CustomerTblModel selected = getSelected();
        this.getTxtNames().setText(selected.getNames());
        this.getTxtSurnames().setText(selected.getSurnames());
        this.getTxtDni().setText(selected.getDni());
        this.getDpBirthDate().setValue(LocalDate.parse(selected.getBirthDate()));
        this.getTxtAddress().setText(selected.getAddress());
        this.getTxtEmail().setText(selected.getEmail());
        this.getCbxState().setSelected((selected.isActive().equalsIgnoreCase("si")));
    }
    private CustomerTblModel getSelected() {
    	return fatherGUI.getTable().getSelectionModel().getSelectedItem();
    }
    private void updateUserInTable(CustomerTblModel customerTblModel) {
        CustomerTblModel selected = fatherGUI.getTable().getSelectionModel().getSelectedItem();
        ObservableList<CustomerTblModel> customerList = fatherGUI.getTable().getItems();
        customerList.remove(selected);
        customerList.add(customerTblModel);
    }
    /* **********************************
     *      GETTERS AND SETTERS
     **********************************/
    @Override
    public TextField getTxtNames() {
        return txtNames;
    }
    @Override
    public void setTxtNames(TextField txtNames) {
        this.txtNames = txtNames;
    }
    @Override
    public TextField getTxtSurnames() {
        return txtSurnames;
    }
    @Override
    public void setTxtSurnames(TextField txtSurnames) {
        this.txtSurnames = txtSurnames;
    }
    @Override
    public TextField getTxtDni() {
        return txtDni;
    }
    @Override
    public void setTxtDni(TextField txtDni) {
        this.txtDni = txtDni;
    }
    @Override
    public DatePicker getDpBirthDate() {
        return dpBirthDate;
    }
    @Override
    public void setDpBirthDate(DatePicker dpBirthDate) {
        this.dpBirthDate = dpBirthDate;
    }
    @Override
    public TextField getTxtAddress() {
        return txtAddress;
    }
    @Override
    public void setTxtAddress(TextField txtAddress) {
        this.txtAddress = txtAddress;
    }
    @Override
    public TextField getTxtEmail() {
        return txtEmail;
    }
    @Override
    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }
    @Override
    public CheckBox getCbxState() {
        return cbxState;
    }
    @Override
    public void setCbxState(CheckBox cbxState) {
        this.cbxState = cbxState;
    }
}
