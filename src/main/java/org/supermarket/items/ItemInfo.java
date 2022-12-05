package org.supermarket.items;

import lombok.*;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(of = "name")
@NoArgsConstructor
public class ItemInfo {
    private String name;
    private int quantity;
    private int quantityDiscount;
    private BigDecimal price;
    private BigDecimal priceDiscount;

    @Builder
    public ItemInfo(String name, int quantity, int quantityDiscount, BigDecimal price, BigDecimal priceDiscount) {
        this.name = name;
        this.quantity = quantity;
        this.quantityDiscount = quantityDiscount;
        this.price = price;
        this.priceDiscount = priceDiscount;
    }
}
