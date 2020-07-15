package com.walletERP.controller.service.create;

import com.walletERP.model.dao.CustomerDAO;
import com.walletERP.model.dao.LogoDAO;
import com.walletERP.model.dao.StatusDAO;
import com.walletERP.model.dao.TaxDAO;
import com.walletERP.model.entity.CustomerWrapper;
import com.walletERP.model.util.date.NowDate;
import com.walletERP.model.util.file.FileProcess;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@ManagedBean
@SessionScoped
public class CreateCustomerBean implements Serializable {
    private static final long serialVersionUID = -8180129954271174492L;
    private CustomerWrapper customerWrapper;
    private final CustomerDAO customerDAO;
    private final LogoDAO logoDAO;
    private final StatusDAO statusDAO;
    private final TaxDAO taxDAO;
    private Map<String, Map<String, String>> data;
    private Map<String, String> countries;
    private Map<String, String> cities;
    private UploadedFile file;
    private byte[] fileContents;
    private String fileName;
    private FileProcess fileProcess;

    @Inject
    public CreateCustomerBean(CustomerWrapper customerWrapper, CustomerDAO customerDAO, LogoDAO logoDAO,
                              StatusDAO statusDAO, TaxDAO taxDAO) {
        this.customerWrapper = customerWrapper;
        this.customerDAO = customerDAO;
        this.logoDAO = logoDAO;
        this.statusDAO = statusDAO;
        this.taxDAO = taxDAO;
    }

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
        if (this.customerWrapper.getCustomer().getCountry() != null && !this.customerWrapper.getCustomer().getCountry().equals(""))
            this.cities = this.data.get(this.customerWrapper.getCustomer().getCountry());
        else
            this.cities = new HashMap<>();
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    @Inject
    public void setFileProcess(FileProcess fileProcess) {
        this.fileProcess = fileProcess;
    }

    public void upload(FileUploadEvent event) {
        this.file = event.getFile();
        this.fileContents = this.file.getContent();
        this.fileName = this.file.getFileName();

        FacesMessage msg = new FacesMessage("Successful", "File Uploaded Successfully. ");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void saveCustomer() {
        if (isCustomerFieldValid()) {
            Long customerID = saveCustomerDetails();
            saveCustomerStatus(customerID);
            saveCustomerTax(customerID);
            saveCustomerLogo(customerID);

            FacesMessage msg = new FacesMessage("Successful",
                    "Add Customer " + this.customerWrapper.getCustomer().getCustomerName());
            FacesContext.getCurrentInstance().addMessage(null, msg);

        } else {
            FacesMessage msg = new FacesMessage("Wrong", "All require field must fills.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    private byte[] uploadDefaultImg() {
        byte[] bytes = null;
        try {
            //TODO change path to your path
            bytes = this.fileProcess.readAPicture("C:\\Users\\Oday Amr\\Documents\\IdeaProjects\\Wallet_ERP-Task\\src\\main\\resources\\img\\no-logo.png");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return bytes;
    }

    private void saveCustomerLogo(Long customerID) {
        this.customerWrapper.getCustomerLogo().getCustomer().setCustomerID(customerID);
        if (this.fileContents == null) {
            this.customerWrapper.getCustomerLogo().setPicture(uploadDefaultImg());
            this.customerWrapper.getCustomerLogo().setName("no-logo.png");

        } else {
            this.customerWrapper.getCustomerLogo().setPicture(this.fileContents);
            this.customerWrapper.getCustomerLogo().setName(this.fileName);
        }

        this.customerWrapper.getCustomerLogo().setUploadDate(NowDate.getNowTimestamp());
        this.logoDAO.createCustomerLogo(this.customerWrapper.getCustomerLogo());
    }

    private void saveCustomerTax(Long customerID) {
        this.customerWrapper.getCustomerTax().getCustomer().setCustomerID(customerID);
        this.taxDAO.createCustomerTax(this.customerWrapper.getCustomerTax());
    }

    private void saveCustomerStatus(Long customerID) {
        this.customerWrapper.getCustomerStatus().setLastModify(NowDate.getNowTimestamp());
        this.customerWrapper.getCustomerStatus().getCustomer().setCustomerID(customerID);
        this.statusDAO.createCustomerStatus(this.customerWrapper.getCustomerStatus());
    }

    private Long saveCustomerDetails() {
        this.customerWrapper.getCustomer().setCreateDate(NowDate.getNowTimestamp());
        return this.customerDAO.createCustomer(this.customerWrapper.getCustomer());
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
