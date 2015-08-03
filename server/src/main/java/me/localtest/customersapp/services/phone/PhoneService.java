package me.localtest.customersapp.services.phone;

import java.util.List;
import me.localtest.customersapp.domain.entities.Phone;
import me.localtest.customersapp.services.GenericService;

public interface PhoneService extends GenericService<Phone, Integer> {
	public List<Phone> findCustomerPhones(Integer id) throws Throwable;
	public List<Phone> findCustomerPhones(String dni) throws Throwable;
}
