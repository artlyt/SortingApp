package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.Menu;
import ru.astondevs.pmcjava.functional.Sorter;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.functional.comparators.StudentComparator;
import ru.astondevs.pmcjava.functional.comparators.UserComparator;
import ru.astondevs.pmcjava.model.Bus;
import ru.astondevs.pmcjava.model.Student;
import ru.astondevs.pmcjava.model.User;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;
import static ru.astondevs.pmcjava.functional.TextMenu.DESCRIPTION_SORT_BUSES;
import static ru.astondevs.pmcjava.functional.TextMenu.DESCRIPTION_SORT_STUDENTS;
import static ru.astondevs.pmcjava.functional.TextMenu.DESCRIPTION_SORT_USERS;

/**
 * Команда для сортировки коллекции.
 */
public class SortingCollectionCommand extends Command {
    public SortingCollectionCommand(String commandName, Menu menu) {
        super(commandName, menu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Bus) {
            out.println(DESCRIPTION_SORT_BUSES);
            out.println(Sorter.sortingSelection((List<Bus>) mainMenu.getListObjects(), new BusComparator(scanner.next()).createComparator()));
            mainMenu.setSortingList(true);
        }
        if(!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Student){
            out.println(DESCRIPTION_SORT_STUDENTS);
            out.println(Sorter.sortingSelection((List<Student>) mainMenu.getListObjects(), new StudentComparator(scanner.next()).createComparator()));
            mainMenu.setSortingList(true);
        }
        if(!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof User){
            out.println(DESCRIPTION_SORT_USERS);
            out.println(Sorter.sortingSelection((List<User>) mainMenu.getListObjects(), new UserComparator(scanner.next()).createComparator()));
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
