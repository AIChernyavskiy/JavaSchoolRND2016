package ru.sbertech.test.lesson21.homework;

import java.sql.*;
import java.util.Map;

class Calculator {
    @Cachable(persistent = true)
    public void fibonachi(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            System.out.println("Это значение мы уже вычисляли и возьмём его из кэша: " + map.get(n));
        } else {
            int resultFib = calculate(n);
            try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
                Statement statement = conn.createStatement();
                statement.execute("INSERT INTO FIBONACHI VALUES(" + n + "," + resultFib + ")");
                conn.close();
                map.put(n, resultFib);
                System.out.println("Добавили новое значение для числа Фибоначчи: " + n);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private int calculate(int n) {
        if ((n == 1) || (n == 2)) {
            return 1;
        } else {
            return (calculate(n - 1) + calculate(n - 2));
        }
    }

}
