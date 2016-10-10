package ru.sbertech.test.lesson25.DAO;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbertech.test.lesson25.Document;

import java.util.List;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    @Autowired
    SessionFactory sessionFactory;

    public DocumentDaoImpl() {
    }

    public DocumentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveDocument(Document document) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.saveOrUpdate(document);
        System.out.println("Сохранили документ в базу " + document);
    }

    @Override
    public List<Document> documentList() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session.createQuery("from Document").list();
    }

    @Override
    public void removeDocumentById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Document document = (Document) session.load(Document.class, id);
        if (document != null) {
            session.delete(document);
        }
    }

    @Override
    public void removeDocumentByPurpose(String purpose) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Document document = (Document) session.load(Document.class, purpose);
        if (document != null) {
            session.delete(document);
        }
    }

    @Override
    public Document getDocumentById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query q = session.createQuery("from Document where id = :id");
        q.setInteger("id", id);
        return (Document) q.uniqueResult();
    }
}
