package org.supermarket;

import org.supermarket.items.ItemInfo;

import java.util.Map;
import java.util.function.Function;

public interface ItemParser extends Function<Map<String, String>, ItemInfo> {
}
