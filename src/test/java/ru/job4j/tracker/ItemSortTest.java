package ru.job4j.tracker;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class ItemSortTest {

    @Test
    public void whenSortAscByName() {
        Item i1 = new Item(1, "Beta");
        Item i2 = new Item(2, "Alpha");
        Item i3 = new Item(3, "Gamma");
        List<Item> items = new ArrayList<>(Arrays.asList(i1, i2, i3));
        List<Item> expected = Arrays.asList(i2, i1, i3);
        Collections.sort(items, new ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void whenSortDescByName() {
        Item i1 = new Item(1, "Beta");
        Item i2 = new Item(2, "Alpha");
        Item i3 = new Item(3, "Gamma");
        List<Item> items = new ArrayList<>(Arrays.asList(i1, i2, i3));
        List<Item> expected = Arrays.asList(i3, i1, i2);
        Collections.sort(items, new ItemDescByName());
        assertEquals(expected, items);
    }
}
