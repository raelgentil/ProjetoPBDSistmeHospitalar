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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtemail;
    
    

    @FXML
    private TextField txtsenha;

    @FXML
    private Button botao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botao.setOnMouseClicked((MouseEvent e)->{
            System.out.println("Logado "+ txtemail.getText());
            Controlador.trocarTela("principal");
            Controlador.trocarPane(Panes.inicioSU);
           //HomeController.setPane(Controlador.gera(url,"InicioSuperUser"));
        });
    }    
    
}
