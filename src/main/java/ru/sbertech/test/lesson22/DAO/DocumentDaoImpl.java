package ru.sbertech.test.lesson22.DAO;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import ru.sbertech.test.lesson22.Account;
import ru.sbertech.test.lesson22.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static ru.sbertech.test.lesson22.Main.applicationContext;

public class DocumentDaoImpl implements DocumentDao {

    JdbcTemplate jdbcTemplate;

    public DocumentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void insert(String accNumDT, String accNumCT, BigDecimal summa, String purpose) {
        AccountDAOImpl accountDAO = (AccountDAOImpl) applicationContext.getBean("AccountDAOImpl");
        try {
            Account accountDT = accountDAO.getAccountByAccNum(accNumDT);
            Account accountCT = accountDAO.getAccountByAccNum(accNumCT);
            if (accountCT.checkSaldo(summa)) {
                accountDAO.updateSaldoByAccNum(accountDT.getSaldoAfterTransactionDT(summa), accNumDT);
                accountDAO.updateSaldoByAccNum(accountCT.getSaldoAfterTransactionCT(summa), accNumCT);
                jdbcTemplate.update("INSERT INTO DOCUMENTS(accDT,accCT,summa,purpose,docDate) VALUES(?,?,?,?,?)",
                        accountDT.getId(),accountCT.getId(),summa,purpose,new Date());
            } else {
                System.out.println("Отрицательный баланс на счете " + accNumCT + " невозможен, разница равна "
                        + accountCT.getSaldo().subtract(summa));
            }
        } catch (IllegalArgumentException e) {
            e.getMessage();
            return;
        }

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public Document getDocumentById(int id) {
        return null;
    }

    @Override
    public List<Document> getDocumentsByPurpose(String purpose) {
        return null;
    }

    @Override
    public List<Document> getListDocuments() {
        return null;
    }
}
