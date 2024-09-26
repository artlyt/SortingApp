package ru.astondevs.pmcjava.validation;

public class PasswordValidator implements Validator<String> {

    @Override
    public String validate(String password) {
        if (isNull(password)) {
            return "Пароль не может быть null";
        }
        if (!isLengthValid(password)) {
            return "Пароль слишком короткий";
        }
        if (!isPasswordStrongEnough(password)) {
            return "Пароль недостаточно сложный";
        }
        return null;
    }

    private boolean isNull(String value) {
        return value == null;
    }

    private boolean isLengthValid(String password) {
        return password.length() > 6;
    }

    private boolean isPasswordStrongEnough(String password) {
        return calculateEntropy(password) >= 20;
    }

    private double calculateEntropy(String password) {
        int charsetSize = getCharacterSetSize(password);
        return password.length() * (Math.log(charsetSize) / Math.log(2));
    }

    private int getCharacterSetSize(String password) {
        int charsetSize = 0;
        if (containsLowerCase(password)) charsetSize += 26;
        if (containsUpperCase(password)) charsetSize += 26;
        if (containsDigit(password)) charsetSize += 10;
        if (containsSpecialCharacter(password)) charsetSize += 32;
        return charsetSize;
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}