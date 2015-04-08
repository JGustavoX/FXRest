package me.localtest.customersapp.domain.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone implements Serializable {
	private static final long serialVersionUID = -2059649399949364422L;
	@XmlElement(name="id")
	private Integer id;
	@XmlElement(name="customer")
	private Customer customer;
	@XmlElement(name="number")
	private String phoneNumber;
	
	public Phone() {
		
	}
	public Phone(Integer id, Customer customer,
			String phoneNumber) {
		super();
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
	@Override
	public String toString() {
		return phoneNumber;
	}
}