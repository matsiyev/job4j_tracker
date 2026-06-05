package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");
        int min = Math.min(leftParts.length, rightParts.length);
        for (int index = 0; index < min; index++) {
            int compare = index == 0
                    ? rightParts[index].compareTo(leftParts[index])
                    : leftParts[index].compareTo(rightParts[index]);
            if (compare != 0) {
                return compare;
            }
        }
        return leftParts.length - rightParts.length;
    }
}
