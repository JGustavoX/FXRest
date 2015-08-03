package me.localtest.customersapp.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gustavo García
 */
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {
    private static final long serialVersionUID = 1447199063826949783L;
	@XmlElement(name="id")
    private Integer id;
    @XmlElement(name="names")
    private String names;
    @XmlElement(name="surnames")
    private String surnames;
    @XmlElement(name="dni")
    private String dni;
    @XmlElement(name="birth-date")
    private Date birthDate;
    @XmlElement(name="address")
    private String address;
    @XmlElement(name="email")
    private String email;
    @XmlElement(name="creation-date")
    private Date creationDate;
    @XmlElement(name="state")
    private Boolean state;
    
    public Customer() {
        
    }
    public Customer(Integer id, String names, String surnames, String dni, Date birthDate, String address,
            String email, Date creationDate, Boolean state) {
        this.id = id;
        this.names = names;
        this.surnames = surnames;
        this.dni = dni;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.creationDate = creationDate;
        this.state = state;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getSurnames() {
        return surnames;
    }
    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public Boolean getState() {
        return state;
    }
    public void setState(Boolean state) {
        this.state = state;
    }  
}
