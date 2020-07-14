package com.walletERP.controller.service.create;

import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.entity.CustomerTax;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class SaveCustomerTaxController {
    private CustomerTax customerTax;
    private final TaxDAO customerTaxDAO;

    @Inject
    public SaveCustomerTaxController(CustomerTax customerTax, TaxDAO taxDAO) {
        this.customerTax = customerTax;
        this.customerTaxDAO = taxDAO;
    }

    public CustomerTax getCustomerTax() {
        return customerTax;
    }

    public void setCustomerTax(CustomerTax customerTax) {
        this.customerTax = customerTax;
    }
}
