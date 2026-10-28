package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.models.dtos.ProductItem;

import java.math.BigDecimal;

public class QuantityRule implements DiscountRules {
    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt, final BigDecimal price) {

        boolean isDiscountMatched = orderReceipt
                .productItems()
                .stream()
                .anyMatch(QuantityRule::isMoreThanFive);

        if (!isDiscountMatched) {
            return orderReceipt.totalPrice();
        }

        return orderReceipt.totalPrice().multiply(BigDecimal.valueOf(0.95));
    }

    private static boolean isMoreThanFive(final ProductItem item) {
        return item.quantity() > 5;
    }
}

