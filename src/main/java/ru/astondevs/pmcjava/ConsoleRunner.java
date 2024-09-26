package ru.astondevs.pmcjava;

import ru.astondevs.pmcjava.command.createtype.InputCommand;
import ru.astondevs.pmcjava.command.createtype.RandomCommand;
import ru.astondevs.pmcjava.command.createtype.ReadFileCommand;
import ru.astondevs.pmcjava.command.createobject.CreateBusCommand;
import ru.astondevs.pmcjava.command.CreateCollectionCommand;
import ru.astondevs.pmcjava.command.createobject.CreateStudentCommand;
import ru.astondevs.pmcjava.command.createobject.CreateUserCommand;
import ru.astondevs.pmcjava.command.ExitCommand;
import ru.astondevs.pmcjava.command.SearchObjectCommand;
import ru.astondevs.pmcjava.command.SortingCollectionCommand;

public class ConsoleRunner {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Menu createObjectMenu = new Menu();
        Menu createTypeMenu = new Menu();

        createObjectMenu.addCommand(new CreateBusCommand("Buses",createObjectMenu, createTypeMenu))
                .addCommand(new CreateUserCommand("Users", createObjectMenu, createTypeMenu))
                .addCommand(new CreateStudentCommand("Students", createObjectMenu, createTypeMenu));


        createTypeMenu.addCommand(new ReadFileCommand("File", menu, createTypeMenu))
                .addCommand(new InputCommand("Input", menu, createTypeMenu))
                .addCommand(new RandomCommand("Random", menu, createTypeMenu));

        menu.addCommand(new CreateCollectionCommand("Fill", createObjectMenu)) //1. Fill data
                .addCommand(new SortingCollectionCommand("Sort", menu)) //2. Sort data
                .addCommand(new SearchObjectCommand("Search", menu)) //3. Search in data
                .addCommand(new ExitCommand("Exit", menu)) //4. Exit
                .run();
    }
}
