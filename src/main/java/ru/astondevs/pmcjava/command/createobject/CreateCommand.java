package ru.astondevs.pmcjava.command.createobject;

import ru.astondevs.pmcjava.Menu;
import ru.astondevs.pmcjava.command.Command;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

/**
 * Команда для создания объектов.
 */
public abstract class CreateCommand extends Command {

    private final Menu createTypeMenu;

    /**
     * Конструктор создает команду для меню.
     *
     * @param commandName Название команды
     * @param mainMenu    Меню
     *
     */
    protected CreateCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu);
        requireNonNull(createTypeMenu);
        this.createTypeMenu = createTypeMenu;
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.println("Input type create");
        mainMenu.setRunning(false);
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

    public Menu getCreateTypeMenu() {
        return createTypeMenu;
    }
}
