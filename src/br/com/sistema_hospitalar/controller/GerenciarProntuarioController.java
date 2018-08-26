/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
        
    } 

    public static GerenciarProntuarioController get() {
        return c;
    }
    public void atualizar(){
        tabela.setItems(FXCollections.observableArrayList(Controlador.FACHADA.prontuarioBuscarPorCodMedicoPacient(Long.MIN_VALUE, pesquisa.getText())));
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
