package com.walletERP.model.dao;

import com.walletERP.model.entity.Customer;

public interface CustomerDAO {
    int createCustomer(Customer customer);

    int updateCustomer(Customer customer);
    
    int deleteCustomer(Customer customer);
}
