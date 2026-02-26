package ru.shulepov.collections;

import java.util.*;

/**
 * Обработка абитуриентов через Map
 */
public class Applicants {

    /**
     * Внутренний класс Абитуриент (должен быть public для доступа из других пакетов)
     */
    public static class Applicant {
        String surname;
        String name;
        int score1;
        int score2;

        public Applicant(String surname, String name, int score1, int score2) {
            this.surname = surname;
            this.name = name;
            this.score1 = score1;
            this.score2 = score2;
        }

        public boolean isAdmitted() {
            return score1 >= 30 && score2 >= 30;
        }

        public String getSurname() {
            return surname;
        }

        public String getName() {
            return name;
        }

        public int getScore1() {
            return score1;
        }

        public int getScore2() {
            return score2;
        }

        @Override
        public String toString() {
            return surname + " " + name + " (" + score1 + ", " + score2 + ")";
        }
    }

    /**
     * Найти абитуриентов, не допущенных к экзаменам
     */
    public static List<Applicant> findFailed(Map<String, Applicant> applicants) {
        List<Applicant> failed = new ArrayList<>();
        for (Applicant applicant : applicants.values()) {
            if (!applicant.isAdmitted()) {
                failed.add(applicant);
            }
        }
        return failed;
    }
}