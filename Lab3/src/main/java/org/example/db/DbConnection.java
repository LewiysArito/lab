package org.example.db;
import java.sql.Connection;//проводник для подлючения к бд
import java.sql.DriverManager;//такой есть способ подключения к бд через драйвер
import java.sql.SQLException;// ошибка скл

public class DbConnection {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/city";
    private static final String login = "postgres";
    private static final String password = "postgres";
    private static Connection connection = null; //для определения подключения
    public static Connection getConnection() {//подключение к бд
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(DB_URL, login, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }


    public static Connection getNewConnection() {//подключение к новой бд
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
