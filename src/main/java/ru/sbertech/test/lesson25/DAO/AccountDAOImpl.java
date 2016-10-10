package ru.sbertech.test.lesson25.DAO;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbertech.test.lesson25.Account;

import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public AccountDAOImpl() {
    }

    public AccountDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveAccount(Account account) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.update(account);
        session.saveOrUpdate(account);
        System.out.println("Сохранили счет в базу " + account);
    }

    @Override
    public void updateAccount(Account account) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        session.update(account);
        System.out.println("Обновили счет в базе " + account);
    }

    @Override
    public List<Account> accountList() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session.createQuery("from Account").list();
    }

    @Override
    public void removeAccountById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Account account = (Account) session.load(Account.class, id);
        if (account != null) {
            session.delete(account);
        }
    }

    @Override
    public void removeAccountByName(String accNum) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Account account = (Account) session.load(Account.class, accNum);
        if (account != null) {
            session.delete(account);
        }
    }

    @Override
    public Account getAccountById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query q = session.createQuery("from Account where id = :id");
        q.setInteger("id", id);
        return (Account) q.uniqueResult();
    }

    @Override
    public Account getAccountByName(String accNum) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query q = session.createQuery("from Account where accNum = :accNum");
        q.setString("accNum", accNum);
        return (Account) q.uniqueResult();
    }
}
