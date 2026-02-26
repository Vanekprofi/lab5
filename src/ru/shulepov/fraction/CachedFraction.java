package ru.shulepov.fraction;

/**
 * Дробь с кэшированием вещественного значения
 */
public class CachedFraction extends Fraction {
    private Double cachedValue;
    private boolean cacheValid;

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
        this.cacheValid = false;
    }

    @Override
    public double getRealValue() {
        if (!cacheValid) {
            cachedValue = super.getRealValue();
            cacheValid = true;
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cacheValid = false;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cacheValid = false;
    }

    @Override
    public String toString() {
        return "CachedFraction{" + super.toString() + ", value=" + getRealValue() + "}";
    }
}