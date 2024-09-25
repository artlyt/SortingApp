package ru.astondevs.pmcjava.model;

import org.junit.jupiter.api.Test;
import ru.astondevs.pmcjava.validation.ValidationErrorCollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void testValidUser() {
        User user = new User.Builder()
                .setName("John")
                .setPassword("StrongPass123!")
                .setEmail("john@example.com")
                .build();

        assertEquals("John", user.getName());
        assertEquals("StrongPass123!", user.getPassword());
        assertEquals("john@example.com", user.getEmail());
    }

    @Test
    void testInvalidUserName() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new User.Builder()
                    .setName("")  // Недопустимое имя
                    .setPassword("StrongPass123!")
                    .setEmail("john@example.com")
                    .build();
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new User.Builder()
                    .setName("John")
                    .setPassword("weak")  // Слабый пароль
                    .setEmail("john@example.com")
                    .build();
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new User.Builder()
                    .setName("John")
                    .setPassword("StrongPass123!")
                    .setEmail("invalid-email")  // Недопустимый формат почты
                    .build();
        });
    }
}