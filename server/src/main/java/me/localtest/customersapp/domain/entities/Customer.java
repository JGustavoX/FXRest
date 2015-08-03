package me.localtest.customersapp.domain.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gus Garsaky
 */
@Entity
@Table(name="customers")
@NamedQueries({
    @NamedQuery(name="Customer.findByDni", query="SELECT c FROM Customer c WHERE c.dni = :dni"),
    @NamedQuery(name="Customer.findById", query="SELECT c FROM Customer c WHERE c.id = :id")
})
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("serial")
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @XmlElement(name="id")
    private Integer id;
    @Column(name="names")
    @XmlElement(name="names")
    private String names;
    @Column(name="surnames")
    @XmlElement(name="surnames")
    private String surnames;
    @Column(name="dni")
    @XmlElement(name="dni")
    private String dni;
    @Column(name="birth_date")
    @XmlElement(name="birth-date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name="address")
    @XmlElement(name="address")
    private String address;
    @Column(name="email")
    @XmlElement(name="email")
    private String email;
    @Column(name="creation_date")
    @Temporal(TemporalType.DATE)
    @XmlElement(name="creation-date")
    private Date creationDate;
    @Column(name="state")
    @XmlElement(name="state")
    private Boolean state;
    
    public Customer() {
        
    }
	public Customer(Integer id, String names, String surnames, String dni,
			Date birthDate, String address, String email, Date creationDate,
			Boolean state) {
		//super();
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
