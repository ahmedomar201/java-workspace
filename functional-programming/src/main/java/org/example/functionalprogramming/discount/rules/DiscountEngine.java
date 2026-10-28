package org.example.functionalprogramming.discount.rules;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DiscountEngine {

    private final List<DiscountRules> discountRules;

    public BigDecimal applyDiscount(final OrderReceipt orderReceipt) {
        final String methodName = "applyDiscount()";

        final BigDecimal totalPrice = orderReceipt.totalPrice();
        log.debug("{}, order total price is: [{}]", methodName, totalPrice);

        return discountRules.stream()
                .reduce(
                        totalPrice,
                        ((currentPrice, discountRule) -> discountRule.applyDiscount(orderReceipt, currentPrice)),
                        BigDecimal::add
                );
    }
}
