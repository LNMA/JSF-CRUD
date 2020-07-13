package com.walletERP.controller.service.view;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.dao.TaxDAO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Set;

@ManagedBean
@RequestScoped
public class ViewModalController implements Serializable {
    private final CustomerDAO customerDAO;
    private final LogoDAO customerLogoDAO;
    private final StatusDAO customerStatusDAO;
    private final TaxDAO customerTaxDAO;

    @Inject
    public ViewModalController(CustomerDAO customerDAO, LogoDAO customerLogoDAO, StatusDAO customerStatusDAO, TaxDAO customerTaxDAO) {
        this.customerDAO = customerDAO;
        this.customerLogoDAO = customerLogoDAO;
        this.customerStatusDAO = customerStatusDAO;
        this.customerTaxDAO = customerTaxDAO;
    }

    public Set<Object> viewAllCustomerInfo(){
        return null;
    }

}
