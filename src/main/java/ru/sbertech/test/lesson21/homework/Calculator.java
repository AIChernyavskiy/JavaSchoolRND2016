package ru.sbertech.test.lesson21.homework;


import java.sql.*;
import java.util.Map;

class Calculator implements InterfaceFibonachi {
    Map<Integer, Integer> map;
    Connection connection;
    PreparedStatement statement;

    public Calculator(Map<Integer, Integer> map, Connection connection) {
        this.map = map;
        this.connection = connection;
        try {
            statement = connection.prepareStatement("INSERT INTO FIBONACHI VALUES(?,?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void fibonachi(int n) {
        try {
            if (map.containsKey(n)) {
                System.out.println("Это значение мы уже вычисляли и возьмём его из кэша: " + map.get(n));
                if (statement.executeBatch().length>0) {
                    System.out.println("Произвели запись в БД");
                }
            } else {
                int resultFib = calculate(n);
                statement.setInt(1,n);
                statement.setInt(2,resultFib);
                statement.addBatch();
                map.put(n, resultFib);
                System.out.println("Добавили новое значение для числа Фибоначчи: " + n);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int calculate(int n) {
        if ((n <= 1) || (n == 2)) {
            return 1;
        } else {
            return (calculate(n - 1) + calculate(n - 2));
        }
    }

}
