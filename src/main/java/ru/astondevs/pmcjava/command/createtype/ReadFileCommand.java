package ru.astondevs.pmcjava.command.createtype;

import ru.astondevs.pmcjava.Menu;

import static java.lang.System.out;

/**
 * Команда для чтения объектов из файла.
 */
public class ReadFileCommand extends TypeCreateCommand {


    public ReadFileCommand(String commandName, Menu mainMenu, Menu createTypeMenu) {
        super(commandName, mainMenu, createTypeMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        super.execute();
        out.println("Input path");
        mainMenu.setListObjects(getCreate().createReadFile(getScanner().next()));
    }
}
