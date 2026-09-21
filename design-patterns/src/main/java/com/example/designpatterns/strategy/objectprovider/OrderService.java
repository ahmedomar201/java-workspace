package com.example.designpatterns.strategy.objectprovider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final ObjectProvider<SmsService> smsServiceProvider;

    public OrderService(ObjectProvider<SmsService> smsServiceProvider) {

        this.smsServiceProvider = smsServiceProvider;
    }

    public void send(String message) {
        final SmsService smsService = smsServiceProvider.getIfAvailable();
        Optional.ofNullable(smsService)
                        .ifPresent(s -> s.send(message));
    }
}
