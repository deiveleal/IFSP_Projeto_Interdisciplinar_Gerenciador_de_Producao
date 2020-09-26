/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.BatmanDeFerro;
import Model.SaborKombucha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author deive
 */
public class SaborKombuchaDAO extends SaborKombucha{
    BatmanDeFerro BatFer = new BatmanDeFerro();
    SaborKombucha saborKombucha = new SaborKombucha();

    private Connection con;
   
    public SaborKombuchaDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    

    //Método que insere um novo sabor;
    public boolean insertSaborKombucha(SaborKombucha saborKombucha){
        String sql = "INSERT INTO SaborKombucha(idKombucha, nomeKombucha, chaBase,"
                + "idChaBase,prePreparoQuantCha, prePreparoQuantAgua,"
                + "quantidadeAcucar, idEmbalagem) VALUES(?,?,?,?,?,?,?,?)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setInt(1, saborKombucha.getIdKombucha());
            stmt.setString(2, saborKombucha.getNomeKombucha());
            stmt.setString(3, saborKombucha.getChaBase());
            stmt.setInt(4, saborKombucha.getIdChaBase());
            stmt.setDouble(5, saborKombucha.getPrePreparoQuantCha());
            stmt.setDouble(6, saborKombucha.getPrePreparoQuantAgua());
            stmt.setDouble(7, saborKombucha.getQuantidadeAcucar());
            stmt.setInt(8, saborKombucha.getIdEmbalagem());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(SaborKombuchaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    //Método que atualiza os dados de um sabor
    public boolean updateSaborKombucha(SaborKombucha saborKombucha){
        
        String sql = "UPDATE SaborKombucha SET  nomeKombucha = ?, chaBase = ?,"
                + "idChaBase = ?, prePreparoQuantCha = ?, prePreparoQuantAgua = ?,"
                + "quantidadeAcucar = ?, idEmbalagem = ? WHERE idKombucha = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, saborKombucha.getNomeKombucha());
            stmt.setString(2, saborKombucha.getChaBase());
            stmt.setInt(3, saborKombucha.getIdChaBase());
            stmt.setDouble(4, saborKombucha.getPrePreparoQuantCha());
            stmt.setDouble(5, saborKombucha.getPrePreparoQuantAgua());
            stmt.setDouble(6, saborKombucha.getQuantidadeAcucar());
            stmt.setInt(7, saborKombucha.getIdEmbalagem());
            stmt.setInt(8, saborKombucha.getIdKombucha());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(SaborKombuchaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    //Método que deleta um sabor
    public boolean deletaSabor(SaborKombucha saborKombucha){
        String sql = "DELETE FROM SaborKombucha WHERE idKombucha = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, saborKombucha.getIdKombucha());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(SaborKombuchaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    public List<SaborKombucha> saboresList(){
        List<SaborKombucha> saborKomb = new ArrayList<>();
        String sqlSabores = "SELECT idKombucha, nomeKombucha from SaborKombucha;";
        try{
                        PreparedStatement stmt = con.prepareStatement(sqlSabores);
            ResultSet ResSet = stmt.executeQuery();
            while(ResSet.next()){
                SaborKombucha saborKombucha = new SaborKombucha();                
                saborKombucha.setIdKombucha(ResSet.getInt("idKombucha"));
                saborKombucha.setNomeKombucha(ResSet.getString("nomeKombucha"));                
                saborKomb.add(saborKombucha);         
            }
            stmt.close();
            ResSet.close();
            con.close();      
        } catch (SQLException ex) {
            System.out.println("Erro! Lista não retornada");
            return null;
        } 
        return saborKomb;
                
    }
    
    
    
    
}
