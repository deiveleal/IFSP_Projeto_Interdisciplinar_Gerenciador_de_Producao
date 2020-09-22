/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author Carolina
 * @author Deive
 */


// Classe com atributos e métodos úteis para utilização geral

public class BatmanDeFerro {
    private String idFuncionarioAtivo;
    
    
    
    
    
    
    

    public String getIdFuncionarioAtivo() {
        return idFuncionarioAtivo;
    }

    public void setIdFuncionarioAtivo(String idFuncionario) {
        this.idFuncionarioAtivo = idFuncionario;
    }  
    public void printaUsuario(){
        System.out.println("Usuário Logado: "+getIdFuncionarioAtivo());    
    }
}
