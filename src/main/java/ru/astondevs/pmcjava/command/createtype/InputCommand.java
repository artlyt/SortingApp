package ru.astondevs.pmcjava.command.createtype;

import ru.astondevs.pmcjava.Menu;

/**
 * Команда для создания объектов с помощью ввода с клавиатуры.
 */
public class InputCommand extends TypeCreateCommand {

    public InputCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu, createTypeMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        super.execute();
        mainMenu.setListObjects(getCreate().createInput(getCreateTypeMenu().getScanner()));
    }
}
