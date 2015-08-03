package me.localtest.customersapp.model.util;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.CustomerTblModel;

/**
 *
 * @author Gus Garsaky
 */
public class Convert {
    
    /**
     * The properties of each User retrieved from REST service
 	 * are set to an UserTableModel object and it is added to the table
 	 * 
     * @param customer User getted from REST service
     * @return UserTableModel with properties values of User
     */
    public static CustomerTblModel toCustomerTblModel(Customer customer) {
        CustomerTblModel customerTblModel = new CustomerTblModel();
        customerTblModel.setId(customer.getId());
        customerTblModel.setNames(customer.getNames());
        customerTblModel.setSurnames(customer.getSurnames());
        customerTblModel.setDni(customer.getDni());
        customerTblModel.setBirthDate(DateUtil.toString("yyyy-MM-dd", customer.getBirthDate()));
        customerTblModel.setAddress(customer.getAddress());
        customerTblModel.setEmail(customer.getEmail());
        customerTblModel.setCreationDate(DateUtil.toString("yyyy-MM-dd", customer.getCreationDate()));
        customerTblModel.setActive((customer.getState()) ? "SI": "NO");
        return customerTblModel;
    }
}
