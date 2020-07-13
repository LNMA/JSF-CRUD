package com.walletERP.controller.service.view;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.CustomerWrapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class ViewModelController implements Serializable {
    private CustomerWrapper customerWrapper;
    private CustomerDAO customerDAO;

    @Inject
    public ViewModelController(CustomerWrapper customerWrapper, CustomerDAO customerDAO) {
        this.customerWrapper = customerWrapper;
        this.customerDAO = customerDAO;
    }

    public CustomerWrapper getCustomerWrapper() {
        return customerWrapper;
    }

    public void setCustomerWrapper(CustomerWrapper customerWrapper) {
        this.customerWrapper = customerWrapper;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
