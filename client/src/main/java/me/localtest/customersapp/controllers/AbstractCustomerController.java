package me.localtest.customersapp.controllers;

import java.text.ParseException;

import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.model.util.DateUtil;

/**
 *
 * @author Gus Garsaky
 */
public abstract class AbstractCustomerController {
    
    protected Customer buildCustomer() throws ParseException {
        Customer customer = new Customer();
        customer.setNames(getTxtNames().getText());
        customer.setSurnames(getTxtSurnames().getText());
        customer.setDni(getTxtDni().getText());
        customer.setBirthDate(DateUtil.toDate("yyyy-MM-dd", getDpBirthDate().getValue().toString()));
        customer.setAddress(getTxtAddress().getText());
        customer.setEmail(getTxtEmail().getText());
        customer.setCreationDate(DateUtil.format("yyyy-MM-dd", new java.util.Date()));
        customer.setState(getCbxState().isSelected());
        return customer;
    }
    protected void closeStage() {
        ((Stage) getTxtNames().getScene().getWindow()).close();
    }
    /* **********************************
     *      GETTERS AND SETTERS
     **********************************/
    public abstract TextField getTxtNames();    
    public abstract void setTxtNames(TextField txtNames);
    public abstract TextField getTxtSurnames();
    public abstract void setTxtSurnames(TextField txtSurnames);
    public abstract TextField getTxtDni();
    public abstract void setTxtDni(TextField txtDni);
    public abstract DatePicker getDpBirthDate();
    public abstract void setDpBirthDate(DatePicker dpBirthDate);
    public abstract TextField getTxtAddress();
    public abstract void setTxtAddress(TextField txtAddress);
    public abstract TextField getTxtEmail();
    public abstract void setTxtEmail(TextField txtEmail);
    public abstract CheckBox getCbxState();
    public abstract void setCbxState(CheckBox cbxState);
}