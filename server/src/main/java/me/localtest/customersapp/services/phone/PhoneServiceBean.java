package me.localtest.customersapp.services.phone;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

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
	@SuppressWarnings("unchecked")
	public List<Phone> findCustomerPhones(Integer id) throws Throwable {
		Query query = em.createNamedQuery("Customer.findById");
		query.setParameter("id", id);
		Customer customer = (Customer) query.getSingleResult();
		query = em.createNamedQuery("Phone.findByCustomer");
		query.setParameter("customer", customer);
		return (List<Phone>) query.getResultList();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Phone> findCustomerPhones(String dni) throws Throwable {
		Query query = em.createNamedQuery("Customer.findByDni");
		query.setParameter("dni", dni);
		Customer customer = (Customer) query.getSingleResult();
		query = em.createNamedQuery("Phone.findByCustomer");
		query.setParameter("customer", customer);
		return (List<Phone>) query.getResultList();
	}
}