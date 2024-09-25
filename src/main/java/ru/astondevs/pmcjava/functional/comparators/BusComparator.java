package ru.astondevs.pmcjava.functional.comparators;

import ru.astondevs.pmcjava.model.Bus;

import java.util.Comparator;
import java.util.Map;

/**
 * Класс, для создания компаратора автобусов.
 */
public class BusComparator extends AbstractComparator<Bus> {

    public BusComparator(String orderSort) {
        super(orderSort);
    }

    /**
     * Формирует мапу с компараторами, где ключ - порядковый номер поля, значение - компаратор для сравнения этого поля.
     * @return Мапа с компараторами
     */
    @Override
    public Map<Integer, Comparator<Bus>> createAllComparators() {
        return Map.of(1, Comparator.comparing(Bus::getNumber),
                2, Comparator.comparing(Bus::getModel),
                3, Comparator.comparingDouble(Bus::getMileage));
    }
}
