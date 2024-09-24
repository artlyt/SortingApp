package ru.astondevs.pmcjava.validation;

public class PositiveIntegerValidator implements Validator<Integer> {

    @Override
    public boolean validate(Integer value) {
        return isNotNull(value) && isPositive(value);
    }

    // Метод для проверки, что значение не null
    private boolean isNotNull(Integer value) {
        return value != null;
    }

    // Метод для проверки, что значение больше 0
    private boolean isPositive(Integer value) {
        return value > 0;
    }
}