package ru.sbertech.test.lesson25.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sbertech.test.lesson25.Client;

import java.util.List;


@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public ClientDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public ClientDaoImpl() {

    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void saveClient(Client client) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.saveOrUpdate(client);
        System.out.println("Сохранили клиента в базу " + client);
    }

    @Override
    public List<Client> clientList() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session.createQuery("from Client").list();
    }

    @Override
    public void removeClientById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Client client = (Client) session.load(Client.class, id);
        if (client != null) {
            session.delete(client);
        }
    }

    @Override
    public void removeClientByName(String name) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Client client = (Client) session.load(Client.class, name);
        if (client != null) {
            session.delete(client);
        }
    }

    @Override
    public Client getClientById(int id) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query q = session.createQuery("from Client where id = :id");
        q.setInteger("id", id);
        return (Client) q.uniqueResult();
    }

    @Override
    public Client getClientByName(String name) {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        Query q = session.createQuery("from Client where name = :name");
        q.setString("name", name);
        return (Client) q.uniqueResult();
    }

}
