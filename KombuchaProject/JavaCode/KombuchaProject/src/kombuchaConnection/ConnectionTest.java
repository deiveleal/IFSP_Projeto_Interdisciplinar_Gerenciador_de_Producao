package kombuchaConnection;


import java.sql.SQLException;
import java.sql.Connection;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class ConnectionTest {
    public static void main(String[] args) throws SQLException{
        try (Connection con = new ConnectionFactory().getConnection()) {
            System.out.println("Conexão aberta!");
        }
            
    }
        
}
