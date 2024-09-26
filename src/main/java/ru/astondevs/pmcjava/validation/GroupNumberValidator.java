package ru.astondevs.pmcjava.validation;

public class GroupNumberValidator extends PositiveIntegerValidator {

    @Override
    protected String getAttributeName() {
        return "Номер группы";
    }
}