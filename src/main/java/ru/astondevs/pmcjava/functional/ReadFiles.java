package ru.astondevs.pmcjava.functional;


import ru.astondevs.pmcjava.mapper.BusMapper;
import ru.astondevs.pmcjava.model.Bus;
import ru.astondevs.pmcjava.model.Student;
import ru.astondevs.pmcjava.model.User;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public class ReadFiles {

    private ReadFiles() {
    }

    /**
     * Возвращает список автобусов из файла
     * @param path - относительный путь к файлу
     * @return Список автобусов
     */
    public static List<Bus> readBusFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> BusMapper.busMapper(strings[0], strings[1], Double.parseDouble(strings[2]))
                ).toList();
    }

    /**
     * Возвращает список студентов из файла
     * @param path - относительный путь к файлу
     * @return Список студентов
     */
    public static List<Student> readStudentFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> new Student.Builder()
                        .setGroupNumber(parseInt(strings[0]))
                        .setRecordBookNumber(parseInt(strings[1]))
                        .setRecordBookNumber(parseInt(strings[2]))
                        .build()
                ).toList();
    }

    /**
     * Возвращает список пользователей из файла
     * @param path - относительный путь к файлу
     * @return Список пользователей
     */
    public static List<User> readUserFile(String path) {
        int numFields = 3;
        return readFile(path, numFields).stream()
                .map(strings -> new User.Builder()
                        .setName(strings[0])
                        .setPassword(strings[1])
                        .setEmail(strings[2])
                        .build()
                ).toList();
    }


    private static List<String[]> readFile(String path, int numFields) {
        try {
            return readAllLines(get(path))
                    .stream()
                    .map(string -> string.split(" "))
                    .filter(strings -> strings.length == numFields)
                    .toList();
        } catch (IOException e) {
            throw new IllegalArgumentException("path is illegal");
        }
    }
}
