package ru.shulepov.streams;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * Обработка имён из файла через Stream API
 */
public class NameStreamProcessor {

    /**
     * Обработать файл с именами и номерами
     */
    public static Map<String, List<Integer>> processFile(String filePath) {
        try {
            return Files.lines(Paths.get(filePath))
                    .filter(line -> line != null && !line.trim().isEmpty())
                    .map(line -> {
                        String[] parts = line.split(":");
                        if (parts.length < 1) return null;
                        String name = normalizeName(parts[0]);
                        int number = parts.length > 1 ? Integer.parseInt(parts[1].trim()) : -1;
                        return new AbstractMap.SimpleEntry<>(name, number);
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                    ));
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return new HashMap<>();
        }
    }

    private static String normalizeName(String name) {
        if (name == null || name.isEmpty()) return "";
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}