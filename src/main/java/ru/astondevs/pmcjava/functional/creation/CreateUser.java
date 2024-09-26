package ru.astondevs.pmcjava.functional.creation;

import ru.astondevs.pmcjava.mapper.UserMapper;
import ru.astondevs.pmcjava.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ru.astondevs.pmcjava.functional.TextMenu.SEPARATOR;
import static ru.astondevs.pmcjava.functional.TextMenu.STOP;
import static ru.astondevs.pmcjava.mapper.UserMapper.map;

public class CreateUser extends Create{
    @Override
    public  List<User> createInput(Scanner scanner) {
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
    public  List<User> createReadFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> map(strings[0], strings[1], (strings[2]))
                ).toList();
    }

    @Override
    public List<User> createRandom() {
        return null;
    }
}
