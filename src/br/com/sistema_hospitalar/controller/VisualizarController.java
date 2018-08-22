/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Enums;
import static br.com.sistema_hospitalar.enums.Enums.ProfSaude;
import static br.com.sistema_hospitalar.enums.Enums.adm;
import static br.com.sistema_hospitalar.enums.Enums.atendente;
import static br.com.sistema_hospitalar.enums.Enums.paciente;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.net.URL;
import java.util.List;
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
    
    @FXML
    private TableColumn<Pessoa, String> nome;

    @FXML
    private TableColumn<Pessoa, String> sexo;

    @FXML
    private TableColumn<Pessoa, String> cpf;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        nome.setCellValueFactory( new PropertyValueFactory("nome"));
        cpf.setCellValueFactory( new PropertyValueFactory("cpf"));
        sexo.setCellValueFactory( new PropertyValueFactory("sexo"));
        
        pesquisa.setOnKeyReleased((event) -> {
            atualizar(opcao);
        });
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
        List aux = null;
        try{
            switch (opcao){
                case paciente:{aux = Controlador.FACHADA.pacienteBuscarPorNome(pesquisa.getText());break;}
                case adm:{aux = Controlador.FACHADA.administradorBuscarPorNome(pesquisa.getText());break;}
                case ProfSaude:{aux = Controlador.FACHADA.profissionalSaudeBuscarPorNome(pesquisa.getText());break;}
                case atendente:{aux = Controlador.FACHADA.atendenteBuscarPorNome(pesquisa.getText());break;}
            }
            tabela.setItems(FXCollections.observableArrayList(aux));
        }catch(NullPointerException e){System.out.println("ERRO AO ATUALIZAR TELA!");}
    }
    private void cadastrar(){
        if(opcao!=null){
            switch (opcao){
                case paciente:{Controlador.trocarPane(Panes.cadastrarPaciente);break;}
                case adm:{Controlador.trocarPane(Panes.cadastrarFuncionario);break;}
                case ProfSaude:{Controlador.trocarPane(Panes.cadastrarFuncionario);break;}
                case atendente:{Controlador.trocarPane(Panes.cadastrarFuncionario);break;}
            }
                CadastrarFuncionarioController.get().setOpcao(opcao);
                atualizar(opcao);
        }
    }
    private void editar(){
        CadastrarFuncionarioController.get().setOpcao(opcao);
        CadastrarFuncionarioController.get().setTela((Funcionario)tabela.getSelectionModel().getSelectedItem());
        atualizar(opcao);
    }
    private void excluir(){
        if(Mensagens.Pergunta("DESEJA CONTINUAR?", "Deseja realmente excluir", Mensagens.YES, Mensagens.NO).equals(Mensagens.YES) && opcao!=null){
            switch (opcao){
                case paciente:{Controlador.FACHADA.pacienteRemover((Paciente)tabela.getSelectionModel().getSelectedItem());;break;}
                case adm:{Controlador.FACHADA.administradorRemover((Administrador)tabela.getSelectionModel().getSelectedItem());;break;}
                case ProfSaude:{Controlador.FACHADA.profissionalSaudeRemover((ProfissionalSaude)tabela.getSelectionModel().getSelectedItem());;break;}
                case atendente:{Controlador.FACHADA.atendenteRemover((Atendente)tabela.getSelectionModel().getSelectedItem());;break;}
            }
            
        }
        atualizar(opcao);
    }
    
    public static VisualizarController get(){
        return controller;
    }
    public void setOpcao(Enums e){
        opcao = e;
    }
    
}
