package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerTax;

import java.io.Serializable;
import java.util.List;

public interface TaxDAO extends Serializable {
    Long createCustomerTax(CustomerTax customerTax);

    int updateCustomerTaxBYID(CustomerTax customerTax);

    int deleteCustomerTaxByID(CustomerTax customerTax);

    CustomerTax retrieveCustomerTax(CustomerTax customerTax);

    List<CustomerTax> retrieveAllCustomerTax();
}
