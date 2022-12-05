package org.supermarket.repository;

import org.supermarket.annotation.Component;
import org.supermarket.items.ItemInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class RequestDataRepository {
    private Map<String, ItemInfo> repository;

    public RequestDataRepository() {
        this.repository = new HashMap<>();
    }

    public Optional<ItemInfo> get(String name) {
        return Optional.ofNullable(repository.get(name));
    }


    public void add(ItemInfo item) {
    }
}
