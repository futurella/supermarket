package org.supermarket;

import org.supermarket.items.ItemInfo;

public interface IParser<T> {

    ItemInfo parseItem(T value);
}
