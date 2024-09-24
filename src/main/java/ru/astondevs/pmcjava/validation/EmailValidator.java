package ru.astondevs.pmcjava.validation;

public class EmailValidator implements Validator<String> {

    @Override
    public boolean validate(String email) {
        return isNotNull(email) && isLengthValid(email) && containsAtSymbol(email) && matchesPattern(email);
    }

    // Метод для проверки, что email не null
    private boolean isNotNull(String email) {
        return email != null;
    }

    // Метод для проверки длины email
    private boolean isLengthValid(String email) {
        return email.length() > 5;
    }

    // Метод для проверки наличия символа "@"
    private boolean containsAtSymbol(String email) {
        return email.contains("@");
    }

    // Метод для проверки соответствия регулярному выражению
    private boolean matchesPattern(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}