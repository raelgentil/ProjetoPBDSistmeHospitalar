/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class CadastrarInsumoController implements Initializable {
    
    @FXML
    private Button salvarBotao;
    
    @FXML
    private Button voltarBotao;
    
    @FXML
    private Pane dadosPane;
    
    @FXML
    private TextField descricao;
    
    @FXML
    private TextField qntdMinima;
    
    @FXML
    private TextField email;
    
    @FXML
    private Pane lotePane;
    
    @FXML
    private TableView<Lote> tabela;
    
    @FXML
    private TableColumn<Lote, Long> codColun;
    
    @FXML
    private TableColumn<Lote, Calendar> dataColun;
    
    @FXML
    private TableColumn<Lote, Calendar> dataValColun;
    
    @FXML
    private TableColumn<Lote, Integer> estoque;
    
    @FXML
    private Button adicionarBotao;
    
    @FXML
    private Button removerBotao;
    private static CadastrarInsumoController c;
    private Insumo insumo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c= this;
        codColun.setCellValueFactory( new PropertyValueFactory("codigo"));
        dataColun.setCellValueFactory( new PropertyValueFactory("dataFabricacao"));
        dataValColun.setCellValueFactory( new PropertyValueFactory("dataValidade"));
        estoque.setCellValueFactory( new PropertyValueFactory("quantidadeInsumo"));
        adicionarBotao.setOnMouseClicked((event) -> {
        });
        removerBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                if(Mensagens.Pergunta("DESEJA CONTINUAR?", "Deseja realmente excluir", Mensagens.YES, Mensagens.NO).equals(Mensagens.YES)){
                    Controlador.FACHADA.loteRemover(tabela.getSelectionModel().getSelectedItem());
                    atualizar();
                            
                }
            }
        });
    }
    
    
    
    
    public static CadastrarInsumoController get() {
        return c;
    }
    private void limpar(){
        Controlador.limparPane(lotePane);
        Controlador.limparPane(dadosPane);
    }

    private void atualizar() {
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.loteBuscarPorInsumo(insumo)));
    }
    
}
