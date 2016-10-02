package ru.sbertech.test.lesson22;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sbertech.test.lesson22.DAO.AccountDAOImpl;
import ru.sbertech.test.lesson22.DAO.ClientDaoImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

    static void printMenu() {
        System.out.println("1-Создать клиента");
        System.out.println("2-Создать счет для клиента");
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
                default:
                    System.out.println("Введите 1 или 2 для продолжения или exit для завершения");
            }
            printMenu();
        }
    }
}
