package ru.sbertech.test.lesson21.classwork;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {


            //System.out.println("TYPE_FORWARD_ONLY= " +
                 //   conn.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));

            //System.out.println("YPE_SCROLL_INSENSITIVE= " +
                   // conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));

            //System.out.println("TYPE_SCROLL_SENSITIVE= " +
                    //conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            Statement statement = conn.createStatement();
            conn.setAutoCommit(false);

            PreparedStatement preparedStatement = conn.prepareStatement("select from songs(NAME) values(?)");
            Savepoint savepoint = conn.setSavepoint("MY_FIRST_SAVE_POINT");
            //insert into songs(NAME) values(?)

            preparedStatement.setString(1, "MySong");
            preparedStatement.execute();

            //Logger logger = new Logger();
            //logger.setStr("MySong");
           /* Thread t = new Thread(logger);
            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */

            //preparedStatement.setString(1, "MySong2");
            //preparedStatement.execute();

            conn.rollback();
            //statement.execute("select * from songs");
            //ResultSet resultSet = statement.executeQuery("select * from songs where id=25");

            //while (resultSet.next()) {
                //System.out.println("Song Name: " + resultSet.getString("NAME") + " Time: " + resultSet.getBigDecimal("SONG_TIME").toString());
            //}

            //PreparedStatement preparedStatement = conn.prepareStatement("select from songs where id=?");
            //insert into songs(NAME) values(?)
            //preparedStatement.setString(1, "25");
            //resultSet = preparedStatement.executeQuery();

           // while (resultSet.next()) {
                //System.out.println("Song name: " + resultSet.getString("NAME") + " Time: " + resultSet.getBigDecimal("SONG_TIME").toString());
           // }
        }
        System.out.println("OK");
    }

}
