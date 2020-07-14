package com.walletERP.controller.config;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import java.io.Serializable;

@ApplicationScoped
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
public class ConfigJSF implements Serializable {
    private static final long serialVersionUID = 5494161473643049394L;
}
