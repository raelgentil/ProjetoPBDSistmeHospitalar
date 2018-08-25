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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */

public class CadastrarEspecializacaoController implements Initializable {
    @FXML
    private AnchorPane pane;
    
    @FXML
    private TextField nome;
    
    @FXML
    private ComboBox<String> conselhos;
    
    @FXML
    private TextField valor;
    
    @FXML
    private Button salvarBotao;
    
    @FXML
    private Button voltarBotao;
    /**
     * Initializes the controller class.
     */
    private Especializacao esp;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        atualizar();
        salvarBotao.setOnMouseClicked((event) -> {
            if(conselhos.getSelectionModel().getSelectedItem() != null ){
                esp = getEspecializacao();
                Controlador.FACHADA.especializacaoSalvarOuAtualizar(esp);
                Controlador.fecharTelaAux();
                Controlador.limparPane(pane);
                Mensagens.informacao("Cadastrado com sucesso!", "Clique em Adicionar para adicionar essa Especialização ao Profssional");
            }else{
                Mensagens.erro("preencha todos os campos", "Selecione um conselho");
            }
            
        });
    }
    private Especializacao getEspecializacao(){
        Especializacao e = new Especializacao();
        e.setNome(nome.getText());
        e.setValor(Double.valueOf(valor.getText()));
        e.setConselho(conselhos.getValue());
        return e;
    }
    private void atualizar(){
        conselhos.getItems().add("CRM");
        conselhos.getItems().add("CRM");
    }
    
}
