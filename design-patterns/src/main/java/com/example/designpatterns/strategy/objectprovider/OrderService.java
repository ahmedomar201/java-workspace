package com.example.designpatterns.strategy.objectprovider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ObjectProvider<SmsService> smsServiceProvider;

    public OrderService(ObjectProvider<SmsService> smsServiceProvider) {

        this.smsServiceProvider = smsServiceProvider;
    }

    public void send(String message) {
        smsServiceProvider.getIfAvailable().send(message);
    }
}
