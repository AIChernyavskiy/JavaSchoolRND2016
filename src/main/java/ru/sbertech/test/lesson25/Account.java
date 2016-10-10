package ru.sbertech.test.lesson25;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "ACCOUNTS")
public class Account implements Serializable {

    @Id
    @Column(name="ID_ACCOUNT")
    @GeneratedValue
    long id;

    @Column(name="SALDO")
    BigDecimal saldo;

    @Column(name="ACCNUM")
    String accNum;

    @Column(name="CLIENT_ID")
    long client_id;


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

    public long getClient_id() {
        return client_id;
    }

    public void setClient_id(long client_id) {
        this.client_id = client_id;
    }

    public boolean checkSaldo(BigDecimal summa) {
        int equals = saldo.compareTo(summa);
        if (equals >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void saldoAfterTransactionCT(BigDecimal summa) {
        saldo = saldo.subtract(summa);
    }

    public void saldoAfterTransactionDT(BigDecimal summa) {
        saldo = saldo.add(summa);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", accNum='" + accNum + '\'' +
                ", client_id=" + client_id +
                '}';
    }
}
