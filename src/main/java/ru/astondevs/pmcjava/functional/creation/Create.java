package ru.astondevs.pmcjava.functional.creation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;

public abstract class Create  {
    public abstract <T> List<T> createInput(Scanner scanner);

    public abstract <T> List<T> createReadFile(String string);

    public abstract <T> List<T> createRandom();

    public List<String[]> readFile(String path, int numFields) {
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
