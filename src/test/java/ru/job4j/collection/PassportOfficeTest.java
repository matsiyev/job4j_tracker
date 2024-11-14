package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void addSameCitizen() {
        Citizen citizen = new Citizen("123abc", "Muhammad Matsiyev");
        Citizen citizen1 = new Citizen("123abc", "Muhammad Sidorov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        office.add(citizen1);
        assertThat(office.get(citizen.getPassport())).isNull();
    }
}