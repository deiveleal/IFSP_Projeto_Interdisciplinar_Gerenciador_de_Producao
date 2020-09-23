/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.BatmanDeFerro;
import Model.GerenciaPedido;
import Model.Login;
import Model.MenuPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
public class GerenciaPedidoController implements Initializable {
    @FXML
    private Button btCancelarPedido;

    @FXML
    private Button btInserirPedido;

    @FXML
    private Button btCadastrarSabor;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TableView<?> tablePedidos;

    @FXML
    private TableColumn<?, ?> colCodPedido;

    @FXML
    private TableColumn<?, ?> colSabor;

    @FXML
    private TableColumn<?, ?> colQtd;

    @FXML
    private TableColumn<?, ?> colData;

    @FXML
    private TableColumn<?, ?> colCliente;

    @FXML
    private ComboBox<?> cbSabors;

    @FXML
    private Button btVoltar;

    @FXML
    private Button btFinalizarSessao;

    @FXML
    private TextField tfBusca;

    @FXML
    private Button btAlterarPedido;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        GerenciaPedido.getStage().close();
    }    
}
