package ru.astondevs.pmcjava.functional;

import org.junit.jupiter.api.Test;
import ru.astondevs.pmcjava.functional.comparators.BusComparator;
import ru.astondevs.pmcjava.model.Bus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {

    @Test
    void sortingSelection_SortByNumber() {
        String orderSorting = "1";

        Bus bus1 = new Bus.Builder().setNumber("В123АА97").setModel("A").setMileage(25).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА97").setModel("A").setMileage(25).build();
        Bus bus3 = new Bus.Builder().setNumber("Х123АА97").setModel("A").setMileage(25).build();
        Bus bus4 = new Bus.Builder().setNumber("К123АА97").setModel("A").setMileage(25).build();

        List<Bus> buses = List.of(bus1, bus2, bus3, bus4);

        List<Bus> busesSorting = List.of(bus2, bus1, bus4, bus3);

        assertEquals(busesSorting, Sorter.sortingSelection(buses, new BusComparator(orderSorting).createComparator()));
    }

    @Test
    void sortingSelection_SortByModel() {
        String orderSorting = "2";

        Bus bus1 = new Bus.Builder().setNumber("В123АА97").setModel("Man").setMileage(25).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА97").setModel("Volvo").setMileage(25).build();
        Bus bus3 = new Bus.Builder().setNumber("Х123АА97").setModel("Volga").setMileage(25).build();
        Bus bus4 = new Bus.Builder().setNumber("К123АА97").setModel("Nissan").setMileage(25).build();

        List<Bus> buses = List.of(bus1, bus2, bus3, bus4);

        List<Bus> busesSorting = List.of(bus1, bus4, bus3, bus2);

        assertEquals(busesSorting, Sorter.sortingSelection(buses, new BusComparator(orderSorting).createComparator()));
    }

    @Test
    void sortingSelection_SortByMileage() {
        String orderSorting = "3";

        Bus bus1 = new Bus.Builder().setNumber("В123АА797").setModel("Man").setMileage(125).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА797").setModel("Volvo").setMileage(100).build();
        Bus bus3 = new Bus.Builder().setNumber("Х123АА797").setModel("Volga").setMileage(37).build();
        Bus bus4 = new Bus.Builder().setNumber("К123АА797").setModel("Nissan").setMileage(25).build();

        List<Bus> buses = List.of(bus1, bus2, bus3, bus4);

        List<Bus> busesSorting = List.of(bus4, bus3, bus2, bus1);

        assertEquals(busesSorting, Sorter.sortingSelection(buses, new BusComparator(orderSorting).createComparator()));
    }

    @Test
    void sortingSelection_SortByNumberModelMileage() {
        String orderSorting = "123";

        Bus bus1 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(125).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА97").setModel("Volvo").setMileage(100).build();
        Bus bus3 = new Bus.Builder().setNumber("А123АА97").setModel("Volga").setMileage(37).build();
        Bus bus4 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(25).build();
        Bus bus5 = new Bus.Builder().setNumber("В123АА97").setModel("Nissan").setMileage(25).build();

        List<Bus> buses = List.of(bus1, bus2, bus3, bus4, bus5);

        List<Bus> busesSorting = List.of(bus3, bus2, bus5, bus4, bus1);

        assertEquals(busesSorting, Sorter.sortingSelection(buses, new BusComparator(orderSorting).createComparator()));
    }

    @Test
    void sortingSelection_SortByModelNumberMileage() {
        String orderSorting = "213";

        Bus bus1 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(125).build();
        Bus bus2 = new Bus.Builder().setNumber("А123АА97").setModel("Volvo").setMileage(100).build();
        Bus bus3 = new Bus.Builder().setNumber("А123АА97").setModel("Volga").setMileage(37).build();
        Bus bus4 = new Bus.Builder().setNumber("В123АА97").setModel("Volvo").setMileage(25).build();
        Bus bus5 = new Bus.Builder().setNumber("В123АА97").setModel("Nissan").setMileage(25).build();

        List<Bus> buses = List.of(bus1, bus2, bus3, bus4, bus5);

        List<Bus> busesSorting = List.of(bus5, bus3, bus2, bus4, bus1);

        assertEquals(busesSorting, Sorter.sortingSelection(buses, new BusComparator(orderSorting).createComparator()));
    }

}