package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.Customer;
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

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final NamedParameterJdbcTemplate jdbcNamedTemplate;
    private final ApplicationContext context;

    @Autowired
    public CustomerDAOImpl(DataSource dataSource, @Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.jdbcNamedTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.context = context;
    }

    @Override
    public Long createCustomer(Customer customer) {
        SqlParameterSource param = buildCustomerParameter(customer);
        KeyHolder keyHolder = (KeyHolder) this.context.getBean("buildKeyHolder");

        //language=MySQL
        final String sql = "INSERT INTO `customer-detail`(`customer_id`, `customer_name`, `country`, `state`, `address`, `create_date`) " +
                "VALUES (:customer_id, :customer_name, :country, :state, :address, :create_date);";

        int result = this.jdbcNamedTemplate.update(sql, param, keyHolder);
        if (result > 0 && keyHolder.getKey() != null){
            return keyHolder.getKey().longValue();
        }else {
            return (long)-1;
        }
    }

    private SqlParameterSource buildCustomerParameter(Customer customer){
        MapSqlParameterSource param = (MapSqlParameterSource) this.context.getBean("buildMapParameter");
        param.addValue("customer_id", customer.getCustomerID(), Types.BIGINT);
        param.addValue("customer_name", customer.getCustomerName(), Types.VARCHAR);
        param.addValue("country", customer.getCountry(), Types.VARCHAR);
        param.addValue("state", customer.getState(), Types.VARCHAR);
        param.addValue("address", customer.getAddress(), Types.VARCHAR);
        param.addValue("create_date", customer.getCreateDate(), Types.TIMESTAMP);

        return param;
    }

    @Override
    public int updateCustomerByID(Customer customer) {
        SqlParameterSource param = buildCustomerParameter(customer);
        //language=MySQL
        final String sql = "UPDATE `customer-detail` SET `customer_name` = :customer_name, `country` = :country, " +
                "`state`= :state, `address` = :address, `create_date` = :create_date WHERE `customer_id` = :customer_id;";
        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public int deleteCustomerByID(Customer customer) {
        SqlParameterSource param = buildCustomerParameter(customer);
        //language=MySQL
        final String sql = "DELETE FROM `customer-detail` WHERE `customer_id` = :customer_id;";
        return this.jdbcNamedTemplate.update(sql, param);
    }
}
