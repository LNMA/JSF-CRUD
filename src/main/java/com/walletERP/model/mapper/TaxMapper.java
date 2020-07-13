package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class TaxMapper implements RowMapper<CustomerTax> {
    private final CustomerTax tax;

    @Autowired
    public TaxMapper(CustomerTax tax) {
        this.tax = tax;
    }

    @Override
    public CustomerTax mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.tax.getCustomer().setCustomerID(rs.getLong("customer_id"));
        this.tax.setTaxNum(rs.getString("tax_num"));
        return this.tax;
    }
}
