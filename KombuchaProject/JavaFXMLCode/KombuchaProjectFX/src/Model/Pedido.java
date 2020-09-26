
package Model;

import java.util.Date;

/**
 *
 * @author carolina
 * @author deive
 * 
 */

public class Pedido {
    private int idPedido;
    private int idSabor;
    private int qtdProducao;
    private String idFuncionario;
    private Date dataPedido;

    public Pedido(){
    }
    public Pedido(int idPedido, int idSabor, int qtdProducao, int idFermentador, String idFuncionario) {
        this.idPedido = idPedido;
        this.idSabor = idSabor;
        this.qtdProducao = qtdProducao;
        this.idFuncionario = idFuncionario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(int idSabor) {
        this.idSabor = idSabor;
    }

    public int getQtdProducao() {
        return qtdProducao;
    }

    public void setQtdProducao(int qtdProducao) {
        this.qtdProducao = qtdProducao;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    } 
    
    public void mostraPedido(){
        System.out.println("Cód. Pedido : "+getIdPedido());
        System.out.println("Cód. Sabor : "+getIdSabor());
        System.out.println("Quantidade : "+getQtdProducao());
        System.out.println("Data : "+getDataPedido());
    }  
    
}






