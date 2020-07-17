package com.walletERP.controller.service.edit;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.entity.Customer;
import com.walletERP.model.entity.CustomerWrapper;
import com.walletERP.model.util.date.NowDate;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@RequestScoped
public class EditCustomersBean implements Serializable {
    private static final long serialVersionUID = -3793581188686617140L;
    private final CustomerDAO customerDAO;
    private final LogoDAO logoDAO;
    private final StatusDAO statusDAO;
    private final TaxDAO taxDAO;
    private CustomerWrapper customerWrapper;
    private final Customer customer;
    private byte[] fileContents;
    private String fileName;
    private Boolean oldStatus;
    private Map<String, Map<String, String>> data;
    private Map<String, String> countries;
    private Map<String, String> cities;

    @PostConstruct
    public void init() {
        this.data = new HashMap<>();
        this.countries = new HashMap<>();
        this.countries.put("Jordan", "Jordan");
        this.countries.put("Palestine", "Palestine");
        this.countries.put("Iraq", "Iraq");
        this.countries.put("Turkey", "Turkey");

        Map<String, String> map = new HashMap<>();
        map.put("'Amman", "'Amman");
        map.put("Ajlun", "Ajlun");
        map.put("Al'Aqabah", "Al'Aqabah");
        map.put("Al Balqa'", "Al Balqa'");
        map.put("Al Karak", "Al Karak");
        map.put("Al Mafraq", "Al Mafraq");
        map.put("At Tafilah", "At Tafilah");
        map.put("Az Zarqa'", "Az Zarqa'");
        map.put("Irbid", "Irbid");
        map.put("Jarash", "Jarash");
        map.put("Ma'an", "Ma'an");
        map.put("Madaba", "Madaba");
        this.data.put("Jordan", map);

        map = new HashMap<>();
        map.put("Acre", "Acre");
        map.put("Safad", "Safad");
        map.put("Haifa", "Haifa");
        map.put("Nazareth", "Nazareth");
        map.put("Tiberias", "Tiberias");
        map.put("Beisan", "Beisan");
        map.put("Tulkarem", "Tulkarem");
        map.put("Jenin", "Jenin");
        map.put("Nablus", "Nablus");
        map.put("Jafaa", "Jafaa");
        map.put("Ramle", "Ramle");
        map.put("Ramallah", "Ramallah");
        map.put("Jerusalem", "Jerusalem");
        map.put("Hebron", "Hebron");
        map.put("Gaza", "Gaza");
        map.put("Beersheba", "Beersheba");
        this.data.put("Palestine", map);

        map = new HashMap<>();
        map.put("Al Anbar", "Al Anbar");
        map.put("Arbil", "Arbil");
        map.put("Al Basrah", "Al Basrah");
        map.put("Babil", "Babil");
        map.put("Baghdad", "Baghdad");
        map.put("Dahuk", "Dahuk");
        map.put("Dhi Qar", "Dhi Qar");
        map.put("Diyala", "Diyala");
        map.put("Al Karbala", "Al Karbala");
        map.put("Al Muthanna", "Al Muthanna");
        map.put("Maysan", "Maysan");
        map.put("An Najaf", "An Najaf");
        map.put("Ninawa", "Ninawa");
        map.put("Al Qadisyah", "Al Qadisyah");
        map.put("Salah ad Din", "Salah ad Din");
        map.put("As Sulaymaniyah", "As Sulaymaniyah");
        map.put("At Ta'mim", "At Ta'mim");
        map.put("Wasit", "Wasit");
        this.data.put("Iraq", map);

        map = new HashMap<>();
        map.put("Adana", "Adana");
        map.put("Adiyaman", "Adiyaman");
        map.put("Afyonkarahisar", "Afyonkarahisar");
        map.put("Agri", "Agri");
        map.put("Aksaray", "Aksaray");
        map.put("Amasya", "Amasya");
        map.put("Ankara", "Ankara");
        map.put("Antalya", "Antalya");
        map.put("Ardahan", "Ardahan");
        map.put("Artvin", "Artvin");
        map.put("Aydin", "Aydin");
        map.put("Balikesir", "Balikesir");
        map.put("Bartin", "Bartin");
        map.put("Batman", "Batman");
        map.put("Bayburt", "Bayburt");
        map.put("Bilecik", "Bilecik");
        map.put("Bingol", "Bingol");
        map.put("Bitlis", "Bitlis");
        map.put("Bolu", "Bolu");
        map.put("Burdur", "Burdur");
        map.put("Bursa", "Bursa");
        map.put("Canakkale", "Canakkale");
        map.put("Cankiri", "Cankiri");
        map.put("Corum", "Corum");
        map.put("Denizli", "Denizli");
        map.put("Diyarbakir", "Diyarbakir");
        map.put("Duzce", "Duzce");
        map.put("Edirne", "Edirne");
        map.put("Elazig", "Elazig");
        map.put("Erzincan", "Erzincan");
        map.put("Erzurum", "Erzurum");
        map.put("Eskisehir", "Eskisehir");
        map.put("Gaziantep", "Gaziantep");
        map.put("Giresun", "Giresun");
        map.put("Gumushane", "Gumushane");
        map.put("Hakkari", "Hakkari");
        map.put("Hatay", "Hatay");
        map.put("Igdir", "Igdir");
        map.put("Isparta", "Isparta");
        map.put("Istanbul", "Istanbul");
        map.put("Izmir", "Izmir");
        map.put("Kahramanmaras", "Kahramanmaras");
        map.put("Karabuk", "Karabuk");
        map.put("Karaman", "Karaman");
        map.put("Kars", "Kars");
        map.put("Kastamonu", "Kastamonu");
        map.put("Kayseri", "Kayseri");
        map.put("Kilis", "Kilis");
        map.put("Kirikkale", "Kirikkale");
        map.put("Kirklareli", "Kirklareli");
        map.put("Kirsehir", "Kirsehir");
        map.put("Kocaeli", "Kocaeli");
        map.put("Konya", "Konya");
        map.put("Kutahya", "Kutahya");
        map.put("Malatya", "Malatya");
        map.put("Manisa", "Manisa");
        map.put("Mardin", "Mardin");
        map.put("Mersin", "Mersin");
        map.put("Mugla", "Mugla");
        map.put("Mus", "Mus");
        map.put("Nevsehir", "Nevsehir");
        map.put("Nigde", "Nigde");
        map.put("Ordu", "Ordu");
        map.put("Osmaniye", "Osmaniye");
        map.put("Rize", "Rize");
        map.put("Sakarya", "Sakarya");
        map.put("Samsun", "Samsun");
        map.put("Sanliurfa", "Sanliurfa");
        map.put("Siirt", "Siirt");
        map.put("Sinop", "Sinop");
        map.put("Sirnak", "Sirnak");
        map.put("Sivas", "Sivas");
        map.put("Tekirdag", "Tekirdag");
        map.put("Tokat", "Tokat");
        map.put("Trabzon", "Trabzon");
        map.put("Tunceli", "Tunceli");
        map.put("Usak", "Usak");
        map.put("Van", "Van");
        map.put("Yalova", "Yalova");
        map.put("Yozgat", "Yozgat");
        map.put("Zonguldak", "Zonguldak");
        this.data.put("Turkey", map);
    }

