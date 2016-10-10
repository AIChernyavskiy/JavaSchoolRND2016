package ru.sbertech.test.lesson25.DAO;


import ru.sbertech.test.lesson25.Client;

import java.util.List;

public interface ClientDao {

    void saveClient(Client client);

    List<Client> clientList();

    void removeClientById(int id);

    void removeClientByName(String name);

    Client getClientById(int id);

    Client getClientByName(String name);
}
