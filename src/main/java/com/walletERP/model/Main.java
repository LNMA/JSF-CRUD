package com.walletERP.model;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.walletERP.model");
        context.refresh();

        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);

        System.out.println(customerDAO.retrieveAllCustomer().iterator().next().toString());

    }
}
