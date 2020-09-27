/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.AlterarQuantidadeEstoqueController;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Carolina
 * @author Deive
 */
public class AlterarQuantidadeEstoque {
    
    public AlterarQuantidadeEstoque(Estoque estoq){
        AlterarQuantidadeEstoqueController.setEstoqAlt(estoq);
    }    
    public AlterarQuantidadeEstoque() {
    }
    
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AlterarQuantidadeEstoque.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.setTitle("Alterar Quantidade de Produtos em Estoque");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AlterarQuantidadeEstoque.stage = stage;
    }
    
}
