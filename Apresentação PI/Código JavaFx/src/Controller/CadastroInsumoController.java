/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.InsumoDAO;
import Model.BatmanDeFerro;
import Model.CadastroInsumo;
import Model.GerenciaEstoque;
import Model.Insumo;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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

    @FXML
    private TextField tfIdInsumo;
    @FXML
    private TextField tfIdItemEstoque;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfDescricao;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btCadastrar;
    @FXML
    private Button btFinalizarSessao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        btCadastrar.setOnMouseClicked((MouseEvent e) -> {
            InsereNovoInsumo();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                InsereNovoInsumo();
            }
        });

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            GerenciaEstoque gerEstoque = new GerenciaEstoque();

            try {
                gerEstoque.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaEstoque gerEstoque = new GerenciaEstoque();

                try {
                    gerEstoque.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void InsereNovoInsumo() {
        int idInsumo = Integer.parseInt(tfIdInsumo.getText()),
                idItemEstoque = Integer.parseInt(tfIdItemEstoque.getText());
        String nomeInsumo = tfNome.getText(),
                descInsumo = tfDescricao.getText();
        Insumo insum = new Insumo(idInsumo, idItemEstoque, nomeInsumo, descInsumo);
        InsumoDAO dao = new InsumoDAO();
        if (dao.insereInsumo(insum)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Insumo cadastrado com sucesso!");
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Erro ao cadastrar insumo!");
            alert.show();
        }
    }

    public void fechaJanela() {
        CadastroInsumo.getStage().close();
    }

}
