package org.supermarket.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public enum SupermarketKey {
    NAME_KEY("name"),
    QUANTITY_KEY("quantity"),
    QUANTITY_DISCOUNT_KEY("quantityDiscount"),
    PRICE_KEY("price"),
    PRICE_DISCOUNT_KEY("priceDiscount");

    private String name;
}
