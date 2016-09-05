package ru.sbertech.test.lesson17;


public class Document {
    public Client getClientA() {
        return clientA;
    }

    public void setClientA(Client clientA) {
        this.clientA = clientA;
    }

    public Client getClientB() {
        return clientB;
    }

    public void setClientB(Client clientB) {
        this.clientB = clientB;
    }

    public Account getAccA() {
        return accA;
    }

    public void setAccA(Account accA) {
        this.accA = accA;
    }

    public Account getAccB() {
        return accB;
    }

    public void setAccB(Account accB) {
        this.accB = accB;
    }

    public Long getSumma() {
        return summa;
    }

    public void setSumma(Long summa) {
        this.summa = summa;
    }

    private Client clientA;
    private Client clientB;
    private Account accA;
    private Account accB;

    private Long summa;

    private String user;

    public ExecBehavior getExecBehavior() {
        return execBehavior;
    }

    public void setExecBehavior(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    private ExecBehavior execBehavior;

    public Document(ExecBehavior execBehavior) {
        this.execBehavior = execBehavior;
    }

    public void print() {
        System.out.println("summa: "+summa);
    }

    public void printUserInfo() {
        System.out.println("Document User: "+user);
    }

    public void savetoDB() {
        System.out.println("Save document database");
    }
}
