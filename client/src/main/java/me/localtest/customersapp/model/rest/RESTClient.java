package me.localtest.customersapp.model.rest;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.CustomerTblModel;
import me.localtest.customersapp.domain.entities.Phone;
import me.localtest.customersapp.model.util.Convert;


/**
 *
 * @author Gus García
 */
public class RESTClient {
    private static final String WS_URI = "http://localhost:8080/customersapp/api/customers";
    
    public static Customer saveCustomer(Customer customer) throws RuntimeException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(getBaseUri());
            Customer saved = target.path("save").request()
                    .post(Entity.entity(customer, MediaType.APPLICATION_XML), Customer.class);
            return saved;
        } catch (RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    public static Customer updateCustomer(Customer customer) throws RuntimeException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(getBaseUri());
            Customer updated = target.path("update").request()
                    .put(Entity.entity(customer, MediaType.APPLICATION_XML), Customer.class);
            return updated;
        } catch(RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    public static Customer removeCustomer(Integer id) throws RuntimeException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(getBaseUri());
            Customer removed = target.path("remove/"+id).request().delete(Customer.class);
            return removed;
        } catch(RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    public static List<CustomerTblModel> findAllCustomers() throws RuntimeException {
        Client client = null;
        try {
            List<CustomerTblModel> models = new ArrayList<>();
            client = ClientBuilder.newClient();  
            WebTarget target = client.target(getBaseUri());
            List<Customer> all = target.path("all").request()
            		.get(new GenericType<List<Customer>>(){}); // get all users
            all.stream().forEach((user) -> {
                models.add(Convert.toCustomerTblModel(user));
            });
            return models;
        } catch(RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    public static Customer findCustomer(String dni) throws RuntimeException {
        Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(getBaseUri());
            List<Customer> found = target.path("find/"+dni).request().get(new GenericType<List<Customer>>() {});
            return found.get(0);
        } catch(RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    public static List<Phone> findCustomerPhones(String dni) throws RuntimeException {
    	Client client = null;
    	try {
    		client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseUri());
    		GenericType<List<Phone>> type = new GenericType<List<Phone>>() {};
    		List<Phone> phones = target.path("phones/"+dni).request().get(type);
    		return phones;
    	} catch(RuntimeException e) {
    		throw e;
    	} finally { if(client != null) client.close(); }
    }
    public static Phone savePhone(Phone phone) throws RuntimeException {
    	Client client = null;
    	try {
    		client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseUri());
    		Phone saved = target.path("phones").path("save").request()
    				.post(Entity.entity(phone, MediaType.APPLICATION_XML), Phone.class);
    		return saved;
    	} catch(RuntimeException e) {
    		throw e;
    	} finally { if(client != null) client.close(); }
    }
    public static Phone updatePhone(Phone phone) throws RuntimeException {
    	Client client = null;
    	try {
    		client = ClientBuilder.newClient();
    		WebTarget target = client.target(getBaseUri());
    		Phone updated = target.path("phones").path("update").request()
    				.put(Entity.entity(phone, MediaType.APPLICATION_XML), Phone.class);
    		return updated;
    	} catch(RuntimeException e) {
    		throw e;
    	} finally { if(client != null) client.close(); }
    }
    public static Phone removePhone(Integer id) throws RuntimeException {
    	Client client = null;
        try {
            client = ClientBuilder.newClient();
            WebTarget target = client.target(getBaseUri());
            Phone removed = target.path("phones").path("remove/"+id).request().delete(Phone.class);
            return removed;
        } catch(RuntimeException e) {
            throw e;
        } finally { if(client != null) client.close(); }
    }
    /* *************************************
     * 			 UTIL METHODS
     ***************************************/
    // Check the status of RESTful WebService
    public static boolean checkWS() {
        Boolean stateOfWS = false;
        try {
            URL siteURL = new URL(getBaseUri().toString());
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if(code == 200) stateOfWS = true;
        } catch(Exception e) {
            // do nothing
        }
        return stateOfWS;
    }
    private static URI getBaseUri() {
        return UriBuilder.fromUri(WS_URI).build();
    }
}
