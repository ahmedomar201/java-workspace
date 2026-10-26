package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public class HighPriceRule implements DiscountRules {
    private static final BigDecimal FIFTY_THOUSANDS = BigDecimal.valueOf(50000);

    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt, final BigDecimal price) {

        if (isPriceLessAmount(orderReceipt.totalPrice(), FIFTY_THOUSANDS)) {
            return price;
        }
        return orderReceipt.totalPrice().multiply(BigDecimal.valueOf(0.9));
    }

    private static boolean isPriceLessAmount(final BigDecimal price, final BigDecimal amount) {
        return price.compareTo(amount) < 0;
    }
}
