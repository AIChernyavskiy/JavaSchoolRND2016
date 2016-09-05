package ru.sbertech.test.lesson17;


public class Main {
    public static void main(String[] args) {
        Document d = new Document(new InfoDocExecBehavior());

        DocumentExecutor documentExecutor = new DocumentExecutor();

        Account accA = new Account();
        accA.setSaldo(100L);

        Account accB = new Account();
        accB.setSaldo(100L);

        d.setAccA(accA);
        d.setAccB(accB);

        d.setSumma(10L);

        documentExecutor.exec(d);
    }
}
