package com.ecommerce.java.Web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    
    @Bean
    public LocaleResolver localeResolver(){
        var slr= new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));//idioma por default a trabajar
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){//forma de cambiar dinamicamente el idioma
        var lci=new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    @Override //Redireccionar sin tener que pasar por el controlador
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
    }
    
}
