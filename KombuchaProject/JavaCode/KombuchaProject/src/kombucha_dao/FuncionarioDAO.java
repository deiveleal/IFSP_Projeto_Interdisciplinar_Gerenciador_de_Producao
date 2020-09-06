/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kombucha_dao;

import kombucha_connection.ConnectionFactory;
import kombucha_project.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author deive
 * 
 */
public class FuncionarioDAO {
    private Connection con;
    int idFuncionario;
    String nomeFuncionario;
    String cargo;
    
    public FuncionarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    public void insere_No_Banco(Funcionario funcionario){ 
        String sql = "INSERT INTO funcionario(nomeFuncionario,cargo) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getCargo());
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        }    
    }
}