package me.localtest.customersapp.services.customer;

import java.util.List;
import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.services.GenericService;

public interface CustomerService extends GenericService<Customer, Integer> {
	public List<Customer> findByDni(String dni) throws Throwable;
}
