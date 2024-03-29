/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.LoginDAO;
import Model.BatmanDeFerro;
import Model.Login;
import Model.MenuPrincipal;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Carolina
 * @author Deive
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField pfSenha;
    @FXML
    private Button btSair;
    @FXML
    private Button btEntrar;

    Login login = new Login();
    LoginDAO dao = new LoginDAO();
    BatmanDeFerro BatFer = new BatmanDeFerro();
    private static String idLoginAtivo;

    public String getIdLoginAtivo() {
        return idLoginAtivo;
    }

    public void setIdLoginAtivo(String idLoginAtivo) {
        this.idLoginAtivo = idLoginAtivo;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btEntrar.setOnMouseClicked((MouseEvent e) -> {
            logar();
        });
        btEntrar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });

        pfSenha.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });

        btSair.setOnMouseClicked((MouseEvent e) -> {
            fechaJanela();
        });
        btSair.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                fechaJanela();
            }

        });
    }

    public void fechaJanela() {
        Login.getStage().close();
    }

    public void logar() {
        try {
            if (dao.login(tfLogin.getText(), pfSenha.getText())) {
                MenuPrincipal menu = new MenuPrincipal();

                try {
                    menu.start(new Stage());
                    BatFer.setIdFuncionarioAtivo(tfLogin.getText());
                    //setIdLoginAtivo(tfLogin.getText());
                    System.out.println("Login: " + BatFer.getIdFuncionarioAtivo());
                    fechaJanela();
                    BatFer.printaUsuario();
                }
                catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Erro!");
                alert.setHeaderText("Login Inválido!");
                alert.setContentText("Erro de Login ou Senha!");
                alert.show();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
