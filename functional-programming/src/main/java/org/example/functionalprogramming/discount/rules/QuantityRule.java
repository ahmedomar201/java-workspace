package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public class QuantityRule implements DiscountRules{
    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt,final BigDecimal price) {

     boolean isDiscountMatched = orderReceipt.productItems().stream().anyMatch(item -> {

         if()


        } );

    }
}
