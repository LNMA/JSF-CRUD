package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class CustomerWrapperMapper implements RowMapper<CustomerWrapper>, Serializable {
    private static final long serialVersionUID = 1519478285758683372L;
    private final CustomerWrapper customerWrapper;

    @Autowired
    public CustomerWrapperMapper(CustomerWrapper customerWrapper) {
        this.customerWrapper = customerWrapper;
    }

    @Override
    public CustomerWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.customerWrapper.getCustomer().setCustomerID(rs.getLong("customer_id"));
        this.customerWrapper.getCustomer().setCustomerName(rs.getString("customer_name"));
        this.customerWrapper.getCustomer().setCountry(rs.getString("country"));
        this.customerWrapper.getCustomer().setState(rs.getString("state"));
        this.customerWrapper.getCustomer().setAddress(rs.getString("address"));
        this.customerWrapper.getCustomer().setCreateDate(rs.getTimestamp("create_date"));
        this.customerWrapper.getCustomerLogo().setPicture(rs.getBytes("picture"));
        this.customerWrapper.getCustomerLogo().setName(rs.getString("name"));
        this.customerWrapper.getCustomerLogo().setUploadDate(rs.getTimestamp("upload_date"));
        this.customerWrapper.getCustomerStatus().setActive(rs.getBoolean("active"));
        this.customerWrapper.getCustomerStatus().setLastModify(rs.getTimestamp("last_modify"));
        this.customerWrapper.getCustomerTax().setTaxNum(rs.getString("tax_num"));
        return this.customerWrapper;
    }
}
