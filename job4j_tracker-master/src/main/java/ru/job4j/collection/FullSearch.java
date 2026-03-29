package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public Set<String> extractNumber(List<Task> tasks) {
        Set<String> num = new HashSet<>();
        for (Task task : tasks) {
            num.add(task.getNumber());
        }
        return num;
    }
}
