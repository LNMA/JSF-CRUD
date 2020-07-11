package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerStatus;

public interface StatusDAO {
    Long createCustomerStatus(CustomerStatus customerStatus);

    int updateCustomerStatusByID(CustomerStatus customerStatus);

    int deleteCustomerStatusByID(CustomerStatus customerStatus);
}
