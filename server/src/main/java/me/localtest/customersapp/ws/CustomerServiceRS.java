package me.localtest.customersapp.ws;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import me.localtest.customersapp.domain.entities.Customer;
import me.localtest.customersapp.domain.entities.Phone;
import me.localtest.customersapp.services.customer.CustomerServiceBean;
import me.localtest.customersapp.services.phone.PhoneServiceBean;


/**
 *
 * @author Gus Garsaky
 */
@Path("/customers")
@Stateless
@LocalBean
public class CustomerServiceRS {
    @Inject private CustomerServiceBean customerServiceBean;
    @Inject private PhoneServiceBean phoneServiceBean;
    
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response create(Customer customer) throws Throwable {
        Customer saved = customerServiceBean.save(customer);
        return Response.status(Status.ACCEPTED).entity(saved).build();
    }
    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response update(Customer customer) throws Throwable {
        Customer updated = customerServiceBean.update(customer);
        return Response.status(Status.ACCEPTED).entity(updated).build();
    }
    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response remove(@PathParam("id") Integer id) throws Throwable {
        Customer removed = customerServiceBean.remove(customerServiceBean.find(id));
        return Response.status(Status.ACCEPTED).entity(removed).build();
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_XML)
    public Response findAll() throws Throwable {
        List<Customer> all = customerServiceBean.findAll("SELECT c FROM Customer c");
        if(all == null) {
          	throw new RuntimeException("No se han encontrado coincidencias");
        }
        GenericEntity<List<Customer>> wrapper = new GenericEntity<List<Customer>>(all) {};
        return Response.status(Status.ACCEPTED).entity(wrapper).build();
    }
    @GET
    @Path("/find/{dni}")
    @Produces(MediaType.APPLICATION_XML)
    public Response findByDni(@PathParam("dni") String dni) throws Throwable {
        Customer found = customerServiceBean.findByDni(dni);
        if(found == null) {
        	throw new Throwable("No se han encontrado coincidencias");
        }
        return Response.status(Response.Status.ACCEPTED).entity(found).build();
    }
    @GET
    @Path("/phones/{dni}")
    @Produces(MediaType.APPLICATION_XML)
    public Response findById(@PathParam("dni") String dni) throws Throwable {
        List<Phone> found = phoneServiceBean.findCustomerPhones(dni);
        if(found == null) {
        	throw new Throwable("No se han encontrado coincidencias");
        }
        GenericEntity<List<Phone>> wrapper = new GenericEntity<List<Phone>>(found) {};
        return Response.status(Response.Status.ACCEPTED).entity(wrapper).build();
    }
    @POST
    @Path("/phones/save")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response savePhone(Phone phone) throws Throwable {
    	Phone saved = phoneServiceBean.save(phone);
    	return Response.status(Status.ACCEPTED).entity(saved).build();
    }
    @PUT
    @Path("/phones/update")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response updatePhone(Phone phone) throws Throwable {
    	Phone updated = phoneServiceBean.update(phone);
    	return Response.status(Status.ACCEPTED).entity(updated).build();
    }
    @DELETE
    @Path("/phones/remove/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Response removePhone(@PathParam("id") Integer id) throws Throwable {
    	Phone removed = phoneServiceBean.remove(phoneServiceBean.find(id));
    	return Response.status(Status.ACCEPTED).entity(removed).build();
    }
}