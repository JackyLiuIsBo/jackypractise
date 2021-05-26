/**
 * Project: alscadkbbp-common
 * 
 * File Created at Jun 28, 2020
 * $Id$
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package utils.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author xiaochao.wuxc
 * @version V1.0
 * @Title: Checks.java
 * @Description: 通用Check 对象类，用于判断是否为空。借用
 * @date 2016年11月8日 上午11:21:09
 **/
public class Checks {

    /**
     * Checks an expression for argument
     *
     * @param expression
     */
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checks an expression for state
     *
     * @param expression
     */
    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /**
     * Checks that an object reference is not null
     *
     * @param reference
     * @return non-null reference
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Long longValue) {
        return longValue == null || (longValue == 0);
    }

    public static boolean isEmpty(Integer intValue) {
        return intValue == null || (intValue == 0);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return isEmpty((String) obj);
        }
        if (obj instanceof Collection) {
            return isEmpty((Collection<?>) obj);
        }
        if (obj instanceof Long) {
            return isEmpty((Long) obj);
        }
        if (obj instanceof Integer) {
            return isEmpty((Integer) obj);
        }
        if (obj instanceof Map) {
            return isEmpty((Map<?, ?>) obj);
        }
        return false;
    }

    public static boolean isAnyEmpty(String first, String second, String... rest) {
        if (isEmpty(first) || isEmpty(second)) {
            return true;
        }
        for (String string : rest) {
            if (isEmpty(string)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(Collection<?> first, Collection<?> second,
                                     Collection<?>... rest) {
        if (isEmpty(first) || isEmpty(second)) {
            return true;
        }
        for (Collection<?> collection : rest) {
            if (isEmpty(collection)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(Object first, Object second, Object... objects) {
        if (isEmpty(first) || isEmpty(second)) {
            return true;
        }
        for (Object object : objects) {
            if (isEmpty(object)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyNull(Object first, Object second, Object... objects) {
        if (first == null || second == null) {
            return true;
        }
        for (Object object : objects) {
            if (object == null) {
                return true;
            }
        }
        return false;
    }
}
