package ru.shulepov.collections;

import java.util.*;

/**
 * Поиск звонких согласных, входящих более чем в одно слово
 */
public class VoicedConsonants {
    private static final Set<Character> VOICED_CONSONANTS = new HashSet<>(
            Arrays.asList('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р'));

    /**
     * Найти звонкие согласные, которые входят более чем в одно слово
     */
    public static List<Character> findVoicedConsonants(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        Map<Character, Set<Integer>> consonantWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Set<Character> wordConsonants = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                if (VOICED_CONSONANTS.contains(c)) {
                    wordConsonants.add(c);
                }
            }
            for (char c : wordConsonants) {
                consonantWords.computeIfAbsent(c, k -> new HashSet<>()).add(i);
            }
        }

        List<Character> result = new ArrayList<>();
        for (Map.Entry<Character, Set<Integer>> entry : consonantWords.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}