/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author carolina
 * @author deive
 * 
 */

public class Funcionario {
    private String idFuncionario;
    private String nomeFuncionario;
    private String cargo;
    private String senha;

    
    public Funcionario(){
    }
    
    public Funcionario(String idFuncionario, String nomeFuncionario, String cargo, String senha) {
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cargo = cargo;
        this.senha = senha;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
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
    
    public void mostraFuncionario(){
        System.out.println("CPF : "+getIdFuncionario());
        System.out.println("Nome : "+getNomeFuncionario());
        System.out.println("Cargo : "+getCargo());
    }        
}
