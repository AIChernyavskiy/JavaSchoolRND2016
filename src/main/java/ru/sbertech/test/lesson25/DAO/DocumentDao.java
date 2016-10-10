package ru.sbertech.test.lesson25.DAO;


import ru.sbertech.test.lesson25.Document;

import java.util.List;

public interface DocumentDao {

    void saveDocument(Document document);

    List<Document> documentList();

    void removeDocumentById(int id);

    void removeDocumentByPurpose(String purpose);

    Document getDocumentById(int id);

}
