package com.walletERP.controller.config;/*

import com.sun.faces.config.FacesInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

public class MainWebAppInitializer extends FacesInitializer implements WebApplicationInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainWebAppInitializer.class);
    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        super.onStartup(classes, servletContext);
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        LOGGER.info("MainWebAppInitializer.onStartup()");

        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(root));
    }
}
*/