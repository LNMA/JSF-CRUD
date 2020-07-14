package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerLogo;

import java.io.Serializable;
import java.util.List;

public interface LogoDAO extends Serializable {
    Long createCustomerLogo(CustomerLogo customerLogo);

    int updateCustomerLogoByID(CustomerLogo customerLogo);

    int deleteCustomerLogoByID(CustomerLogo customerLogo);

    CustomerLogo retrieveCustomerLogoByID(CustomerLogo customerLogo);

    List<CustomerLogo> retrieveAllCustomerLogo();
}
