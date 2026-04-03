package ru.job4j.bank;

import java.util.*;

/**
 * Сервис для управления пользователями и их банковскими счетами.
 * Хранит счета пользователей
 * Имеет операции по удалению/добавлению пользователей , добавления счетов
 * поиск по паспорту и реквизиту
 *
 * @author Job4j
 * @version 1.0
 */
public class BankService {
    /**
     * Хранилище пользователей и их счетов
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя в систему
     * Если пользователь с таким паспортом уже существует, ничего не меняется.
     *
     * @param user добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя по номеру паспорта
     *
     * @param passport паспорт пользователя, которого нужно удалить
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, null));
    }

    /**
     * Добавляет счёт указанному пользователю.
     * Если пользователь не найден или счёт уже существует, добавление не происходит.
     *
     * @param passport паспорт пользователя, которому добавляется счёт
     * @param account  добавляемый счёт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Находит пользователя по номеру паспорта.
     *
     * @param passport паспорт искомого пользователя
     * @return найденный пользователь
     */
    public User findByPassport(String passport) {
        Set<User> allUsers = users.keySet();
        for (User user : allUsers) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Находит счёт пользователя по паспорту и реквизитам счёта.
     *
     * @param passport  паспорт владельца счёта
     * @param requisite реквизиты искомого счёта
     * @return найденный счёт или {@code null}, если пользователь или счёт не найдены
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги между двумя счетами.
     * Перевод возможен, если оба счёта существуют и на счету-источнике
     * достаточно средств.
     *
     * @param sourcePassport      паспорт пользователя-отправителя
     * @param sourceRequisite     реквизиты счёта-источника
     * @param destinationPassport паспорт пользователя-получателя
     * @param destinationRequisite реквизиты счёта-получателя
     * @param amount              сумма перевода
     * @return {@code true}, если перевод выполнен успешно; {@code false} иначе
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && destination != null && (source.getBalance() - amount) >= 0) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Возвращает список всех счетов пользователя.
     *
     * @param user пользователь, чьи счета нужно получить
     * @return список счетов или {@code null}, если пользователь не найден в системе
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}