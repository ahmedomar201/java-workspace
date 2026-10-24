package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public interface DiscountRules {

    BigDecimal applyDiscount(OrderReceipt orderReceipt);

}
