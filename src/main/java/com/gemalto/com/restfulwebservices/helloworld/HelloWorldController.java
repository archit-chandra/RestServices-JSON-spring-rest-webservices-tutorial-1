package com.gemalto.com.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
    
//    @RequestMapping(method=RequestMethod.GET, path="/hello-world")
//    public String helloWorld() {
//        return "hello-world";
//    }
    
    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    
    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }
    
    @GetMapping(path="/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
    
    //Localization => LocaleResolver (Default:Locale.US)
    //             => ResourceBundleResource
    // Usage:
    //Autowire MessageSource
    //@RequestHeader(value="Accept-Language, required=false) Locale locale
    //MessageSource.getMessage("helloWorld.message", null, locale)
    @GetMapping(path="/hello-world-localized")
    public String helloWorldLocalized() {
        return "Good Morning"; // "Bonjour"
    }
}
