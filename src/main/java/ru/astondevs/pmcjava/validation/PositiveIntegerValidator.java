package ru.astondevs.pmcjava.validation;

public abstract class PositiveIntegerValidator implements Validator<Integer> {

    @Override
    public String validate(Integer value) {
        if (isNull(value)) {
            return getAttributeName() + " не может быть null";
        }
        if (!isPositive(value)) {
            return getAttributeName() + " должно быть положительным";
        }
        return null;
    }

    protected boolean isNull(Integer value) {
        return value == null;
    }

    protected boolean isPositive(Integer value) {
        return value > 0;
    }

    protected abstract String getAttributeName();
}