    @Inject
    public EditCustomersBean(CustomerDAO customerDAO, LogoDAO logoDAO, StatusDAO statusDAO, TaxDAO taxDAO,
                             Customer customer) {
        this.customerDAO = customerDAO;
        this.logoDAO = logoDAO;
        this.statusDAO = statusDAO;
        this.taxDAO = taxDAO;
        this.customer = customer;
    }

    public CustomerWrapper getCustomerWrapper() {
        return customerWrapper;
    }

    public void setCustomerWrapper(CustomerWrapper customerWrapper) {
        this.customerWrapper = customerWrapper;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

    public void onCountryChange() {
        if (this.customerWrapper.getCustomer().getCountry() != null &&
                !this.customerWrapper.getCustomer().getCountry().equals("")) {
            this.cities = this.data.get(this.customerWrapper.getCustomer().getCountry());

        } else {
            this.cities = new HashMap<>();
        }
    }

    public String prepareEditPage() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String customerID = facesContext.getExternalContext().getRequestParameterMap().get("customerIdEdit");
        if (customerID == null) {
            FacesMessage msg = new FacesMessage("Wrong", "Something wrong while handling process.");
            facesContext.addMessage(null, msg);
            throw new RuntimeException("something wrong while handling process.");
        } else {
            this.customer.setCustomerID(Long.valueOf(customerID));
            this.customerWrapper = this.customerDAO.retrieveAllCustomerInfoByID(this.customer);
            this.oldStatus = this.customerWrapper.getCustomerStatus().getActive();
            return "edit-page";
        }
    }

