package com.walletERP.controller.service.create;

import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.entity.CustomerStatus;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class SaveCustomerStatusController {
    private CustomerStatus customerStatus;
    private final StatusDAO customerStatusDAO;

    @Inject
    public SaveCustomerStatusController(CustomerStatus customerStatus, StatusDAO statusDAO) {
        this.customerStatus = customerStatus;
        this.customerStatusDAO = statusDAO;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }
}
