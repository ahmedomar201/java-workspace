package org.example.functionalprogramming.discount.controllers;

import lombok.RequiredArgsConstructor;
import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.service.DiscountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("discount")
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("apply")

    public BigDecimal applyDiscountApi(@RequestBody OrderReceipt orderReceipt) {

        return discountService.applyDiscount(orderReceipt);

    }

}
