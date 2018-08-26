/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.Lote;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class CadastrarLoteController implements Initializable {

     @FXML
    private Pane pane;

    @FXML
    private TextField codigo;

    @FXML
    private TextField qntd;

    @FXML
    private DatePicker fabricacao;

    @FXML
    private DatePicker validade;

    @FXML
    private ComboBox<String> generico;

    @FXML
    private Button salvarBotao;

    @FXML
    private Button voltarBotao;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generico.getItems().addAll("Sim","Não");
        voltarBotao.setOnMouseClicked((event) -> {
            Controlador.fecharTelaAux();
            Controlador.limparPane(pane);
        });
        salvarBotao.setOnMouseClicked((event) -> {
            Lote l = getLote();
            if(l != null){
                Controlador.FACHADA.loteSalvarOuAtualizar(l);
                Controlador.fecharTelaAux();
                CadastrarInsumoController.get().atualizar();
                Controlador.limparPane(pane);
            }else
                Mensagens.erro("Erro ao salvar Lote", "Um lote deve pertencer a um Insumo!");
        });
    }
    private Lote getLote(){
        Lote l = new Lote();
        l.setInsumo(CadastrarInsumoController.get().getInsumo());
        if(l.getInsumo()== null)
            return null;
        l.setCodigo(Long.parseLong(codigo.getText()));
        l.setGenerico(generico.getValue().equals("Sim"));
        l.setQuantidadeInsumo(Integer.parseInt(qntd.getText()));
        
        Calendar fab = Calendar.getInstance();
        fab.setTime(Date.valueOf(fabricacao.getValue()));
        l.setDataFabricacao(fab);
        
        Calendar val = Calendar.getInstance();
        val.setTime(Date.valueOf(validade.getValue()));
        l.setDataValidade(val);
        return l;
    }
    
}
