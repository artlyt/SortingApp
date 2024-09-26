package ru.astondevs.pmcjava.functional.creation;

import ru.astondevs.pmcjava.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static ru.astondevs.pmcjava.functional.TextMenu.SEPARATOR;
import static ru.astondevs.pmcjava.mapper.BusMapper.map;

public class CreateBus extends Create{
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
     * @param path - относительный путь к файлу
     * @return Список автобусов
     */
    @Override
    public  List<Bus> createReadFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> map(strings[0], strings[1], Double.parseDouble(strings[2]))
                ).toList();
    }

    @Override
    public  List<Bus> createRandom() {
        return null;
    }
}
