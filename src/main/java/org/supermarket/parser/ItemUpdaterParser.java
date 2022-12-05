package org.supermarket.parser;

import lombok.RequiredArgsConstructor;
import org.supermarket.ItemParser;
import org.supermarket.repository.RequestDataRepository;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.items.ItemInfo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static org.supermarket.constants.SupermarketKey.*;

@Component
@RequiredArgsConstructor
public class ItemUpdaterParser implements ItemParser {

    @Inject
    private RequestDataRepository repository;

    @Override
    public ItemInfo apply(Map<String, String> requestData) {
        Objects.requireNonNull(requestData, "");

        Optional<ItemInfo> itemInfoOptional = repository.get(requestData.get(NAME_KEY.getName()));

        return itemInfoOptional.map(item -> {
                    item.setQuantity(Integer.parseInt(requestData.get(QUANTITY_KEY.getName())));
                    item.setPrice(new BigDecimal(requestData.get(PRICE_KEY.getName())));
                    return item;
                })
                .orElseGet(() -> ItemInfo.builder()
                        .name(requestData.get(NAME_KEY.getName()))
                        .quantity(Integer.parseInt(requestData.get(QUANTITY_KEY.getName())))
                        .price(new BigDecimal(requestData.get(PRICE_KEY.getName())))
                        .build());
    }
}
