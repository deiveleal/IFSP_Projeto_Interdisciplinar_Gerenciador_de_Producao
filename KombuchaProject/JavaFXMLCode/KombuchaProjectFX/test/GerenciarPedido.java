/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.PedidoDAO;
import Model.Pedido;
import java.util.List;
/**
 *
 * @author deive
 */
public class GerenciarPedido {
    public static void main(String[] args) {
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> pedido = dao.getList();
       
        if(pedido != null){
            for (int dado = 0; dado < pedido.size(); dado++){
                
                System.out.println("--------------------------------------------");
                
                pedido.get(dado).mostraPedido();
                
                System.out.println("--------------------------------------------");
            }
        }
        else{
            System.out.println("Lista Nula!");
        }
    }
    
}
