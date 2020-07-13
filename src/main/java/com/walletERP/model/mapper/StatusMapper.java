package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Scope("prototype")
public class StatusMapper implements RowMapper<CustomerStatus> {
    private final CustomerStatus status;

    @Autowired
    public StatusMapper(CustomerStatus status) {
        this.status = status;
    }

    @Override
    public CustomerStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        this.status.getCustomer().setCustomerID(rs.getLong("customer_id"));
        this.status.setActive(rs.getBoolean("active"));
        this.status.setLastModify(rs.getTimestamp("last_modify"));
        return this.status;
    }
}
