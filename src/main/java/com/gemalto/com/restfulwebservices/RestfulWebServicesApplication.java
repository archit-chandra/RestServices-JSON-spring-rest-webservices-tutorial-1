package com.gemalto.com.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServicesApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        /**
         *  To improve the localization, such that every method
         *  should not add @RequestHeader(name = "Accept-Language", required = false)
         *  to every method
         */
        //AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    // To read messages from the appropriate message properties file,
    // and customized them based on the input accept header
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("locale/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
