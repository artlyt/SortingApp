package ru.astondevs.pmcjava.validation;

public class NameValidator extends StringValidator {

    @Override
    protected String getAttributeName() {
        return "Имя";
    }
}