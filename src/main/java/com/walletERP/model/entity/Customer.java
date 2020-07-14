package com.walletERP.model.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Component
@Scope("prototype")
public class Customer implements Comparable<Customer>, Serializable {
    private static final long serialVersionUID = 399443145836441006L;
    private Long customerID;
    private String customerName;
    private String country;
    private String state;
    private String address;
    private java.sql.Timestamp createDate;

    public Customer() {
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return getCustomerID().compareTo(that.getCustomerID()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerID());
    }

    @Override
    public int compareTo(Customer o) {
        return this.createDate.compareTo(o.getCreateDate());
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", address='" + address + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
