package ru.sbertech.test.lesson22.DAO;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.sbertech.test.lesson22.Account;
import ru.sbertech.test.lesson22.Client;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ru.sbertech.test.lesson22.Main.applicationContext;

public class AccountDAOImpl implements AccountDAO {

    JdbcTemplate jdbcTemplate;

    public AccountDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(BigDecimal saldo, String accNum, String clientName) {
        ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
        try {
            Client client = clientDao.getClientByName(clientName);
            jdbcTemplate.update("INSERT INTO ACCOUNTS(accNum,saldo,client_id) VALUES(?,?,?)", accNum, saldo, client.getId());
            System.out.println("Создали счет с именем " + accNum);
        } catch (IllegalArgumentException e) {
            System.out.println("В таблице CLIENTS, нет клиента с именем " + clientName);
        }
    }

    @Override
    public void updateSaldoByAccNum(BigDecimal newsaldo, String accNum) {
        jdbcTemplate.update("UPDATE ACCOUNTS SET saldo = ? WHERE  accNum = ?", newsaldo, accNum);
        System.out.println("Изменили сальдо по счету " + accNum);
    }

    @Override
    public void deleteByAccNum(String accNum) {
        jdbcTemplate.update("DELETE FROM ACCOUNTS WHERE accNum = ?", accNum);
        System.out.println("Удалили счет с номером " + accNum);
    }

    @Override
    public Account getAccountById(int id) {
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM ACCOUNTS WHERE NAME=?", new Object[]{id}, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = (Account) applicationContext.getBean("Account");
                account.setId(resultSet.getInt(1));
                account.setSaldo(resultSet.getBigDecimal(2));
                account.setAccNum(resultSet.getString(3));
                ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
                Client client = clientDao.getClientById(resultSet.getInt(1));
                account.setClient(client);
                return account;
            }
        });
        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("Счета с id = " + id + " нет в базе данных");
        }
        return accounts.get(0);
    }

    @Override
    public Account getAccountByAccNum(String accNum) {
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM ACCOUNTS WHERE accNum=?", new Object[]{accNum}, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = (Account) applicationContext.getBean("Account");
                account.setId(resultSet.getInt(1));
                account.setSaldo(resultSet.getBigDecimal(2));
                account.setAccNum(resultSet.getString(3));
                ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
                Client client = clientDao.getClientById(resultSet.getInt(1));
                account.setClient(client);
                return account;
            }
        });
        if (accounts.isEmpty()) {
            throw new IllegalArgumentException("Счета с accNum = " + accNum + " нет в базе данных");
        }
        return accounts.get(0);
    }

    @Override
    public List<Account> getListAccounts() {
        List<Account> accounts = jdbcTemplate.query("SELECT * FROM ACCOUNTS", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = (Account) applicationContext.getBean("Account");
                account.setId(resultSet.getInt(1));
                account.setSaldo(resultSet.getBigDecimal(2));
                account.setAccNum(resultSet.getString(3));
                ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
                Client client = clientDao.getClientById(resultSet.getInt(1));
                account.setClient(client);
                return account;
            }
        });
        return accounts;
    }
}
