/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.Estoque;
import Model.Pedido;
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
 * @author Deive
 */
public class EstoqueDAO{
    private Connection con;
    Estoque estok = new Estoque();
    
    public EstoqueDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    /*
    //Método que insere um novo pedido;
    public boolean inserePedido(Pedido ped){
        String sql = "CALL montaPedidoPreparo(?, ?, ?);";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ped.getIdFuncionario());            
            stmt.setString(2, ped.getNomeSabor());
            stmt.setInt(3, ped.getQtdProducao());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }*/
    
    //Método que atualiza os dados de um usuário
    public boolean updateEstoque(Estoque estoq){
        String sql = "UPDATE Estoque SET  quantItem = ?  WHERE idItem = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setDouble(1, estoq.getQtdItem());

            stmt.setInt(4, estoq.getIdItem());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    //Método que deleta um usuário
    public boolean deletaItem(Estoque estoq){
        String sql = "DELETE FROM Estoque WHERE idItem = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, estoq.getIdItem());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    //Método que retorna uma lista de pedidos
    public List<Estoque> getList(){
        List<Estoque> estoq = new ArrayList<>();
        String sql = "SELECT * FROM Estoque ORDER BY nomeItem";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while(ResSet.next()){
                Estoque estoque = new Estoque();
                
                estoque.setIdItem(ResSet.getInt("idItem"));
                estoque.setIdItemEstoque(ResSet.getInt("idItemEstoque"));
                estoque.setNomeItem(ResSet.getString("nomeItem"));
                estoque.setQtdItem(ResSet.getDouble("quantItem"));
                
                estoq.add(estoque);         
            }
            stmt.close();
            ResSet.close();
            con.close();                
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }        
        return estoq;
    }
    
    
}
