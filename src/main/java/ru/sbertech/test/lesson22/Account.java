package ru.sbertech.test.lesson22;


import java.math.BigDecimal;

public class Account {
    long id;
    BigDecimal saldo;
    String accNum;
    Client client;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", accNum='" + accNum + '\'' +
                ", client=" + client +
                '}';
    }
}
