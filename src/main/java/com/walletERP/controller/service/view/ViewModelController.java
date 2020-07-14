package com.walletERP.controller.service.view;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.CustomerWrapper;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ViewModelController implements Serializable {
    private static final long serialVersionUID = 5267453387933706238L;
    private final CustomerDAO customerDAO;

    @Inject
    public ViewModelController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        System.out.println(this.customerDAO.retrieveAllCustomerInfo().get(0).toString());
    }

    public List<CustomerWrapper> getCustomerAllInfo(){
        return this.customerDAO.retrieveAllCustomerInfo();
    }
}
