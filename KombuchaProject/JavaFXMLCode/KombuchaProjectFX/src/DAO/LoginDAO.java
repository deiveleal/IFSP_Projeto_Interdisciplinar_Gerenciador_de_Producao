/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Carolina
 * @author Deive
 */
public class LoginDAO extends Funcionario {

    private Connection con;

    public LoginDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método que busca o usuário e a senha
    public Boolean login(String idFuncionario, String senha) throws SQLException {
        boolean encontrado = false;
        String sql = "SELECT * FROM Funcionario WHERE idFuncionario = ? AND senha = ?;";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, idFuncionario);
        stm.setString(2, senha);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            encontrado = true;
            con.close();
            rs.close();
        }
        return encontrado;
    }
}