    public void upload(FileUploadEvent event) {
        UploadedFile file = event.getFile();
        this.fileContents = file.getContent();
        this.fileName = file.getFileName();

        FacesMessage msg = new FacesMessage("Successful", "File Uploaded Successfully. ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public String updateCustomer() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (isCustomerFieldValid()) {
            updateCustomerDetails();
            updateCustomerStatus();
            updateCustomerTax();
            updateCustomerLogo();

            FacesMessage msg = new FacesMessage("Successful", "Update Customer: " +
                    this.customerWrapper.getCustomer().getCustomerName());

            facesContext.addMessage(null, msg);

        } else {
            FacesMessage msg = new FacesMessage("Wrong", "All require field must fills.");
            facesContext.addMessage(null, msg);
        }

        facesContext.getExternalContext().getFlash().setKeepMessages(true);

        return "home";
    }

    private void updateCustomerLogo() {
        if (this.fileContents != null) {
            this.customerWrapper.getCustomerLogo().setCustomer(this.customer);
            this.customerWrapper.getCustomerLogo().setPicture(this.fileContents);
            this.customerWrapper.getCustomerLogo().setName(this.fileName);
            this.customerWrapper.getCustomerLogo().setUploadDate(NowDate.getNowTimestamp());
            this.logoDAO.updateCustomerLogoByID(this.customerWrapper.getCustomerLogo());
        }
    }

    private void updateCustomerTax() {
        this.customerWrapper.getCustomerTax().getCustomer().setCustomerID(this.customer.getCustomerID());
        this.taxDAO.updateCustomerTaxBYID(this.customerWrapper.getCustomerTax());
    }

    private void updateCustomerStatus() {
        if (this.oldStatus.compareTo(this.customerWrapper.getCustomerStatus().getActive()) != 0) {
            this.customerWrapper.getCustomerStatus().getCustomer().setCustomerID(this.customer.getCustomerID());
            this.customerWrapper.getCustomerStatus().setLastModify(NowDate.getNowTimestamp());
            this.statusDAO.updateCustomerStatusByID(this.customerWrapper.getCustomerStatus());
        }
    }

    private void updateCustomerDetails() {
        this.customerDAO.updateCustomerByID(this.customerWrapper.getCustomer());
    }

    private Boolean isCustomerFieldValid() {
        return this.customerWrapper.getCustomer().getCustomerName() != null &&
                this.customerWrapper.getCustomer().getCountry() != null &&
                this.customerWrapper.getCustomer().getState() != null &&
                this.customerWrapper.getCustomer().getAddress() != null &&
                this.customerWrapper.getCustomerStatus().getActive() != null &&
                !this.customerWrapper.getCustomer().getCustomerName().equals("") &&
                !this.customerWrapper.getCustomer().getCountry().equals("") &&
                !this.customerWrapper.getCustomer().getState().equals("") &&
                !this.customerWrapper.getCustomer().getAddress().equals("");
    }
}
