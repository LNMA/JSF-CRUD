package com.walletERP.controller.factory;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.dao.impl.CustomerDAOImpl;
import com.walletERP.model.dao.impl.LogoDAOImpl;
import com.walletERP.model.dao.impl.StatusDAOImpl;
import com.walletERP.model.dao.impl.TaxDAOImpl;
import com.walletERP.model.entity.Customer;
import com.walletERP.model.entity.CustomerLogo;
import com.walletERP.model.entity.CustomerStatus;
import com.walletERP.model.entity.CustomerTax;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.walletERP.model")
public class ControllerBeansFactory {

    @Bean
    @Scope("prototype")
    public Customer getCustomer(){
        return new Customer();
    }

    @Bean
    @Scope("prototype")
    public CustomerLogo getCustomerLogo(){
        return new CustomerLogo();
    }

    @Bean
    @Scope("prototype")
    public CustomerStatus getCustomerStatus(){
        return new CustomerStatus();
    }

    @Bean
    @Scope("prototype")
    public CustomerTax getCustomerTax(){
        return new CustomerTax();
    }

    @Bean
    @Scope("prototype")
    public CustomerDAO getCustomerDAO(){
        return new CustomerDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public LogoDAO getCustomerLogoDAO(){
        return new LogoDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public StatusDAO getCustomerStatusDAO(){
        return new StatusDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public TaxDAO getCustomerTaxDAO(){
        return new TaxDAOImpl();
    }
}
