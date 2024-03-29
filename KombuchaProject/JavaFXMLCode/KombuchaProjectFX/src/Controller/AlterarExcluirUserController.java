package Controller;

import DAO.FuncionarioDAO;
import Model.AlteraDadosFuncionario;
import Model.AlterarExcluirUser;
import Model.BatmanDeFerro;
import Model.Funcionario;
import Model.GerenciaUsuario;
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
import javafx.scene.control.Alert.AlertType;
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
 * @author carolina
 * @author deive
 */
public class AlterarExcluirUserController implements Initializable {

    private ObservableList<Funcionario> funcionarioList = FXCollections.observableArrayList();
    private Funcionario funcSelecionado;
    BatmanDeFerro BatFer = new BatmanDeFerro();

    @FXML
    private Button btExcluirUser;
    @FXML
    private TableView<Funcionario> tableUser;
    @FXML
    private TableColumn<Funcionario, String> tbcolCPF;
    @FXML
    private TableColumn<Funcionario, String> tbcolNome;
    @FXML
    private TableColumn<Funcionario, String> tbcolCargo;
    @FXML
    private Button btVoltar;
    @FXML
    private TextField tfBusca;
    @FXML
    private Button btAlteraDados;
    @FXML
    private Button btFinalizarSessao;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();

        tableUser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                funcSelecionado = (Funcionario) newValue;
            }
        });

        btAlteraDados.setOnMouseClicked((MouseEvent e) -> {
            if (funcSelecionado != null) {
                AlteraDadosFuncionario altDadFunc = new AlteraDadosFuncionario(funcSelecionado);
                try {
                    altDadFunc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(AlterarExcluirUserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(AlertType.WARNING);
                a.setHeaderText("Nenhum funcionário selecionado!");
                a.show();
            }
        });
        btAlteraDados.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (funcSelecionado != null) {
                    AlteraDadosFuncionario altDadFunc = new AlteraDadosFuncionario(funcSelecionado);
                    try {
                        altDadFunc.start(new Stage());
                        fechaJanela();
                    }
                    catch (Exception ex) {
                        Logger.getLogger(AlterarExcluirUserController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(AlertType.WARNING);
                    a.setHeaderText("Nenhum funcionário selecionado!");
                    a.show();
                }
            }
        });

        btExcluirUser.setOnMouseClicked((MouseEvent e) -> {
            try {
                deleta();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btExcluirUser.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    deleta();
                }
                catch (Exception ex) {
                    Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btVoltar.setOnMouseClicked((MouseEvent e) -> {
            GerenciaUsuario geruser = new GerenciaUsuario();

            try {
                geruser.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                GerenciaUsuario geruser = new GerenciaUsuario();

                try {
                    geruser.start(new Stage());
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
            tableUser.setItems(buscaFuncionario());
        });

    }

    public void fechaJanela() {
        AlterarExcluirUser.getStage().close();
    }

    public void initTable() {
        tbcolCPF.setCellValueFactory(new PropertyValueFactory("idFuncionario"));
        tbcolNome.setCellValueFactory(new PropertyValueFactory("nomeFuncionario"));
        tbcolCargo.setCellValueFactory(new PropertyValueFactory("cargo"));

        tableUser.setItems(atualizaTabela());
    }

    public ObservableList<Funcionario> atualizaTabela() {
        FuncionarioDAO dao = new FuncionarioDAO();
        funcionarioList = FXCollections.observableArrayList(dao.getList());
        return funcionarioList;
    }

    public void deleta() {
        if (funcSelecionado != null) {
            FuncionarioDAO dao = new FuncionarioDAO();
            dao.delete(funcSelecionado);
            Alert a = new Alert(AlertType.CONFIRMATION);
            a.setHeaderText("Funcionário deletado com sucesso!");
            a.show();
            tableUser.setItems(atualizaTabela());
        } else {
            Alert a = new Alert(AlertType.WARNING);
            a.setHeaderText("Nenhum funcionário selecionado!");
            a.show();
        }
    }

    private ObservableList<Funcionario> buscaFuncionario() {
        ObservableList<Funcionario> pesquisaFuncionario = FXCollections.observableArrayList();
        for (int x = 0; x < funcionarioList.size(); x++) {
            if (funcionarioList.get(x).getNomeFuncionario().toLowerCase().contains(tfBusca.getText().toLowerCase())) {
                pesquisaFuncionario.add(funcionarioList.get(x));
            }
        }
        return pesquisaFuncionario;
    }

}
