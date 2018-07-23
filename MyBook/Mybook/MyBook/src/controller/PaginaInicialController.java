/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import view.CadastroRegistro;

/**
 * FXML Controller class
 *
 * @author Mateus
 */

public class PaginaInicialController implements Initializable {
    @FXML
    private ImageView exitImage;
    private final Image exitButton = new Image("view/SairDaConta.png");
    private final Image buttonPressed = new Image("view/buttonPressed.png");
    
    @FXML
    protected void sair(){
        CadastroRegistro.changeScene("cadastroRegistro");
    }
    
    @FXML
    protected void mouseMoved() {
        exitImage.setImage(buttonPressed);
    }
    
    @FXML
    protected void mouseExited() {
        exitImage.setImage(exitButton);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
