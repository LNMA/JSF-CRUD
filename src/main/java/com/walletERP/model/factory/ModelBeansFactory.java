package com.walletERP.model.factory;

import com.walletERP.model.entity.Customer;
import com.walletERP.model.entity.CustomerLogo;
import com.walletERP.model.entity.CustomerStatus;
import com.walletERP.model.entity.CustomerTax;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.Collection;
import java.util.HashSet;

@Configuration
@ComponentScan(basePackages = {"com.walletERP.model"})
public class ModelBeansFactory {
    @Bean(name = "buildAnnotationContextModel")
    @Scope("prototype")
    public ApplicationContext buildContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.walletERP.model");
        context.refresh();
        return context;
    }

    @Bean(name = "buildMapParameter")
    @Scope("prototype")
    public MapSqlParameterSource buildMapSqlParameter(){
        return new MapSqlParameterSource();
    }

    @Bean(name = "buildKeyHolder")
    @Scope("prototype")
    public KeyHolder buildGeneratedKeyHolder(){
        return new GeneratedKeyHolder();
    }

    @Bean("customerContainer")
    @Scope("prototype")
    public Collection<Customer> customerContainer(){
        return new HashSet<>(50, (float) 0.8);
    }

    @Bean("customerLogoContainer")
    @Scope("prototype")
    public Collection<CustomerLogo> customerLogoContainer(){
        return new HashSet<>(50, (float) 0.8);
    }

    @Bean("customerStatusContainer")
    @Scope("prototype")
    public Collection<CustomerStatus> customerStatusContainer(){
        return new HashSet<>(50, (float) 0.8);
    }

    @Bean("customerTaxContainer")
    @Scope("prototype")
    public Collection<CustomerTax> customerTaxContainer(){
        return new HashSet<>(50, (float) 0.8);
    }
}
