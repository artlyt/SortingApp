package ru.astondevs.pmcjava.functional.creation;

import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static ru.astondevs.pmcjava.functional.TextMenu.SEPARATOR;
import static ru.astondevs.pmcjava.mapper.BusMapper.map;

public class CreateBus extends Create {
    @Override
    public List<Bus> createInput(Scanner scanner) {
        List<Bus> buses = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals("СТОП")) {
            userInput = scanner.next();
            if (!userInput.equals("СТОП")) {
                String[] strings = userInput.split(SEPARATOR);
                buses.add(map(strings[0], strings[1], parseDouble(strings[2])));
            }
        }
        return buses;
    }

    /**
     * Возвращает список автобусов из файла
     *
     * @param path - относительный путь к файлу
     * @return Список автобусов
     */
    @Override
    public List<Bus> createReadFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> map(strings[0], strings[1], Double.parseDouble(strings[2]))
                ).toList();
    }

    @Override
    public List<Bus> createRandom(int numberOfBuses) {
        final String[] MODELS = {"Mercedes", "Volvo", "MAN", "Scania", "Ikarus"};
        final char[] BUS_NUMBER_LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        final Random random = new Random();

        List<Bus> buses = new ArrayList<>();

        for (int i = 0; i < numberOfBuses; i++) {

            String randomNumber = generateRandomBusNumber(BUS_NUMBER_LETTERS, random);
            String randomModel = MODELS[random.nextInt(MODELS.length)];
            double randomMileage = random.nextDouble() * 1000000;

            Bus bus = new Bus.Builder()
                    .setNumber(randomNumber)
                    .setModel(randomModel)
                    .setMileage(randomMileage)
                    .build();

            buses.add(bus);
        }
        return buses;
    }

    private String generateRandomBusNumber(char[] busNumberLetters, Random random) {
        StringBuilder busNumber = new StringBuilder();

        busNumber.append(busNumberLetters[random.nextInt(busNumberLetters.length)]);
        busNumber.append(String.format("%03d", random.nextInt(1000)));
        busNumber.append(busNumberLetters[random.nextInt(busNumberLetters.length)]);
        busNumber.append(busNumberLetters[random.nextInt(busNumberLetters.length)]);
        busNumber.append(String.format("%02d", random.nextInt(100)));

        if (random.nextBoolean()) {
            busNumber.append(random.nextInt(10));
        }

        return busNumber.toString();
    }
}
