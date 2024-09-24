package ru.astondevs.pmcjava.validation;

public interface Validator<T> {
    boolean validate(T value);
}