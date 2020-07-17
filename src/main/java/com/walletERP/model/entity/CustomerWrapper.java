package com.walletERP.model.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
@Scope("prototype")
public class CustomerWrapper implements Comparable<CustomerWrapper>, Serializable {
    private static final long serialVersionUID = 994936265412350194L;
    private Customer customer;
    private CustomerLogo customerLogo;
    private CustomerStatus customerStatus;
    private CustomerTax customerTax;

    public CustomerWrapper() {
    }

    public Customer getCustomer() {
        return customer;
    }

    @Autowired
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerLogo getCustomerLogo() {
        return customerLogo;
    }

    @Autowired
    public void setCustomerLogo(CustomerLogo customerLogo) {
        this.customerLogo = customerLogo;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    @Autowired
    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerTax getCustomerTax() {
        return customerTax;
    }

    @Autowired
    public void setCustomerTax(CustomerTax customerTax) {
        this.customerTax = customerTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerWrapper that = (CustomerWrapper) o;
        return getCustomer().equals(that.getCustomer()) &&
                getCustomerLogo().equals(that.getCustomerLogo()) &&
                getCustomerStatus().equals(that.getCustomerStatus()) &&
                getCustomerTax().equals(that.getCustomerTax());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getCustomerLogo(), getCustomerStatus(), getCustomerTax());
    }

    @Override
    public int compareTo(CustomerWrapper o) {
        return this.customer.getCreateDate().compareTo(o.getCustomer().getCreateDate());
    }

    @Override
    public String toString() {
        return "CustomerWrapper{" +
                "customer=" + customer +
                ", customerLogo=" + customerLogo +
                ", customerStatus=" + customerStatus +
                ", customerTax=" + customerTax +
                '}';
    }
}
