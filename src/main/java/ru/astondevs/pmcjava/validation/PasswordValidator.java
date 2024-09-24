package ru.astondevs.pmcjava.validation;

public class PasswordValidator implements Validator<String> {

    @Override
    public boolean validate(String password) {
        return isNotNull(password) && isLengthValid(password) && isPasswordStrongEnough(password);
    }

    // Метод для проверки, что пароль не null
    private boolean isNotNull(String password) {
        return password != null;
    }

    // Метод для проверки минимальной длины пароля
    private boolean isLengthValid(String password) {
        return password.length() > 7;
    }

    // Метод для проверки, что пароль достаточно сложный
    private boolean isPasswordStrongEnough(String password) {
        return calculateEntropy(password) >= 25; // Порог энтропии 25 бит
    }

    // Метод для вычисления энтропии пароля (длина * логарифм по основанию 2 от размерности алфавита)
    private double calculateEntropy(String password) {
        int charsetSize = getCharacterSetSize(password);
        return password.length() * (Math.log(charsetSize) / Math.log(2));
    }

    // Метод для вычисления размерности набора символов, используемых в пароле
    private int getCharacterSetSize(String password) {
        int charsetSize = 0;
        if (containsLowerCase(password)) charsetSize += 26; // 26 строчных букв
        if (containsUpperCase(password)) charsetSize += 26; // 26 заглавных букв
        if (containsDigit(password)) charsetSize += 10; // 10 цифр
        if (containsSpecialCharacter(password)) charsetSize += 32; // Около 32 специальных символов
        return charsetSize;
    }

    // Метод для проверки наличия строчных латинских букв
    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    // Метод для проверки наличия заглавных латинских букв
    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    // Метод для проверки наличия цифр
    private boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    // Метод для проверки наличия специальных символов
    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}