package com.walletERP.controller.factory;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.dao.impl.CustomerDAOImpl;
import com.walletERP.model.dao.impl.LogoDAOImpl;
import com.walletERP.model.dao.impl.StatusDAOImpl;
import com.walletERP.model.dao.impl.TaxDAOImpl;
import com.walletERP.model.entity.*;
import com.walletERP.model.util.file.FileProcess;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.walletERP.model", "com.walletERP.controller"})
public class ControllerBeansFactory {

    @Bean
    @Scope("prototype")
    public Customer customer(){
        return new Customer();
    }

    @Bean
    @Scope("prototype")
    public CustomerLogo customerLogo(){
        return new CustomerLogo();
    }

    @Bean
    @Scope("prototype")
    public CustomerStatus customerStatus(){
        return new CustomerStatus();
    }

    @Bean
    @Scope("prototype")
    public CustomerTax customerTax(){
        return new CustomerTax();
    }

    @Bean
    @Scope("prototype")
    public CustomerWrapper customerWrapper(){
        return new CustomerWrapper();
    }

    @Bean
    @Scope("prototype")
    public CustomerDAO customerDAO(){
        return new CustomerDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public LogoDAO logoDAO(){
        return new LogoDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public StatusDAO statusDAO(){
        return new StatusDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public TaxDAO taxDAO(){
        return new TaxDAOImpl();
    }

    @Bean
    @Scope("prototype")
    public FileProcess fileProcess(){
        return new FileProcess();
    }
}
