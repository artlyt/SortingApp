package ru.astondevs.pmcjava.functional.creation;

import ru.astondevs.pmcjava.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static ru.astondevs.pmcjava.functional.TextMenu.SEPARATOR;
import static ru.astondevs.pmcjava.functional.TextMenu.STOP;
import static ru.astondevs.pmcjava.mapper.UserMapper.map;

public class CreateUser extends Create {

    @Override
    public List<User> createInput(Scanner scanner) {
        List<User> users = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals(STOP)) {
            userInput = scanner.next();
            if (!userInput.equals(STOP)) {
                String[] strings = userInput.split(SEPARATOR);
                users.add(map(strings[0], strings[1], strings[2]));
            }
        }
        return users;
    }

    @Override
    public List<User> createReadFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> map(strings[0], strings[1], (strings[2]))
                ).toList();
    }

    public List<User> createRandom(int numberOfUsers) {
        final String[] NAMES = {"Андрей", "Артем", "Дмитрий", "Сергей", "Алексей", "Арина", "Алина"};
        final String[] DOMAINS = {"gmail.com", "yahoo.com", "outlook.com", "mail.ru"};
        final Random random = new Random();

        List<User> users = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {

            String randomName = NAMES[random.nextInt(NAMES.length)];
            String randomEmail = randomName.toLowerCase() + (random.nextInt(100) + 1) + "@" + DOMAINS[random.nextInt(DOMAINS.length)];
            String randomPassword = generateRandomPassword(random.nextInt(5) + 8, random);

            User user = new User.Builder()
                    .setName(randomName)
                    .setEmail(randomEmail)
                    .setPassword(randomPassword)
                    .build();

            users.add(user);
        }

        return users;
    }

    private String generateRandomPassword(int length, Random random) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return password.toString();
    }
}
