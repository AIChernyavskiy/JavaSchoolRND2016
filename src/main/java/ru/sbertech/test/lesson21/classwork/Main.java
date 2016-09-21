package ru.sbertech.test.lesson21.classwork;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","")) {
            Statement statement = conn.createStatement();
            //statement.execute("select * from songs");
            ResultSet resultSet = statement.executeQuery("select * from songs where id=25");

            while (resultSet.next()) {
                System.out.println("Song Name: " + resultSet.getString("NAME")+" Time: "+resultSet.getBigDecimal("SONG_TIME").toString());
            }

            PreparedStatement preparedStatement = conn.prepareStatement("select from songs where id=?");
            //insert into songs(NAME) values(?)
            preparedStatement.setString(1,"25");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Song name: " + resultSet.getString("NAME")+" Time: "+resultSet.getBigDecimal("SONG_TIME").toString());
            }
        }
        System.out.println("OK");
    }
}
