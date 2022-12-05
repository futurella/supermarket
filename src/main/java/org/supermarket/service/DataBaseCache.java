package org.supermarket.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.supermarket.annotation.Inject;
import org.supermarket.exception.ReflectionErrorException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DataBaseCache {
    private static final Map<Class<?>, Object> cachedMap = new HashMap<>();

    public static Object checkCache(Class<?> clazz, Field field) {
        Objects.requireNonNull(clazz, "");

        try {
            if (cachedMap.containsKey(clazz)) {
                return cachedMap.get(clazz);
            } else if (clazz.isInterface()) {
                Map<Class<?>, Object> subClasses = getSubClasses(DataBaseCache.getCachedMap(), clazz);
                return subClasses(subClasses, field);
            } else {
                Object object = clazz.getConstructor().newInstance();
                cachedMap.put(clazz, object);
                return object;
            }
        } catch (Exception exc) {
            throw new ReflectionErrorException("Error create object", exc);
        }
    }

    private static Object subClasses(Map<Class<?>, Object> subClasses, Field field) throws ClassNotFoundException {
        if (subClasses.size() > 1) {
            Inject annotation = field.getAnnotation(Inject.class);
            return subClasses.get(Class.forName(annotation.name()));
        } else {
            return subClasses.values().stream().findFirst().orElseThrow();
        }
    }

    private static Map<Class<?>, Object> getSubClasses(Map<Class<?>, Object> data, Class<?> clazz) {
        return data.entrySet().stream()
                .filter(entry -> clazz.isAssignableFrom(entry.getValue().getClass()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<Class<?>, Object> getCachedMap() {
        return cachedMap;
    }
}
