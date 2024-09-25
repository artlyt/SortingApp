package ru.astondevs.pmcjava.functional;

import java.util.Comparator;
import java.util.List;


public class GlobalSearch {


    public static <T> boolean binarySearch(List<T> list, T target, Comparator <T> comp) {
        if (target == null || list == null || comp == null) {
            throw new NullPointerException("Target to search must not be null");
        }
        List <T> sortinglist = Sorter.sortingSelection(list , comp);
        int low = 0;
        int high = sortinglist.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            T midVal = sortinglist.get(mid);
            int cmp = comp.compare(midVal, target);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return true; // Найдено
            }
        }
        return false; // Не найдено
    }
}