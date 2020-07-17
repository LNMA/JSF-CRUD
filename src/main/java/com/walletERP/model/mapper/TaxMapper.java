package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerTax;
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
public class TaxMapper implements RowMapper<CustomerTax>, Serializable {
    private static final long serialVersionUID = -3911508359163104738L;
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public CustomerTax mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerTax tax = this.context.getBean(CustomerTax.class);
        tax.getCustomer().setCustomerID(rs.getLong("customer_id"));
        tax.setTaxNum(rs.getString("tax_num"));
        return tax;
    }
}
