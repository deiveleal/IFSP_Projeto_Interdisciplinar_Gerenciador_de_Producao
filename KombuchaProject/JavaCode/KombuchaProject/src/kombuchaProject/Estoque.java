
package kombuchaProject;

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class Estoque {
    private int id_Item;
    private int id_Item_Estoque;
    private String nome_Item;
    private double qtd_Item;

    public Estoque(int id_Item, int id_Item_Estoque, String nome_Item, double qtd_Item) {
        this.id_Item = id_Item;
        this.id_Item_Estoque = id_Item_Estoque;
        this.nome_Item = nome_Item;
        this.qtd_Item = qtd_Item;
    }

    public int getId_Item() {
        return id_Item;
    }

    public void setId_Item(int id_Item) {
        this.id_Item = id_Item;
    }

    public int getId_Item_Estoque() {
        return id_Item_Estoque;
    }

    public void setId_Item_Estoque(int id_Item_Estoque) {
        this.id_Item_Estoque = id_Item_Estoque;
    }

    public String getNome_Item() {
        return nome_Item;
    }

    public void setNome_Item(String nome_Item) {
        this.nome_Item = nome_Item;
    }

    public double getQtd_Item() {
        return qtd_Item;
    }

    public void setQtd_Item(double qtd_Item) {
        this.qtd_Item = qtd_Item;
    }
    
    
}



