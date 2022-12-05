package org.supermarket.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.supermarket.ServiceMessage;
import org.supermarket.annotation.Component;
import org.supermarket.constants.MessageKey;

import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceProgramMessage {
    private static final Map<MessageKey, ServiceMessage> serviceMessages = new HashMap<>();

    /**
     * Add program messages
     *
     * @param key            message key
     * @param serviceMessage message
     */
    public static void addMessage(MessageKey key, ServiceMessage serviceMessage) {
        serviceMessages.put(key, serviceMessage);
    }

    /**
     * Get program message
     *
     * @param key message key
     */
    public static ServiceMessage getMessage(MessageKey key) {
        return serviceMessages.get(key);
    }
}
