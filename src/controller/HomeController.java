/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class HomeController implements Initializable {
    
    private static HomeController controller = null;
    private Pane anterior;
    @FXML
    private StackPane pane;
     @FXML
    private Label nomeUsuario;

    @FXML
    private ImageView usuario;

    @FXML
    private ImageView sairSessao;

    @FXML
    private ImageView home;

    @FXML
    private ImageView voltar;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        voltar.setOnMouseClicked((MouseEvent e)->{
           voltar();
        });
        
    
    }
    public void alterarPane(Pane p){
        anterior = (Pane) pane;
        pane.getChildren().setAll(p);
    }
    private void voltar(){
        if(anterior != null){
        Pane aux = pane;
        pane.getChildren().setAll(anterior);
        anterior = aux;
        }
    }
    public static HomeController get(){
        return controller;
    }
    
    
}
