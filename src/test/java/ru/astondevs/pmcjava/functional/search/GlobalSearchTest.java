package ru.astondevs.pmcjava.functional.search;

import org.junit.jupiter.api.Test;
import ru.astondevs.pmcjava.functional.GlobalSearch;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.model.Bus;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GlobalSearchTest {

    @Test
    void binarySearch() {
        String orderSorting = "123";
        Bus bus1 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(125).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА97").setModel("Volvo").setMileage(100).build();
        Bus bus3 = new Bus.Builder().setNumber("А123АА97").setModel("Volga").setMileage(37).build();
        Bus bus4 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(25).build();
        Bus bus5 = new Bus.Builder().setNumber("В123АА97").setModel("Nissan").setMileage(25).build();
        List<Bus> buses = List.of(bus1, bus2, bus3, bus4, bus5);

        assertEquals(true, GlobalSearch.binarySearch(buses, bus2, new BusComparator(orderSorting).createComparator()));

    }
}




