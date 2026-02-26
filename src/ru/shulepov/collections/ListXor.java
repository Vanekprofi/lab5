package ru.shulepov.collections;

import java.util.*;

/**
 * Список с элементами из L1 или L2, но не из обоих (XOR)
 */
public class ListXor {

    /**
     * Формирует список с элементами, которые есть в одном списке, но не в другом
     */
    public static <T> List<T> xorLists(List<T> l1, List<T> l2) {
        Set<T> set1 = new HashSet<>(l1);
        Set<T> set2 = new HashSet<>(l2);

        List<T> result = new ArrayList<>();

        // Элементы из L1, которых нет в L2
        for (T item : l1) {
            if (!set2.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        // Элементы из L2, которых нет в L1
        for (T item : l2) {
            if (!set1.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
}