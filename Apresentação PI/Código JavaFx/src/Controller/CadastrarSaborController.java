/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SaborKombuchaDAO;
import Model.BatmanDeFerro;
import Model.CadastrarSabor;
import Model.GerenciaPedido;
import Model.SaborKombucha;
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
 * @author deive
 */
public class CadastrarSaborController implements Initializable {

    BatmanDeFerro BatFer = new BatmanDeFerro();

    @FXML
    private TextField tfIdKombucha;
    @FXML
    private TextField tfNomeKombucha;
    @FXML
    private TextField tfChaBase;
    @FXML
    private TextField tfIdChaBase;
    @FXML
    private TextField tfPrePreparoQuantCha;
    @FXML
    private TextField tfQuantidadeAgua;
    @FXML
    private TextField tfPrePreparoQuantAcucar;
    @FXML
    private TextField tfIdEmbalagem;
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
            cadastraSabor();
        });
        btCadastrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                cadastraSabor();
            }
        });

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            GerenciaPedido gerPed = new GerenciaPedido();

            try {
                gerPed.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaPedido gerPed = new GerenciaPedido();
                try {
                    gerPed.start(new Stage());
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

    public void cadastraSabor() {
        int idKombucha = Integer.parseInt(tfIdKombucha.getText()),
                idChaBase = Integer.parseInt(tfIdChaBase.getText()),
                idEmbalagem = Integer.parseInt(tfIdEmbalagem.getText());
        String nomeKombucha = tfNomeKombucha.getText(),
                chaBase = tfChaBase.getText();
        double qtdCha = Double.parseDouble(tfPrePreparoQuantCha.getText()),
                qtdAgua = Double.parseDouble(tfQuantidadeAgua.getText()),
                qtdAcucar = Double.parseDouble(tfPrePreparoQuantAcucar.getText());

        SaborKombucha saborKombucha = new SaborKombucha(idKombucha, nomeKombucha,
                chaBase, idChaBase, qtdCha,
                qtdAgua, qtdAcucar, idEmbalagem);
        SaborKombuchaDAO saborKombuchaDao = new SaborKombuchaDAO();
        if (saborKombuchaDao.insertSaborKombucha(saborKombucha)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Sabor cadastrado com sucesso!");
            alert.show();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Erro ao cadastrar novo sabor!");
            alert.show();
        }
    }

    public void fechaJanela() {
        CadastrarSabor.getStage().close();
    }

}
