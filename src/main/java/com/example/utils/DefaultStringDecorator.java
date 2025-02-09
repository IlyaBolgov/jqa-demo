package com.example.utils;

import org.springframework.stereotype.Component;

@Component
public class DefaultStringDecorator implements StringDecorator {

    @Override
    public String decorate(String account) {
        return "Decorated: " + account;
    }
}
