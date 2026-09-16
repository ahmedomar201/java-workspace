package com.example.designpatterns.strategy.objectprovider;

import org.springframework.beans.factory.ObjectProvider;

public class OrderService {

    private final ObjectProvider<SmsService> smsServiceProvider;

    public OrderService( ObjectProvider<SmsService> smsServiceProvider) {

        this.smsServiceProvider = smsServiceProvider;
    }

    public void send() {
        smsServiceProvider.getObject().send();
    }
}
