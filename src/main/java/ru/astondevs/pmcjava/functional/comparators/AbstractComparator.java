package ru.astondevs.pmcjava.functional.comparators;

import java.util.Comparator;
import java.util.Map;


public abstract class AbstractComparator<T> {
    /**
     * Порядок сортировки.
     * Например, если будет передано значение 123, то сначала будет проводиться сортировка по компаратору 1,
     * затем по компаратору 2, затем по компаратору 3.
     */
    private final String orderSort;

    protected AbstractComparator(String orderSort) {
        this.orderSort = orderSort;
    }

    /**
     * Формирует мапу с компараторами, где ключ - порядковый номер поля, значение - компаратор для сравнения этого поля.
     *
     * @return Мапа с компараторами
     */
    protected abstract Map<Integer, Comparator<T>> createAllComparators();

    /**
     * Создает компаратор из возможных вариантов стратегий.
     *
     * @return Компаратор
     */
    public Comparator<T> createComparator() {
        String[] strings = orderSort.split("");
        Integer[] numbers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        Map<Integer, Comparator<T>> comparatorMap = createAllComparators();
        Comparator<T> comparator = comparatorMap.get(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            comparator = comparator.thenComparing(comparatorMap.get(numbers[i]));
        }
        return comparator;
    }
}
