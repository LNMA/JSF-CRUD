package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerLogo;

public interface LogoDAO {
    Long createCustomerLogo(CustomerLogo customerLogo);

    int updateCustomerLogoByID(CustomerLogo customerLogo);

    int deleteCustomerLogoByID(CustomerLogo customerLogo);
}
