package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.Menu;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;


/**
 * Команда для создания коллекции
 */
public class CreateCollectionCommand extends Command {

    public CreateCollectionCommand(String commandName, Menu createObjectMenu) {
        super(commandName, createObjectMenu);
        requireNonNull(createObjectMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.println("=== Choose type collection===");
        getMainMenu().run();
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
}
