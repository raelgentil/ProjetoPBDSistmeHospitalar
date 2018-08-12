/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package controller;

import enums.Panes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class GerenciarFuncionariosController implements Initializable {
    
   @FXML
    private Button admBotao;

    @FXML
    private Button atendenteBotao;

    @FXML
    private Button saudeBotao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        admBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar);
        });
        atendenteBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar);
        });
        saudeBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar);
        });
    }
    
}
