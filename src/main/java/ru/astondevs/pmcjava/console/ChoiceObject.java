package ru.astondevs.pmcjava.console;

import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChoiceObject {
    private Scanner scanner = new Scanner(System.in);

    public List<?> fillData() {
        System.out.println("""
        \n=== Choose type ===
        1. Buses
        2. Users
        3. Students
        Choose an option: """);

        int typeChoice = scanner.nextInt();
        switch (typeChoice) {
            case 1 -> {
                return createBuses();
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }
    }

    private List<Bus> createBuses() {
        List<Bus> buses = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals("СТОП")) {
            userInput = scanner.next();
            if (!userInput.equals("СТОП")) {
                String[] strings = userInput.split("::");
                buses.add(new Bus.Builder()
                        .setNumber(strings[0])
                        .setModel(strings[1])
                        .setMileage(Double.parseDouble(strings[2]))
                        .build());

            }
        }
        return buses;
    }
}
