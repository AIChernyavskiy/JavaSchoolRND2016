package ru.sbertech.test.lesson25;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "DOCUMENTS")
public class Document implements Serializable{

    @Id
    @Column(name="ID_DOCUMENT")
    @GeneratedValue
    long id;

    @Column(name = "ACCDT")
    long id_AccountDT;

    @Column(name = "ACCCT")
    long id_AccountCT;

    @Column(name = "SUMMA")
    BigDecimal summa;

    @Column(name = "PURPOSE")
    String purpose;

    @Column(name = "DOCDATE")
    @Temporal(TemporalType.DATE)
    Date docDate;

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", accDT=" + id_AccountDT +
                ", accCT=" + id_AccountCT +
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

    public long getId_AccountDT() {
        return id_AccountDT;
    }

    public void setId_AccountDT(long id_AccountDT) {
        this.id_AccountDT = id_AccountDT;
    }

    public long getId_AccountCT() {
        return id_AccountCT;
    }

    public void setId_AccountCT(long id_AccountCT) {
        this.id_AccountCT = id_AccountCT;
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
