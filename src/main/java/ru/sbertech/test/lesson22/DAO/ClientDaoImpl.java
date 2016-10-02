package ru.sbertech.test.lesson22.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.sbertech.test.lesson22.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ru.sbertech.test.lesson22.Main.applicationContext;


public class ClientDaoImpl implements ClientDao {

    JdbcTemplate jdbcTemplate;

    public ClientDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(String clientName) {
        try {
            Client client = this.getClientByName(clientName);
            System.out.println("Клиент с именем "+ clientName + " уже существует в базе данных, измените имя и попробуйте заново");
        } catch (IllegalArgumentException e) {
            jdbcTemplate.update("INSERT INTO CLIENTS(NAME) VALUES(?)",clientName);
            System.out.println("Создали клиента с именем " + clientName);
        }

    }


    @Override
    public void update(String clientName,String newClientName) {
        jdbcTemplate.update("UPDATE CLIENTS SET NAME = ? WHERE NAME = ?",newClientName,clientName);
        System.out.println("Изменили имя клиенту " + clientName + " на имя"+ newClientName);
    }

    @Override
    public void delete(String clientName) {
        jdbcTemplate.update("DELETE FROM CLIENTS WHERE NAME = ?",clientName);
        System.out.println("Удалили клиента " + clientName);
    }

    @Override
    public Client getClientById(int id) {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM CLIENTS WHERE id_client=?", new Object[]{id}, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Client client = (Client) applicationContext.getBean("Client");
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                return client;
            }
        });
        if (clients.isEmpty()) {
           throw new IllegalArgumentException("Клиента с id = "+ id+ " нет в базе данных");
        }
        return clients.get(0);
    }

    @Override
    public Client getClientByName(String clientName) {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM CLIENTS WHERE NAME=?", new Object[]{clientName}, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Client client = (Client) applicationContext.getBean("Client");
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                return client;
            }
        });
        if (clients.isEmpty()) {
            throw new IllegalArgumentException("Клиента с таким именем "+ clientName+ " нет в базе данных");
        }
        return clients.get(0);
    }

    @Override
    public List<Client> getListClients() {
        List<Client> clients = jdbcTemplate.query("SELECT * FROM CLIENTS", new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet resultSet, int i) throws SQLException {
                Client client = (Client) applicationContext.getBean("Client");
                client.setId(resultSet.getInt(1));
                client.setName(resultSet.getString(2));
                return client;
            }
        });
        return clients;
    }
}
