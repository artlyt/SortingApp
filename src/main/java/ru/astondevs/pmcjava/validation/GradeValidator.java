package ru.astondevs.pmcjava.validation;

public class GradeValidator implements Validator<Double> {

    @Override
    public String validate(Double grade) {
        if (isNull(grade)) {
            return "Оценка не может быть null";
        }
        if (!isWithinRange(grade)) {
            return "Оценка должна быть в диапазоне от 2.0 до 5.0";
        }
        return null;
    }

    private boolean isNull(Double value) {
        return value == null;
    }

    private boolean isWithinRange(Double grade) {
        return grade >= 2.0 && grade <= 5.0;
    }
}