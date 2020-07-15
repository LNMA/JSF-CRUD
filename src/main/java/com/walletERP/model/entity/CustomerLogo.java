package com.walletERP.model.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Base64;
import java.util.Objects;

@Component
@Scope("prototype")
public class CustomerLogo implements Comparable<CustomerLogo>, Serializable {
    private static final long serialVersionUID = -759570026208211998L;
    private Customer customer;
    private byte[] picture;
    private String name;
    private java.sql.Timestamp uploadDate;

    public CustomerLogo() {
    }

    public Customer getCustomer() {
        return customer;
    }

    @Autowired
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

    public StringBuilder getBase64() {
        StringBuilder stringBase46 = new StringBuilder();
        stringBase46.append(Base64.getEncoder().encodeToString(this.picture));

        return stringBase46;
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
    public int compareTo(CustomerLogo o) {
        return this.uploadDate.compareTo(o.getUploadDate());
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
