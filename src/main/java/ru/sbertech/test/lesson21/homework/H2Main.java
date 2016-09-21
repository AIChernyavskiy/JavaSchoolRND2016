package ru.sbertech.test.lesson21.homework;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class H2Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fibonachi");

            while (resultSet.next()) {
                map.put(resultSet.getInt(1), resultSet.getInt(2));
                System.out.println("ID: " + resultSet.getInt(1) + " RESULT: " + resultSet.getInt(2));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Calculator calculator = new Calculator();
        calculator.fibonachi(6, map);
    }
}
