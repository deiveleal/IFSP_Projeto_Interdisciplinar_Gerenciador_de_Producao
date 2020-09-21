
package Model;

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class EmbalagemKombucha {
    private int id_Embalagem;
    private int id_Item_Estoque;
    private String cor_Embalagem;
    private String nome_Embalagem;

    public EmbalagemKombucha(int id_Embalagem, int id_Item_Estoque, String cor_Embalagem, String nome_Embalagem) {
        this.id_Embalagem = id_Embalagem;
        this.id_Item_Estoque = id_Item_Estoque;
        this.cor_Embalagem = cor_Embalagem;
        this.nome_Embalagem = nome_Embalagem;
    }

    public int getId_Embalagem() {
        return id_Embalagem;
    }

    public void setId_Embalagem(int id_Embalagem) {
        this.id_Embalagem = id_Embalagem;
    }

    public int getId_Item_Estoque() {
        return id_Item_Estoque;
    }

    public void setId_Item_Estoque(int id_Item_Estoque) {
        this.id_Item_Estoque = id_Item_Estoque;
    }

    public String getCor_Embalagem() {
        return cor_Embalagem;
    }

    public void setCor_Embalagem(String cor_Embalagem) {
        this.cor_Embalagem = cor_Embalagem;
    }

    public String getNome_Embalagem() {
        return nome_Embalagem;
    }

    public void setNome_Embalagem(String nome_Embalagem) {
        this.nome_Embalagem = nome_Embalagem;
    }
    
    
    
}



