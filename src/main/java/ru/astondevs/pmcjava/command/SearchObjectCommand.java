package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.console.MainMenu;
import ru.astondevs.pmcjava.functional.GlobalSearch;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.mapper.BusMapper;
import ru.astondevs.pmcjava.model.Bus;

import java.util.List;

import static java.lang.System.out;

public class SearchObjectCommand extends Command{
    /**
     * Конструктор создает команду для игры.
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
        if (!mainMenu.getListObjects().isEmpty() && mainMenu.getListObjects().getFirst() instanceof Bus) {
            out.println("Введите номер, модель, пробег автобуса");
            Bus bus = BusMapper.busMapper(getScanner().next(), getScanner().next(), getScanner().nextDouble());
            out.println("Is in collection: " +
                    GlobalSearch.binarySearch((List<Bus>) mainMenu.getListObjects(), bus, new BusComparator("123").createComparator()));
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
