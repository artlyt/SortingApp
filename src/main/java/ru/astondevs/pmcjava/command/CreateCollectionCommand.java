package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.console.MainMenu;
import ru.astondevs.pmcjava.mapper.BusMapper;
import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCollectionCommand extends Command{
    /**
     * Конструктор создает команду для игры.
     *
     * @param commandName Название команды
     * @param mainMenu    Игровой процесс
     */
    public CreateCollectionCommand(String commandName, MainMenu mainMenu) {
        super(commandName, mainMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        System.out.println("""
        === Choose type ===
        1. Buses
        2. Users
        3. Students
        Choose an option:""");
        int typeChoice = getScanner().nextInt();
        mainMenu.setSortingList(false);
        switch (typeChoice) {
            case 1 -> mainMenu.setListObjects(createBuses());
            default -> throw new IllegalArgumentException();
        }
    }

    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return true;
    }

    private List<Bus> createBuses() {
        List<Bus> buses = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals("СТОП")) {
            userInput = getScanner().next();
            if (!userInput.equals("СТОП")) {
                String[] strings = userInput.split("::");
                buses.add(BusMapper.busMapper(strings[0], strings[1], Double.parseDouble(strings[2])));
            }
        }
        return buses;
    }
}
