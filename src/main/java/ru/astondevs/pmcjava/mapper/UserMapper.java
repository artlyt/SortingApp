package ru.astondevs.pmcjava.mapper;

import ru.astondevs.pmcjava.model.User;

public class UserMapper {

    private UserMapper() {
    }

    public static User map(String name, String password, String email) {
        return new User.Builder()
                .setName(name)
                .setPassword(password)
                .setEmail(email)
                .build();
    }
}
