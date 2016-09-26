package ru.sbertech.test.lesson21.classwork;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Logger implements Runnable {


    public void setStr(String str) {
        this.str = str;
    }

    String str;


    @Override
    public void run() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            PreparedStatement preparedStatement = conn.prepareStatement("select from log(STR) values(?)");
            preparedStatement.setString(1, str);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
