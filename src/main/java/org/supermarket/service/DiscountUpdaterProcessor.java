package org.supermarket.service;

import lombok.RequiredArgsConstructor;
import org.supermarket.ItemProcessor;
import org.supermarket.ServiceMessage;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.constants.MessageKey;
import org.supermarket.repository.RequestDataRepository;

import static org.supermarket.constants.MessageKey.KEY_DISCOUNT_BUY;

@Component
@RequiredArgsConstructor
public class DiscountUpdaterProcessor implements ItemProcessor {
    @Inject
    private RequestDataRepository repository;

    @Override
    public ServiceMessage handle(MessageKey messageKey, String value) {
        return null;
    }

    @Override
    public boolean isAppropriateProcess(MessageKey messageKey) {
        return KEY_DISCOUNT_BUY.getKey().equalsIgnoreCase(messageKey.getKey());
    }
}
