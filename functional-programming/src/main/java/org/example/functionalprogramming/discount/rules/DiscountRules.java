package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface DiscountRules {

    BigDecimal applyDiscount(OrderReceipt orderReceipt,BigDecimal price);

}
