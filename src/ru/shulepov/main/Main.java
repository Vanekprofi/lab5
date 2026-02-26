package ru.shulepov.main;

import ru.shulepov.animals.*;
import ru.shulepov.collections.*;
import ru.shulepov.fraction.*;
import ru.shulepov.geometry.*;
import ru.shulepov.streams.*;

import java.util.*;

/**
 * Главный класс программы
 * Демонстрирует работу всех классов и методов
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== ЛАБОРАТОРНАЯ РАБОТА ===\n");

        task1Fraction();
        task2CatMeow();
        task3ListXor();
        task4Applicants();
        task5VoicedConsonants();
        task6QueueReverse();
        task7StreamPoint();
        task7StreamName();

        System.out.println("\n=== ВСЕ ЗАДАНИЯ ВЫПОЛНЕНЫ ===");
    }

    private static void task1Fraction() {
        System.out.println("=== ЗАДАНИЕ 1: ДРОБЬ ===");

        Fraction fraction = new Fraction(3, 4);
        System.out.println("Дробь: " + fraction);
        System.out.println("Вещественное значение: " + fraction.getRealValue());

        Fraction negative = new Fraction(-3, -4);
        System.out.println("\nОтрицательная дробь: " + negative);

        CachedFraction cached = new CachedFraction(5, 2);
        System.out.println("\nКэшированная дробь: " + cached);
        System.out.println("Значение: " + cached.getRealValue());

        cached.setNumerator(10);
        System.out.println("После изменения: " + cached);

        System.out.println();
    }

    private static void task2CatMeow() {
        System.out.println("=== ЗАДАНИЕ 2: КОТ И МЯУКАНЬЕ ===");

        Cat cat = new Cat("Барсик");
        System.out.println(cat);

        CountingCatDecorator decorator = new CountingCatDecorator(cat);

        System.out.println("\nВызываем мяуканье через декоратор:");
        decorator.meow();
        decorator.meow();
        decorator.meow();

        System.out.println("\nКоличество мяуканий: " + decorator.getMeowCount());
        System.out.println(decorator);

        System.out.println();
    }

    private static void task3ListXor() {
        System.out.println("=== ЗАДАНИЕ 3: СПИСОК XOR ===");

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l2 = Arrays.asList(4, 5, 6, 7, 8);

        System.out.println("L1: " + l1);
        System.out.println("L2: " + l2);

        List<Integer> result = ListXor.xorLists(l1, l2);
        System.out.println("XOR (элементы только в одном списке): " + result);

        System.out.println();
    }

    private static void task4Applicants() {
        System.out.println("=== ЗАДАНИЕ 4: АБИТУРИЕНТЫ ===");

        Map<String, Applicants.Applicant> applicants = new HashMap<>();
        applicants.put("Vetrov", new Applicants.Applicant("Ветров", "Роман", 68, 59));
        applicants.put("Anisimova", new Applicants.Applicant("Анисимова", "Екатерина", 64, 88));
        applicants.put("Petrov", new Applicants.Applicant("Петров", "Иван", 25, 45));
        applicants.put("Sidorov", new Applicants.Applicant("Сидоров", "Петр", 29, 28));

        List<Applicants.Applicant> failed = Applicants.findFailed(applicants);

        System.out.println("Не допущенные к экзаменам:");
        for (Applicants.Applicant applicant : failed) {
            System.out.println("  " + applicant);
        }

        System.out.println();
    }

    private static void task5VoicedConsonants() {
        System.out.println("=== ЗАДАНИЕ 5: ЗВОНКИЕ СОГЛАСНЫЕ ===");

        String text = "бабушка варит варенье в ванной";
        System.out.println("Текст: " + text);

        List<Character> consonants = VoicedConsonants.findVoicedConsonants(text);
        System.out.println("Звонкие согласные в более чем одном слове: " + consonants);

        System.out.println();
    }

    private static void task6QueueReverse() {
        System.out.println("=== ЗАДАНИЕ 6: ОЧЕРЕДЬ ===");

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Очередь: " + queue);
        QueueReverse.printReverse(queue);

        System.out.println();
    }

    private static void task7StreamPoint() {
        System.out.println("=== ЗАДАНИЕ 7: СТРИМ ТОЧЕК ===");

        List<Point> points = Arrays.asList(
                new Point(3, 5),
                new Point(1, -2),
                new Point(3, 5),
                new Point(2, -4),
                new Point(1, 2)
        );

        System.out.println("Исходные точки: " + points);

        Polyline polyline = PointStreamProcessor.processPoints(points);
        System.out.println("После обработки: " + polyline);

        System.out.println();
    }

    private static void task7StreamName() {
        System.out.println("=== ЗАДАНИЕ 7: СТРИМ ИМЁН ===");

        System.out.println("Введите путь к файлу с именами (или нажмите Enter для примера):");
        String filePath = scanner.nextLine();

        if (filePath.trim().isEmpty()) {
            System.out.println("Используем пример данных...");
            Map<String, List<Integer>> result = new HashMap<>();
            result.put("Вася", Arrays.asList(5, 5));
            result.put("Петя", Arrays.asList(3));
            result.put("Аня", Arrays.asList(5));

            System.out.println("Результат:");
            for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        } else {
            Map<String, List<Integer>> result = NameStreamProcessor.processFile(filePath);
            System.out.println("Результат:");
            for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
                System.out.println("  " + entry.getKey() + ": " + entry.getValue());
            }
        }

        System.out.println();
    }
}