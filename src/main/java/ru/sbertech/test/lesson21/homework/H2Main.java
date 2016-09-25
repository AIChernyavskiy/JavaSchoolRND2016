package ru.sbertech.test.lesson21.homework;

import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class H2Main {
    public static void main(String[] args){
        Map<Integer, Integer> map = new HashMap<>();
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fibonachi");

            while (resultSet.next()) {
                map.put(resultSet.getInt(1), resultSet.getInt(2));
                System.out.println("ID: " + resultSet.getInt(1) + " RESULT: " + resultSet.getInt(2));
            }
            Calculator calculator = new Calculator(map,conn);
            InterfaceFibonachi calculatorproxy = (InterfaceFibonachi) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
                    Calculator.class.getInterfaces(),
                    new FibonachiInvocationHandler(calculator));
            for (int i = 0; i < 10; i++) {
                calculatorproxy.fibonachi((int) (Math.random() * 6));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
