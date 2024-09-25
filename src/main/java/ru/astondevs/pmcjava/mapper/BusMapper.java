package ru.astondevs.pmcjava.mapper;

import ru.astondevs.pmcjava.model.Bus;

public class BusMapper {
    public static Bus busMapper(String number, String model, double mileage) {
        return new Bus.Builder()
                .setNumber(number)
                .setModel(model)
                .setMileage(mileage).build();
    }
}
