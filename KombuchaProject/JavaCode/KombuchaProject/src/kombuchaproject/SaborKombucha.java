package kombuchaproject;

/**
 *
 * @author Deive
 */
public class SaborKombucha {
    private int id_kombucha;
    private String nome_kombucha;
    private String cha_base;
    private double qtd_cha_base;
    private double pre_preparo_qtd_cha;
    private double pre_preparo_qtd_agua;
    private int id_embalagem;

    public SaborKombucha(int id_kombucha, String nome_kombucha, String cha_base, double qtd_cha_base, double pre_preparo_qtd_cha, double pre_preparo_qtd_agua, int id_embalagem) {
        this.id_kombucha = id_kombucha;
        this.nome_kombucha = nome_kombucha;
        this.cha_base = cha_base;
        this.qtd_cha_base = qtd_cha_base;
        this.pre_preparo_qtd_cha = pre_preparo_qtd_cha;
        this.pre_preparo_qtd_agua = pre_preparo_qtd_agua;
        this.id_embalagem = id_embalagem;
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

    public double getQtd_cha_base() {
        return qtd_cha_base;
    }

    public void setQtd_cha_base(double qtd_cha_base) {
        this.qtd_cha_base = qtd_cha_base;
    }

    public double getPre_preparo_qtd_cha() {
        return pre_preparo_qtd_cha;
    }

    public void setPre_preparo_qtd_cha(double pre_preparo_qtd_cha) {
        this.pre_preparo_qtd_cha = pre_preparo_qtd_cha;
    }

    public double getPre_preparo_qtd_agua() {
        return pre_preparo_qtd_agua;
    }

    public void setPre_preparo_qtd_agua(double pre_preparo_qtd_agua) {
        this.pre_preparo_qtd_agua = pre_preparo_qtd_agua;
    }

    public int getId_embalagem() {
        return id_embalagem;
    }

    public void setId_embalagem(int id_embalagem) {
        this.id_embalagem = id_embalagem;
    }
    
    
}





