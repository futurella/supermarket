package org.supermarket.parser;

import lombok.RequiredArgsConstructor;
import org.supermarket.ItemParser;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.items.ItemInfo;
import org.supermarket.repository.RequestDataRepository;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.supermarket.constants.SupermarketKey.*;

@Component
@RequiredArgsConstructor
public class DiscountUpdaterParser implements ItemParser {
    @Inject
    private RequestDataRepository repository;

    @Override
    public ItemInfo apply(Map<String, String> requestData) {
        Objects.requireNonNull(requestData, "");

        Optional<ItemInfo> itemInfo = repository.get(requestData.get(NAME_KEY.getName()));

        return itemInfo.map(item -> {
                    item.setQuantityDiscount(Integer.parseInt(requestData.get(QUANTITY_DISCOUNT_KEY.getName())));
                    item.setPriceDiscount(new BigDecimal(requestData.get(PRICE_DISCOUNT_KEY.getName())));
                    return item;
                })
                .orElseGet(() -> ItemInfo.builder()
                        .name(requestData.get(NAME_KEY.getName()))
                        .quantityDiscount(Integer.parseInt(requestData.get(QUANTITY_DISCOUNT_KEY.getName())))
                        .priceDiscount(new BigDecimal(requestData.get(PRICE_DISCOUNT_KEY.getName())))
                        .build());
    }
}
