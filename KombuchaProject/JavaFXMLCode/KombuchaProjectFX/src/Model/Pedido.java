
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
    private String nomeSabor;
    private int qtdProducao;
    private int idFermentador;
    private String idFuncionario;
    private double quantidadeCha; 
    private double quantidadeAgua; 
    private double quantidadeAcucar; 
    private int quantidadeEmbalagem;
    private Date dataPedido;

    public Pedido(){
    }
    
    public Pedido(Pedido pedido){
    
    }
    
    public Pedido(int idPedido, String idFuncionario, String nomeSabor, int qtdProducao) {
        this.idPedido = idPedido;
        this.nomeSabor = nomeSabor;
        this.qtdProducao = qtdProducao;
        this.idFuncionario = idFuncionario;
    }

    public Pedido(String idFuncionario, String nomeSabor, int qtdProducao) {
        this.nomeSabor = nomeSabor;
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

    public String getNomeSabor() {
        return nomeSabor;
    }

    public void setNomeSabor(String nomeSabor) {
        this.nomeSabor = nomeSabor;
    }

    public int getIdFermentador() {
        return idFermentador;
    }

    public void setIdFermentador(int idFermentador) {
        this.idFermentador = idFermentador;
    }

    public double getQuantidadeCha() {
        return quantidadeCha;
    }

    public void setQuantidadeCha(double quantidadeCha) {
        this.quantidadeCha = quantidadeCha;
    }

    public double getQuantidadeAgua() {
        return quantidadeAgua;
    }

    public void setQuantidadeAgua(double quantidadeAgua) {
        this.quantidadeAgua = quantidadeAgua;
    }

    public double getQuantidadeAcucar() {
        return quantidadeAcucar;
    }

    public void setQuantidadeAcucar(double quantidadeAcucar) {
        this.quantidadeAcucar = quantidadeAcucar;
    }

    public int getQuantidadeEmbalagem() {
        return quantidadeEmbalagem;
    }

    public void setQuantidadeEmbalagem(int quantidadeEmbalagem) {
        this.quantidadeEmbalagem = quantidadeEmbalagem;
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
}






