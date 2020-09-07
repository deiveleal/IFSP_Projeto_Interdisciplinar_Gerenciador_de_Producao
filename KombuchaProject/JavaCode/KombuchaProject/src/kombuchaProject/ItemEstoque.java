
package kombuchaProject;

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class ItemEstoque {
    private int id_Item;
    private String tipo_Item;

    public ItemEstoque(int id_Item, String tipo_Item) {
        this.id_Item = id_Item;
        this.tipo_Item = tipo_Item;
    }

    public int getId_Item() {
        return id_Item;
    }

    public void setId_Item(int id_Item) {
        this.id_Item = id_Item;
    }

    public String getTipo_Item() {
        return tipo_Item;
    }

    public void setTipo_Item(String tipo_Item) {
        this.tipo_Item = tipo_Item;
    }
    
    

    
    
}



