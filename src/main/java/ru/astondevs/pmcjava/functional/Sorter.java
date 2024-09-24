package ru.astondevs.pmcjava.functional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Сортировщик коллекций.
 */
public class Sorter<T> {

    /**
     * Реализует сортировку коллекции выбором.
     *
     * @param list       Список для сортировки
     * @param comparator Компаратор
     * @return Отсортированная коллекция
     */

    public List<T> sortingSelection(List<T> list, Comparator<T> comparator) {
        List<T> listCopy = generateModifibleList(list, comparator);
        int lengthList = listCopy.size();
        for (int i = 0; i < lengthList - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < lengthList; j++) {
                if (comparator.compare(listCopy.get(j), listCopy.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = listCopy.get(i);
                listCopy.set(i, listCopy.get(minIndex));
                listCopy.set(minIndex, temp);
            }
        }
        return listCopy;
    }

    /**
     * Копирует значения переданной коллекции
     *
     * @param list       Исходная коллекция
     * @param comparator Компаратор
     * @return Список объектов
     */
    private List<T> generateModifibleList(List<T> list, Comparator<T> comparator) {
        if (list == null || comparator == null) {
            throw new NullPointerException("list or comparator is null");
        }
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }
        List<T> listCopy = new ArrayList<>();
        for (T element : list) {
            if (element == null) {
                throw new NullPointerException("element of list is null");
            }
            listCopy.add(element);
        }
        return listCopy;
    }
}
