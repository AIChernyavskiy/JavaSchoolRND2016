package ru.sbertech.test.lesson25.DAO;


import ru.sbertech.test.lesson25.Account;

import java.util.List;

public interface AccountDAO {

    void saveAccount(Account account);

    void updateAccount(Account account);

    List<Account> accountList();

    void removeAccountById(int id);

    void removeAccountByName(String accNum);

    Account getAccountById(int id);

    Account getAccountByName(String accNum);
}
