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
 *
 * @author deive
 */
public class PedidoDAO extends Pedido{

    private Date dataPedido;

    @Override
    public Date getDataPedido() {
        return dataPedido;
    }

    @Override
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    BatmanDeFerro BatFer = new BatmanDeFerro();
    Pedido pedido = new Pedido();

    private Connection con;
   
    public PedidoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Método que insere um novo pedido;
    public boolean insertPedido(Pedido pedido){
        pedido.setIdFuncionario(BatFer.getIdFuncionarioAtivo());
        String sql = "INSERT INTO Pedido(idSabor, qtdProducao, idFuncionario) VALUES(?,?,?)";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);            
            stmt.setInt(1, pedido.getIdSabor());
            stmt.setInt(2, pedido.getQtdProducao());
            stmt.setString(3, pedido.getIdFuncionario());
            
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
    public boolean updatePedido(Pedido pedido){
        pedido.setIdFuncionario(BatFer.getIdFuncionarioAtivo());
        String sql = "UPDATE Pedido SET  idSabor = ?, qtdProducao = ?, idFuncionario = ?  WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getIdSabor());
            stmt.setInt(2, pedido.getQtdProducao());
            stmt.setString(3, pedido.getIdFuncionario());
            stmt.setInt(4, pedido.getIdPedido());
            
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
    public boolean deletaPedido(Pedido pedido){
        String sql = "DELETE FROM Pedido WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, pedido.getIdPedido());
            
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
        String sql = "SELECT * FROM Pedido";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while(ResSet.next()){
                Pedido pedido = new Pedido();
                
                pedido.setIdPedido(ResSet.getInt("idPedido"));
                pedido.setIdSabor(ResSet.getInt("idSabor"));
                pedido.setQtdProducao(ResSet.getInt("quantidadeProducao"));
                pedido.setDataPedido(ResSet.getDate("dataEntradaPedido"));
                
                ped.add(pedido);         
            }
            stmt.close();
            ResSet.close();
            con.close();                
        } catch (SQLException ex) {
            System.out.println("Erro! Lista não retornada");
            return null;
        }        
        return ped;
    }
    
}