package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.MainMenu;
import ru.astondevs.pmcjava.functional.Sorter;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.model.Bus;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * Команда для сортировки коллекции.
 */
public class SortingCollectionCommand extends Command {
    public SortingCollectionCommand(String commandName, MainMenu mainMenu) {
        super(commandName, mainMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Bus) {
            out.println("""
                                Введите порядок сортировки, где
                                1 - Номерной знак
                                2 - Модель
                                3 - Пробег
                                """);
            out.println(Sorter.sortingSelection((List<Bus>) mainMenu.getListObjects(), new BusComparator(scanner.next()).createComparator()));
            mainMenu.setSortingList(true);
        }
    }

    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return !mainMenu.getListObjects().isEmpty();
    }
}
