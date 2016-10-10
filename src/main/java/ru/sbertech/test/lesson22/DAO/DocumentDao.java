package ru.sbertech.test.lesson22.DAO;


import ru.sbertech.test.lesson22.Document;

import java.math.BigDecimal;
import java.util.List;

public interface DocumentDao {
    void insert(String accNumDT, String accNumCT, BigDecimal summa,String purpose);
    //void updateSaldoByAccNum(BigDecimal newsaldo,String accNum);
    void deleteById(int id);
    Document getDocumentById(int id);
    List<Document> getDocumentsByPurpose(String purpose);
    List<Document> getListDocuments();
}
