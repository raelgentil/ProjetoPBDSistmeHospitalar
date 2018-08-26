/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class VisualizarInsumosController implements Initializable {

    @FXML
    private TableView<Insumo> tabela;

    @FXML
    private TableColumn<Insumo, String> descricao;

    @FXML
    private TableColumn<Insumo, Integer> estoque;

    @FXML
    private TableColumn<Insumo, Double> valor;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button cadastrarBotao;

    @FXML
    private Button editarBotao;

    @FXML
    private Button excluirBotao;
    private static VisualizarInsumosController c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = this;
        descricao.setCellValueFactory( new PropertyValueFactory("descricao"));
        estoque.setCellValueFactory( new PropertyValueFactory("quantidadeTotal"));
        valor.setCellValueFactory( new PropertyValueFactory("valor"));
        pesquisa.setOnAction((event) -> {
            atualizar();
        });
        excluirBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                if(Mensagens.Pergunta("DESEJA CONTINUAR?", "Deseja realmente excluir", Mensagens.YES, Mensagens.NO).equals(Mensagens.YES)){
                    Controlador.FACHADA.insumoRemover(tabela.getSelectionModel().getSelectedItem());
                    atualizar();
                }
            }else
                Mensagens.informacao("Selecione um Item", "Selecione um item da tabela para realizar essa operação");
        });
        cadastrarBotao.setOnMouseClicked((event) -> {
            Controlador.trocarPane(Panes.cadastrarInsumo);
        });
        editarBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                System.out.println(tabela.getSelectionModel().getSelectedItem());
                CadastrarInsumoController.get().setInsumo(tabela.getSelectionModel().getSelectedItem());
                Controlador.trocarPane(Panes.cadastrarInsumo);
                atualizar();
            }else
                Mensagens.informacao("Selecione um Item", "Selecione um item da tabela para realizar essa operação");
        });
        
    } 
    
    public static VisualizarInsumosController get(){
        return c;
    }
    public void atualizar(){
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.insumoBuscarDescricao(pesquisa.getText())));
    }
    
}
