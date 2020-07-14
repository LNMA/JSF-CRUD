package com.walletERP.model.dao;

import com.walletERP.model.entity.CustomerStatus;

import java.io.Serializable;
import java.util.List;

public interface StatusDAO extends Serializable {
    Long createCustomerStatus(CustomerStatus customerStatus);

    int updateCustomerStatusByID(CustomerStatus customerStatus);

    int deleteCustomerStatusByID(CustomerStatus customerStatus);

    CustomerStatus retrieveCustomerStatusByID(CustomerStatus customerStatus);

    List<CustomerStatus> retrieveAllCustomerStatus();
}
