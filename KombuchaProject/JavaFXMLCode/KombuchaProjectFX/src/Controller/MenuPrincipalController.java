/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GerenciaEstoque;
import Model.GerenciaUsuario;
import Model.MenuPrincipal;
import Model.GerenciaPedido;
import Model.Login;
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
public class MenuPrincipalController implements Initializable {
    

    @FXML
    private Button btGerencUsuario;

    @FXML
    private Button btGerencPedido;

    @FXML
    private Button btGerencEstoq;

    @FXML
    private Button btFinalizarSessao;


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btGerencUsuario.setOnMouseClicked((MouseEvent e)->{
            GerenciaUsuario ger = new GerenciaUsuario();
            fechaJanela();            
            try {
                ger.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btGerencPedido.setOnMouseClicked((MouseEvent e)->{
            GerenciaPedido ped = new GerenciaPedido();
            fechaJanela();            
            try {
                ped.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btGerencEstoq.setOnMouseClicked((MouseEvent e)->{
            GerenciaEstoque estq = new GerenciaEstoque();
            fechaJanela();            
            try {
                estq.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        btFinalizarSessao.setOnMouseClicked((MouseEvent e)->{
            voltaTelaLogin();
        });

        btFinalizarSessao.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                voltaTelaLogin();
            }
        });
    
    }
    private void fechaJanela() {
        MenuPrincipal.getStage().close();
    }
    private void voltaTelaLogin(){
        Login login = new Login();
        try {
            login.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fechaJanela();
    }
    
}
