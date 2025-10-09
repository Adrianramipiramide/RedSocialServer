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
                conexion = DriverManager.getConnection("jdbc:mysql://servidorseptiembre.cvkm0wqi41sp.us-east-1.rds.amazonaws.com","admin","monzon2025$");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conexion;
    }
}
