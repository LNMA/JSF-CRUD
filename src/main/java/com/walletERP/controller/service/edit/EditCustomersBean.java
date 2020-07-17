package com.walletERP.controller.service.edit;

import com.walletERP.model.dao.CustomerDAO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

@ManagedBean
@RequestScoped
public class EditCustomersBean {
    private CustomerDAO customerDAO;

}
