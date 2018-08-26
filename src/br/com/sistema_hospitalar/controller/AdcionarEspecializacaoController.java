/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
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
public class AdcionarEspecializacaoController implements Initializable {

     @FXML
    private TableView<Especializacao> tabela;

    @FXML
    private Button adicionar;

    @FXML
    private Button cancelar;
    @FXML
    private TableColumn<Especializacao, String> nome;

    @FXML
    private TableColumn<Especializacao, String> conselho;

    @FXML
    private TableColumn<Especializacao, Double> valor;
    private static AdcionarEspecializacaoController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        nome.setCellValueFactory( new PropertyValueFactory("nome"));
        conselho.setCellValueFactory( new PropertyValueFactory("conselho"));
        valor.setCellValueFactory( new PropertyValueFactory("valor"));
        
        adicionar.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                CadastrarFuncionarioController.get().addEspecializacao(tabela.getSelectionModel().getSelectedItem());
                Controlador.fecharTelaAux();
                
            }else
                Mensagens.informacao("Informação","Selecione Um Item na tabela");
        });
        cancelar.setOnMouseClicked((event) -> {
            Controlador.fecharTelaAux();
        });
    } 
    public void atualizar(){
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.especializacaoBuscarPorNome("")));
    }
    public static AdcionarEspecializacaoController get(){
        return controller;
    }
    
}
