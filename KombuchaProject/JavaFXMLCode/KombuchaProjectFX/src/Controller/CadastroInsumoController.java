/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BatmanDeFerro;
import Model.CadastroInsumo;
import Model.GerenciaEstoque;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deive
 */
public class CadastroInsumoController implements Initializable {
    BatmanDeFerro BatFer = new BatmanDeFerro();
    
    @FXML private TextField tfIdInsumo;
    @FXML private TextField tfItemEstoque;
    @FXML private TextField tfNome;
    @FXML private TextField tfDescricao;
    @FXML private Button btVoltar;
    @FXML private Button btCadastrar;
    @FXML private Button btFinalizarSessao;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            GerenciaEstoque gerEstoque = new GerenciaEstoque();
          
            try {
                gerEstoque.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                GerenciaEstoque gerEstoque = new GerenciaEstoque();
          
                try {
                    gerEstoque.start(new Stage());
                    fechaJanela();  
                } catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btFinalizarSessao.setOnMouseClicked((MouseEvent e)->{
            BatFer.voltaTelaLogin();
            fechaJanela();  
        });
        btFinalizarSessao.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                BatFer.voltaTelaLogin();
                fechaJanela();  
            }
        });
    }   
    
    /*private void cadastraInsumo(){//Falta adaptar
        String idFuncionario = tfCPF.getText(),
               nomeFuncionario = tfNome.getText(), 
               cargo = tfCargo.getText(), 
               senha = pfSenha.getText(), 
               confirm = pfConfirm.getText();
        
        if(senha.equals(confirm)){
            Funcionario func = new Funcionario(idFuncionario, nomeFuncionario, cargo, senha);  
            FuncionarioDAO funcDao = new FuncionarioDAO();
            if(funcDao.insert(func)){
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Usuário cadastrado!");
                alert.show();            
            }else{
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Erro ao cadastrar usuário!");
                alert.show();
            }            
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Senhas não coincidem!");
            alert.show();
        }    
    }*/
    
    public void fechaJanela(){
        CadastroInsumo.getStage().close();
    }
    
}
