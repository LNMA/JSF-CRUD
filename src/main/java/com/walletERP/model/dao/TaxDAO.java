package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerTax;

public interface TaxDAO {
    Long createCustomerTax(CustomerTax customerTax);

    int updateCustomerTaxBYID(CustomerTax customerTax);

    int deleteCustomerTaxByID(CustomerTax customerTax);
}
