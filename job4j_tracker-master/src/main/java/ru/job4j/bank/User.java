package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель пользователя банка.
 * Содержит паспортные данные и имя пользователя.
 * Пользователи считаются одинаковыми, если совпадают их паспорта.
 *
 * @author Job4j
 * @version 1.0
 */
public class User {
    /**
     * Номер паспорта
     */
    private String passport;

    /**
     * Имя пользователя
     */
    private String username;

    /**
     * Конструктор пользователя
     *
     * @param passport номер паспорта
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта
     *
     * @return паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает новый номер паспорта.
     *
     * @param passport новый паспорт
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя
     *
     * @return имя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Новое имя пользователя
     *
     * @param username новое имя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает текущего пользователя с другим объектом
     * Пользователи равны, если совпадают номера паспортов
     *
     * @param o объект для сравнения
     * @return {@code true}, если объекты равны; {@code false} иначе
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код пользователя на основе паспорта.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}