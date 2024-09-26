package ru.astondevs.pmcjava.functional.comparators;

import ru.astondevs.pmcjava.model.User;

import java.util.Comparator;
import java.util.Map;

/**
 * Класс для создания компараторов пользователей/
 */
public class UserComparator extends AbstractComparator<User> {
    public UserComparator(String orderSort) {
        super(orderSort);
    }

    /**
     * Формирует мапу с компараторами, где ключ - порядковый номер поля, значение - компаратор для сравнения этого поля.
     * @return Мапа с компараторами
     */
    @Override
    public Map<Integer, Comparator<User>> createAllComparators() {
        return Map.of(1, Comparator.comparing(User::getName),
                2, Comparator.comparing(User::getPassword),
                3, Comparator.comparing(User::getEmail));
    }
}
