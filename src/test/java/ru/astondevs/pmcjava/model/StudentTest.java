package ru.astondevs.pmcjava.model;

import org.junit.jupiter.api.Test;
import ru.astondevs.pmcjava.validation.ValidationErrorCollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void testValidStudent() {
        Student student = new Student.Builder()
                .setGroupNumber(101)
                .setAverageGrade(4.0)
                .setRecordBookNumber(12345)
                .build();

        assertEquals(101, student.getGroupNumber());
        assertEquals(4.0, student.getAverageGrade());
        assertEquals(12345, student.getRecordBookNumber());
    }

    @Test
    void testInvalidGroupNumber() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Student.Builder()
                    .setGroupNumber(-1)  // Недопустимый номер группы
                    .setAverageGrade(4.0)
                    .setRecordBookNumber(12345)
                    .build();
        });
    }

    @Test
    void testInvalidAverageGrade() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Student.Builder()
                    .setGroupNumber(101)
                    .setAverageGrade(6.0)  // Недопустимый средний балл
                    .setRecordBookNumber(12345)
                    .build();
        });
    }

    @Test
    void testInvalidRecordBookNumber() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Student.Builder()
                    .setGroupNumber(101)
                    .setAverageGrade(4.0)
                    .setRecordBookNumber(-123)  // Недопустимый номер зачетной книжки
                    .build();
        });
    }
}