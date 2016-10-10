package ru.sbertech.test.lesson22;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.test.lesson22.DAO.AccountDAOImpl;
import ru.sbertech.test.lesson22.DAO.ClientDaoImpl;
import ru.sbertech.test.lesson22.DAO.DocumentDaoImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

    static void printMenu() {
        System.out.println("1-Создать клиента");
        System.out.println("2-Создать счет для клиента");
        System.out.println("3-Создать документ");
        System.out.println("exit-для выхода");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String string;
        printMenu();
        while (!(string = in.nextLine()).equals("exit")) {
            switch (string) {
                case "1":
                    ClientDaoImpl clientDao = (ClientDaoImpl) applicationContext.getBean("ClientDaoImpl");
                    System.out.println("Введите имя клиента");
                    String clientName = in.nextLine();
                    clientDao.insert(clientName);
                    break;
                case "2":
                    System.out.println("Введите номер счета ");
                    String accNum = in.nextLine();
                    System.out.println("Введите сальдо");
                    BigDecimal saldo = in.nextBigDecimal();
                    System.out.println("Введите имя клиента");
                    String accNum1 = in.nextLine();
                    String nameClient = in.nextLine();
                    AccountDAOImpl accountDAO = (AccountDAOImpl) applicationContext.getBean("AccountDAOImpl");
                    accountDAO.insert(saldo, accNum, nameClient);
                    break;
                case "3":
                    System.out.println("Введите счет с которого будем снимать средства");
                    String accNumCT = in.nextLine();
                    System.out.println("Введите счет на который будем зачислять средства");
                    String accNumDT = in.nextLine();
                    System.out.println("Введите сумму платежа");
                    BigDecimal summa = in.nextBigDecimal();
                    System.out.println("Введите назначение платежа");
                    String purpose = in.nextLine();
                    DocumentDaoImpl documentDao = (DocumentDaoImpl) applicationContext.getBean("DocumentDaoImpl");
                    documentDao.insert(accNumDT,accNumCT,summa,purpose);
                    break;
                default:
                    System.out.println("Введите 1, 2 или 3 для продолжения или exit для завершения");
            }
            printMenu();
        }
    }
}
