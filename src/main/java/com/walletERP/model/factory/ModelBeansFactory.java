package com.walletERP.model.factory;

import com.walletERP.model.entity.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import java.util.ArrayList;
import java.util.Collection;

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

    @Bean(name = "buildDefaultLobHandler")
    @Scope("prototype")
    public DefaultLobHandler buildDefaultLobHandler(){
        return new DefaultLobHandler();
    }

    @Bean("customerContainer")
    @Scope("prototype")
    public Collection<Customer> customerContainer(){
        return new ArrayList<>();
    }

    @Bean("customerLogoContainer")
    @Scope("prototype")
    public Collection<CustomerLogo> customerLogoContainer(){
        return new ArrayList<>();
    }

    @Bean("customerStatusContainer")
    @Scope("prototype")
    public Collection<CustomerStatus> customerStatusContainer(){
        return new ArrayList<>();
    }

    @Bean("customerTaxContainer")
    @Scope("prototype")
    public Collection<CustomerTax> customerTaxContainer(){
        return new ArrayList<>();
    }

    @Bean("customerWrapperContainer")
    @Scope("prototype")
    public Collection<CustomerWrapper> customerWrapperContainer(){
        return new ArrayList<>();
    }
}
