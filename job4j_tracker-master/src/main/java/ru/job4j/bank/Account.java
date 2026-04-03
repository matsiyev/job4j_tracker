package ru.job4j.bank;

import java.util.Objects;

/**
 * Модель банковского счёта.
 * Содержит реквизит счета , уникалный индентификатор, баланс
 * Два счёта считаются равными, если совпадают их реквизитные номера
 *
 * @author Job4j
 * @version 1.0
 */
public class Account {
    /**
     * Реквизит счета
     */
    private String requisite;

    /**
     * Баланс счёта.
     */
    private double balance;

    /**
     * Конструктор счёта
     *
     * @param requisite реквизиты счёта
     * @param balance   начальный баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счёта.
     *
     * @return реквизиты (строка)
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает новые реквизиты счёта.
     *
     * @param requisite новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс счёта.
     *
     * @return баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счёта.
     *
     * @param balance новый баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает текущий счет с другим обьектом для сравнения
     * Счета считаются равными, если совпадают их реквизиты.
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хеш-код счёта на основе его реквизитов.
     *
     * @return хеш-код
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}