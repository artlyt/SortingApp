package ru.astondevs.pmcjava.command.createtype;

import ru.astondevs.pmcjava.Menu;
import ru.astondevs.pmcjava.command.createobject.CreateCommand;
import ru.astondevs.pmcjava.functional.creation.Create;


import static java.util.Objects.requireNonNull;

/**
 * Команда, определяющая способ создания объектов
 */
public abstract class TypeCreateCommand extends CreateCommand {
    private Create create;

    protected TypeCreateCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu, createTypeMenu);
    }

    public void setCreate(Create create) {
        requireNonNull(create);
        this.create = create;
    }

    public Create getCreate() {
        return create;
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        getCreateTypeMenu().setRunning(false);
    }
}
