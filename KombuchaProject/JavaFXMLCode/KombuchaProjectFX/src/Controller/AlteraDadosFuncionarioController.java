/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.FuncionarioDAO;
import Model.AlteraDadosFuncionario;
import Model.AlterarExcluirUser;
import Model.BatmanDeFerro;
import Model.Funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class AlteraDadosFuncionarioController implements Initializable {
    BatmanDeFerro BatFer = new BatmanDeFerro();
    private static Funcionario funcionario;
    
    @FXML private Button btVoltar;
    @FXML private Button btAtualizarDados;
    @FXML private TextField tfNome;
    @FXML private TextField tfCargo;
    @FXML private PasswordField pfSenha;
    @FXML private PasswordField pfConfirm;
    @FXML private Label lblIdFuncionario;
    @FXML private Button btFinalizarSessao;
    
    public static Funcionario getFuncionario() {
        return funcionario;
    }

    public static void setFuncionario(Funcionario funcionario) {
        AlteraDadosFuncionarioController.funcionario = funcionario;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFuncionario();
        
        btAtualizarDados.setOnMouseClicked((MouseEvent e)->{                                          
            try {
                atualizaDados();
            } catch (Exception ex) {
                Logger.getLogger(AlteraDadosFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btAtualizarDados.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){                                                 
                try {
                    atualizaDados();
                } catch (Exception ex) {
                    Logger.getLogger(AlteraDadosFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });       
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            AlterarExcluirUser altExcUs = new AlterarExcluirUser();
            try {
                altExcUs.start(new Stage());                            
                fechaJanela();
            } catch (Exception ex) {
                Logger.getLogger(AlteraDadosFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                AlterarExcluirUser altExcUs = new AlterarExcluirUser();
                try {
                    altExcUs.start(new Stage());                            
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(AlteraDadosFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void fechaJanela(){
        AlteraDadosFuncionario.getStage().close();    
    }
    public void initFuncionario(){
        lblIdFuncionario.setText(funcionario.getIdFuncionario());
        tfNome.setText(funcionario.getNomeFuncionario());
        tfCargo.setText(funcionario.getCargo());
        pfSenha.setText(funcionario.getSenha());
        pfConfirm.setText(funcionario.getSenha());    
    }
    
    public void atualizaDados() throws Exception{
        String idFuncionario = lblIdFuncionario.getText(),
               nomeFuncionario = tfNome.getText(),
               cargo = tfCargo.getText(),
               senha = pfSenha.getText(),
               confirm = pfConfirm.getText();
        if(idFuncionario != null && nomeFuncionario != null && cargo != null 
                && senha != null && confirm != null){
            if(senha.equals(confirm)){
                FuncionarioDAO dao = new FuncionarioDAO();
                Funcionario func = new Funcionario(idFuncionario, nomeFuncionario, cargo, senha);
                if(dao.update(func)){
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Dados do usuário atualizados!");
                    alert.show();
                    tfCargo.setText("");
                    pfSenha.setText("");
                    pfConfirm.setText("");
                    
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Erro ao atualizar dados do usuário!");                
                    alert.show();
                }
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Senhas não coincidem!");
                alert.show();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Todos os campos devem ser preenchidos!");
            alert.show(); 
        }
    }
}
