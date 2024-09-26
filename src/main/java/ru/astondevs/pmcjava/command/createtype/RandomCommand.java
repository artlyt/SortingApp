package ru.astondevs.pmcjava.command.createtype;

import ru.astondevs.pmcjava.Menu;

/**
 * Команда для создания объектов рандомно.
 */
public class RandomCommand extends TypeCreateCommand {
    public RandomCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu, createTypeMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        super.execute();
        mainMenu.setListObjects(getCreate().createRandom());
    }
}
