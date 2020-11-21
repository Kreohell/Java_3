package ru.geekbrains.lessons.lesson_b;

import java.sql.*;

public class DBHomeWork{

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;
    private static String TABLE_NAME = "Workers";

    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:MainDB.db");
        stmt = connection.createStatement();
    }

    private static void disconnect() throws SQLException {
        connection.close();
    }

    private static void create() throws SQLException {
       String sqlTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "\n" +
               "(\n" +
               "  ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
               "  Name TEXT NOT NULL,\n" +
               "  Payment INTEGER NOT NULL\n" +
               ")";
       stmt.executeUpdate(sqlTable);
    }

    private static void add() throws SQLException {
        for (int i = 0; i < 5; i++) {
            String sqlAdd = "INSERT INTO " + TABLE_NAME + "(Name, Payment) VALUES (\"Bob\", 80000)";
            stmt.executeUpdate(sqlAdd);
        }
    }

    private static void read() throws SQLException {
        String sqlRead = "SELECT * FROM " + TABLE_NAME;
        rs = stmt.executeQuery(sqlRead);
        while (rs.next()){
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int payment = rs.getInt(3);
            System.out.printf("%d. %s - %d \n", id, name, payment);
        }
    }

    private static void delete() throws SQLException {
        String sqlDelete = "DELETE FROM " + TABLE_NAME + " WHERE ID = 2";
        stmt.executeUpdate(sqlDelete);
    }

    private static void deleteTable() throws SQLException {
        String sqlDelete = "DROP TABLE " + TABLE_NAME;
        stmt.executeUpdate(sqlDelete);
    }

    public static void main(String[] args) {
        try {
            connect();
            create();
            add();
            delete();
            read();
            deleteTable();
            disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}