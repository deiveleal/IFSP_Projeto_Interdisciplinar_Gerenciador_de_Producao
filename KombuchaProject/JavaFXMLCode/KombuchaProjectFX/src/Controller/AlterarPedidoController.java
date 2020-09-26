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
import Model.GerenciaPedido;
import Model.Pedido;
import Model.SaborKombucha;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
public class AlterarPedidoController implements Initializable {
    BatmanDeFerro BatFer = new BatmanDeFerro();
    private ObservableList<SaborKombucha> obsSaborKombucha;

    
    @FXML private Label lblIdFuncionarioAtivo;
    @FXML private Label lblIdPedido;
    @FXML private Label lblIdFuncionario;
    @FXML private TextField tfQuantidade;
    @FXML private Button btVoltar;
    @FXML private Button btAtualizarPedido;
    @FXML private Button btFinalizarSessao;
    @FXML private ComboBox<SaborKombucha> cbListSabores;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initAltPedido();
        // TODO
        btAtualizarPedido.setOnMouseClicked((MouseEvent e)->{
            try {
                atualizaPedido();
            } catch (Exception ex) {
                Logger.getLogger(AlterarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechaJanela();  
        });
        btAtualizarPedido.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                try {
                    atualizaPedido();
                } catch (Exception ex) {
                    Logger.getLogger(AlterarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                fechaJanela();  
            }
        });
        
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            GerenciaPedido gerPedido = new GerenciaPedido();
          
            try {
                gerPedido.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(GerenciaUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                GerenciaPedido gerPedido = new GerenciaPedido();
          
                try {
                    gerPedido.start(new Stage());
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
        AlterarPedido.getStage().close();
    }    
    
    public void initAltPedido(){
        Pedido pedidoInit = new Pedido();
        lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());
        lblIdPedido.setText(Integer.toString(pedidoInit.getIdPedido()));
        lblIdFuncionario.setText(BatFer.getIdFuncionarioAtivo());
        cbListSabores.setItems(saboresCombobox());
        tfQuantidade.setText(Integer.toString(pedidoInit.getQtdProducao()));    
    }
    
    public void atualizaPedido() throws Exception{
        Pedido pedidoBase = new Pedido();
        int idPedido = pedidoBase.getIdPedido();
        String idFuncionario = BatFer.getIdFuncionarioAtivo();
        String nomeSabor = cbListSabores.getValue().toString(); 
        int qtdProducao = Integer.parseInt(tfQuantidade.getText());
       
        PedidoDAO dao = new PedidoDAO();
        Pedido pedidoCorrigido = new Pedido(idPedido, idFuncionario, nomeSabor, qtdProducao);
        if(dao.updatePedido(pedidoCorrigido)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Pedido atualizado com sucesso!");
            alert.show();
            fechaJanela();            
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao atualizar pedido!");                
            alert.show();
            fechaJanela();
        }
    }
    public ObservableList<SaborKombucha> saboresCombobox(){
        SaborKombuchaDAO dao = new SaborKombuchaDAO();
        obsSaborKombucha = FXCollections.observableArrayList(dao.saboresList());
        return obsSaborKombucha;        
    }    
}
