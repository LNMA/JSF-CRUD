package com.walletERP.model.dao;

import com.walletERP.model.entity.Customer;

public interface CustomerDAO {
    Long createCustomer(Customer customer);

    int updateCustomerByID(Customer customer);
    
    int deleteCustomerByID(Customer customer);
}
