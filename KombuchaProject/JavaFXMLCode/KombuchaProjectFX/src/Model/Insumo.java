package Model;

/**
 *
 * @author carolina
 * @author deive
 *
 */
public class Insumo {

    private int idInsumo;
    private int idItemEstoque;
    private String nomeInsumo;
    private String descrInsumo;

    public Insumo(int idInsumo, int idItemEstoque, String nomeInsumo, String descInsumo) {
        this.idInsumo = idInsumo;
        this.idItemEstoque = idItemEstoque;
        this.nomeInsumo = nomeInsumo;
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

    public int getIdItemEstoque() {
        return idItemEstoque;
    }

    public void setIdItemEstoque(int idItemEstoque) {
        this.idItemEstoque = idItemEstoque;
    }

    public String getNomeInsumo() {
        return nomeInsumo;
    }

    public void setNomeInsumo(String nomeInsumo) {
        this.nomeInsumo = nomeInsumo;
    }

    public String getDescrInsumo() {
        return descrInsumo;
    }

    public void setDescrInsumo(String descrInsumo) {
        this.descrInsumo = descrInsumo;
    }

}
