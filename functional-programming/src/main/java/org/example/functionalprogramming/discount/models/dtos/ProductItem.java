package org.example.functionalprogramming.discount.models.dtos;

import org.example.functionalprogramming.discount.utills.Category;
import org.example.functionalprogramming.discount.utills.SubCategory;

import java.math.BigDecimal;

public record ProductItem(
        String productCode,
        int quantity,
        BigDecimal price,
        Category category,
        SubCategory subCategory
) {

    public BigDecimal totalPrice() {

        return price.multiply(new BigDecimal(quantity));
    }
}
