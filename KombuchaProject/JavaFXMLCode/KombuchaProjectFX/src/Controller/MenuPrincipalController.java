/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BatmanDeFerro;
import Model.GerenciaEstoque;
import Model.GerenciaUsuario;
import Model.MenuPrincipal;
import Model.GerenciaPedido;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    BatmanDeFerro BatFer = new BatmanDeFerro();

    @FXML
    private Button btGerencUsuario;
    @FXML
    private Button btGerencPedido;
    @FXML
    private Button btGerencEstoq;
    @FXML
    private Button btFinalizarSessao;
    @FXML
    private Label lblIdFuncionarioAtivo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initIdFuncionarioAtivo();

        btGerencUsuario.setOnMouseClicked((MouseEvent e) -> {
            GerenciaUsuario ger = new GerenciaUsuario();

            try {
                ger.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btGerencUsuario.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaUsuario ger = new GerenciaUsuario();
                try {
                    ger.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btGerencPedido.setOnMouseClicked((MouseEvent e) -> {
            GerenciaPedido ped = new GerenciaPedido();

            try {
                ped.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btGerencPedido.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaPedido ped = new GerenciaPedido();
                try {
                    ped.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btGerencEstoq.setOnMouseClicked((MouseEvent e) -> {
            GerenciaEstoque estq = new GerenciaEstoque();

            try {
                estq.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btGerencEstoq.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaEstoque estq = new GerenciaEstoque();

                try {
                    estq.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btFinalizarSessao.setOnMouseClicked((MouseEvent e) -> {
            BatFer.voltaTelaLogin();
            fechaJanela();
        });

        btFinalizarSessao.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                BatFer.voltaTelaLogin();
                fechaJanela();
            }
        });

    }

    private void fechaJanela() {
        MenuPrincipal.getStage().close();
    }

    public void initIdFuncionarioAtivo() {
        lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());
    }

}
