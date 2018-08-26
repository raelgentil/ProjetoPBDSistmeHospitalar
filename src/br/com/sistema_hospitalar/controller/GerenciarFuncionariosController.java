/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;


import br.com.sistema_hospitalar.enums.Enums;
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
public class GerenciarFuncionariosController implements Initializable {
    private Enum opcao;
    private static GerenciarFuncionariosController cont;
    @FXML
    private Button admBotao;
    
    @FXML
    private Button atendenteBotao;
    
     @FXML
    private Button resetarBotao;
    
    @FXML
    private Button saudeBotao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cont = this;
        admBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar,Enums.adm);
        });
        atendenteBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar,Enums.atendente);
        });
        saudeBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.visualizar,Enums.ProfSaude);
        });
        resetarBotao.setOnMouseClicked((MouseEvent) -> {
            Controlador.trocarPane(Panes.resetSenha);
        });
        
    }
    public Enum getOpcao(){
        return opcao;
    }
    public static GerenciarFuncionariosController get(){
        return cont;
    }
}
