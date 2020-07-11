package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerStatus;

public interface StatusDAO {
    int createCustomerStatus(CustomerStatus customerStatus);

    int updateCustomerStatus(CustomerStatus customerStatus);

    int deleteCustomerStatus(CustomerStatus customerStatus);
}
