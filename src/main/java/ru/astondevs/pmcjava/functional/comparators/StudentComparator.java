package ru.astondevs.pmcjava.functional.comparators;

import ru.astondevs.pmcjava.model.Student;

import java.util.Comparator;
import java.util.Map;

/**
 * Класс для создания компаратора студентов.
 */
public class StudentComparator extends AbstractComparator<Student> {
    protected StudentComparator(String orderSort) {
        super(orderSort);
    }

    /**
     * Формирует мапу с компараторами, где ключ - порядковый номер поля, значение - компаратор для сравнения этого поля.
     * @return Мапа с компараторами
     */
    @Override
    public Map<Integer, Comparator<Student>> createAllComparators() {
        return Map.of(1, Comparator.comparingInt(Student::getGroupNumber),
                2, Comparator.comparingDouble(Student::getAverageGrade),
                3, Comparator.comparingInt(Student::getGroupNumber));
    }
}
