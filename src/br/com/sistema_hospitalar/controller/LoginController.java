/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Panes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class LoginController implements Initializable {

    @FXML
    private TextField login;
    @FXML
    private PasswordField senha;
    @FXML
    private Button botao;
    @FXML
    private Label resetSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botao.setOnMouseClicked((MouseEvent e)->{
            Mensagens.informacao("Login","Logado "+ login.getText());
            Controlador.trocarTela("principal");
            Controlador.trocarPane(Panes.inicioSU);
        });
        resetSenha.setOnMouseClicked((event) -> {
            String cpf = Mensagens.inserirTexto("Reset de Senha", "Insira seu CPF", "");
            if(cpf != null){
                System.out.println("CPF: "+cpf);
                Controlador.FACHADA.solicitarResetSenha(cpf);
//                Mensagens.informacao("Solicitação de Reset de realizada com sucesso!", "Quando o reset de senha for aprovado pelo administrador, voê deverá logar com a senha padrão!");
            }
        });
    }    
    
}
