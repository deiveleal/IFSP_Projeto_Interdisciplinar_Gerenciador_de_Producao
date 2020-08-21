
package kombuchaproject;

/**
 *
 * @author Deive
 */
public class Pedido {
    private int id_Pedido;
    private int id_Sabor;
    private int qtd_Producao;
    private int id_Fermentador;
    private int id_Funcionario;

    public Pedido(int id_Pedido, int id_Sabor, int qtd_Producao, int id_Fermentador, int id_Funcionario) {
        this.id_Pedido = id_Pedido;
        this.id_Sabor = id_Sabor;
        this.qtd_Producao = qtd_Producao;
        this.id_Fermentador = id_Fermentador;
        this.id_Funcionario = id_Funcionario;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public int getId_Sabor() {
        return id_Sabor;
    }

    public void setId_Sabor(int id_Sabor) {
        this.id_Sabor = id_Sabor;
    }

    public int getQtd_Producao() {
        return qtd_Producao;
    }

    public void setQtd_Producao(int qtd_Producao) {
        this.qtd_Producao = qtd_Producao;
    }

    public int getId_Fermentador() {
        return id_Fermentador;
    }

    public void setId_Fermentador(int id_Fermentador) {
        this.id_Fermentador = id_Fermentador;
    }

    public int getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }
    
    
}



