package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerStatus;

import java.util.List;

public interface StatusDAO {
    Long createCustomerStatus(CustomerStatus customerStatus);

    int updateCustomerStatusByID(CustomerStatus customerStatus);

    int deleteCustomerStatusByID(CustomerStatus customerStatus);

    CustomerStatus retrieveCustomerStatusByID(CustomerStatus customerStatus);

    List<CustomerStatus> retrieveAllCustomerStatus();
}
