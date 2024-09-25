package ru.astondevs.pmcjava.validation;

public class MileageValidator implements Validator<Double> {

    private static final double MAX_MILEAGE = 10_000_000;

    @Override
    public String validate(Double mileage) {
        if (isNull(mileage)) {
            return "Пробег не может быть null";
        }
        if (!isMileageInRange(mileage)) {
            return "Пробег должен быть в диапазоне от 0 до " + MAX_MILEAGE;
        }
        return null;
    }

    private boolean isNull(Double value) {
        return value == null;
    }

    private boolean isMileageInRange(Double mileage) {
        return mileage >= 0 && mileage <= MAX_MILEAGE;
    }
}