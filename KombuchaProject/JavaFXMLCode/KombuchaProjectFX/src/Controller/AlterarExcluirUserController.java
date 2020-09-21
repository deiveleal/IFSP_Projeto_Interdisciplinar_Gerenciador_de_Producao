/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AlterarExcluirUser;
import Model.GerenciaUsuario;
import Model.MenuPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
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
public class AlterarExcluirUserController implements Initializable {
    
    @FXML
    private Button btExcluirUser;

    @FXML
    private TableView<?> tableUser;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btSair;

    @FXML
    private TextField tfBusca;

    @FXML
    private Button btAlteraDados;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
        
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            GerenciaUsuario geruser = new GerenciaUsuario();
            fechaJanela();            
            try {
                geruser.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                GerenciaUsuario geruser = new GerenciaUsuario();
                fechaJanela();            
                try {
                    geruser.start(new Stage());
                } catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        btSair.setOnMouseClicked((MouseEvent e)->{
            fechaJanela();
        });
        btSair.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                fechaJanela();
            }
        });
    }
    public void fechaJanela(){
        AlterarExcluirUser.getStage().close();
    }      
    
}
