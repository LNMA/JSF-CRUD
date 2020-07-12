package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.entity.CustomerTax;
import com.walletERP.model.mapper.TaxMapper;
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
public class TaxDAOImpl implements TaxDAO {
    private final NamedParameterJdbcTemplate jdbcNamedTemplate;
    private final ApplicationContext context;

    @Autowired
    public TaxDAOImpl(DataSource dataSource, @Qualifier("buildAnnotationContextModel") ApplicationContext context) {
        this.jdbcNamedTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.context = context;
    }

    @Override
    public Long createCustomerTax(CustomerTax customerTax) {
        SqlParameterSource param = buildCustomerTaxParameter(customerTax);
        KeyHolder keyHolder = (KeyHolder) this.context.getBean("buildKeyHolder");

        //language=MySQL
        final String sql = "INSERT INTO `customer-tax`(`customer_id`, `tax_num`) VALUES (:customer_id, :tax_num);";

        int result = this.jdbcNamedTemplate.update(sql, param, keyHolder);
        if (result > 0 && keyHolder.getKey() != null){
            return keyHolder.getKey().longValue();
        }else {
            return (long)-1;
        }
    }

    private SqlParameterSource buildCustomerTaxParameter(CustomerTax customerTax){
        MapSqlParameterSource param = (MapSqlParameterSource) this.context.getBean("buildMapParameter");
        param.addValue("customer_id", customerTax.getCustomer().getCustomerID(), Types.BIGINT);
        param.addValue("tax_num", customerTax.getTaxNum(), Types.VARCHAR);

        return param;
    }

    @Override
    public int updateCustomerTaxBYID(CustomerTax customerTax) {
        SqlParameterSource param = buildCustomerTaxParameter(customerTax);

        //language=MySQL
        final String sql = "UPDATE `customer-tax` SET `tax_num` = :tax_num WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public int deleteCustomerTaxByID(CustomerTax customerTax) {
        SqlParameterSource param = buildCustomerTaxParameter(customerTax);

        //language=MySQL
        final String sql = "DELETE FROM `customer-tax` WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public CustomerTax retrieveCustomerTax(CustomerTax customerTax) {
        SqlParameterSource param = buildCustomerTaxParameter(customerTax);
        //language=MySQL
        final String sql = "SELECT * FROM `customer-tax` WHERE `customer_id` = :customer_id;";
        return (CustomerTax) this.jdbcNamedTemplate.query(sql, param, this.context.getBean(TaxMapper.class));
    }

    @Override
    public Collection<CustomerTax> retrieveAllCustomerTaxByID(CustomerTax customerTax) {
        SqlParameterSource param = buildCustomerTaxParameter(customerTax);
        //language=MySQL
        final String sql = "SELECT * FROM `customer-tax`;";

        @SuppressWarnings(value = "unchecked")
        Set<CustomerTax> customersTaxContainer =
                (Set<CustomerTax>) this.context.getBean("customerTaxContainer");
        customersTaxContainer.addAll(this.jdbcNamedTemplate.query(sql, param, this.context.getBean(TaxMapper.class)));

        return customersTaxContainer;
    }
}
