/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author deive
 */
public class ConnectionFactoryTeste {
    public static void main(String[] args) throws SQLException{
        try (Connection con = new ConnectionFactory().getConnection()) {
            System.out.println("Conexão aberta!");
        }
    }
    
}