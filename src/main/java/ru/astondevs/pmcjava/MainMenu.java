package ru.astondevs.pmcjava;

import ru.astondevs.pmcjava.command.Command;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);

    private boolean running = true;

    private List<?> listObjects = new ArrayList<>();

    private boolean isSortingList = false;

    private final Map<String, Command> menuMap = new LinkedHashMap<>();

    public MainMenu addCommand(Command command) {
        requireNonNull(command);
        menuMap.putIfAbsent(command.getNameCommand(), command);
        return this;
    }

    public void run() {
        while (running) {
            out.println("==Input paragraph menu==");
            menuMap.values().stream()
                    .filter(Command::isDisplay)
                    .forEach(command -> out.println(command.getNameCommand()));
            String choice = scanner.next();
            Optional.ofNullable(choice)
                    .map(menuMap::get)
                    .ifPresentOrElse(Command::execute, ()-> out.println("Command is bad"));
        }
    }

    public List<?> getListObjects() {
        return listObjects;
    }

    public boolean isSortingList() {
        return isSortingList;
    }

    public void setSortingList(boolean sortingList) {
        isSortingList = sortingList;
    }

    public void setListObjects(List<?> listObjects) {
        this.listObjects = listObjects;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
