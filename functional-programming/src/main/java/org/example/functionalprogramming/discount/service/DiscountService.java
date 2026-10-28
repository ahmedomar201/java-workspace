package org.example.functionalprogramming.discount.service;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public interface DiscountService  {

    BigDecimal applyDiscount(OrderReceipt orderReceipt);

}
