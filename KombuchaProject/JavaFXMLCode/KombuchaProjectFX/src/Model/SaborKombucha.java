package Model;

/**
 *
 * @author carolina
 * @author deive
 * 
 */
public class SaborKombucha {
    private int idKombucha;
    private String nomeKombucha;
    private String chaBase;
    private int idChaBase;
    private double prePreparoQuantCha;
    private double prePreparoQuantAgua;
    private double quantidadeAcucar;
    private int idEmbalagem;

    public SaborKombucha(){
    
    }
    
    public SaborKombucha(int id_kombucha, String nome_kombucha, String cha_base, double qtd_cha, double qtd_agua, int id_embalagem, int id_cha_base) {
        this.idKombucha = id_kombucha;
        this.nomeKombucha = nome_kombucha;
        this.chaBase = cha_base;
        this.prePreparoQuantCha = qtd_cha;
        this.prePreparoQuantAgua = qtd_agua;
        this.idEmbalagem = id_embalagem;
        this.idChaBase = id_cha_base;
    }

    public int getIdKombucha() {
        return idKombucha;
    }

    public void setIdKombucha(int idKombucha) {
        this.idKombucha = idKombucha;
    }

    public String getNomeKombucha() {
        return nomeKombucha;
    }

    public void setNomeKombucha(String nomeKombucha) {
        this.nomeKombucha = nomeKombucha;
    }

    public String getChaBase() {
        return chaBase;
    }

    public void setChaBase(String chaBase) {
        this.chaBase = chaBase;
    }
    
    public int getIdChaBase() {
        return idChaBase;
    }

    public void setIdChaBase(int idChaBase) {
        this.idChaBase = idChaBase;
    }

    public double getPrePreparoQuantCha() {
        return prePreparoQuantCha;
    }

    public void setPrePreparoQuantCha(double prePreparoQuantCha) {
        this.prePreparoQuantCha = prePreparoQuantCha;
    }

    public double getPrePreparoQuantAgua() {
        return prePreparoQuantAgua;
    }

    public void setPrePreparoQuantAgua(double prePreparoQuantAgua) {
        this.prePreparoQuantAgua = prePreparoQuantAgua;
    }

    public double getQuantidadeAcucar() {
        return quantidadeAcucar;
    }

    public void setQuantidadeAcucar(double quantidadeAcucar) {
        this.quantidadeAcucar = quantidadeAcucar;
    }

    public int getIdEmbalagem() {
        return idEmbalagem;
    }

    public void setIdEmbalagem(int idEmbalagem) {
        this.idEmbalagem = idEmbalagem;
    }  
}







