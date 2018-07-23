/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Usuario;
import view.CadastroRegistro;

/**
 *
 * @author Mateus
 */
public class CadastroRegistroController implements Initializable {
    
    @FXML
    private TextField textoLogin,nome,login,telefone;
    @FXML
    private PasswordField senha,confirmarSenha,textoSenha;
    @FXML
    private Label senhaMalConfirmada, messageUsuarioInexistente, messageWrongPassword;
    
    @FXML
    protected void registrar(ActionEvent event) {
        ControllerRegistro controller = new ControllerRegistro();
        try {
            senhaMalConfirmada.setVisible(false);
            nome.clear();
            login.clear();
            telefone.clear();
            senha.clear();
            confirmarSenha.clear();
            controller.registrarUsuario(nome.getText(), login.getText(),
                    telefone.getText(), senha.getText(), confirmarSenha.getText());
        } catch (ControllerRegistro.SenhaMalConfirmadaException ex) {
            senhaMalConfirmada.setVisible(true);
        }
    }
    
    @FXML
    protected void logar(ActionEvent event) {
        ControllerLogin controller = new ControllerLogin();
        try{
            messageUsuarioInexistente.setVisible(false);
            messageWrongPassword.setVisible(false);
            Usuario user = controller.login(textoLogin.getText(), textoSenha.getText());
            textoLogin.clear();
            textoSenha.clear();
            CadastroRegistro.changeScene("paginaInicial");
        }catch(ControllerLogin.UsuarioInexistenteException e){
            messageUsuarioInexistente.setVisible(true);
        }catch(ControllerLogin.SenhaIncorretaException e){
            messageWrongPassword.setVisible(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
