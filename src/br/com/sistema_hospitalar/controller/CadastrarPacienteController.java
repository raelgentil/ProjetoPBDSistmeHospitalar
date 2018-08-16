/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class CadastrarPacienteController implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private ComboBox<?> sexo;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private DatePicker dataNasc;
    @FXML
    private TextField logradouro;
    @FXML
    private TextField complemento;
    @FXML
    private TextField numero;
    @FXML
    private ComboBox<?> cidade;
    @FXML
    private ComboBox<?> estado;
    @FXML
    private TextField bairro;
    @FXML
    private ComboBox<?> tipoSanguineo;
    @FXML
    private ComboBox<?> fatorRh;
    @FXML
    private ComboBox<?> doador;
    @FXML
    private Button salvarBotao;
    @FXML
    private Button voltarBotao;
    private static CadastrarPacienteController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
    }
    public static CadastrarPacienteController get(){
        return controller;
    }
    
}
