package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.Customer;
import com.walletERP.model.mapper.CustomerMapper;
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
import java.util.Collection;
import java.util.Set;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private NamedParameterJdbcTemplate jdbcNamedTemplate;
    private ApplicationContext context;

    @Autowired
    public void setJdbcNamedTemplate(DataSource dataSource) {
        this.jdbcNamedTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    public void setContext(@Qualifier("buildAnnotationContextModel") ApplicationContext context) {
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

    @Override
    public Customer retrieveCustomerByID(Customer customer) {
        SqlParameterSource param = buildCustomerParameter(customer);
        //language=MySQL
        final String sql = "SELECT * FROM `customer-detail` WHERE `customer_id` = :customer_id;";
        return (Customer) this.jdbcNamedTemplate.query(sql, param, this.context.getBean(CustomerMapper.class));
    }

    @Override
    public Collection<Customer> retrieveAllCustomer() {
        //language=MySQL
        final String sql = "SELECT * FROM `customer-detail`;";

        @SuppressWarnings(value = "unchecked")
        Set<Customer> customersContainer = (Set<Customer>) this.context.getBean("customerContainer");
        customersContainer.addAll(this.jdbcNamedTemplate.query(sql, this.context.getBean(CustomerMapper.class)));

        return customersContainer;
    }

    @Override
    public Collection<Object> retrieveAllCustomerInfo() {
        //language=MySQL
        final String sql = "SELECT `customer-detail`.`customer_id`, `customer-detail`.`customer_name`, " +
                "`customer-detail`.`country`, `customer-detail`.`state`, `customer-detail`.`address`, " +
                "`customer-detail`.`create_date`, `customer-logo`.`picture`, `customer-logo`.`name`, " +
                "`customer-logo`.`upload_date`, `customer-status`.`active`, `customer-status`.`last_modify`, " +
                "`customer-tax`.`tax_num` FROM `customer-detail` INNER JOIN `customer-logo` ON " +
                "`customer-detail`.`customer_id` = `customer-logo`.`customer_id` INNER JOIN `customer-status` ON " +
                "`customer-detail`.`customer_id` = `customer-status`.`customer_id` INNER JOIN `customer-tax` ON " +
                "`customer-detail`.`customer_id` = `customer-tax`.`customer_id`;";


        this.jdbcNamedTemplate.query(sql, this.context.getBean(CustomerMapper.class));

        return null;
    }
}
