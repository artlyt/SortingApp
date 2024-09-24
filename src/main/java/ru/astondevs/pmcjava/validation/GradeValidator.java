package ru.astondevs.pmcjava.validation;

public class GradeValidator implements Validator<Double> {

    @Override
    public boolean validate(Double grade) {
        return isNotNull(grade) && isWithinRange(grade);
    }

    // Метод для проверки, что grade не null
    private boolean isNotNull(Double grade) {
        return grade != null;
    }

    // Метод для проверки, что grade находится в диапазоне [2;5]
    private boolean isWithinRange(Double grade) {
        return grade >= 2.0 && grade <= 5.0;
    }
}