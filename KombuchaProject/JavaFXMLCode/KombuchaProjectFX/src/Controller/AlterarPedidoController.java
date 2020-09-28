/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PedidoDAO;
import Model.AlterarPedido;
import Model.BatmanDeFerro;
import Model.GerenciaPedido;
import Model.Pedido;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    private static Pedido ped;

    @FXML private Label lblIdFuncionarioAtivo;
    @FXML private Label lblIdPedido;
    @FXML private Label lblIdFuncionario;
    @FXML private Label lblSabor;
    @FXML private TextField tfQuantidade;
    @FXML private Button btVoltar;
    @FXML private Button btAtualizarPedido;
    @FXML private Button btFinalizarSessao;

    public static Pedido getPed() {
        return ped;
    }

    public static void setPed(Pedido ped) {
        AlterarPedidoController.ped = ped;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initAltPedido();

        btAtualizarPedido.setOnMouseClicked((MouseEvent e)->{

            try {
                atualizaPedido();

            } catch (Exception ex) {
                Logger.getLogger(AlterarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btAtualizarPedido.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){

                try {
                    atualizaPedido();
 
                } catch (Exception ex) {
                    Logger.getLogger(AlterarPedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());
        lblIdPedido.setText(Integer.toString(ped.getIdPedido()));
        lblIdFuncionario.setText(BatFer.getIdFuncionarioAtivo());
        lblSabor.setText(ped.getNomeSabor());
        tfQuantidade.setText(Integer.toString(ped.getQtdProducao()));        
    }
    
    public void atualizaPedido() throws Exception{   
        int idPedido = Integer.parseInt(lblIdPedido.getText());
        String idFuncionario = lblIdFuncionario.getText();
        int qtdProducao = Integer.parseInt(tfQuantidade.getText());
       
        PedidoDAO dao = new PedidoDAO();
        Pedido pedidoCorrigido = new Pedido(idPedido, idFuncionario, qtdProducao);
        if(dao.updatePedido(pedidoCorrigido)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Pedido atualizado com sucesso!");
            alert.show();   
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao atualizar pedido!");                
            alert.show();
        }
    }
}
