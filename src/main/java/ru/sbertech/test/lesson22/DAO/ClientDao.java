package ru.sbertech.test.lesson22.DAO;


import ru.sbertech.test.lesson22.Client;

import java.util.List;

public interface ClientDao {
    void insert(String clientName);
    void update(String clientName,String newClientName);
    void delete(String clientName);
    Client getClientByName(String clientName);
    Client getClientById(int id);
    List<Client> getListClients();
}
