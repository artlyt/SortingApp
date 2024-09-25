package ru.astondevs.pmcjava.model;

import ru.astondevs.pmcjava.validation.EmailValidator;
import ru.astondevs.pmcjava.validation.NameValidator;
import ru.astondevs.pmcjava.validation.PasswordValidator;
import ru.astondevs.pmcjava.validation.ValidationErrorCollector;

public final class User {
    private final String name;
    private final String password;
    private final String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
    }

    public String getName() { return name; }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public static class Builder {
        private String name;
        private String password;
        private String email;
        private final ValidationErrorCollector errorCollector = new ValidationErrorCollector();

        public Builder setName(String name) {
            this.name = name;
            NameValidator validator = new NameValidator();
            errorCollector.collectError(validator.validate(name));
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            PasswordValidator validator = new PasswordValidator();
            errorCollector.collectError(validator.validate(password));
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            EmailValidator validator = new EmailValidator();
            errorCollector.collectError(validator.validate(email));
            return this;
        }

        public User build() {
            errorCollector.throwIfErrors();
            return new User(this);
        }
    }
}