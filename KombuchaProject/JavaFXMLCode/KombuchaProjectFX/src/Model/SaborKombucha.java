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

    public SaborKombucha() {

    }

    public SaborKombucha(int idkombucha, String nomekombucha, String chabase, int idchabase, double qtdcha, double qtdagua, double qtdacucar, int idembalagem) {
        this.idKombucha = idkombucha;
        this.nomeKombucha = nomekombucha;
        this.chaBase = chabase;
        this.idChaBase = idchabase;
        this.prePreparoQuantCha = qtdcha;
        this.prePreparoQuantAgua = qtdagua;
        this.quantidadeAcucar = qtdacucar;
        this.idEmbalagem = idembalagem;
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

    @Override
    public String toString() {
        return getNomeKombucha();
    }

}
