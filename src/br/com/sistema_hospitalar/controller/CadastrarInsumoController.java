/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
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
    private TextField valor;
    
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
    
//    @FXML
//    private Tab loteTab;
    private static CadastrarInsumoController c;
    private boolean edit;
    private Insumo insumo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = this;
        codColun.setCellValueFactory( new PropertyValueFactory("codigo"));
        dataColun.setCellValueFactory( new PropertyValueFactory("dataFabricacao"));
        dataValColun.setCellValueFactory( new PropertyValueFactory("dataValidade"));
        estoque.setCellValueFactory( new PropertyValueFactory("quantidadeInsumo"));
        salvarBotao.setOnMouseClicked((event) -> {
            if(Controlador.FACHADA.insumoSalvarOuAtualizar(getInsumoTela())){
                Mensagens.informacao("Insumo Salvo!", "Cadastrado com sucesso!");
                edit = false;
                VisualizarInsumosController.get().atualizar();
            }else
                Mensagens.erro("Erro!","Erro ao salvar Insumo verifique se todos os campos estao preenchidos!");
        });
        voltarBotao.setOnMouseClicked((event) -> {
            Controlador.voltar();
            VisualizarInsumosController.get().atualizar();
            edit = false;
            limpar();
        });
        adicionarBotao.setOnMouseClicked((event) -> {
            if(insumo != null && insumo.getId() != 0){
                Controlador.abrirTelaAux(Panes.cadastrarLote);
            }else
                Mensagens.informacao("Primeiro Você deve Salvar o Insumo!", "Clique no botão salvar, e tente novamente!");
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
    
    public Insumo getInsumo() {
        return insumo;
    }
    public void setInsumo(Insumo ins){
        edit = true;
        insumo = ins;
        System.out.println("Ins:" + ins);
        System.out.println("Insumo:" + insumo);
        descricao.setText(insumo.getDescricao());
        qntdMinima.setText(insumo.getQuantidadeMinima()+"");
        valor.setText(Double.toString(insumo.getValor()));
        
    }
    private Insumo getInsumoTela(){
        if(insumo == null)
            insumo = new Insumo();
        Insumo i = insumo;
        i.setDescricao(descricao.getText());
        i.setQuantidadeMinima(Integer.valueOf(qntdMinima.getText()));
        i.setValor(Double.valueOf(valor.getText()));
        return i;
    }
    public static CadastrarInsumoController get() {
        return c;
    }
    public void limpar(){
        if(!edit){
            Controlador.limparPane(lotePane);
            Controlador.limparPane(dadosPane);
            insumo = null;
        }else
            atualizar();
    }
    
    public void atualizar() {
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.loteBuscarPorInsumo(insumo)));
    }
    
}
