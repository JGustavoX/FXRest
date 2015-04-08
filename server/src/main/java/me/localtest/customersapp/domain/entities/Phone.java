package me.localtest.customersapp.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="customer_phones")
@NamedQueries({
	@NamedQuery(name="Phone.findByCustomer", query="SELECT p FROM Phone p WHERE p.customer = :customer")
})
@XmlRootElement(name="phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
	@XmlElement(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@XmlElement(name="customer")
	@ManyToOne
	@JoinColumn(name="customer", referencedColumnName="id")
	private Customer customer;
	@XmlElement(name="number")
	@Column(name="phone_number")
	private String phoneNumber;
	
	public Phone() {
		
	}
	public Phone(Integer id, Customer customer, String phoneNumber) {
		//super();
		this.id = id;
		this.customer = customer;
		this.phoneNumber = phoneNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
