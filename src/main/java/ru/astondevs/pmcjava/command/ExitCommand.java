package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.Menu;

import static java.lang.System.out;

/**
 * Команда выхода из программы
 */
public class ExitCommand extends Command{
    public ExitCommand(String commandName, Menu menu) {
        super(commandName, menu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.print("Choose an option: ");
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
}
