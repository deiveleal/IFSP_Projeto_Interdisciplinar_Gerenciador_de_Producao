/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.PedidoDAO;
import Model.Pedido;
import Model.PopConfirmaQuantPedido;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 * @author carolina
 * @author Deive
 */
public class PopConfirmaQuantPedidoController implements Initializable {

    @FXML private Label lblIdPedido;
    @FXML private Label lblSabor;
    @FXML private Label lblQtdProducao;
    @FXML private Label lblIdFermentador;
    @FXML private Label lblQtdExtrato;
    @FXML private Label lblQtdAgua;
    @FXML private Label lblQtdAcucar;
    @FXML private Label lblQtdEmbalagem;
    @FXML private Button btOK;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initRelatorioPedido();
        
        btOK.setOnMouseClicked((MouseEvent e)->{
            fechaJanela();  
        });
        btOK.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                fechaJanela();  
            }
        });
    }    
    public void initRelatorioPedido(){
        DecimalFormat df = new DecimalFormat("#0.000#"); 
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> ultimoPedido = dao.selectUltimoPedido();
        lblIdPedido.setText(Integer.toString(ultimoPedido.get(0).getIdPedido()));
        lblSabor.setText(ultimoPedido.get(0).getNomeSabor());
        lblQtdProducao.setText(Integer.toString(ultimoPedido.get(0).getQtdProducao()));
        lblIdFermentador.setText(Integer.toString(ultimoPedido.get(0).getIdFermentador()));
        lblQtdExtrato.setText(df.format(ultimoPedido.get(0).getQuantidadeCha()));
        lblQtdAgua.setText(df.format(ultimoPedido.get(0).getQuantidadeAgua()));
        lblQtdAcucar.setText(df.format(ultimoPedido.get(0).getQuantidadeAcucar()));
        lblQtdEmbalagem.setText(Integer.toString(ultimoPedido.get(0).getQuantidadeEmbalagem()));
    }
    public void fechaJanela(){
        PopConfirmaQuantPedido.getStage().close();
    }  
    
}
