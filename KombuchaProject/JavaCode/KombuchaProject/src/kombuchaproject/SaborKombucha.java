package kombuchaproject;

/**
 *
 * @author Deive
 */
public class SaborKombucha {
    private int id_kombucha;
    private String nome_kombucha;
    private String cha_base;
    private double qtd_cha;
    private double qtd_agua;
    private int id_embalagem;
    private int id_cha_base;

    public SaborKombucha(int id_kombucha, String nome_kombucha, String cha_base, double qtd_cha, double qtd_agua, int id_embalagem, int id_cha_base) {
        this.id_kombucha = id_kombucha;
        this.nome_kombucha = nome_kombucha;
        this.cha_base = cha_base;
        this.qtd_cha = qtd_cha;
        this.qtd_agua = qtd_agua;
        this.id_embalagem = id_embalagem;
        this.id_cha_base = id_cha_base;
    }

    public int getId_kombucha() {
        return id_kombucha;
    }

    public void setId_kombucha(int id_kombucha) {
        this.id_kombucha = id_kombucha;
    }

    public String getNome_kombucha() {
        return nome_kombucha;
    }

    public void setNome_kombucha(String nome_kombucha) {
        this.nome_kombucha = nome_kombucha;
    }

    public String getCha_base() {
        return cha_base;
    }

    public void setCha_base(String cha_base) {
        this.cha_base = cha_base;
    }

    public double getQtd_cha() {
        return qtd_cha;
    }

    public void setQtd_cha(double qtd_cha) {
        this.qtd_cha = qtd_cha;
    }

    public double getQtd_agua() {
        return qtd_agua;
    }

    public void setQtd_agua(double qtd_agua) {
        this.qtd_agua = qtd_agua;
    }

    public int getId_embalagem() {
        return id_embalagem;
    }

    public void setId_embalagem(int id_embalagem) {
        this.id_embalagem = id_embalagem;
    }

    public int getId_cha_base() {
        return id_cha_base;
    }

    public void setId_cha_base(int id_cha_base) {
        this.id_cha_base = id_cha_base;
    }
    
    

    
}







