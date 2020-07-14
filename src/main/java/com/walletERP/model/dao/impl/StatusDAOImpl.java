package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.entity.CustomerStatus;
import com.walletERP.model.mapper.StatusMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

@Repository
public class StatusDAOImpl implements StatusDAO {
    private static final long serialVersionUID = -7057686126877158452L;
    private NamedParameterJdbcTemplate jdbcNamedTemplate;
    private ApplicationContext context;

    @Autowired
    public void setJdbcNamedTemplate(NamedParameterJdbcTemplate jdbcNamedTemplate) {
        this.jdbcNamedTemplate = jdbcNamedTemplate;
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.context = context;
    }

    @Override
    public Long createCustomerStatus(CustomerStatus customerStatus) {
        SqlParameterSource param = buildCustomerStatusParameter(customerStatus);
        KeyHolder keyHolder = (KeyHolder) this.context.getBean("buildKeyHolder");

        //language=MySQL
        final String sql = "INSERT INTO `customer-status`(`customer_id`, `active`, `last_modify`) VALUES " +
                "(:customer_id, :active, :last_modify );";

        int result = this.jdbcNamedTemplate.update(sql, param, keyHolder);
        if (result > 0 && keyHolder.getKey() != null){
            return keyHolder.getKey().longValue();
        }else {
            return (long)-1;
        }
    }

    private SqlParameterSource buildCustomerStatusParameter(CustomerStatus customerStatus){
        MapSqlParameterSource param = (MapSqlParameterSource) this.context.getBean("buildMapParameter");
        param.addValue("customer_id", customerStatus.getCustomer().getCustomerID(), Types.BIGINT);
        param.addValue("active", customerStatus.isActive(), Types.TINYINT);
        param.addValue("last_modify", customerStatus.getLastModify(), Types.TIMESTAMP);

        return param;
    }

    @Override
    public int updateCustomerStatusByID(CustomerStatus customerStatus) {
        SqlParameterSource param = buildCustomerStatusParameter(customerStatus);

        //language=MySQL
        final String sql = "UPDATE `customer-status` SET `active` = :active, `last_modify` = :last_modify " +
                "WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public int deleteCustomerStatusByID(CustomerStatus customerStatus) {
        SqlParameterSource param = buildCustomerStatusParameter(customerStatus);

        //language=MySQL
        final String sql = "DELETE FROM `customer-status` WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public CustomerStatus retrieveCustomerStatusByID(CustomerStatus customerStatus) {
        SqlParameterSource param = buildCustomerStatusParameter(customerStatus);
        //language=MySQL
        final String sql = "SELECT * FROM `customer-status` WHERE `customer_id` = :customer_id;";
        return (CustomerStatus) this.jdbcNamedTemplate.query(sql, param, this.context.getBean(StatusMapper.class));
    }

    @Override
    public List<CustomerStatus> retrieveAllCustomerStatus( ) {
        //language=MySQL
        final String sql = "SELECT * FROM `customer-status`;";

        return this.jdbcNamedTemplate.query(sql, this.context.getBean(StatusMapper.class));
    }
}
