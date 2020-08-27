package kombuchaproject;
/**
 *
 * @author deive
 */

public class Funcionario {
    private int idFuncionario;
    private String nomeFuncionario;
    private String cargo;

    public Funcionario(int idFuncionario, String nomeFuncionario, String cargo) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public boolean login(){
        
    return true;
    }
        
}
