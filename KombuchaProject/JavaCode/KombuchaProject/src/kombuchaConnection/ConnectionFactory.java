/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kombuchaConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Carolina
 * @author Deive
 * 
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/tribos_kombucha", 
                    "root", 
                    "123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}