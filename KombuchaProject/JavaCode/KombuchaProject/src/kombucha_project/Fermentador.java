
package kombucha_project;

/**
 *
 * @author Deive
 */
public class Fermentador {
    private int id_Fermentador;
    private int id_Item_Estoque;
    private boolean estado_Produção;
    private double volume;

    public Fermentador(int id_Fermentador, int id_Item_Estoque, boolean estado_Produção, double volume) {
        this.id_Fermentador = id_Fermentador;
        this.id_Item_Estoque = id_Item_Estoque;
        this.estado_Produção = estado_Produção;
        this.volume = volume;
    }

    public int getId_Fermentador() {
        return id_Fermentador;
    }

    public void setId_Fermentador(int id_Fermentador) {
        this.id_Fermentador = id_Fermentador;
    }

    public int getId_Item_Estoque() {
        return id_Item_Estoque;
    }

    public void setId_Item_Estoque(int id_Item_Estoque) {
        this.id_Item_Estoque = id_Item_Estoque;
    }

    public boolean isEstado_Produção() {
        return estado_Produção;
    }

    public void setEstado_Produção(boolean estado_Produção) {
        this.estado_Produção = estado_Produção;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
    
    
}


