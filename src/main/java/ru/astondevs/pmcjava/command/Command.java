package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.MainMenu;

import java.util.Scanner;

import static java.util.Objects.requireNonNull;

public abstract class Command {

    private final Scanner scanner = new Scanner(System.in);

    /**
     * Наименование команды.
     */
    private final String nameCommand;
    /**
     * Меню процесса
     */
    protected final MainMenu mainMenu;

    /**
     * Конструктор создает команду для меню.
     *
     * @param commandName Название команды
     * @param mainMenu        Игровой процесс
     */
    Command(String commandName, MainMenu mainMenu) {
        this.nameCommand = requireNonNull(commandName);
        this.mainMenu = requireNonNull(mainMenu);

    }

    /**
     * Выполнить команду.
     */
    public abstract void execute();


    /**
     * Проверяет возможность вывода на экран.
     *
     * @return true/false, если вывод доступен/не доступен
     */
    public abstract boolean isDisplay();

    public String getNameCommand() {
        return nameCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Command command)) {
            return false;
        }

        return nameCommand.equals(command.nameCommand);
    }

    @Override
    public int hashCode() {
        return nameCommand.hashCode();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
