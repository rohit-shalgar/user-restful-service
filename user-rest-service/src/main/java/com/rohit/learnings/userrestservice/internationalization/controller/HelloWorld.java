package com.rohit.learnings.userrestservice.internationalization.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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

}
