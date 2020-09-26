/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import Model.BatmanDeFerro;
import Model.CadastrarFuncionario;
import Model.Funcionario;
import Model.GerenciaUsuario;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deive
 */
public class CadastrarFuncionarioController implements Initializable { 
    BatmanDeFerro BatFer = new BatmanDeFerro();

    @FXML private Button btVoltar;
    @FXML private Button btCadastrar;
    @FXML private Button btFinalizarSessao;
    @FXML private TextField tfCPF;
    @FXML private TextField tfNome;
    @FXML private TextField tfCargo;
    @FXML private PasswordField pfSenha;
    @FXML private PasswordField pfConfirm;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btCadastrar.setOnMouseClicked((MouseEvent e)->{
            cadastraFunc();
    
        });
        btCadastrar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode()==KeyCode.ENTER){
                cadastraFunc();             
            }        
        });       
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            GerenciaUsuario geruser = new GerenciaUsuario();
          
            try {
                geruser.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                GerenciaUsuario geruser = new GerenciaUsuario();
          
                try {
                    geruser.start(new Stage());
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
    
    private void cadastraFunc(){
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
    }
    public void fechaJanela(){
        CadastrarFuncionario.getStage().close();
    }
}
