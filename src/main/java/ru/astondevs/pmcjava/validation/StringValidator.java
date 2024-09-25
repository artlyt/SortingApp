package ru.astondevs.pmcjava.validation;

public abstract class StringValidator implements Validator<String> {

    @Override
    public String validate(String value) {
        if (isNull(value)) {
            return getAttributeName() + " не может быть null";
        }
        if (isEmpty(value)) {
            return getAttributeName() + " не может быть пустым";
        }
        return null;
    }

    protected boolean isNull(String value) {
        return value == null;
    }

    protected boolean isEmpty(String value) {
        return value.trim().isEmpty();
    }

    protected abstract String getAttributeName();
}