package com.example.redSocial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnector {

    private static Connection conexion;

    private BDConnector() {
    }

    public static Connection getInstance() {

        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection("jdbc:postgresql://database-2.cmnw02d6ukoi.us-east-1.rds.amazonaws.com/postgres","postgres","monzon2025");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}
