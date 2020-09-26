/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.BatmanDeFerro;
import Model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author carolina
 * @author deive
 */
public class PedidoDAO extends Pedido{
    private Connection con;
    private Date dataPedido;
    
    BatmanDeFerro BatFer = new BatmanDeFerro();
    Pedido pedido = new Pedido();
    
    public PedidoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    

    public Date getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
      
    //Método que insere um novo pedido;
    public boolean inserePedido(Pedido ped){
        ped.setIdFuncionario(BatFer.getIdFuncionarioAtivo());
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
    }
    
    //Método que atualiza os dados de um usuário
    public boolean updatePedido(Pedido ped){
        ped.setIdFuncionario(BatFer.getIdFuncionarioAtivo());
        String sql = "UPDATE Pedido SET  idFuncionario = ?, idSabor = ?, qtdProducao = ?  WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, ped.getIdFuncionario());
            stmt.setString(2, ped.getNomeSabor());
            stmt.setInt(3, ped.getQtdProducao());

            stmt.setInt(4, ped.getIdPedido());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }    
    }
    
    //Método que deleta um usuário
    public boolean deletaPedido(Pedido ped){
        String sql = "DELETE FROM Pedido WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, ped.getIdPedido());
            
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        } 
        catch (SQLException ex) { 
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    //Método que retorna uma lista de pedidos
    public List<Pedido> getList(){
        List<Pedido> ped = new ArrayList<>();
        String sql = "SELECT * FROM Pedido ORDER BY dataEntradaPedido";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while(ResSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(ResSet.getInt("idPedido"));
                pedido.setNomeSabor(ResSet.getString("nomeSabor"));
                pedido.setQtdProducao(ResSet.getInt("quantidadeProducao"));
                pedido.setDataPedido(ResSet.getDate("dataEntradaPedido"));
                
                ped.add(pedido);         
            }
            stmt.close();
            ResSet.close();
            con.close();                
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }        
        return ped;
    }
    
}