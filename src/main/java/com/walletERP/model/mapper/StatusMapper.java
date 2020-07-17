package com.walletERP.model.mapper;

import com.walletERP.model.entity.CustomerStatus;
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
public class StatusMapper implements RowMapper<CustomerStatus>, Serializable {
    private static final long serialVersionUID = -5474898287087603534L;
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public CustomerStatus mapRow(ResultSet rs, int rowNum) throws SQLException {
        CustomerStatus status = this.context.getBean(CustomerStatus.class);
        status.getCustomer().setCustomerID(rs.getLong("customer_id"));
        status.setActive(rs.getBoolean("active"));
        status.setLastModify(rs.getTimestamp("last_modify"));
        return status;
    }
}
