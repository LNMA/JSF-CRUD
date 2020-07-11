package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerLogo;

public interface LogoDAO {
    int createCustomerLogo(CustomerLogo customerLogo);

    int updateCustomerLogo(CustomerLogo customerLogo);

    int deleteCustomerLogo(CustomerLogo customerLogo);
}
