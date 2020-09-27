/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AlterarQuantidadeEstoque;
import Model.BatmanDeFerro;
import Model.Estoque;
import Model.GerenciaEstoque;
import Model.MenuPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
 * @author Deive
 */
public class AlterarQuantidadeEstoqueController implements Initializable {
    BatmanDeFerro BatFer = new BatmanDeFerro();
    private static Estoque estoqAlt;
    
    @FXML private Label lblIdFuncionarioAtivo;
    @FXML private TextField tfQtdReposicao;
    @FXML private Label lblIdItem;
    @FXML private Label lblIdItemEstoque;
    @FXML private Label lblNome;
    @FXML private Button btVoltar;
    @FXML private Button btInserirReposicao;
    @FXML private Button btFinalizarSessao;

    public static Estoque getEstoqAlt() {
        return estoqAlt;
    }

    public static void setEstoqAlt(Estoque estoqAlt) {
        AlterarQuantidadeEstoqueController.estoqAlt = estoqAlt;
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initAlterQtdEstoque(); 
        
        
        
        // TODO
        
        
        
        btVoltar.setOnMouseClicked((MouseEvent e)->{
            GerenciaEstoque gerEstoque = new GerenciaEstoque();
         
            try {
                gerEstoque.start(new Stage());
                fechaJanela();  
            } catch (Exception ex) {
                Logger.getLogger(AlterarQuantidadeEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btVoltar.setOnKeyPressed((KeyEvent e)->{
            if(e.getCode() == KeyCode.ENTER){
                GerenciaEstoque gerEstoque = new GerenciaEstoque();
           
                try {
                    gerEstoque.start(new Stage());
                    fechaJanela();  
                } catch (Exception ex) {
                    Logger.getLogger(AlterarQuantidadeEstoqueController.class.getName()).log(Level.SEVERE, null, ex);
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
        AlterarQuantidadeEstoque.getStage().close();
    }
        
    public void initAlterQtdEstoque(){
            lblIdFuncionarioAtivo.setText(BatFer.getIdFuncionarioAtivo());
            lblIdItem.setText(Integer.toString(estoqAlt.getIdItem()));
            lblIdItemEstoque.setText(Integer.toString(estoqAlt.getIdItemEstoque()));
            lblNome.setText(estoqAlt.getNomeItem());
            tfQtdReposicao.setText(Double.toString(estoqAlt.getQtdItem()));                    
    }
    
    public void insereEstok(){
    
    }    
    
}
