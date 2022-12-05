package org.supermarket;

import org.supermarket.constants.MessageKey;

public interface ConditionService {
    default boolean isAppropriateProcess(MessageKey messageKey) {
        return false;
    }

    default boolean canIPerform(MessageKey messageKey) {
        return isAppropriateProcess(messageKey);
    }
}
