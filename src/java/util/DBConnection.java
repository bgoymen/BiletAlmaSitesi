/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bünyamin
 */
public abstract class DBConnection {

    private Connection connection;

    public Connection connect() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biletal", "root", "123");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return this.connection;
    }
}
