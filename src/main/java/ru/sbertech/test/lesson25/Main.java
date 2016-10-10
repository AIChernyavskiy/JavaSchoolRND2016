package ru.sbertech.test.lesson25;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.test.lesson25.DAO.AccountDAOImpl;
import ru.sbertech.test.lesson25.DAO.ClientDaoImpl;
import ru.sbertech.test.lesson25.DAO.DocumentDaoImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("contextHibarnate.xml");

    static void printMenu() {
        System.out.println("1-Создать клиента");
        System.out.println("2-Создать счет для клиента");
        System.out.println("3-Создать документ");
        System.out.println("exit-для выхода");
    }

    public static void main(String[] args) {


        Client client = (Client) applicationContext.getBean("Client");
        Account account = (Account) applicationContext.getBean("Account");
        Account accountCT = (Account) applicationContext.getBean("Account");
        Account accountDT = (Account) applicationContext.getBean("Account");
        Document document = (Document) applicationContext.getBean("Document");
        ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
        AccountDAOImpl accountDAO = (AccountDAOImpl) applicationContext.getBean("AccountDAOImpl");
        DocumentDaoImpl documentDao = (DocumentDaoImpl) applicationContext.getBean("DocumentDaoImpl");

        Scanner in = new Scanner(System.in);
        String string;
        printMenu();
        while (!(string = in.nextLine()).equals("exit")) {
            switch (string) {
                case "1":
                    System.out.println("Введите имя клиента");
                    String clientName = in.nextLine();
                    client.setName(clientName);
                    if (clientDao.getClientByName(clientName) != null) {
                        System.out.println("Клиент с именем " + clientName + " уже существует, измените имя и попробуйте ещё раз!");
                    } else {
                        clientDao.saveClient(client);
                    }
                    break;
                case "2":
                    System.out.println("Введите номер счета ");
                    String accNum = in.nextLine();
                    System.out.println("Введите сальдо");
                    BigDecimal saldo = in.nextBigDecimal();
                    System.out.println("Введите имя клиента");
                    String accNum1 = in.nextLine();
                    String nameClient = in.nextLine();
                    account.setAccNum(accNum);
                    account.setSaldo(saldo);
                    client = clientDao.getClientByName(nameClient);
                    if (client == null) {
                        System.out.println("Клиента с именем " + nameClient + " не существует, создайте сначала клиента");
                    } else {
                        account.setClient_id(client.getId());
                        accountDAO.saveAccount(account);
                    }
                    break;
                case "3":
                    System.out.println("Введите счет с которого будем снимать средства");
                    String accNumCT = in.nextLine();
                    System.out.println("Введите счет на который будем зачислять средства");
                    String accNumDT = in.nextLine();
                    System.out.println("Введите сумму платежа");
                    BigDecimal summa = in.nextBigDecimal();
                    System.out.println("Введите назначение платежа");
                    in.nextLine();
                    String purpose = in.nextLine();
                    accountCT = accountDAO.getAccountByName(accNumCT);
                    accountDT = accountDAO.getAccountByName(accNumDT);
                    if (accountCT == null) {
                        System.out.println("Счета с номером " + accNumCT + " нет в базе, созлайте счет и попробуйте заново.");
                    } else if (accountDT == null) {
                        System.out.println("Счета с номером " + accNumDT + " нет в базе, созлайте счет и попробуйте заново.");
                    } else if (accountCT.checkSaldo(summa)) {
                        document.setId_AccountCT(accountCT.getId());
                        document.setId_AccountDT(accountDT.getId());
                        document.setSumma(summa);
                        document.setDocDate(new Date());
                        document.setPurpose(purpose);
                        accountCT.saldoAfterTransactionCT(summa);
                        accountDT.saldoAfterTransactionDT(summa);
                        accountDAO.updateAccount(accountCT);
                        accountDAO.updateAccount(accountDT);
                        documentDao.saveDocument(document);
                    }
                    break;
                default:
                    System.out.println("Введите 1, 2 или 3 для продолжения или exit для завершения");
            }
            printMenu();
        }
    }
}
