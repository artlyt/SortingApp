package ru.astondevs.pmcjava.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorCollector {

    private final List<String> errors = new ArrayList<>();

    public void collectError(String error) {
        if (error != null) {
            errors.add(error);
        }
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public void throwIfErrors() {
        if (hasErrors()) {
            throw new ValidationException(String.join(", ", errors));
        }
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }
}