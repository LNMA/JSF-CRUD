package com.walletERP.model.dao;

import com.walletERP.model.entity.Customer;

import java.util.Collection;

public interface CustomerDAO {
    Long createCustomer(Customer customer);

    int updateCustomerByID(Customer customer);
    
    int deleteCustomerByID(Customer customer);

    Customer retrieveCustomerByID(Customer customer);

    Collection<Customer> retrieveAllCustomer();

    Collection<Object> retrieveAllCustomerInfo();
}
