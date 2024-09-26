package ru.astondevs.pmcjava.command.createobject;

import ru.astondevs.pmcjava.Menu;
import ru.astondevs.pmcjava.command.createtype.TypeCreateCommand;
import ru.astondevs.pmcjava.functional.creation.CreateStudent;

/**
 * Команда для создания студентов.
 */
public class CreateStudentCommand extends CreateCommand {

    public CreateStudentCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
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
                .forEach(command -> command.setCreate(new CreateStudent()));
        getCreateTypeMenu().run();
    }
}
