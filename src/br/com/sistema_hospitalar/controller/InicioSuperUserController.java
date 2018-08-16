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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class InicioSuperUserController implements Initializable {
    
     
    @FXML
    private Button funcionarioBotao;

    @FXML
    private Button pacienteBotao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        funcionarioBotao.setOnMouseClicked((MouseEvent e)->{
            Controlador.trocarPane(Panes.gerenciarFunc);
          // Controlador.trocarTela("login");
           //HomeController.setPane(Controlador.gera(url,"InicioSuperUser"));
        });
        
        pacienteBotao.setOnMouseClicked((MouseEvent e)->{
            Controlador.trocarPane(Panes.visualizar);
          // Controlador.trocarTela("login");
           //HomeController.setPane(Controlador.gera(url,"InicioSuperUser"));
        });
    }    
    
}
