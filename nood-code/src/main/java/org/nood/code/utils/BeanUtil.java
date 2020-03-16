package org.nood.code.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.lang.String.format;

/**
 * @program: nood
 * @description: 封装BeanUtils
 * @author: singhlee
 * @create: 2020-03-16 11:15
 **/
@Slf4j
public class BeanUtil {
    /**
     * The map to store {@link BeanCopier} of source type and class type for conversion.
     */
    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    /**
     * Private constructor.
     */
    private BeanUtil() {
    }

    /**
     * Copy the property values of the given source bean into the target bean.
     *
     * @param source the source bean
     * @param target the target bean
     *
     * @see BeanCopier
     */
    public static void copyProperties(Object source, Object target) {
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(target, "target must not be null");
        BeanCopier beanCopier = getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    /**
     * Convert the given source bean to a target bean of specified type.
     *
     * @param source the source bean
     * @param clazz  the class of target bean
     * @param <T>    the type of target bean
     *
     * @return the target bean of type <code>T</code>
     */
    public static <T> T convert(Object source, Class<T> clazz) {
        // Initialize a new instance of the target type.
        T result;
        try {
            result = clazz.newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("fail to create instance of type" + clazz.getCanonicalName(), e);
        }

        copyProperties(source, result);
        return result;
    }

    /**
     * Get the {@link BeanCopier} of source class and target class.
     * Create a new one if it is not contained in <code>BEAN_COPIER_MAP</code>.
     *
     * @param source the source class
     * @param target the target class
     *
     * @return the bean copier of source class and target class
     */
    private static BeanCopier getBeanCopier(Class<?> source, Class<?> target) {
        String key = generateKey(source, target);
        return BEAN_COPIER_MAP.computeIfAbsent(key, x -> BeanCopier.create(source, target, false));
    }

    /**
     * Get key of <code>BEAN_COPIER_MAP</code> by source class and target class.
     *
     * @param source the source class
     * @param target the target class
     *
     * @return the key of <code>BEAN_COPIER_MAP</code> by source class and target class
     */
    private static String generateKey(Class<?> source, Class<?> target) {
        return source.getCanonicalName().concat(target.getCanonicalName());
    }
}
