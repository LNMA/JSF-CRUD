package com.walletERP.model.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;

@Component
@Scope("prototype")
public class CustomerStatus {
    private Customer customer;
    private boolean isActive;
    private java.sql.Timestamp lastModify;

    public CustomerStatus() {
    }

    public Customer getCustomer() {
        return customer;
    }

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
    public String toString() {
        return "CustomerTax{" +
                "customer=" + customer +
                ", isActive=" + isActive +
                ", lastModify=" + lastModify +
                '}';
    }
}