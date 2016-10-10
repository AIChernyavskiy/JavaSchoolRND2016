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

    public boolean checkSaldo(BigDecimal summa) {
        int equals = saldo.compareTo(summa);
        if (equals >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public BigDecimal getSaldoAfterTransactionCT(BigDecimal summa) {
        saldo = saldo.subtract(summa);
        return saldo;
    }

    public BigDecimal getSaldoAfterTransactionDT(BigDecimal summa) {
        saldo = saldo.add(summa);
        return saldo;
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
