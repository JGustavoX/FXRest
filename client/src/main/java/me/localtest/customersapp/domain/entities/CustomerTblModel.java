package me.localtest.customersapp.domain.entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Gustavo García
 */
public class CustomerTblModel {
    final private IntegerProperty id;
    final private StringProperty names;
    final private StringProperty surnames;
    final private StringProperty dni;
    final private StringProperty birthDate;
    final private StringProperty address;
    @SuppressWarnings("unused")
	private BooleanProperty phones;
    final private StringProperty email;
    final private StringProperty creationDate;
    final private StringProperty active;
    
    public CustomerTblModel() {
        this.id = new SimpleIntegerProperty();
        this.names = new SimpleStringProperty();
        this.surnames = new SimpleStringProperty();
        this.dni = new SimpleStringProperty();
        this.birthDate = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.phones = new SimpleBooleanProperty();
        this.email = new SimpleStringProperty();
        this.creationDate = new SimpleStringProperty();
        this.active = new SimpleStringProperty();
    }
    public CustomerTblModel(Integer id, String names, String surnames, String dni, String birthDate,
             String address, String email, String creationDate, String active) {
        this.id = new SimpleIntegerProperty(id);
        this.names = new SimpleStringProperty(names);
        this.surnames = new SimpleStringProperty(surnames);
        this.dni = new SimpleStringProperty(dni);
        this.birthDate = new SimpleStringProperty(birthDate);
        this.address = new SimpleStringProperty(address);
        this.email = new SimpleStringProperty(email);
        this.creationDate = new SimpleStringProperty(creationDate);
        this.active = new SimpleStringProperty(active);
    }
    public Integer getId() {
        return id.get();
    }
    public IntegerProperty getIdProperty() {
        return id;
    }
    public void setId(Integer id) {
        this.id.set(id);
    }
    public String getNames() {
        return names.get();
    }
    public StringProperty getNamesProperty() {
        return names;
    }
    public void setNames(String names) {
        this.names.set(names);
    }
    public String getSurnames() {
        return surnames.get();
    }
    public StringProperty getSurnamesProperty() {
        return surnames;
    }
    public void setSurnames(String surnames) {
        this.surnames.set(surnames);
    }
    public String getDni() {
        return dni.get();
    }
    public void setDni(String dni) {
        this.dni.set(dni);
    }
    public StringProperty getDniProperty() {
        return dni;
    }
    public String getBirthDate() {
        return birthDate.get();
    }
    public StringProperty getBirthDateProperty() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate.set(birthDate);
    }
    public String getAddress() {
        return address.get();
    }
    public StringProperty getAddressProperty() {
        return address;
    }
    public void setAddress(String address) {
        this.address.set(address);
    }
    public String getEmail() {
        return email.get();
    }
    public StringProperty getEmailProperty()  {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getCreationDate() {
        return creationDate.get();
    }
    public StringProperty getCreationDateProperty() {
        return creationDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate.set(creationDate);
    }
    public String isActive() {
        return active.get();
    }
    public StringProperty getActiveProperty() {
        return active;
    }
    public void setActive(String active) {
        this.active.set(active);
    }
}
