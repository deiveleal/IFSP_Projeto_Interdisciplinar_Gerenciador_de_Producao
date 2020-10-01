package Model;

/**
 *
 * @author carolina
 * @author deive
 *
 */
public class Insumo extends Estoque {

    private int idInsumo;
    private String descrInsumo;

    public Insumo(int idInsumo, int idItemEstoque, String nomeProduto, String descInsumo) {
        this.idInsumo = idInsumo;
        super.setIdItemEstoque(idItemEstoque);
        super.setNomeProduto(nomeProduto);
        this.descrInsumo = descInsumo;
    }

    public Insumo() {
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(int idInsumo) {
        this.idInsumo = idInsumo;
    }

    @Override
    public int getIdItemEstoque() {
        return super.getIdItemEstoque();
    }

    @Override
    public void setIdItemEstoque(int idItemEstoque) {
        super.setIdItemEstoque(idItemEstoque);
    }

    @Override
    public String getNomeProduto() {
        return super.getNomeProduto();
    }

    @Override
    public void setNomeProduto(String nomeProduto) {
        super.setNomeProduto(nomeProduto);
    }

    public String getDescrInsumo() {
        return descrInsumo;
    }

    public void setDescrInsumo(String descrInsumo) {
        this.descrInsumo = descrInsumo;
    }

}
