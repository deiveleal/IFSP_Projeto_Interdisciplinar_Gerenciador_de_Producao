package Model;

import java.util.Date;
/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class KombuchaPronto extends ItemEstoque {
    private int id_Kombuhca_Pronto;
    private int id_Item_Estoque;
    private int id_Sabor;
    private String nome_Produto;
    private Date data_Fabricacao;

    public KombuchaPronto(int id_Kombuhca_Pronto, int id_Item_Estoque, int id_Sabor, String nome_Produto, Date data_Fabricacao, int id_Item, String tipo_Item) {
        super(id_Item, tipo_Item);
        this.id_Kombuhca_Pronto = id_Kombuhca_Pronto;
        this.id_Item_Estoque = id_Item_Estoque;
        this.id_Sabor = id_Sabor;
        this.nome_Produto = nome_Produto;
        this.data_Fabricacao = data_Fabricacao;
    }

    public int getId_Kombuhca_Pronto() {
        return id_Kombuhca_Pronto;
    }

    public void setId_Kombuhca_Pronto(int id_Kombuhca_Pronto) {
        this.id_Kombuhca_Pronto = id_Kombuhca_Pronto;
    }

    public int getId_Item_Estoque() {
        return id_Item_Estoque;
    }

    public void setId_Item_Estoque(int id_Item_Estoque) {
        this.id_Item_Estoque = id_Item_Estoque;
    }

    public int getId_Sabor() {
        return id_Sabor;
    }

    public void setId_Sabor(int id_Sabor) {
        this.id_Sabor = id_Sabor;
    }

    public String getNome_Produto() {
        return nome_Produto;
    }

    public void setNome_Produto(String nome_Produto) {
        this.nome_Produto = nome_Produto;
    }

    public Date getData_Fabricacao() {
        return data_Fabricacao;
    }

    public void setData_Fabricacao(Date data_Fabricacao) {
        this.data_Fabricacao = data_Fabricacao;
    }

    
}






