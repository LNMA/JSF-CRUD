package com.walletERP.model.entity;

import java.util.Objects;

public class Customer {
    private Long customerID;
    private String customerName;
    private String country;
    private String state;
    private String address;
    private String createDate;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
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
