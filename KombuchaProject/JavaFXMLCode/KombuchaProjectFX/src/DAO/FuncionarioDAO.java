/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.Funcionario;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carolina
 * @author deive
 *
 */
public class FuncionarioDAO extends Funcionario {

    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Método que insere um novo usuário;
    public boolean insert(Funcionario func) {
        String sql = "INSERT INTO Funcionario(idFuncionario,nomeFuncionario,cargo,senha) VALUES(?,?,?,?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, func.getIdFuncionario());
            stmt.setString(2, func.getNomeFuncionario());
            stmt.setString(3, func.getCargo());
            stmt.setString(4, func.getSenha());

            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que atualiza os dados de um usuário
    public boolean update(Funcionario func) {
        String sql = "UPDATE Funcionario SET nomeFuncionario = ?, cargo = ?, senha = ? WHERE idFuncionario = ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, func.getNomeFuncionario());
            stmt.setString(2, func.getCargo());
            stmt.setString(3, func.getSenha());

            stmt.setString(4, func.getIdFuncionario());

            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que deleta um usuário
    public boolean delete(Funcionario func) {
        String sql = "DELETE FROM Funcionario WHERE idFuncionario = ?;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, func.getIdFuncionario());

            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }
        catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //Método que retorna uma lista de usuários do banco
    public List<Funcionario> getList() {
        List<Funcionario> func = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario ORDER BY nomeFuncionario";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while (ResSet.next()) {
                Funcionario funcionario = new Funcionario();

                funcionario.setIdFuncionario(ResSet.getString("idFuncionario"));
                funcionario.setNomeFuncionario(ResSet.getString("nomeFuncionario"));
                funcionario.setCargo(ResSet.getString("cargo"));

                func.add(funcionario);
            }
            stmt.close();
            ResSet.close();
            con.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }
        return func;
    }

}
