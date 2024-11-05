package ru.job4j.collection;

import java.security.Key;
import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> mail = new HashMap<>();
        mail.put("matsiyev@mail.ru", "Muhammad Matsiyev");

        for (String key : mail.keySet()) {
            String value = mail.get(key);
            System.out.println(value);
        }
    }
}
