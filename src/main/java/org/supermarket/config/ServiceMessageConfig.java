package org.supermarket.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.supermarket.ServiceMessage;
import org.supermarket.constants.MessageKey;

import static org.supermarket.constants.DesktopMessages.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServiceMessageConfig {

    public static void initMessage() {
        ServiceProgramMessage.addMessage(MessageKey.getMessageKey("1"), new ServiceMessage(SCAN_ITEM_MESSAGE, SCAN_ITEM_MESSAGE_EXAMPLE, SCAN_ITEM_MESSAGE_FINISH));
        ServiceProgramMessage.addMessage(MessageKey.getMessageKey("2"), new ServiceMessage(SCAN_ITEM_UPDATE_MESSAGE, SCAN_ITEM_UPDATE_MESSAGE_EXAMPLE, SCAN_ITEM_UPDATE_MESSAGE_FINISH));
        ServiceProgramMessage.addMessage(MessageKey.getMessageKey("3"), new ServiceMessage(SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE, SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE_EXAMPLE, SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE_FINISH));
    }
}
