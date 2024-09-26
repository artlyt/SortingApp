package ru.astondevs.pmcjava.command;

import ru.astondevs.pmcjava.MainMenu;
import ru.astondevs.pmcjava.functional.creation.Create;
import ru.astondevs.pmcjava.functional.creation.CreateBus;
import ru.astondevs.pmcjava.functional.creation.CreateStudent;
import ru.astondevs.pmcjava.functional.creation.CreateUser;

import java.util.InputMismatchException;

import static java.lang.System.out;
import static ru.astondevs.pmcjava.functional.TextMenu.CREATE_COLLECTION;
import static ru.astondevs.pmcjava.functional.TextMenu.TYPE_INPUT;


/**
 * Команда для создания коллекции
 */
public class CreateCollectionCommand extends Command {
    /**
     * Конструктор создает команду для игры.
     *
     * @param commandName Название команды
     * @param mainMenu    Игровой процесс
     */
    public CreateCollectionCommand(String commandName, MainMenu mainMenu) {
        super(commandName, mainMenu);
    }

    /**
     * Выполнить команду.
     */
    @Override
    public void execute() {
        out.println(CREATE_COLLECTION);
        mainMenu.setSortingList(false);
        boolean nextInput;
        do {
            nextInput = true;
            int typeChoice;
            Create create = null;
            try {
                typeChoice = getScanner().nextInt();
                switch (typeChoice) {
                    case 1 -> create = new CreateBus();
                    case 2 -> create = new CreateStudent();
                    case 3 -> create = new CreateUser();
                    default -> {
                        out.println("Введен неправильный номер пункта");
                        nextInput = false;
                    }
                }
                if (nextInput) {
                    out.println(TYPE_INPUT);
                    typeChoice = getScanner().nextInt();
                    checkType(typeChoice, create);
                }
            } catch (InputMismatchException e) {
                out.println("Введен неправильный номер пункта");
            }
        }
        while (!nextInput);
    }

    private void checkType(int typeChoice, Create create) {
        switch (typeChoice) {
            case 1 -> {
                out.println("Input with keyboard");
                mainMenu.setListObjects(create.createInput(getScanner()));
            }
            case 2 -> {
                out.println("Input path file");
                mainMenu.setListObjects(create.createReadFile(getScanner().next()));
            }
            case 3 -> {
                out.println("Random generate");
                mainMenu.setListObjects(create.createRandom());
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
