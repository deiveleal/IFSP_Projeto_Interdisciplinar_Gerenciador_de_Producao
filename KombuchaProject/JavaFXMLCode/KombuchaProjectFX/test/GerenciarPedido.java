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
        Pedido pedTeste = new Pedido("06146045675","Anis",11);
        List<Pedido> ultimoPedido = dao.selectUltimoPedido();
        //dao.inserePedido(pedTeste);
        
        System.out.println("----------------------------------------------");
        System.out.println("SAbor 2: "+ultimoPedido.get(0).getNomeSabor());

    }
    
}
