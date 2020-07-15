package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerLogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class LogoMapper implements RowMapper<CustomerLogo>, Serializable {
    private static final long serialVersionUID = 4422157809154378888L;
    private final CustomerLogo logo;
    private final DefaultLobHandler defaultLobHandler;

    @Autowired
    public LogoMapper(CustomerLogo logo, @Qualifier("buildDefaultLobHandler") DefaultLobHandler defaultLobHandler) {
        this.logo = logo;
        this.defaultLobHandler = defaultLobHandler;
    }

    @Override
    public CustomerLogo mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.logo.getCustomer().setCustomerID(rs.getLong("customer_id"));
        this.logo.setPicture(this.defaultLobHandler.getBlobAsBytes(rs,"picture"));
        this.logo.setName(rs.getString("name"));
        this.logo.setUploadDate(rs.getTimestamp("upload_date"));
        return this.logo;
    }
}
