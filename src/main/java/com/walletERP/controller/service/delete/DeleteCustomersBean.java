package com.walletERP.controller.service.delete;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.entity.Customer;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@SessionScope
public class DeleteCustomersBean implements Serializable {
    private static final long serialVersionUID = 4739757182506178525L;
    private final Customer customer;
    private final CustomerDAO customerDAO;

    @Inject
    public DeleteCustomersBean(Customer customer, CustomerDAO customerDAO) {
        this.customer = customer;
        this.customerDAO = customerDAO;
    }

    public void deleteCustomer(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String customerId = ec.getRequestParameterMap().get("deleteForm:customerIdDelete");
        this.customer.setCustomerID(Long.valueOf(customerId));
        this.customerDAO.deleteCustomerByID(customer);

        FacesMessage msg = new FacesMessage("Successful", "User delete successfully.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
