package ru.astondevs.pmcjava.validation;

public class RecordBookNumberValidator extends PositiveIntegerValidator {

    @Override
    protected String getAttributeName() {
        return "Номер зачётной книжки";
    }
}