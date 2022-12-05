package org.supermarket;

import lombok.RequiredArgsConstructor;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.config.ServiceMessageConfig;
import org.supermarket.config.ServiceProgramMessage;
import org.supermarket.constants.MessageKey;
import org.supermarket.service.ItemProcessorFactory;
import org.supermarket.util.InjectUtils;

import java.util.Scanner;

import static org.supermarket.constants.DesktopMessages.*;

@Component
@RequiredArgsConstructor
public class Main {
    @Inject
    private static ItemProcessorFactory factory;

    public static void main(String[] args) {

        InjectUtils.injectList();
        ServiceMessageConfig.initMessage();

        start();
    }

    public static void start() {
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println(SCAN_ITEM_BUY_MENU);
                System.out.println(SCAN_ITEM_UPDATE_MENU);
                System.out.println(SCAN_ITEM_UPDATE_DISCOUNT_MENU);
                System.out.println(EXIT_MESSAGE_MENU);

                String messageKey = scanner.nextLine();

                if (messageKey.equalsIgnoreCase("exit")) {
                    break;
                }

                ServiceMessage serviceMessage = ServiceProgramMessage.getMessage(MessageKey.getMessageKey(messageKey));

                System.out.println(serviceMessage.getMessage());
                System.out.println(serviceMessage.getExample());

                String stringMenu = scanner.nextLine();

                ItemProcessor itemProcessor = factory.getProcessor(MessageKey.getMessageKey(messageKey));
                ServiceMessage message = itemProcessor.handle(MessageKey.getMessageKey(messageKey), stringMenu);

                System.out.println(message.getFinish());
            }
        }
    }
}