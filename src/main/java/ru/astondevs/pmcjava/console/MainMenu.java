package ru.astondevs.pmcjava.console;

import ru.astondevs.pmcjava.functional.GlobalSearch;
import ru.astondevs.pmcjava.functional.Sorter;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.mapper.BusMapper;
import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final ChoiceObject choiceObject = new ChoiceObject();


    public void run() {
        boolean running = true;
        List<?> listObjects = new ArrayList<>();
        while (running) {
            System.out.println("\n=== Sorting Application ===");
            System.out.println("1. Fill data");
            System.out.println("2. Sort data");
            System.out.println("3. Search in data");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getUserMenuInput();

            switch (choice) {
                case 1:
                    listObjects = choiceObject.fillData();
                    System.out.println(listObjects);
                    break;
                case 2:
                    if (listObjects.get(0) instanceof Bus) {
                        System.out.println("""
                                Введите порядок сортировки, где
                                1 - Номерной знак
                                2 - Модель
                                3 - Пробег
                                """);
                        System.out.println(Sorter.sortingSelection((List<Bus>) listObjects, new BusComparator(scanner.next()).createComparator()));
                    }
                    break;
                case 3:
                    if (listObjects.get(0) instanceof Bus) {
                        System.out.println("Введите номер, модель, пробег автобуса");
                        Bus bus = BusMapper.busMapper(scanner.next(), scanner.next(), scanner.nextDouble());
                        System.out.println("Is in collection: " +
                                GlobalSearch.binarySearch((List<Bus>) listObjects, bus, new BusComparator("123").createComparator()));
                    }
                    break;
//                case 4:
//                    running = false;
//                    System.out.println("Exiting the application...");
//                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private int getUserMenuInput() {
        int choice = -1;
        while (true) {
            try {
                choice = scanner.nextInt();
                break;  // Если ввод корректный, выходим из цикла
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();  // Очищаем некорректный ввод
            }
        }
        return choice;
    }

}
