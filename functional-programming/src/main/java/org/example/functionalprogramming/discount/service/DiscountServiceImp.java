package org.example.functionalprogramming.discount.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.rules.DiscountEngine;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImp implements  DiscountService{

    private final DiscountEngine discountEngine;

    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt) {
        final BigDecimal priceAfterDiscount = discountEngine.applyDiscount(orderReceipt);

        log.debug("applyDiscount(), Price after discount = [{}]", priceAfterDiscount);
        return priceAfterDiscount;
    }
}

