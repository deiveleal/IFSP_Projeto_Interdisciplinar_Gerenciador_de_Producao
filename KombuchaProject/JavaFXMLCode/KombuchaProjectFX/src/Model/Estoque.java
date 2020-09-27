
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
    private String nomeItem;
    private double qtdItem;
    
    public Estoque() {
    }
    
    public Estoque(Estoque estoque){
    }
    
    public Estoque(int id_Item, int id_Item_Estoque, String nome_Item, double qtd_Item) {
        this.idItem = id_Item;
        this.idItemEstoque = id_Item_Estoque;
        this.nomeItem = nome_Item;
        this.qtdItem = qtd_Item;
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

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public double getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(double qtdItem) {
        this.qtdItem = qtdItem;
    }
    
    
}



