package me.localtest.customersapp.services.customer;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.services.GenericServiceImpl;

@LocalBean
@Stateless
public class CustomerServiceBean extends GenericServiceImpl<Customer, Integer> implements CustomerService {
	
	public CustomerServiceBean() {
		super(Customer.class);
	}
	@Override
	public List<Customer> findByDni(String dni) throws Throwable {
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findByDni", Customer.class);
		query.setParameter("dni", dni);
		return query.getResultList();
	}
}
