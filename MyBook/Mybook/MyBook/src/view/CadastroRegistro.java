/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mateus
 */
public class CadastroRegistro extends Application {
    
    private static Stage stage;
    
    private static Scene cadastroRegistro;
    private static Scene paginaInicial;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        
        Parent fxmlCadastroRegistro = FXMLLoader.load(getClass().getResource("FXMLCadastroRegistro.fxml"));
        cadastroRegistro = new Scene(fxmlCadastroRegistro, 800, 600);
        Parent fxmlPaginaInicial = FXMLLoader.load(getClass().getResource("FXMLPaginaInicial.fxml"));
        paginaInicial = new Scene(fxmlPaginaInicial, 800, 600);
        
        primaryStage.setScene(cadastroRegistro);
        primaryStage.show();
    }
    
    public static void changeScene(String name){
        switch(name){
            case "cadastroRegistro":
                stage.setScene(cadastroRegistro);
                break;
            case "paginaInicial":
                stage.setScene(paginaInicial);
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
