package org.supermarket.parser;

import lombok.RequiredArgsConstructor;
import org.supermarket.ItemParser;
import org.supermarket.repository.RequestDataRepository;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.items.ItemInfo;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

import static org.supermarket.constants.SupermarketKey.NAME_KEY;

@Component
@RequiredArgsConstructor
public class ItemBuyerParser implements ItemParser {

    @Inject
    private RequestDataRepository repository;

    @Override
    public ItemInfo apply(Map<String, String> requestData) {
        Objects.requireNonNull(requestData, "");

        return repository.get(requestData.get(NAME_KEY.getName()))
                .orElseThrow(() -> new NoSuchElementException("Item: {} not Exist"));
    }
}
