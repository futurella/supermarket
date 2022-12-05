package org.supermarket.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.reflections.Reflections;
import org.supermarket.annotation.Component;
import org.supermarket.annotation.Inject;
import org.supermarket.annotation.InjectList;
import org.supermarket.exception.ReflectionErrorException;
import org.supermarket.service.DataBaseCache;

import java.lang.reflect.Field;
import java.util.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InjectUtils {

    public static void injectList() {
        Reflections reflections = new Reflections("org.supermarket");

        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Component.class);

        try {
            injectComponentAnnotation(classes);
            injectAnnotation(classes);
        } catch (Exception e) {
            throw new ReflectionErrorException("Cannot create ", e);
        }
    }

    private static void injectAnnotation(Set<Class<?>> classes) throws ClassNotFoundException, IllegalAccessException {
        for (Class<?> cl : classes) {
            injectAnnotationReflection(cl);
            injectListAnnotationReflection(cl);
        }
    }

    private static void injectComponentAnnotation(Set<Class<?>> classes) {
        classes.forEach(clazz -> DataBaseCache.checkCache(clazz, null));
    }

    public static void injectListAnnotationReflection(Class<?> cl) throws IllegalAccessException {
        Field[] fields = Arrays.stream(cl.getDeclaredFields()).filter(field -> field.isAnnotationPresent(InjectList.class)).toArray(Field[]::new);

        for (Field field : fields) {
            InjectList annotation = field.getAnnotation(InjectList.class);
            Class<?>[] arrays = annotation.value();
            List<Object> list = new ArrayList<>();

            for (Class<?> array : arrays) {
                Object object = DataBaseCache.checkCache(array, field);
                list.add(object);
            }
            setField(true, cl, field, list);
        }
    }

    public static void injectAnnotationReflection(Class<?> cl) throws ClassNotFoundException, IllegalAccessException {
        Field[] fields = Arrays.stream(cl.getDeclaredFields()).filter(field -> field.isAnnotationPresent(Inject.class)).toArray(Field[]::new);

        for (Field field : fields) {
            Class<?> classField = Class.forName(field.getType().getName());

            Object object = DataBaseCache.checkCache(classField, field);

            setField(true, cl, field, object);
        }
    }

    public static void setField(boolean access, Class<?> clazz, Field field, Object value) throws IllegalAccessException {
        field.setAccessible(access);
        field.set(DataBaseCache.checkCache(clazz, field), value);
    }
}
