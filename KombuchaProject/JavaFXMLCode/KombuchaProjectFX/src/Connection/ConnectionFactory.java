/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

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
        String nomeBanco = "tribos_kombucha";//Nome do banco de dados
        String nomeUsuario = "root";//Usuário do servidor
        String senhaUsuario = "123456";//Senha do servidor
        String enderecoServidor = "localhost";
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://"+enderecoServidor+"/"+nomeBanco, 
                    nomeUsuario, 
                    senhaUsuario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}