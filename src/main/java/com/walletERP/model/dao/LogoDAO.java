package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerLogo;

import java.util.Collection;

public interface LogoDAO {
    Long createCustomerLogo(CustomerLogo customerLogo);

    int updateCustomerLogoByID(CustomerLogo customerLogo);

    int deleteCustomerLogoByID(CustomerLogo customerLogo);

    CustomerLogo retrieveCustomerLogoByID(CustomerLogo customerLogo);

    Collection<CustomerLogo> retrieveAllCustomerLogoByID(CustomerLogo customerLogo);
}
