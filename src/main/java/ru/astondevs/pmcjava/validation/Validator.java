package ru.astondevs.pmcjava.validation;

public interface Validator<T> {
    String validate(T value);
}