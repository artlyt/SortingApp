package ru.astondevs.pmcjava.command.createobject;

import ru.astondevs.pmcjava.Menu;
import ru.astondevs.pmcjava.command.createtype.TypeCreateCommand;
import ru.astondevs.pmcjava.functional.creation.CreateBus;

/**
 * Команда для создания автобусов.
 */
public class CreateBusCommand extends CreateCommand {

    public CreateBusCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu, createTypeMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        super.execute();
        getCreateTypeMenu().getMenuMap().values().stream()
                .map(TypeCreateCommand.class::cast)
                .forEach(command -> command.setCreate(new CreateBus()));
        getCreateTypeMenu().run();
    }
}
