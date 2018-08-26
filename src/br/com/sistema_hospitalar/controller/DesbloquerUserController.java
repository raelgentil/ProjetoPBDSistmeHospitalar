/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.ResetSenha;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class DesbloquerUserController implements Initializable {

    @FXML
    private TableView<ResetSenha> tabela;

    @FXML
    private TableColumn<ResetSenha, String> nome;

//    @FXML
//    private TableColumn<Funcionario, String> sexo;
//
//    @FXML
//    private TableColumn<Funcionario, String> cpf;

    @FXML
    private Button resetar;

    @FXML
    private Button cancelar;
    private static DesbloquerUserController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        nome.setCellValueFactory( new PropertyValueFactory("nome"));
//        cpf.setCellValueFactory( new PropertyValueFactory("cpf"));
//        sexo.setCellValueFactory( new PropertyValueFactory("sexo"));
        cancelar.setOnMouseClicked((event) -> {
            Controlador.voltar();
            atualizar();
        });
        resetar.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() == null)
                Mensagens.informacao("Você deve selecionar um item", "Selecione um item da tabela");
            else
                Controlador.FACHADA.funcionarioResetSenha(tabela.getSelectionModel().getSelectedItem().getId());
            atualizar();
        });
        
        
    }
    public static DesbloquerUserController get(){
        return controller;
    }
    public void atualizar(){
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.funcionarioGetAResetarSenha()));
    }
    
}
