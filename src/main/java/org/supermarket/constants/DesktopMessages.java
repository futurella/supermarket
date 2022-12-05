package org.supermarket.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DesktopMessages {
    public static final String SCAN_ITEM_BUY_MENU                     = "If u want to buy item press : 1";
    public static final String SCAN_ITEM_UPDATE_MENU                  = "If u want to update item price press : 2";
    public static final String SCAN_ITEM_UPDATE_DISCOUNT_MENU         = "If u want to update item discount press : 3";
    public static final String EXIT_MESSAGE_MENU                      = "If u want to finish press : 'exit'";

    public static final String SCAN_ITEM_MESSAGE                      = "Please enter item that you want to buy: ";
    public static final String SCAN_ITEM_MESSAGE_EXAMPLE              = "Type example: A";
    public static final String SCAN_ITEM_MESSAGE_FINISH               = "AMOUNT: %s";

    public static final String SCAN_ITEM_UPDATE_MESSAGE                       = "Please enter update item price (item_name, item_quantity, item_price): ";
    public static final String SCAN_ITEM_UPDATE_MESSAGE_EXAMPLE               = "Type example: A, 10, 56";
    public static final String SCAN_ITEM_UPDATE_MESSAGE_FINISH                = "";

    public static final String SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE              = "Please enter update item discount (item_name, discount_quantity, discount_price): ";
    public static final String SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE_EXAMPLE      = "Type example: A, 3, 150";
    public static final String SCAN_ITEM_UPDATE_DISCOUNT_MESSAGE_FINISH       = "";
}
