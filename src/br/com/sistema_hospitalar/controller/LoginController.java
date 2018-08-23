/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    @FXML
    private AnchorPane pane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botao.setOnMouseClicked((MouseEvent e)->{
            logar();
        });
        senha.setOnKeyReleased((event) -> {
            if(event.getCode() == KeyCode.ENTER)
                logar();
        });
        login.setOnKeyReleased((event) -> {
            if(event.getCode() == KeyCode.ENTER)
                senha.requestFocus();
        });
        resetSenha.setOnMouseClicked((event) -> {
            String cpf = Mensagens.inserirTexto("Reset de Senha", "Insira seu CPF", "");
            if(cpf != null){
                System.out.println("CPF: "+cpf);
                if(Controlador.FACHADA.solicitarResetSenha(cpf))
                    Mensagens.informacao("Solicitação de Reset de realizada com sucesso!", "Quando o reset de senha for aprovado pelo administrador, voê deverá logar com a senha padrão!");
                else
                    Mensagens.erro("Erro ao realizar solicitação de Reset", "Verifique o CPF informado!");
            }
        });
    }
    private boolean logar(){
        Funcionario f = Controlador.FACHADA.funcionarioBuscarUsuario(login.getText(), senha.getText());
        if(f != null){
            Controlador.setUsuarioLogado(f);
            Controlador.trocarTela("principal");
            Controlador.trocarPane(Panes.inicioSU);
            Controlador.limparPane(pane);
            return true;
        }
        Mensagens.erro("Credenciais Inválidas", "Dados de Login e/ou senha estão incorretos!");
        return false;
    }
    
}
