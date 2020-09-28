/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.Insumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deive
 */
public class InsumoDAO extends Insumo{
    private Connection con;
    
    public InsumoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean insereInsumo(Insumo insum) {
        String sql = "INSERT INTO Insumo(idInsumo,idItemEstoque,nomeInsumo,descInsumo) VALUES(?,?,?,?);";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            
                stmt.setInt(1, insum.getIdInsumo());            
                stmt.setInt(2, insum.getIdItemEstoque());
                stmt.setString(3, insum.getNomeInsumo());
                stmt.setString(4, insum.getDescrInsumo());

                stmt.execute();
                stmt.close();
                con.close();
                return true;    
        } catch (SQLException ex) {
            Logger.getLogger(InsumoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
