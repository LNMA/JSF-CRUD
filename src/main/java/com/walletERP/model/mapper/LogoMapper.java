package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerLogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class LogoMapper implements RowMapper<CustomerLogo>, Serializable {
    private static final long serialVersionUID = 3607681062085142371L;
    private DefaultLobHandler defaultLobHandler;
    private ApplicationContext context;

    public DefaultLobHandler getDefaultLobHandler() {
        return defaultLobHandler;
    }

    @Autowired
    public void setDefaultLobHandler(DefaultLobHandler defaultLobHandler) {
        this.defaultLobHandler = defaultLobHandler;
    }

    public ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public CustomerLogo mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerLogo logo = this.context.getBean(CustomerLogo.class);
        logo.getCustomer().setCustomerID(rs.getLong("customer_id"));
        logo.setPicture(this.defaultLobHandler.getBlobAsBytes(rs,"picture"));
        logo.setName(rs.getString("name"));
        logo.setUploadDate(rs.getTimestamp("upload_date"));
        return logo;
    }
}
