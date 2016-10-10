package ru.sbertech.test.lesson25;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENTS")
public class Client implements Serializable {

    public Client() {
    }

    @Id
    @Column(name="ID_CLIENT")
    @GeneratedValue

    long id;

    @Column(name="NAME")
    String name;

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
