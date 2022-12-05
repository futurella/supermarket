package org.supermarket.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
@Getter
@ToString
public enum MessageKey {
    KEY_BUY_ITEM("1"),
    KEY_UPDATE_ITEM("2"),
    KEY_DISCOUNT_BUY("3");

    String key;


    /**
     * @param messageKey String Message key
     * @return MessageKey - Message key
     */
    public static MessageKey getMessageKey(String messageKey) {
        Objects.requireNonNull(messageKey, "");

        return Arrays.stream(values())
                .filter(s -> s.getKey().equalsIgnoreCase(messageKey))
                .findFirst()
                .orElseThrow();
    }

}
