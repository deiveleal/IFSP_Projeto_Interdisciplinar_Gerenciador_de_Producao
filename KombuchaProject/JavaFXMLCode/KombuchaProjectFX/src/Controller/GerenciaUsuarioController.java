/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AlterarExcluirUser;
import Model.BatmanDeFerro;
import Model.CadastrarFuncionario;
import Model.GerenciaUsuario;
import Model.Login;
import Model.MenuPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deive
 */
public class GerenciaUsuarioController implements Initializable {   
    

    @FXML
    private Button btVoltar;

    @FXML
    private Button btFinalizarSessao;

    @FXML
    private Button btCadastFunc;

    @FXML
    private Button btAltExcDadFunc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btCadastFunc.setOnMouseClicked((MouseEvent e)->{
            CadastrarFuncionario cadfunc = new CadastrarFuncionario();
           
            try {
                cadfunc.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btAltExcDadFunc.setOnMouseClicked((MouseEvent e)->{
            AlterarExcluirUser altdeluser = new AlterarExcluirUser();
           
            try {
                altdeluser.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            MenuPrincipal menu = new MenuPrincipal();
           
            try {
                menu.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                MenuPrincipal menu = new MenuPrincipal();
            
                try {
                    menu.start(new Stage());
                    fechaJanela();  
                } catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        BatmanDeFerro BatFer = new BatmanDeFerro();
        
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
    public void fechaJanela(){
        GerenciaUsuario.getStage().close();
    }  
        
}
