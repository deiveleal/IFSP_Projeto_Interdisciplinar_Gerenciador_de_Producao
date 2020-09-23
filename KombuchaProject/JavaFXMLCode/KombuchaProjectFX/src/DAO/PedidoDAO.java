/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactory;
import Model.BatmanDeFerro;
import Model.Funcionario;
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
    BatmanDeFerro BatFer = new BatmanDeFerro();
    Pedido pedido = new Pedido();
    private Connection con;
   
    public PedidoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Método que insere um novo usuário;
    public boolean insert(Pedido pedido){
        String sql = "INSERT INTO Pedido(idPedido, idSabor, qtdProducao, idFuncionario, dataEntradaPedido) VALUES(?,?,?,?,? )";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getId_Pedido());            
            stmt.setInt(2, pedido.getId_Sabor());
            stmt.setInt(3, pedido.getQtd_Producao());
            stmt.setString(4, pedido.getId_Funcionario());
            stmt.setDate(5, (java.sql.Date) pedido.getData_Pedido());
            
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
    public boolean update(Funcionario func){
        String sql = "UPDATE Pedido SET  idSabor = ?, qtdProducao = ?, idFuncionario = ?, dataEntradaPedido = ? WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, pedido.getId_Sabor());
            stmt.setInt(2, pedido.getQtd_Producao());
            stmt.setString(3, pedido.getId_Funcionario());
            stmt.setDate(4, (java.sql.Date) pedido.getData_Pedido());
            stmt.setInt(5, pedido.getId_Pedido());
            
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
    public boolean delete(Funcionario func){
        String sql = "DELETE FROM Pedido WHERE idPedido = ?;";
        try { 
            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, pedido.getId_Pedido());
            
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
    
    //Método que retorna uma lista de usuários do banco
    public List<Pedido> getList(){
        List<Pedido> ped = new ArrayList<>();
        String sql = "SELECT * FROM Pedido";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while(ResSet.next()){
                Pedido pedid = new Pedido();
                pedid.setId_Pedido(ResSet.getInt("idPedido"));
                pedid.setId_Sabor(ResSet.getInt("idSabor"));
                pedid.setQtd_Producao(ResSet.getInt("quantidadeProducao"));
                pedid.setId_Funcionario(ResSet.getString("idFuncionario"));
                pedid.setData_Pedido(ResSet.getDate("dataEntradaPedido"));                
                
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