package org.example.functionalprogramming.discount.rules;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.utills.Category;
import org.example.functionalprogramming.discount.utills.SubCategory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LaptopRule implements DiscountRules {
    @Override
    public BigDecimal applyDiscount(final OrderReceipt orderReceipt, final BigDecimal price) {

        final boolean isDiscountMatched = orderReceipt.productItems()
                .stream()
                .anyMatch(item -> Category
                        .ELECTRONICS
                        .equals(item
                                .category()) && SubCategory.LAPTOP.equals(item.subCategory()));

        if (!isDiscountMatched) {
            return price;
        }
        return price.subtract(BigDecimal.valueOf(500));

    }
}

