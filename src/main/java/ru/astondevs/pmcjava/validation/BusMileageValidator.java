package ru.astondevs.pmcjava.validation;

public class BusMileageValidator implements Validator<Double> {

    // Константа для максимального пробега
    private static final double MAX_MILEAGE = 10_000_000;

    @Override
    public boolean validate(Double mileage) {
        return isNotNull(mileage) && isMileageInRange(mileage);
    }

    // Метод для проверки, что пробег не null
    private boolean isNotNull(Double mileage) {
        return mileage != null;
    }

    // Метод для проверки, что пробег находится в допустимом диапазоне
    private boolean isMileageInRange(Double mileage) {
        return mileage >= 0 && mileage <= MAX_MILEAGE;
    }
}