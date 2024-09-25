package ru.astondevs.pmcjava.validation;

public class EmailValidator implements Validator<String> {

    @Override
    public String validate(String email) {
        if (isNull(email)) {
            return "Email не может быть null";
        }
        if (!isLengthValid(email)) {
            return "Email слишком короткий";
        }
        if (!containsAtSymbol(email)) {
            return "Email должен содержать символ @";
        }
        if (!matchesPattern(email)) {
            return "Email имеет неверный формат";
        }
        return null;
    }

    private boolean isNull(String value) {
        return value == null;
    }

    private boolean isLengthValid(String email) {
        return email.length() > 5;
    }

    private boolean containsAtSymbol(String email) {
        return email.contains("@");
    }

    private boolean matchesPattern(String email) {
        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }
}