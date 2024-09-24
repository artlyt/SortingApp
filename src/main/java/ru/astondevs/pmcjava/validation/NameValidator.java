package ru.astondevs.pmcjava.validation;

public class NameValidator implements Validator<String> {

    @Override
    public boolean validate(String name) {
        return isNotNull(name) && isNotEmpty(name);
    }

    // Метод для проверки, что имя не null
    private boolean isNotNull(String name) {
        return name != null;
    }

    // Метод для проверки, что имя не пустое или не состоит только из пробелов
    private boolean isNotEmpty(String name) {
        return !name.trim().isEmpty();
    }
}