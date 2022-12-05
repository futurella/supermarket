package org.supermarket.parser;

import org.supermarket.constants.MessageKey;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import static org.supermarket.constants.SupermarketKey.*;

public class ItemDefaultParser {

    public Map<String, String> parse(MessageKey messageKey, String value) {
        Objects.requireNonNull(messageKey, "");
        Objects.requireNonNull(value, "");

        String[] values = getStrWithoutSpace(value);

        switch (messageKey) {
            case KEY_BUY_ITEM:
                return getBuyItem(values);
            case KEY_UPDATE_ITEM:
                return getUpdateItem(values);
            case KEY_DISCOUNT_BUY:
                return getDiscountUpdaterItem(values);
            default:
                return Map.of();
        }
    }

    private String[] getStrWithoutSpace(String value) {
        return Arrays.stream(value.split(",")).map(String::trim).toArray(String[]::new);
    }


    private Map<String, String> getBuyItem(String[] values) {
        return Map.of(NAME_KEY.getName(), values[0]);
    }

    private Map<String, String> getUpdateItem(String[] values) {
        return Map.of(NAME_KEY.getName(), values[0], QUANTITY_KEY.getName(), values[1], PRICE_KEY.getName(), values[2]);
    }

    private Map<String, String> getDiscountUpdaterItem(String[] values) {
        return Map.of(NAME_KEY.getName(), values[0], QUANTITY_DISCOUNT_KEY.getName(), values[1], PRICE_DISCOUNT_KEY.getName(), values[2]);
    }
}
