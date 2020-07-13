package com.walletERP.model.dao;

import com.walletERP.model.entity.Customer;
import com.walletERP.model.entity.CustomerWrapper;

import java.util.List;

public interface CustomerDAO {
    Long createCustomer(Customer customer);

    int updateCustomerByID(Customer customer);
    
    int deleteCustomerByID(Customer customer);

    Customer retrieveCustomerByID(Customer customer);

    List<Customer> retrieveAllCustomer();

    List<CustomerWrapper> retrieveAllCustomerInfo();
}
