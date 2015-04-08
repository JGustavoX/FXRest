package me.localtest.customersapp.services.customer;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.services.GenericServiceImpl;

@LocalBean
@Stateless
public class CustomerServiceBean extends GenericServiceImpl<Customer, Integer> implements CustomerService {
	
	public CustomerServiceBean() {
		super(Customer.class);
	}
	@Override
	public Customer findByDni(String dni) {
		Query query = em.createNamedQuery("Customer.findByDni");
		query.setParameter("dni", dni);
		return (Customer) query.getSingleResult();
	}
}