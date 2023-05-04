package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/japanese", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
