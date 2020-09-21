/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.FuncionarioDAO;
import Model.Funcionario;
import java.util.List;
/**
 *
 * @author deive
 */
public class CadastrarFuncionarioTeste {
    public static void main(String[] args) {
        FuncionarioDAO funcdao = new FuncionarioDAO();
        List<Funcionario> funcionario = funcdao.getList();
       
        if(funcionario != null){
            for (int dado = 0; dado < funcionario.size(); dado++){
                
                System.out.println("--------------------------------------------");
                
                funcionario.get(dado).mostraFuncionario();
                
                System.out.println("--------------------------------------------");
            }
        }
        else{
            System.out.println("Lista Nula!");
        }
    }
    
}
