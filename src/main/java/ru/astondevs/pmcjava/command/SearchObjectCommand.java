package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.Menu;
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
public class SearchObjectCommand extends Command {

    private static final String TEXT_COLLECTION = "Is in collection: ";
    /**
     * Конструктор создает команды.
     *
     * @param commandName Название команды
     * @param menu        Игровой процесс
     */
    public SearchObjectCommand(String commandName, Menu menu) {
        super(commandName, menu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        if (mainMenu.getListObjects().isEmpty()) {
            out.println("type object is bad");
            return;
        }

        Object firstObject = mainMenu.getListObjects().getFirst();
        if (firstObject instanceof Bus) {
            searchBus();
        } else if (firstObject instanceof Student) {
            searchStudent();
        } else if (firstObject instanceof User) {
            searchUser();
        } else {
            out.println("type object is bad");
        }
    }

    private void searchBus() {
        out.println("Введите номер, модель, пробег автобуса");
        Bus bus = map(getScanner().next(), getScanner().next(), getScanner().nextDouble());
        out.println(TEXT_COLLECTION +
                binarySearch((List<Bus>) mainMenu.getListObjects(), bus, new BusComparator("123").createComparator()));
    }

    private void searchStudent() {
        out.println("Введите номер группы, средний балл, номер зачетной книжки");
        Student student = StudentMapper.map(getScanner().nextInt(), getScanner().nextDouble(), getScanner().nextInt());
        out.println(TEXT_COLLECTION +
                binarySearch((List<Student>) mainMenu.getListObjects(), student, new StudentComparator("123").createComparator()));
    }

    private void searchUser() {
        out.println("Введите номер группы, средний балл, номер зачетной книжки");
        User user = UserMapper.map(getScanner().next(), getScanner().next(), getScanner().next());
        out.println(TEXT_COLLECTION +
                binarySearch((List<User>) mainMenu.getListObjects(), user, new UserComparator("123").createComparator()));
    }

    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    @Override
    public boolean isDisplay() {
        return mainMenu.isSortingList();
    }
}
