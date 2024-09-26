package ru.astondevs.pmcjava.functional.creation;

import ru.astondevs.pmcjava.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static ru.astondevs.pmcjava.functional.TextMenu.SEPARATOR;
import static ru.astondevs.pmcjava.functional.TextMenu.STOP;
import static ru.astondevs.pmcjava.mapper.StudentMapper.map;


public class CreateStudent extends Create {
    @Override
    public List<Student> createInput(Scanner scanner) {
        List<Student> students = new ArrayList<>();
        String userInput = "";
        while (!userInput.equals(STOP)) {
            userInput = scanner.next();
            if (!userInput.equals(STOP)) {
                String[] strings = userInput.split(SEPARATOR);
                students.add(map(parseInt(strings[0]), parseDouble(strings[1]), parseInt(strings[2])));
            }
        }
        return students;
    }


    /**
     * Возвращает список студентов из файла
     *
     * @param path - относительный путь к файлу
     * @return Список студентов
     */
    @Override
    public  List<Student> createReadFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> map(parseInt(strings[0]), parseInt(strings[1]), parseInt(strings[2])))
                .toList();
    }

    @Override
    public List<Student> createRandom() {
        return null;
    }
}
