package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerLogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class LogoMapper implements RowMapper<CustomerLogo> {
    private final CustomerLogo logo;

    @Autowired
    public LogoMapper(CustomerLogo logo) {
        this.logo = logo;
    }

    @Override
    public CustomerLogo mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.logo.getCustomer().setCustomerID(rs.getLong("customer_id"));
        this.logo.setPicture(rs.getBytes("picture"));
        this.logo.setName(rs.getString("name"));
        this.logo.setUploadDate(rs.getTimestamp("upload_date"));
        return this.logo;
    }
}
