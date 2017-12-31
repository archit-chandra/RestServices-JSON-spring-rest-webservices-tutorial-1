package com.gemalto.com.restfulwebservices.helloworld;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControllerTest {
    
    @Autowired
    private MessageSource messageSource;
    
    @Test
    public void localizationTest() {
        String code = "good.morning.message";
        Locale locale = Locale.US;
        String localizedMessage = messageSource.getMessage(code, null, locale);
        System.out.println("localizedMessage" + localizedMessage);
        assertEquals("Good Morning", localizedMessage);
    }

}
