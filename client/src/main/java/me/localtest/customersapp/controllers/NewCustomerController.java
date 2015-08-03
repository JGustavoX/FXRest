package me.localtest.customersapp.controllers;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.CustomerTblModel;
import me.localtest.customersapp.model.rest.RESTClient;
import me.localtest.customersapp.model.util.Convert;
import me.localtest.customersapp.model.util.DialogUtil;
import me.localtest.customersapp.model.util.FormUtil;

import java.text.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author gus
 */
public class NewCustomerController extends AbstractCustomerController {
    private MainController fatherGUI;
    @FXML private TextField txtNames;
    @FXML private TextField txtSurnames;
    @FXML private TextField txtDni;
    @FXML private DatePicker dpBirthDate;
    @FXML private TextField txtAddress;
    @FXML private TextField txtPhone;
    @FXML private TextField txtEmail;
    @FXML private CheckBox cbxState;
    
    public void setFatherGUI(MainController fatherGUI) {
        this.fatherGUI = fatherGUI;
    }
    @FXML private void registerAction() {
        try {
            Customer saved = null; // user to persist
            if(FormUtil.isValid(txtNames, txtSurnames, txtDni, txtAddress, txtEmail)) {
            	saved = registerCustomer();
            	closeStage();
                appendUserToTable(Convert.toCustomerTblModel(saved));
            } else {
            	DialogUtil.buildSimpleDialog("Importante", null, "No deje campos vacíos", AlertType.WARNING).showAndWait();
            }
        } catch(RuntimeException | ParseException e) {
            DialogUtil.buildExceptionDialog
            ("Ha ocurrido un error", "Error al registrar cliente", e).showAndWait();
        }
    }
    @FXML private void cancelAction() {
        closeStage();
    }
    private Customer registerCustomer() throws RuntimeException, ParseException {
        Customer saved = RESTClient.saveCustomer(buildCustomer());
        return saved;
    }
	private void appendUserToTable(CustomerTblModel newCustomer) {
        fatherGUI.getTable().getItems().add(newCustomer);
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
