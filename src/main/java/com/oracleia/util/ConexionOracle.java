package com.oracleia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionOracle {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "system";
    private static final String PASSWORD = "Tapiero123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
