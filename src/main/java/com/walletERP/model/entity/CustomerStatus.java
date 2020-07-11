package com.walletERP.model.entity;

import java.util.Objects;

public class CustomerStatus {
    private Customer customer;
    private String taxNum;

    public CustomerStatus() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTaxNum() {
        return taxNum;
    }

    public void setTaxNum(String taxNum) {
        this.taxNum = taxNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStatus that = (CustomerStatus) o;
        return getCustomer().equals(that.getCustomer()) &&
                getTaxNum().compareTo(that.getTaxNum()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer(), getTaxNum());
    }

    @Override
    public String toString() {
        return "CustomerStatus{" +
                "customer=" + customer +
                ", taxNum='" + taxNum + '\'' +
                '}';
    }
}
