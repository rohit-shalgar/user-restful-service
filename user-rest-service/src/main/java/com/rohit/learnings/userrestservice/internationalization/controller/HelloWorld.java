package com.rohit.learnings.userrestservice.internationalization.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@SuppressWarnings("unused")
public class HelloWorld {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String getHelloWordInDifferentLanguages(
            @RequestHeader(name="Accept-Language",required = false)Locale locale){

        return messageSource.getMessage(HelloWorldMessages.GOOD_MORNING_MESSAGE,null,locale);

    }

    //you can pass the header, but it is not required to be explicitly used by the method.
    @GetMapping(path = "/hello-world-without-header")
    public String getHelloWordWithoutRequestHeader(){
        return messageSource.getMessage(HelloWorldMessages.GOOD_MORNING_MESSAGE,null, LocaleContextHolder.getLocale());

    }

}
