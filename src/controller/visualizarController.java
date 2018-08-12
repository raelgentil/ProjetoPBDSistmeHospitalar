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
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class visualizarController implements Initializable {

    
      @FXML
    private TableView<?> tabela;

    @FXML
    private Button cadastrarBotao;

    @FXML
    private Button editarBotao;

    @FXML
    private Button excluirBotao;

    @FXML
    private TextField pesquisa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
