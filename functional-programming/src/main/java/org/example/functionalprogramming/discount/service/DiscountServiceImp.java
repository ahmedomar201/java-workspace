package org.example.functionalprogramming.discount.service;

import lombok.RequiredArgsConstructor;
import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.rules.DiscountEngine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DiscountServiceImp implements  DiscountService{

    private final DiscountEngine discountEngine;

    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt) {

        return discountEngine.applyDiscount(orderReceipt);
    }
}

