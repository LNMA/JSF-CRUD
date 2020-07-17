package com.walletERP.model.mapper;

import com.walletERP.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class CustomerMapper implements RowMapper<Customer>, Serializable {
    private static final long serialVersionUID = -2260635831461199210L;
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = this.context.getBean(Customer.class);
        customer.setCustomerID(rs.getLong("customer_id"));
        customer.setCustomerName(rs.getString("customer_name"));
        customer.setCountry(rs.getString("country"));
        customer.setState(rs.getString("state"));
        customer.setAddress(rs.getString("address"));
        customer.setCreateDate(rs.getTimestamp("create_date"));
        return customer;
    }
}
