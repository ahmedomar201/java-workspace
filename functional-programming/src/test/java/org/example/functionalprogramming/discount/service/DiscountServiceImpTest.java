package org.example.functionalprogramming.discount.service;

import org.example.functionalprogramming.discount.models.dtos.OrderReceipt;
import org.example.functionalprogramming.discount.models.dtos.ProductItem;
import org.example.functionalprogramming.discount.rules.DiscountEngine;
import org.example.functionalprogramming.discount.utills.Category;
import org.example.functionalprogramming.discount.utills.SubCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DiscountServiceImpTest {

    @Mock
    private DiscountEngine discountEngine;

    @InjectMocks
    private DiscountServiceImp discountServiceImp;

    @Test
    void testApplyDiscount_whenLaptopRuleApplied_then500DiscountApplied() {

        //Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(
                        Category.ELECTRONICS,
                        SubCategory.LAPTOP,
                        "LP123",
                        1,
                        BigDecimal.valueOf(40000)
                ),
                new ProductItem(
                        Category.CLOTHES,
                        SubCategory.T_SHIRT,
                        "TS123",
                        1,
                        BigDecimal.valueOf(300))
        );

        final OrderReceipt orderReceipt = new OrderReceipt(productItems);
        final BigDecimal totalPrice = orderReceipt.totalPrice();

        when(discountEngine.applyDiscount(orderReceipt))
                .thenReturn(totalPrice.subtract(BigDecimal.valueOf(500)));

        //Action
        //or Ack
        final BigDecimal priceAfterDiscount = discountServiceImp.applyDiscount(orderReceipt);

        //Assert
        assertEquals(BigDecimal.valueOf(39800), priceAfterDiscount);
        verify(discountEngine, times(1)).applyDiscount(orderReceipt);
        assertDoesNotThrow(() -> RuntimeException.class);

    }

    @Test
    void testApplyDiscount_whenLaptopRuleAndQuantityApplied_then500DiscountAnd5PercentApplied() {
        // Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(
                        Category.ELECTRONICS,
                        SubCategory.LAPTOP,
                        "LP123",
                        1,
                        BigDecimal.valueOf(40000)
                ),
                new ProductItem(
                        Category.CLOTHES,
                        SubCategory.T_SHIRT,
                        "TS123",
                        1,
                        BigDecimal.valueOf(300)
                ),
                new ProductItem(
                        Category.CLOTHES,
                        SubCategory.PANT,
                        "PT123",
                        6,
                        BigDecimal.valueOf(500)
                )
        );

        final OrderReceipt orderReceipt = new OrderReceipt(productItems);
        final BigDecimal totalPrice = orderReceipt.totalPrice();
        final BigDecimal laptopDiscount = totalPrice.subtract(BigDecimal.valueOf(500));
        final BigDecimal quantityDiscount = laptopDiscount.multiply(BigDecimal.valueOf(0.95));

        when(discountEngine.applyDiscount(orderReceipt))
                .thenReturn(quantityDiscount);

        // Action
        final BigDecimal priceAfterDiscount = discountServiceImp.applyDiscount(orderReceipt);

        // Assert
        assertEquals(quantityDiscount, priceAfterDiscount);
        verify(discountEngine).applyDiscount(orderReceipt);
    }
}
