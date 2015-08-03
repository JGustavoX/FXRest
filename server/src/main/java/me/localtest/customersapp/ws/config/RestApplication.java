package me.localtest.customersapp.ws.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import me.localtest.customersapp.ws.CustomerServiceRS;

/**
 *
 * @author Gustavo García
 */
@ApplicationPath("api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> rests = new HashSet<>();
    	rests.add(CustomerServiceRS.class);
    	return rests;
    }
}
