package ru.sbertech.test.lesson22.DAO;


import ru.sbertech.test.lesson22.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDAO {
    void insert(BigDecimal saldo,String accNum,String clientName);
    void updateSaldoByAccNum(BigDecimal newsaldo,String accNum);
    void deleteByAccNum(String accNum);
    Account getAccountById(int id);
    Account getAccountByAccNum(String accNum);
    List<Account> getListAccounts();
}
