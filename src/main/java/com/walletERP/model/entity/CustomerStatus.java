package com.walletERP.model.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Component
@Scope("prototype")
public class CustomerStatus implements Comparable<CustomerStatus>, Serializable {
    private static final long serialVersionUID = -1864360941034343140L;
    private Customer customer;
    private boolean isActive;
    private java.sql.Timestamp lastModify;

    public CustomerStatus() {
    }

    public Customer getCustomer() {
        return customer;
    }

    @Autowired
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getLastModify() {
        return lastModify;
    }

    public void setLastModify(Timestamp lastModify) {
        this.lastModify = lastModify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStatus that = (CustomerStatus) o;
        return getCustomer().equals(that.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer());
    }

    @Override
    public int compareTo(CustomerStatus o) {
        return this.lastModify.compareTo(o.getLastModify());
    }

    @Override
    public String toString() {
        return "CustomerStatus{" +
                "customer=" + customer +
                ", isActive=" + isActive +
                ", lastModify=" + lastModify +
                '}';
    }
}
