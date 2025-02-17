package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionController {

    private Connection connection;

    public ConnectionController(){
        try {
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/javapexcercice", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection(){
        return this.connection;
    }

}
