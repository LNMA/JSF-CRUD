package com.walletERP.model.config;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.walletERP.model"})
public class DBConfig {
    @Bean
    @Primary
    public DataSource mysqlDataSource() {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        PoolProperties p = new PoolProperties();
        p.setDriverClassName("com.mysql.cj.jdbc.Driver");
        p.setUrl("jdbc:mysql://localhost:3306/wallet-erp?useSSL=false");
        p.setUsername("root");
        p.setPassword("1729384#General");
        p.setMaxActive(100);
        p.setMaxIdle(100);
        p.setMinIdle(10);
        p.setInitialSize(10);
        p.setMaxWait(10000);
        p.setTestOnBorrow(true);
        p.setTestOnConnect(false);
        p.setTestOnReturn(false);
        p.setTestWhileIdle(false);
        p.setValidationQuery("SELECT 1");
        p.setValidationQueryTimeout(-1);
        p.setValidatorClassName(null);
        p.setTimeBetweenEvictionRunsMillis(5000);
        p.setMinEvictableIdleTimeMillis(30000);
        p.setRemoveAbandoned(true);
        p.setRemoveAbandonedTimeout(60);
        p.setLogAbandoned(true);
        p.setJmxEnabled(true);
        p.setValidationInterval(3000);
        p.setMaxAge(7200000);
        p.setJdbcInterceptors(
                "org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"+
                        "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
        dataSource.setPoolProperties(p);

        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate getJdbcTemplate(){
        return new NamedParameterJdbcTemplate(mysqlDataSource());
    }
}
