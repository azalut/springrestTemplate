package com.maciej.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = webApplicationContext();

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

    public AnnotationConfigWebApplicationContext webApplicationContext(){
        AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();
        config.setConfigLocation("com.maciej.config");
        return config;
    }
}
