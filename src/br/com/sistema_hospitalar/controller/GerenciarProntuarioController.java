/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class GerenciarProntuarioController implements Initializable {

    @FXML
    private TableView<Prontuario> tabela;

    @FXML
    private TableColumn<Prontuario, String> paciente;

    @FXML
    private TableColumn<Prontuario, String> medico;

    @FXML
    private TableColumn<Prontuario, String> codigo;

    @FXML
    private TableColumn<Prontuario, Calendar> abertura;

    @FXML
    private TableColumn<Prontuario, Calendar> atendimento;
     @FXML
    private CheckBox medicBox;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button atenderBotao;

    @FXML
    private Button editarBotao;

    @FXML
    private Button excluirBotao;
    private static GerenciarProntuarioController c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = this;
        iniciarComponentes();
        excluirBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                if(Mensagens.Pergunta("DESEJA CONTINUAR?", "Deseja realmente excluir", Mensagens.YES, Mensagens.NO).equals(Mensagens.YES)){
                    Controlador.FACHADA.prontuarioRemover(tabela.getSelectionModel().getSelectedItem());
                }
            }else
                Mensagens.informacao("Selecione um Item", "Selecione um item da tabela para realizar essa operação");
        });
        atenderBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                if(Objects.equals(tabela.getSelectionModel().getSelectedItem().getMedico().getId(), Controlador.getUsuarioLogado().getId())){
                    AtenderProntuarioController.get().setProntuario(tabela.getSelectionModel().getSelectedItem());
                    Controlador.abrirTelaAux(Panes.atenderProntuario);
                }else
                    Mensagens.informacao("Somente o médico do prontuário pode atende-lo", "Operação Inválida");
                
                
            }else
                Mensagens.informacao("Selecione um Item", "Selecione um item da tabela para realizar essa operação");
        });
        medicBox.setOnAction((event) -> {
            atualizar();
        });
        pesquisa.setOnKeyReleased((event) -> {
            atualizar();
        });
        editarBotao.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
                    //EditarProntuarioController.get().setProntuario(tabela.getSelectionModel().getSelectedItem());
                    Controlador.abrirTelaAux(Panes.verProntuario);
                
            }else
                Mensagens.informacao("Selecione um Item", "Selecione um item da tabela para realizar essa operação");
        });
        
    } 

    public static GerenciarProntuarioController get() {
        return c;
    }
    public void atualizarFuncionarioLogado(Funcionario f){
        if(!(f instanceof ProfissionalSaude)){
            medicBox.setDisable(true);
            medicBox.setSelected(false);
            
        }else{
            medicBox.setDisable(false);
            medicBox.setSelected(true);
        }
            
    }
    public void atualizar(){
        if(medicBox.isSelected())
            tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.prontuarioBuscarPorCodMedicoPacient(((ProfissionalSaude)Controlador.getUsuarioLogado()).getApelido())));
        else
            tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.prontuarioBuscarPorCodMedicoPacient(pesquisa.getText())));
    for(Prontuario p : tabela.getItems()){
        System.out.println(p);
    }//
    for(Prontuario p : Controlador.FACHADA.prontuarioBuscarPorCodMedicoPacient(pesquisa.getText())){
        System.out.println(p);
    }
    }
    private void iniciarComponentes(){
        final DateFormat dateFormat = DateFormat.getDateInstance() ;
        abertura.setCellFactory(col -> new TableCell<Prontuario, Calendar>() {
            @Override
            public void updateItem(Calendar item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item.getTime()));
                }
            }
        });
        atendimento.setCellFactory(col -> new TableCell<Prontuario, Calendar>() {
            @Override
            public void updateItem(Calendar item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null) {
                    setText(null);
                } else {
                    setText(dateFormat.format(item.getTime()));
                }
            }
        });
        
        abertura.setCellValueFactory( new PropertyValueFactory("dataAbertura"));
        atendimento.setCellValueFactory( new PropertyValueFactory("dataAtendimento"));
        codigo.setCellValueFactory( new PropertyValueFactory("codMedicoPaciente"));
        medico.setCellValueFactory( new PropertyValueFactory("medico"));
        paciente.setCellValueFactory( new PropertyValueFactory("paciente"));
    }
    
    
}
