/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.enums.Enums;
import java.net.URL;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class VisualizarController implements Initializable {
    private static VisualizarController controller;
    private Enums opcao;
      @FXML
    private TableView<?> tabela;

    @FXML
    private Button cadastrarBotao;

    @FXML
    private Button editarBotao;

    @FXML
    private Button excluirBotao;

    @FXML
    private TextField pesquisa;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
    } 
    public void atualiar(){
        tabela.getColumns().clear();
        tabela.getColumns().add(new TableColumn("Nome:"));
        tabela.getColumns().add(new TableColumn("CPF:"));
        tabela.getColumns().add(new TableColumn("Sexo:"));
        tabela.getColumns().add(new TableColumn("Data Nasc.:"));
        
        try{
            switch (opcao){
            case ProfSaude:{
                //FXCollections.observableList(new ArrayList());
//                TableView tabe = new TableView();
//                tabe.getColumns().add(tabe);
//                tabela.setItems(value);
//                tabela.
            }
        }
        }catch(NullPointerException e){System.out.println("ERRO AO ATUALIZAR TELA!");}
    }
   
    public static VisualizarController get(){
        return controller;
    }
    public void setOpcao(Enums e){
        opcao = e;
    }
    
}
