package com.walletERP.controller.service.view;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.CustomerWrapper;
import com.walletERP.model.util.date.NowDate;
import com.walletERP.model.util.file.FileProcess;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@RequestScoped
public class ViewCustomersBean implements Serializable {
    private static final long serialVersionUID = 31543384323170989L;
    private final CustomerDAO customerDAO;
    private CustomerWrapper customerWrapper;
    private FileProcess fileProcess;

    @Inject
    public ViewCustomersBean(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Inject
    public void setCustomerWrapper(CustomerWrapper customerWrapper) {
        this.customerWrapper = customerWrapper;
    }

    public FileProcess getFileProcess() {
        return fileProcess;
    }

    @Inject
    public void setFileProcess(FileProcess fileProcess) {
        this.fileProcess = fileProcess;
    }

    public List<CustomerWrapper> getCustomerAllInfo(){
        List<CustomerWrapper> customerWrapperList = this.customerDAO.retrieveAllCustomerInfo();
        if (customerWrapperList.size() == 0){
            this.customerWrapper.getCustomer().setCustomerID((long)0);
            this.customerWrapper.getCustomer().setCustomerName("There is no customer yet.");
            this.customerWrapper.getCustomer().setCountry("System");
            this.customerWrapper.getCustomer().setState("Controller");
            this.customerWrapper.getCustomer().setAddress("ViewCustomersBean.class");
            this.customerWrapper.getCustomer().setCreateDate(NowDate.getNowTimestamp());
            this.customerWrapper.getCustomerLogo().setPicture(this.fileProcess.uploadDefaultImg());
            customerWrapperList.add(this.customerWrapper);
        }
        return customerWrapperList;
    }
}
