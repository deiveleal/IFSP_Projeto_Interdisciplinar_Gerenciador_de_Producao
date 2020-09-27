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
        Pedido pedido = new Pedido();
        PedidoDAO dao = new PedidoDAO();
        
        pedido.setIdFuncionario("06146045675");            
        pedido.setIdSabor(1);
        pedido.setQtdProducao(7);
        
        dao.inserePedido(pedido);
        
        List<Pedido> lastpedido = dao.getList();        
       
        if(lastpedido != null){
            for (int dado = 0; dado < lastpedido.size(); dado++){
                
                System.out.println("--------------------------------------------");
                
                //lastpedido.get(dado).mostraPedido();
                
                System.out.println("--------------------------------------------");
            }
        }
        else{
            System.out.println("Lista Nula!");
        }
    }
    
}
