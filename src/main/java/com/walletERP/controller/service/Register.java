package com.walletERP.controller.service;

import com.walletERP.model.entity.Customer;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Inject;

@ManagedBean
@ApplicationScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class Register {
    Customer customer;

    @Inject
    public Register(Customer customer) {
        this.customer = customer;
    }

    public String display(){
        return "register/customer-register.xhtml";
    }
}
