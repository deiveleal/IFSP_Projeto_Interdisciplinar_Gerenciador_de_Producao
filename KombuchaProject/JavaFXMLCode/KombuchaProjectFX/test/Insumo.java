

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class Insumo extends Estoque{
    private int idInsumo;
    private String descrInsumo;

    public Insumo(int idInsumo, int idItemEstoque, String nomeProduto, String descInsumo) {
        this.idItemEstoque = idItemEstoque;
        this.nomeProduto = nomeProduto;
        this.idInsumo = idInsumo;
        this.descrInsumo = descInsumo;
    }
    
    public Insumo(){
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public int getIdItemEstoque() {
        return idItemEstoque;
    }

    @Override
    public void setIdItemEstoque(int idItemEstoque) {
        this.idItemEstoque = idItemEstoque;
    }

    @Override
    public String getNomeProduto() {
        return nomeProduto;
    }

    @Override
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescrInsumo() {
        return descrInsumo;
    }

    public void setDescrInsumo(String descrInsumo) {
        this.descrInsumo = descrInsumo;
    }

   
    
    
}




