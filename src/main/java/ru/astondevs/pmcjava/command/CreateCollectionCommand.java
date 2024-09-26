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

    private void checkType(int typeChoice, Create create) {
        switch (typeChoice) {
            case 1 -> {
                out.println("Введите с клавиатуры");
                mainMenu.setListObjects(create.createInput(getScanner()));
            }
            case 2 -> {
                out.println("Введите путь файла");
                mainMenu.setListObjects(create.createReadFile(getScanner().next()));
            }
            case 3 -> {
                out.println("Введите количество объектов");
                int number = getScanner().nextInt();
                out.println("Генерация случайных объектов");
                mainMenu.setListObjects(create.createRandom(number));
            }
            default -> out.println("Неправильный ввод мы вас вернули в меню");
        }
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
