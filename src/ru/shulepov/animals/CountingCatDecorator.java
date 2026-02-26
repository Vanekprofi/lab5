package ru.shulepov.animals;

/**
 * Декоратор для подсчёта количества мяуканий
 */
public class CountingCatDecorator implements Meowable {
    private final Cat cat;
    private int meowCount;

    public CountingCatDecorator(Cat cat) {
        this.cat = cat;
        this.meowCount = 0;
    }

    @Override
    public void meow() {
        meowCount++;
        cat.meow();
    }

    public int getMeowCount() {
        return meowCount;
    }

    public void resetCount() {
        meowCount = 0;
    }

    @Override
    public String toString() {
        return cat.toString() + " (мяуканий: " + meowCount + ")";
    }
}