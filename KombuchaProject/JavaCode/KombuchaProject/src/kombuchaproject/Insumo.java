package kombuchaproject;
/**
 *
 * @author Deive
 */
public class Insumo extends ItemEstoque{
    private int id_Insumo;
    private int id_Item_Estoque;
    private String nome_Insumo;
    private String descr_Insumo;

    public Insumo(int id_Insumo, int id_Item_Estoque, String nome_Insumo, String descr_Insumo, int id_Item, String tipo_Item) {
        super(id_Item, tipo_Item);
        this.id_Insumo = id_Insumo;
        this.id_Item_Estoque = id_Item_Estoque;
        this.nome_Insumo = nome_Insumo;
        this.descr_Insumo = descr_Insumo;
    }

    public int getId_Insumo() {
        return id_Insumo;
    }

    public void setId_Insumo(int id_Insumo) {
        this.id_Insumo = id_Insumo;
    }

    public int getId_Item_Estoque() {
        return id_Item_Estoque;
    }

    public void setId_Item_Estoque(int id_Item_Estoque) {
        this.id_Item_Estoque = id_Item_Estoque;
    }

    public String getNome_Insumo() {
        return nome_Insumo;
    }

    public void setNome_Insumo(String nome_Insumo) {
        this.nome_Insumo = nome_Insumo;
    }

    public String getDescr_Insumo() {
        return descr_Insumo;
    }

    public void setDescr_Insumo(String descr_Insumo) {
        this.descr_Insumo = descr_Insumo;
    }

   
    
    
}




