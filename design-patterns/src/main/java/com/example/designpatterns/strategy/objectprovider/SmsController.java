package com.example.designpatterns.strategy.objectprovider;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("send")
public class SmsController {

    private final OrderService orderService;

    public SmsController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("message/{message}")
    public void sendMessage(@PathVariable String message) {
        orderService.send(message);
    }
}
