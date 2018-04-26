package com.gemalto.com.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

//Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

//    @RequestMapping(method=RequestMethod.GET, path="/hello-world")
//    public String helloWorld() {
//        return "hello-world";
//    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    //Localization => LocaleResolver (Default:Locale.US)
    //             => ResourceBundleResource
    // Usage:
    //Autowire MessageSource
    //@RequestHeader(value="Accept-Language, required=false) Locale locale
    //MessageSource.getMessage("helloWorld.message", null, locale)
    @GetMapping(path = "/hello-world-localized")
    public String helloWorldLocalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        /*return "Good Morning"; // "Bonjour"*/
        return messageSource.getMessage("good.morning.message", null, locale);
    }

    /**
     *  To improve the localization, such that every method
     *  should not add @RequestHeader(name = "Accept-Language", required = false)
     *  to every method
     */
    /*@GetMapping(path = "/hello-world-localized")
    public String helloWorldLocalized(@RequestHeader() {
        *//*return "Good Morning"; // "Bonjour"*//*
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }*/

}
