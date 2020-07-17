package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerWrapper;
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
public class CustomerWrapperMapper implements RowMapper<CustomerWrapper>, Serializable {
    private static final long serialVersionUID = 8219462350977823390L;
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public CustomerWrapper mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerWrapper customerWrapper = this.context.getBean(CustomerWrapper.class);
        customerWrapper.getCustomer().setCustomerID(rs.getLong("customer_id"));
        customerWrapper.getCustomer().setCustomerName(rs.getString("customer_name"));
        customerWrapper.getCustomer().setCountry(rs.getString("country"));
        customerWrapper.getCustomer().setState(rs.getString("state"));
        customerWrapper.getCustomer().setAddress(rs.getString("address"));
        customerWrapper.getCustomer().setCreateDate(rs.getTimestamp("create_date"));
        customerWrapper.getCustomerLogo().setPicture(rs.getBytes("picture"));
        customerWrapper.getCustomerLogo().setName(rs.getString("name"));
        customerWrapper.getCustomerLogo().setUploadDate(rs.getTimestamp("upload_date"));
        customerWrapper.getCustomerStatus().setActive(rs.getBoolean("active"));
        customerWrapper.getCustomerStatus().setLastModify(rs.getTimestamp("last_modify"));
        customerWrapper.getCustomerTax().setTaxNum(rs.getString("tax_num"));
        return customerWrapper;
    }
}
