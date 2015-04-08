package me.localtest.customersapp.services.phone;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.Phone;
import me.localtest.customersapp.services.GenericServiceImpl;

@LocalBean
@Stateless
public class PhoneServiceBean extends GenericServiceImpl<Phone, Integer> implements PhoneService {
	
	public PhoneServiceBean() {
		super(Phone.class);
	}
	@Override
	public List<Phone> findCustomerPhones(Integer id) throws Throwable {
		TypedQuery<Customer> customerQuery = em.createNamedQuery("Customer.findById", Customer.class);
		customerQuery.setParameter("id", id);
		Customer customer = customerQuery.getSingleResult();
		TypedQuery<Phone> phoneQuery = em.createNamedQuery("Phone.findByCustomer", Phone.class);
		phoneQuery.setParameter("customer", customer);
		return phoneQuery.getResultList();
	}
	@Override
	public List<Phone> findCustomerPhones(String dni) throws Throwable {
		TypedQuery<Customer> customerQuery = em.createNamedQuery("Customer.findByDni", Customer.class);
		customerQuery.setParameter("dni", dni);
		Customer customer = customerQuery.getSingleResult();
		TypedQuery<Phone> phoneQuery = em.createNamedQuery("Phone.findByCustomer", Phone.class);
		phoneQuery.setParameter("customer", customer);
		return phoneQuery.getResultList();
	}
}