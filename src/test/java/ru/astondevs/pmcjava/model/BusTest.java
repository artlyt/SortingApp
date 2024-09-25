package ru.astondevs.pmcjava.model;

import org.junit.jupiter.api.Test;
import ru.astondevs.pmcjava.validation.ValidationErrorCollector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BusTest {

    @Test
    void testValidBus() {
        Bus bus = new Bus.Builder()
                .setNumber("А123ВС77")
                .setModel("Mercedes")
                .setMileage(5000)
                .build();

        assertEquals("А123ВС77", bus.getNumber());
        assertEquals("Mercedes", bus.getModel());
        assertEquals(5000, bus.getMileage());
    }

    @Test
    void testInvalidBusNumber() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Bus.Builder()
                    .setNumber("123ВС77")  // Недопустимый формат
                    .setModel("Mercedes")
                    .setMileage(5000)
                    .build();
        });
    }

    @Test
    void testInvalidBusMileage() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Bus.Builder()
                    .setNumber("А123ВС77")
                    .setModel("Mercedes")
                    .setMileage(10000001)  // Превышает предел пробега
                    .build();
        });
    }

    @Test
    void testInvalidBusModel() {
        assertThrows(ValidationErrorCollector.ValidationException.class, () -> {
            new Bus.Builder()
                    .setNumber("А123ВС77")
                    .setModel("")  // Пустое поле
                    .setMileage(5000)
                    .build();
        });
    }
}