package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_URL = "jdbc:mysql://localhost:3306/javapp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "11082000";


    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, DB_URL);
        properties.put(Environment.USER, DB_USERNAME);
        properties.put(Environment.PASS, DB_PASSWORD);
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(User.class);


        SessionFactory sessionFactory = configuration.addAnnotatedClass(User.class).addProperties(configuration.getProperties()).buildSessionFactory();

        return sessionFactory;
    }



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
