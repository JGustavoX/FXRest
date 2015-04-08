package me.localtest.customersapp.services.customer;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.services.GenericService;

public interface CustomerService extends GenericService<Customer, Integer> {
	public Customer findByDni(String dni);
}
