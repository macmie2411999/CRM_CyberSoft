package com.macmie.crm_cybersoft.Connection;

import com.macmie.crm_cybersoft.Constants.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionConfiguration {

    // Set attributes to connect to MySQL
    public static Connection getConnection() {
        try {
            Class.forName(Constants.DRIVER_MYSQL_JDBC);
            return DriverManager.getConnection(Constants.URL_MYSQL_JDBC,
                    Constants.USERNAME_MYSQL_JDBC,
                    Constants.PASSWORD_MYSQL_JDBC);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Can Not Connect To MySQL JDBC!");
        }
        return null;
    }
}
