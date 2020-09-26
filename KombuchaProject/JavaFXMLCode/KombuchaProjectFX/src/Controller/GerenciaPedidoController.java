/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.PedidoDAO;
import Model.BatmanDeFerro;
import Model.GerenciaPedido;
import Model.MenuPrincipal;
import Model.Pedido;
import java.net.URL;
import java.util.Date;
import java.util.List;
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
 * @author deive
 */
public class GerenciaPedidoController implements Initializable {
    @FXML private Button btExcluiPedido;
    @FXML private Button btInserirPedido;
    @FXML private Button btCadastrarSabor;
    @FXML private TextField tfQuantidade;
    @FXML private TableView<Pedido> tablePedidos;
    @FXML private TableColumn<Pedido, Integer> colCodPedido;
    @FXML private TableColumn<Pedido, Integer> colSabor;
    @FXML private TableColumn<Pedido, Integer> colQtd;
    @FXML private TableColumn<Pedido, Date> colData;
    @FXML private ComboBox<?> cbSabors;
    @FXML private Button btVoltar;
    @FXML private TextField tfBusca;
    @FXML private Button btAlterarPedido;
    @FXML private Button btFinalizarSessao;
    @FXML private Label lblIdFuncionarioAtivo;
    
    PedidoDAO dao = new PedidoDAO();
    BatmanDeFerro BatFer = new BatmanDeFerro();
    
    private Pedido ped;
    
    public Pedido getPed() {
        return ped;
    }
    public void setPed(Pedido ped) {
        this.ped = ped;
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());     
        initTable();
        listaPedidos();
        
        tablePedidos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object  newValue){
                ped = (Pedido) newValue;           
            }       
        }); 
        
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
    
    public void initTable(){
        colCodPedido.setCellValueFactory(new PropertyValueFactory("idPedido"));
        colSabor.setCellValueFactory(new PropertyValueFactory("idSabor"));
        colQtd.setCellValueFactory(new PropertyValueFactory("qtdProducao")); 
        colData.setCellValueFactory(new PropertyValueFactory("dataPedido")); 
        
        tablePedidos.setItems(atualizaTabela());
    }      
    
    public ObservableList<Pedido> atualizaTabela(){
        return FXCollections.observableArrayList(dao.getList());
    }
    
    public void deleta(){
        if (ped != null){
            dao.deletaPedido(ped);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Pedido deletado com sucesso!");            
            a.show(); 
            tablePedidos.setItems(atualizaTabela());
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Nenhum Pedido selecionado!");
            a.show();            
        }
    }   
        
    public void listaPedidos(){
        List<Pedido> pedido = new PedidoDAO().getList();
        System.out.println("Listando Pedidos");
        for (int x = 0; x < pedido.size(); x++){
            pedido.get(x).mostraPedido();
        }
    }
    
}
