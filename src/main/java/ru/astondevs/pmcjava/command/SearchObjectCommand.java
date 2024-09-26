package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.MainMenu;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.functional.comparators.StudentComparator;
import ru.astondevs.pmcjava.functional.comparators.UserComparator;
import ru.astondevs.pmcjava.mapper.StudentMapper;
import ru.astondevs.pmcjava.mapper.UserMapper;
import ru.astondevs.pmcjava.model.Bus;
import ru.astondevs.pmcjava.model.Student;
import ru.astondevs.pmcjava.model.User;

import java.util.List;

import static java.lang.System.out;
import static ru.astondevs.pmcjava.functional.GlobalSearch.binarySearch;
import static ru.astondevs.pmcjava.mapper.BusMapper.map;

/**
 * Команда для поиска объекта в коллекции
 */
public class SearchObjectCommand extends Command{
    /**
     * Конструктор создает команды.
     *
     * @param commandName Название команды
     * @param mainMenu    Игровой процесс
     */
    public SearchObjectCommand(String commandName, MainMenu mainMenu) {
        super(commandName, mainMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        String textCollection = "Is in collection: ";
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Bus) {
            out.println("Введите номер, модель, пробег автобуса");
            Bus bus = map(getScanner().next(), getScanner().next(), getScanner().nextDouble());
            out.println( textCollection +
                    binarySearch((List<Bus>) mainMenu.getListObjects(), bus, new BusComparator("123").createComparator()));
        }
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Student) {
            out.println("Введите номер группы, средний балл, номер зачетной книжки");
            Student student = StudentMapper.map(getScanner().nextInt(), getScanner().nextDouble(), getScanner().nextInt());
            out.println(textCollection +
                    binarySearch((List<Student>) mainMenu.getListObjects(), student, new StudentComparator("123").createComparator()));
        }
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof User) {
            out.println("Введите номер группы, средний балл, номер зачетной книжки");
            User user = UserMapper.map(getScanner().next(), getScanner().next(), getScanner().next());
            out.println(textCollection +
                    binarySearch((List<User>) mainMenu.getListObjects(), user, new UserComparator("123").createComparator()));
        }

    }

    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return  mainMenu.isSortingList();
    }
}
