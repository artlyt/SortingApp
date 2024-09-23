package ru.astondevs.pmcjava;

import ru.astondevs.pmcjava.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleRunner {
    private Scanner scanner = new Scanner(System.in);
    private List<Object> data = new ArrayList<>();  // Коллекция данных

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Sorting Application ===");
            System.out.println("1. Fill data");
            System.out.println("2. Sort data");
            System.out.println("3. Search in data");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = getUserInput();

            switch (choice) {
                case 1:
                    fillData();
                    break;
                case 2:
                    sortData();
                    break;
                case 3:
                    searchData();
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void fillData() {
        System.out.println("\n=== Fill Data ===");
        System.out.println("1. Fill manually (placeholder)");
        System.out.println("2. Fill randomly (placeholder)");
        System.out.println("3. Fill from file (placeholder)");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        // Пока что не реализовано, заглушка
        data.clear();  // Очистим текущие данные
        switch (choice) {
            case 1:
                System.out.println("Filling data manually... (placeholder)");
                // Заглушка для ручного заполнения
                data.add(new Object());  // Добавим тестовый объект в список
                break;
            case 2:
                System.out.println("Filling data randomly... (placeholder)");
                // Заглушка для случайного заполнения
                data.add(new Object());  // Добавим тестовый объект в список
                break;
            case 3:
                System.out.println("Filling data from file... (placeholder)");
                // Заглушка для заполнения из файла
                data.add(new Object());  // Добавим тестовый объект в список
                break;
            default:
                System.out.println("Invalid choice.");
        }

        System.out.println("Data has been filled.");
    }

    private void sortData() {
        System.out.println("\n=== Sort Data ===");
        if (data.isEmpty()) {
            System.out.println("No data to sort. Please fill the data first.");
            return;
        }
        // Заглушка для сортировки
        System.out.println("Sorting data... (placeholder)");
        // В дальнейшем здесь будет сортировка
        System.out.println("Data has been sorted.");
    }

    private void searchData() {
        System.out.println("\n=== Search in Data ===");
        if (data.isEmpty()) {
            System.out.println("No data to search. Please fill the data first.");
            return;
        }

        // Заглушка для поиска
        System.out.println("Searching in data... (placeholder)");
        // В дальнейшем здесь будет поиск
        System.out.print("Enter item to search (placeholder): ");
        scanner.next();  // Ввод пользователя, пока не используется
        System.out.println("Element not found (placeholder).");
    }

    private int getUserInput() {
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

    public static void main(String[] args) {
        ConsoleRunner app = new ConsoleRunner();
        app.run();
    }
}
