/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.enums.Enums;
import static br.com.sistema_hospitalar.enums.Enums.ProfSaude;
import static br.com.sistema_hospitalar.enums.Enums.adm;
import static br.com.sistema_hospitalar.enums.Enums.atendente;
import static br.com.sistema_hospitalar.enums.Enums.paciente;
import br.com.sistema_hospitalar.enums.Panes;
import java.net.URL;
import java.util.ResourceBundle;
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
        cadastrarBotao.setOnMouseClicked((MouseEvent) -> {
            cadastrar();
        });
        editarBotao.setOnMouseClicked((MouseEvent) -> {
            editar();
        });
        excluirBotao.setOnMouseClicked((MouseEvent) -> {
            excluir();
        });
        
    }
    public void atualizar(Enums opcao){
        this.opcao = opcao;
        tabela.getColumns().clear();
        tabela.getColumns().add(new TableColumn("Nome:"));
        tabela.getColumns().add(new TableColumn("CPF:"));
        tabela.getColumns().add(new TableColumn("Sexo:"));
        tabela.getColumns().add(new TableColumn("Data Nasc.:"));
        
        try{
            switch (opcao){
                case paciente:{
                    
                }
                case adm:{
                    
                }
                case ProfSaude:{
                    
                }
                case atendente:{
                    
                }
            }
        }catch(NullPointerException e){System.out.println("ERRO AO ATUALIZAR TELA!");}
    }
    private void cadastrar(){
        if(opcao!=null)
            switch (opcao){
                case paciente:{
                    Controlador.trocarPane(Panes.cadastrarPaciente);
                }
                case adm:{
                    
                }
                case ProfSaude:{
                    
                }
                case atendente:{
                    
                }
            }
    }
    private void editar(){
        
    }
    private void excluir(){
        
    }
    
    public static VisualizarController get(){
        return controller;
    }
    public void setOpcao(Enums e){
        opcao = e;
    }
    
}
