package Model;

/**
 *
 * @author carolina
 * @author deive
 *
 */
public class Estoque {

    private int idItem;
    private int idItemEstoque;
    private String nomeProduto;
    private double qtdItem;

    public Estoque() {
    }

    public Estoque(Estoque estoque) {
    }

    public Estoque(int id_Item, int id_Item_Estoque, String nome_Item, double qtd_Item) {
        this.idItem = id_Item;
        this.idItemEstoque = id_Item_Estoque;
        this.nomeProduto = nome_Item;
        this.qtdItem = qtd_Item;
    }

    public Estoque(int idItem, int idItemEstoque, double quantItem) {
        this.idItem = idItem;
        this.idItemEstoque = idItemEstoque;
        this.qtdItem = quantItem;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdItemEstoque() {
        return idItemEstoque;
    }

    public void setIdItemEstoque(int idItemEstoque) {
        this.idItemEstoque = idItemEstoque;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(double qtdItem) {
        this.qtdItem = qtdItem;
    }

}
