package ru.shulepov.fraction;

/**
 * Интерфейс для работы с дробью
 */
public interface FractionInterface {
    /**
     * Получить вещественное значение дроби
     */
    double getRealValue();

    /**
     * Установить числитель
     */
    void setNumerator(int numerator);

    /**
     * Установить знаменатель
     */
    void setDenominator(int denominator);
}