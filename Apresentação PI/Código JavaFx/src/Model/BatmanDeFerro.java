/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.MenuPrincipalController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

/**
 * @author Carolina
 * @author Deive
 */
// Classe com atributos e métodos úteis para utilização geral
public class BatmanDeFerro {

    private int idProduto;
    private String nomeProduto;
    private static String idFuncionarioAtivo;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getIdFuncionarioAtivo() {
        return idFuncionarioAtivo;
    }

    public void setIdFuncionarioAtivo(String idFuncionarioAtivo) {
        this.idFuncionarioAtivo = idFuncionarioAtivo;
    }

    public void printaUsuario() {
        System.out.println("Usuário Logado: " + getIdFuncionarioAtivo());
    }

    public void voltaTelaLogin() {
        Login login = new Login();
        try {
            login.start(new Stage());
        }
        catch (Exception ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
