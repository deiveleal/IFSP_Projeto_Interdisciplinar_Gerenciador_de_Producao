/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pedido;
import Model.PopConfirmaQuantPedido;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 * @author carolina
 * @author Deive
 */
public class PopConfirmaQuantPedidoController implements Initializable {
    private static Pedido ped;


    @FXML private Label lblIdPedido;
    @FXML private Label lblSabor;
    @FXML private Label lblQtdProducao;
    @FXML private Label lblIdFermentador;
    @FXML private Label lblQtdExtrato;
    @FXML private Label lblQtdAgua;
    @FXML private Label lblQtdAcucar;
    @FXML private Label lblQtdEmbalagem;
    @FXML private Button btOK;

    public static Pedido getPed() {
        return ped;
    }

    public static void setPed(Pedido ped) {
        PopConfirmaQuantPedidoController.ped = ped;
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btOK.setOnMouseClicked((MouseEvent e)->{
            fechaJanela();  
        });
        btOK.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                fechaJanela();  
            }
        });
    }    
    public void initRelatorioPedido(){
    
    }
    public void fechaJanela(){
        PopConfirmaQuantPedido.getStage().close();
    }  
    
}
