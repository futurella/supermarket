package org.supermarket.service;

import org.supermarket.ItemProcessor;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.InjectList;
import org.supermarket.constants.MessageKey;

import java.util.List;

@Component
public class ItemProcessorFactory {

    @InjectList({DiscountUpdaterProcessor.class, ItemBuyerProcessor.class, ItemUpdaterProcessor.class})
    private List<ItemProcessor> processors;

    public ItemProcessor getProcessor(MessageKey messageKey) {
        return processors.stream()
                .filter(process -> process.canIPerform(messageKey))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Key doesnt exist"));
    }
}
