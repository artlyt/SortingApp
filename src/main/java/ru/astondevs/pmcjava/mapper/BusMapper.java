package ru.astondevs.pmcjava.mapper;

import ru.astondevs.pmcjava.model.Bus;

public class BusMapper {
    private BusMapper() {
    }

    public static Bus map(String number, String model, double mileage) {
        return new Bus.Builder()
                .setNumber(number)
                .setModel(model)
                .setMileage(mileage).build();
    }
}
