package ru.sbertech.test.lesson22;


import java.math.BigDecimal;
import java.util.Date;

public class Document {
    long id;
    Account accDT;
    Account accCT;
    BigDecimal summa;
    String purpose;
    Date docDate;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", accDT=" + accDT +
                ", accCT=" + accCT +
                ", summa=" + summa +
                ", purpose='" + purpose + '\'' +
                ", docDate=" + docDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccDT() {
        return accDT;
    }

    public void setAccDT(Account accDT) {
        this.accDT = accDT;
    }

    public Account getAccCT() {
        return accCT;
    }

    public void setAccCT(Account accCT) {
        this.accCT = accCT;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
}
