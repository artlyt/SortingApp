package ru.astondevs.pmcjava;

import ru.astondevs.pmcjava.command.CreateCollectionCommand;
import ru.astondevs.pmcjava.command.ExitCommand;
import ru.astondevs.pmcjava.command.SearchObjectCommand;
import ru.astondevs.pmcjava.command.SortingCollectionCommand;

public class ConsoleRunner {
    public static void main(String[] args) {
       MainMenu menu = new MainMenu();
       menu.addCommand(new CreateCollectionCommand("Fill", menu)) //1. Fill data
               .addCommand(new SortingCollectionCommand("Sort", menu)) //2. Sort data
               .addCommand(new SearchObjectCommand("Search", menu)) //3. Search in data
               .addCommand(new ExitCommand("Exit", menu)) //4. Exit
               .run();
    }
}
