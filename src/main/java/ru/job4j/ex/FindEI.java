package ru.job4j.ex;

public class FindEI {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
               result = i;
               break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found in array");
        }
        return result;
    }
}
