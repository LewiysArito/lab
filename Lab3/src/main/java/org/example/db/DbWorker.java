package org.example.db;
import org.example.util.CsvReader;

import java.sql.Connection;// соедиенение с бд
import java.sql.PreparedStatement;
import java.sql.ResultSet;//манипулирование запросами
import java.sql.SQLException;
import java.sql.Statement;//манипулировать значениями бд
import java.util.List;

public class DbWorker {
    public static void populateFromFile(String fileName){
        List<String []> strings = CsvReader.readCsvFile(fileName, ";");//считываем csv файл
        Connection conn = DbConnection.getConnection();//подключаемся к базе данных
        try {
            Statement cleaner = conn.createStatement();//очищаем бд
            System.out.println(cleaner.executeUpdate("DELETE FROM city"));//очистка
            System.out.println(cleaner.executeUpdate("DELETE FROM village"));//очистка
            PreparedStatement citySt = conn.prepareStatement(
                    "INSERT INTO city (locality_name, country,  founding_date, population, natural_increase, is_administrative_center) " +
                            " VALUES (?, ?, ?, ?, ?, ?)");
            PreparedStatement villageSt = conn.prepareStatement(
                    "INSERT INTO village (locality_name, country,  founding_date, population,  involved_ruralization, locality_area) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");
            for (String[] line: strings) {//поддставляем значения, прочитанные из csv файла в соответсвующие таблицы
                if (line[0].equals("0")) {
                    citySt.setString(1, line[1]);
                    citySt.setString(2, line[2]);
                    citySt.setString(3, line[3]);
                    citySt.setInt(4, Integer.parseInt(line[4]));
                    citySt.setInt(5, Integer.parseInt(line[5]));
                    citySt.setString(6, line[6]);
                    citySt.addBatch();
                } else {
                    villageSt.setString(1, line[1]);
                    villageSt.setString(2, line[2]);
                    villageSt.setString(3, line[3]);
                    villageSt.setInt(4, Integer.parseInt(line[4]));
                    villageSt.setString(5, line[5]);
                    villageSt.setString(6, line[6]);
                    villageSt.addBatch();
                }
            }
            int[] ctyRes = citySt.executeBatch();
            int[] vlgRes = villageSt.executeBatch();
            for (int num: ctyRes) {
                System.out.println(num);
            }

            for (int num: vlgRes) {
                System.out.println(num);
            }
            cleaner.close();
            citySt.close();
            villageSt.close();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    public static void demoQuery() {
        Connection conn = DbConnection.getConnection(); // подключение к бд
        try {
            Statement st = conn.createStatement();//запрашиваем
            ResultSet rs = st.executeQuery("SELECT * FROM city WHERE population > 3000000"); // запрос к бд
            while (rs.next()) {
                System.out.print(rs.getString("locality_name"));
                System.out.print(" ");
                System.out.println(rs.getString("country"));
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  static void dirtyReadDemo(){
        Runnable first = () -> {
            Connection conn1 = DbConnection.getNewConnection();
            if (conn1 != null){
                try{
                    conn1.setAutoCommit(false);
                    conn1.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                    Statement upd = conn1.createStatement();
                    upd.executeUpdate("UPDATE village SET involved_ruralization = 'Нет' WHERE involved_ruralization ='Да'");
                    Thread.sleep(2000);
                    conn1.rollback();//откат изменения транзакции
                    upd.close();
                    Statement st = conn1.createStatement();
                    System.out.println("In the first thread:");
                    ResultSet rs = st.executeQuery("SELECT * FROM village");
                    while (rs.next()) {
                        System.out.print(rs.getString("locality_name"));
                        System.out.print(" ");
                        System.out.println(rs.getString("involved_ruralization"));
                    }
                    st.close();
                    rs.close();
                    conn1.close();
                }catch (SQLException | InterruptedException throwables){
                    throwables.printStackTrace();}
            }
        };
        Runnable second = () -> {
            Connection conn2 = DbConnection.getNewConnection();
            if (conn2 != null) {
                try {
                    Thread.sleep(500);
                    conn2.setAutoCommit(false);
                    conn2.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);//установка изоляции транзакции
                    Statement st = conn2.createStatement();
                    System.out.println("In the second thread:");
                    ResultSet rs = st.executeQuery("SELECT * FROM village");
                    while (rs.next()) {
                        System.out.print(rs.getString("locality_name"));
                        System.out.print(" ");
                        System.out.println(rs.getString("involved_ruralization"));
                    }
                    rs.close();
                    st.close();
                    conn2.close();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
        };
        Thread th1 = new Thread(first);
        Thread th2 = new Thread(second);
        th1.start();
        th2.start();
    }
}
