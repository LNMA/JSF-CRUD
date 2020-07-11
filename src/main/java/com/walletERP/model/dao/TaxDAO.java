package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerTax;

public interface TaxDAO {
    int createCustomerTax(CustomerTax customerTax);

    int updateCustomerTax(CustomerTax customerTax);

    int deleteCustomerTax(CustomerTax customerTax);
}
