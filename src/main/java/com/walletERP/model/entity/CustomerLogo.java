package com.walletERP.model.entity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class CustomerLogo {
    private Customer customer;
    private byte[] picture;
    private String name;
    private java.sql.Timestamp uploadDate;

    public CustomerLogo() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Timestamp uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerLogo that = (CustomerLogo) o;
        return getCustomer().equals(that.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomer());
    }

    @Override
    public String toString() {
        return "CustomerLogo{" +
                "customer=" + customer +
                ", picture=" + Arrays.toString(picture) +
                ", name='" + name + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
