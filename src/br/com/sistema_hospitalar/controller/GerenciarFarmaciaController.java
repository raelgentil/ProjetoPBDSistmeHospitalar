/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.enums.Panes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class GerenciarFarmaciaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button vender;

    @FXML
    private Button gerenciar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gerenciar.setOnMouseClicked((event) -> {
            Controlador.trocarPane(Panes.visualizarInsumo);
        });
    }    
    
}
