package ru.astondevs.pmcjava.console;

import ru.astondevs.pmcjava.mapper.BusMapper;
import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceObject {
    private Scanner scanner = new Scanner(System.in);

    public List<?> fillData() {
        System.out.println("""
        === Choose type ===
        1. Buses
        2. Users
        3. Students
        Choose an option:""");

        int typeChoice = scanner.nextInt();
        switch (typeChoice) {
            case 1 -> {
                return createBuses();
            }
            default -> throw new IllegalArgumentException();

        }
    }

    private List<Bus> createBuses() {
        List<Bus> buses = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals("СТОП")) {
            userInput = scanner.next();
            if (!userInput.equals("СТОП")) {
                String[] strings = userInput.split("::");
                buses.add(BusMapper.busMapper(strings[0], strings[1], Double.parseDouble(strings[2])));
            }
        }
        return buses;
    }
}
