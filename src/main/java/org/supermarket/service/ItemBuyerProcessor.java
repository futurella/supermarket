package org.supermarket.service;

import org.supermarket.ItemProcessor;
import org.supermarket.ServiceMessage;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.config.ServiceProgramMessage;
import org.supermarket.constants.MessageKey;
import org.supermarket.parser.ItemBuyerParser;
import org.supermarket.parser.ItemDefaultParser;
import org.supermarket.repository.RequestDataRepository;

import java.util.Objects;

import static org.supermarket.constants.MessageKey.KEY_BUY_ITEM;

@Component
public class ItemBuyerProcessor implements ItemProcessor {
    @Inject
    private ItemBuyerParser parser;
    @Inject
    private ItemDefaultParser itemDefaultParser;
    @Inject
    private RequestDataRepository repository;

    @Override
    public ServiceMessage handle(MessageKey messageKey, String value) {
        Objects.requireNonNull(messageKey, "");
        Objects.requireNonNull(value, "");

        return ServiceProgramMessage.getMessage(MessageKey.getMessageKey(KEY_BUY_ITEM.getKey()));
    }

    @Override
    public boolean isAppropriateProcess(MessageKey messageKey) {
        return KEY_BUY_ITEM.getKey().equalsIgnoreCase(messageKey.getKey());
    }
}
