package com.walletERP.model.dao.impl;

import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.entity.CustomerLogo;
import com.walletERP.model.mapper.LogoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class LogoDAOImpl implements LogoDAO {
    private static final long serialVersionUID = 1508091990011952333L;
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
    public Long createCustomerLogo(CustomerLogo customerLogo) {
        SqlParameterSource param = buildCustomerLogoParameter(customerLogo);
        KeyHolder keyHolder = (KeyHolder) this.context.getBean("buildKeyHolder");

        //language=MySQL
        final String sql = "INSERT INTO `customer-logo`(`customer_id`, `picture`, `name`, `upload_date`) " +
                "VALUES (:customer_id, :picture, :name, :upload_date );";

        int result = this.jdbcNamedTemplate.update(sql, param, keyHolder);
        if (result > 0 && keyHolder.getKey() != null) {
            return keyHolder.getKey().longValue();
        } else {
            return (long) -1;
        }
    }

    private SqlParameterSource buildCustomerLogoParameter(CustomerLogo customerLogo) {
        MapSqlParameterSource param = (MapSqlParameterSource) this.context.getBean("buildMapParameter");
        param.addValue("customer_id", customerLogo.getCustomer().getCustomerID(), Types.BIGINT);
        param.addValue("picture", new SqlLobValue(customerLogo.getPicture()), Types.BLOB);
        param.addValue("name", customerLogo.getName(), Types.VARCHAR);
        param.addValue("upload_date", customerLogo.getUploadDate(), Types.TIMESTAMP);

        return param;
    }

    @Override
    public int updateCustomerLogoByID(CustomerLogo customerLogo) {
        SqlParameterSource param = buildCustomerLogoParameter(customerLogo);

        //language=MySQL
        final String sql = "UPDATE `customer-logo` SET `picture` = :picture, `name` = :name, `upload_date` = :upload_date " +
                "WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);

    }

    @Override
    public int deleteCustomerLogoByID(CustomerLogo customerLogo) {
        SqlParameterSource param = buildCustomerLogoParameter(customerLogo);

        //language=MySQL
        final String sql = "DELETE FROM `customer-logo` WHERE`customer_id` = :customer_id;";

        return this.jdbcNamedTemplate.update(sql, param);
    }

    @Override
    public CustomerLogo retrieveCustomerLogoByID(CustomerLogo customerLogo) {
        SqlParameterSource param = buildCustomerLogoParameter(customerLogo);
        //language=MySQL
        final String sql = "SELECT * FROM `customer-logo` WHERE `customer_id` = :customer_id;";
        return this.jdbcNamedTemplate.queryForObject(sql, param, this.context.getBean(LogoMapper.class));
    }

    @Override
    public List<CustomerLogo> retrieveAllCustomerLogo() {
        //language=MySQL
        final String sql = "SELECT * FROM `customer-logo`;";

        return this.jdbcNamedTemplate.query(sql, this.context.getBean(LogoMapper.class));
    }
}
