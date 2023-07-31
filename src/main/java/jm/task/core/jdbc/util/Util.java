package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javapp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "11082000";
    public static Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection ok");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Connection ERROR");
        }
        return connection;
    }


}
