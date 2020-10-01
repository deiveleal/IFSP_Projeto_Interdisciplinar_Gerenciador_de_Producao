/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EstoqueDAO;
import Model.AlterarQuantidadeEstoque;
import Model.BatmanDeFerro;
import Model.CadastroInsumo;
import Model.Estoque;
import Model.GerenciaEstoque;
import Model.MenuPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deive
 */
public class GerenciaEstoqueController implements Initializable {

    private ObservableList<Estoque> estoqueList = FXCollections.observableArrayList();
    private Estoque itemSelecionado;
    BatmanDeFerro BatFer = new BatmanDeFerro();

    @FXML
    private Button btCadastrarItem;
    @FXML
    private TableView<Estoque> tableEstoque;
    @FXML
    private TableColumn<Estoque, Integer> colIdEstoque;
    @FXML
    private TableColumn<Estoque, Integer> colItemEstoque;
    @FXML
    private TableColumn<Estoque, String> colNome;
    @FXML
    private TableColumn<Estoque, Double> colQuantidade;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btFinalizarSessao;
    @FXML
    private TextField tfBusca;
    @FXML
    private Button btAlterarQtd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initTable();

        tableEstoque.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                itemSelecionado = (Estoque) newValue;
            }
        });

        btCadastrarItem.setOnMouseClicked((MouseEvent e) -> {
            CadastroInsumo cadInsumo = new CadastroInsumo();
            try {
                cadInsumo.start(new Stage());
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechaJanela();
        });
        btCadastrarItem.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastroInsumo cadInsumo = new CadastroInsumo();
                try {
                    cadInsumo.start(new Stage());
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
                }
                fechaJanela();
            }
        });

        btAlterarQtd.setOnMouseClicked((MouseEvent e) -> {
            if (itemSelecionado != null) {
                AlterarQuantidadeEstoque altEstoq = new AlterarQuantidadeEstoque(itemSelecionado);

                try {
                    altEstoq.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum item selecionado!");
                a.show();
            }
        });
        btAlterarQtd.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (itemSelecionado != null) {
                    AlterarQuantidadeEstoque altEstoq = new AlterarQuantidadeEstoque(itemSelecionado);

                    try {
                        altEstoq.start(new Stage());
                        fechaJanela();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum item selecionado!");
                    a.show();
                }
            }
        });

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipal menu = new MenuPrincipal();

            try {
                menu.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipal menu = new MenuPrincipal();

                try {
                    menu.start(new Stage());
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

        tfBusca.setOnKeyReleased((KeyEvent e) -> {
            tableEstoque.setItems(buscaEstoque());
        });
    }

    public void fechaJanela() {
        GerenciaEstoque.getStage().close();
    }

    public void initTable() {
        colIdEstoque.setCellValueFactory(new PropertyValueFactory("idItem"));
        colItemEstoque.setCellValueFactory(new PropertyValueFactory("idItemEstoque"));
        colNome.setCellValueFactory(new PropertyValueFactory("nomeItem"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory("qtdItem"));

        tableEstoque.setItems(atualizaTabela());
    }

    public ObservableList<Estoque> atualizaTabela() {
        EstoqueDAO dao = new EstoqueDAO();
        estoqueList = FXCollections.observableArrayList(dao.getList());
        return estoqueList;
    }

    private ObservableList<Estoque> buscaEstoque() {
        ObservableList<Estoque> pesquisaEstoque = FXCollections.observableArrayList();
        for (int x = 0; x < estoqueList.size(); x++) {
            if (estoqueList.get(x).getNomeProduto().toLowerCase().contains(tfBusca.getText().toLowerCase())) {
                pesquisaEstoque.add(estoqueList.get(x));
            }
        }
        return pesquisaEstoque;
    }

}
