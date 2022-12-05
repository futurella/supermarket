package org.supermarket;

import org.supermarket.constants.MessageKey;

public interface ItemProcessor extends ConditionService {
    ServiceMessage handle(MessageKey messageKey, String value);
}
