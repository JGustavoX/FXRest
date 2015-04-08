package me.localtest.customersapp.services;

import java.io.Serializable;
import java.util.List;

//import javax.ejb.TransactionAttribute;
//import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Gus Garsaky
 * @param <T>
 * @param <PK>
 */
public interface GenericService<T, PK extends Serializable> {
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T save(T t) throws Throwable;
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T update(T t) throws Throwable;
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T remove(T t) throws Throwable;
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public T find(PK pk) throws Throwable;
    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public List<T> findAll(String namedQuery) throws Throwable;
}