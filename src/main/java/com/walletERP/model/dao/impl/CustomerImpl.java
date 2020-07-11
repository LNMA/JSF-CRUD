package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class CustomerImpl implements CustomerDAO {
    private final NamedParameterJdbcTemplate jdbcNamedTemplate;

    @Autowired
    public CustomerImpl(DataSource dataSource) {
        this.jdbcNamedTemplate = new NamedParameterJdbcTemplate(dataSource);;
    }

    @Override
    public int createCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(Customer customer) {
        return 0;
    }
}
