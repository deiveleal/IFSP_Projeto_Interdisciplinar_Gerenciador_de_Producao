/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PedidoDAO;
import DAO.SaborKombuchaDAO;
import Model.AlterarPedido;
import Model.BatmanDeFerro;
import Model.CadastrarSabor;
import Model.GerenciaPedido;
import Model.MenuPrincipal;
import Model.Pedido;
import Model.PopConfirmaQuantPedido;
import Model.SaborKombucha;
import java.net.URL;
import java.util.Date;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
 * @author carolina
 * @author deive
 */
public class GerenciaPedidoController implements Initializable {

    private ObservableList<Pedido> pedidoList = FXCollections.observableArrayList();
    private Pedido pedidoSelecionado;
    private ObservableList<SaborKombucha> obsSaborKombucha;
    BatmanDeFerro BatFer = new BatmanDeFerro();
    SaborKombuchaDAO saborKDAO = new SaborKombuchaDAO();

    @FXML
    private Label lblIdFuncionarioAtivo;
    @FXML
    private ComboBox<SaborKombucha> cbSabores;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private TextField tfBusca;
    @FXML
    private Button btCadastrarSabor;
    @FXML
    private Button btInserirPedido;
    @FXML
    private Button btAlterarPedido;
    @FXML
    private Button btExcluiPedido;
    @FXML
    private TableView<Pedido> tablePedidos;
    @FXML
    private TableColumn<Pedido, Integer> colCodPedido;
    @FXML
    private TableColumn<Pedido, String> colSabor;
    @FXML
    private TableColumn<Pedido, Integer> colQtd;
    @FXML
    private TableColumn<Pedido, Date> colData;
    @FXML
    private Button btVoltar;
    @FXML
    private Button btFinalizarSessao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initIdFuncionarioAtivo();
        initTable();

        tablePedidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                pedidoSelecionado = (Pedido) newValue;
            }
        });

        btAlterarPedido.setOnMouseClicked((MouseEvent e) -> {
            if (pedidoSelecionado != null) {
                AlterarPedido alteraPedido = new AlterarPedido(pedidoSelecionado);
                try {
                    alteraPedido.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum pedido selecionado!");
                a.show();
            }
        });
        btAlterarPedido.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (pedidoSelecionado != null) {
                    AlterarPedido alteraPedido = new AlterarPedido(pedidoSelecionado);
                    try {
                        alteraPedido.start(new Stage());
                        fechaJanela();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(GerenciaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum pedido selecionado!");
                    a.show();
                }
            }
        });

        btCadastrarSabor.setOnMouseClicked((MouseEvent e) -> {
            CadastrarSabor cadSabor = new CadastrarSabor();
            try {
                cadSabor.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btCadastrarSabor.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastrarSabor cadSabor = new CadastrarSabor();
                try {
                    cadSabor.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btInserirPedido.setOnMouseClicked((MouseEvent e) -> {
            inserePedido();
        });
        btInserirPedido.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                inserePedido();
            }
        });

        btExcluiPedido.setOnMouseClicked((MouseEvent e) -> {
            try {
                deleta();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btExcluiPedido.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    deleta();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
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
            tablePedidos.setItems(buscaPedido());
        });

    }

    public void fechaJanela() {
        GerenciaPedido.getStage().close();
    }

    public void initTable() {
        cbSabores.setItems(saboresCombobox());
        colCodPedido.setCellValueFactory(new PropertyValueFactory("idPedido"));
        colSabor.setCellValueFactory(new PropertyValueFactory("nomeSabor"));
        colQtd.setCellValueFactory(new PropertyValueFactory("qtdProducao"));
        colData.setCellValueFactory(new PropertyValueFactory("dataPedido"));

        tablePedidos.setItems(atualizaTabela());
    }

    public ObservableList<Pedido> atualizaTabela() {
        PedidoDAO dao = new PedidoDAO();
        pedidoList = FXCollections.observableArrayList(dao.getList());
        return pedidoList;
    }

    public void deleta() {
        if (pedidoSelecionado != null) {
            PedidoDAO dao = new PedidoDAO();
            dao.deletaPedido(pedidoSelecionado);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Pedido deletado com sucesso!");
            a.show();
            tablePedidos.setItems(atualizaTabela());
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Nenhum Pedido selecionado!");
            a.show();
        }
    }

    /*
    public void listaPedidos(){
        List<Pedido> pedido = new PedidoDAO().getList();
        System.out.println("Listando Pedidos");
        for (int x = 0; x < pedido.size(); x++){
            pedido.get(x).mostraPedido();
        }
    }*/

    public void initIdFuncionarioAtivo() {
        lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());
    }

    public ObservableList<SaborKombucha> saboresCombobox() {
        obsSaborKombucha = FXCollections.observableArrayList(saborKDAO.saboresList());
        return obsSaborKombucha;
    }

    public void inserePedido() {
        String idFuncionarioAtivo = BatFer.getIdFuncionarioAtivo(),
                nomeSabor = cbSabores.getValue().toString();
        int quantidadeProducao = Integer.parseInt(tfQuantidade.getText());

        Pedido novoPedido = new Pedido(idFuncionarioAtivo, nomeSabor, quantidadeProducao);
        PopConfirmaQuantPedido confped = new PopConfirmaQuantPedido();
        PedidoDAO dao = new PedidoDAO();

        if (dao.inserePedido(novoPedido)) {
            try {
                confped.start(new Stage());
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            //alert.setHeaderText("Pedido inserido com sucesso!");
            //alert.show();
            tablePedidos.setItems(atualizaTabela());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao inserir novo pedido!");
            alert.show();
        }
    }

    private ObservableList<Pedido> buscaPedido() {
        ObservableList<Pedido> pesquisaPedido = FXCollections.observableArrayList();
        for (int x = 0; x < pedidoList.size(); x++) {
            if (pedidoList.get(x).getNomeSabor().toLowerCase().contains(tfBusca.getText().toLowerCase())) {
                pesquisaPedido.add(pedidoList.get(x));
            }
        }
        return pesquisaPedido;
    }

}
