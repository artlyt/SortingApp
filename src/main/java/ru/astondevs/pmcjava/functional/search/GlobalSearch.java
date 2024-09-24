package ru.astondevs.pmcjava.functional.search;


import ru.astondevs.pmcjava.functional.Sorter;
import ru.astondevs.pmcjava.functional.comparators.AbstractComparator;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class GlobalSearch<T> extends AbstractComparator<T> {

    public GlobalSearch(String orderSort) {
        super(orderSort);
    }

    /**
     * Проверяю и сравниваю переданные объекты
     *
     * @param list       Коллекция для проверки и сортировки
     * @param element    Элемент для поиска
     * @param comparator Компаратор для сравнения
     * @return true, если элемент найден, иначе false
     */
    public boolean compareAndSort(List<T> list, T element, Comparator<T> comparator) {
        if (list == null || element == null) {
            throw new NullPointerException("Элемент нулевой");
        }

        List<T> sortedList = Sorter.sortingSelection(list, comparator);
        return binarySearch(sortedList, element, comparator);
    }

    /**
     * Бинарный поиск элемента в отсортированной коллекции.
     *
     * @param sortedList Отсортированная коллекция
     * @param element    Элемент для поиска
     * @param comparator Компаратор для сравнения
     * @return true, если элемент присутствует в коллекции, иначе false
     */
    private boolean binarySearch(List<T> sortedList, T element, Comparator<T> comparator) {
        int left = 0;
        int right = sortedList.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int comparison = comparator.compare(sortedList.get(middle), element);

            if (comparison == 0) {
                return true; // Элемент найден
            } else if (comparison < 0) {
                left = middle + 1; // Идём вправо
            } else {
                right = middle - 1; // Идём влево
            }
        }
        return false; // Элемент не найден
    }

    @Override
    public Map<Integer, Comparator<T>> createAllComparators() {
        // Вопрос про переопределение
        throw new UnsupportedOperationException("Need to override createAllComparators");
    }
}