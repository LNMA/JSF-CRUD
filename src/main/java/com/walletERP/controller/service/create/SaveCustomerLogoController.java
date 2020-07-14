package com.walletERP.controller.service.create;

import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.entity.CustomerLogo;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean
@RequestScoped
public class SaveCustomerLogoController {
    private CustomerLogo customerLogo;
    private final LogoDAO customerLogoDAO;
    private UploadedFile uploadedFile;

    @Inject
    public SaveCustomerLogoController(CustomerLogo customerLogo, LogoDAO logoDAO) {
        this.customerLogo = customerLogo;
        this.customerLogoDAO = logoDAO;
    }

    public CustomerLogo getCustomerLogo() {
        return customerLogo;
    }

    public void setCustomerLogo(CustomerLogo customerLogo) {
        this.customerLogo = customerLogo;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void upload() {
        if (uploadedFile != null) {
            FacesMessage message = new FacesMessage("Successful", uploadedFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}
