/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kombuchaDAO;

import kombuchaConnection.ConnectionFactory;
import kombuchaModels.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class FuncionarioDAO {
    private Connection connection;
    int idFuncionario;
    String nomeFuncionario;
    String cargo;
    
    public FuncionarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void insereNoBanco(Funcionario funcionario){ 
        String sql = "INSERT INTO funcionario(idFuncionario,nomeFuncionario,cargo) VALUES(?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, funcionario.getIdFuncionario());            
            stmt.setString(2, funcionario.getNomeFuncionario());
            stmt.setString(3, funcionario.getCargo());
            
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException ex) { 
            throw new RuntimeException(ex);
        }    
    }
}