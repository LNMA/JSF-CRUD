package com.walletERP.model.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Configuration
@ComponentScan(basePackages = {"com.walletERP.model"})
public class BeansFactory {
    @Bean(name = "buildAnnotationContextModel")
    @Scope("prototype")
    public ApplicationContext buildContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.louay.model");
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
}
