/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class CadastrarPacienteController implements Initializable {

    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private ComboBox<?> sexo;
    @FXML
    private TextField cep;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private TextField telefone2;
    @FXML
    private DatePicker dataNasc;
    @FXML
    private TextField logradouro;
    @FXML
    private TextField complemento;
    @FXML
    private TextField numero;
    @FXML
    private ComboBox<?> cidade;
    @FXML
    private ComboBox<?> estado;
    @FXML
    private TextField bairro;
    @FXML
    private ComboBox<?> tipoSanguineo;
    @FXML
    private ComboBox<?> fatorRh;
    @FXML
    private ComboBox<?> doador;
    @FXML
    private Button salvarBotao;
    @FXML
    private Button voltarBotao;
    @FXML
    private TextArea alergias;
    @FXML
    private TextArea limitacoes;
     @FXML
    private Tab dadosMedicos;
     @FXML
    private Pane panePessoa;
     @FXML
    private Pane paneMedico;
     @FXML
    private Pane paneEndereco;
     @FXML
    private Pane paneResp;
     @FXML
    private Button adicionarBotao;

    @FXML
    private Button cadastrarBotao;
    @FXML
    private Button removerBotao;
     
   
//Eu nao vou ser apagada
    
    
   private static CadastrarPacienteController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        dadosMedicos.setDisable(false);
        carregarComponentes();
        
        salvarBotao.setOnMouseClicked((MouseEvent event) -> {
            Controlador.FACHADA.pacienteSalvarOuAtualizar(getPaciente());
        });
        voltarBotao.setOnMouseClicked((MouseEvent event) -> {
            Controlador.voltar();
            limparTela();
        });
        cidade.setOnAction((ActionEvent event) -> {
            Municipio m ;
            List<Municipio> munis = Controlador.FACHADA.municipioBuscarPorNome((String)cidade.getValue());
            if(munis.size() > 0 ){
                m = munis.get(0);
                estado.getSelectionModel().select(estado.getItems().indexOf(m.getEstado().getDescricao()));
            }
        });
        cadastrarBotao.setOnMouseClicked((MouseEvent event) -> {
            Controlador.abrirTelaAux(Panes.cadastrarPaciente);
        });
    }
    public Paciente getPaciente(){
        Paciente p = new Paciente();
        p.setNome(nome.getText());
        p.setCpf(cpf.getText());
        p.setEmail(email.getText());
        p.setSexo(((String)sexo.getValue()).substring(0, 1));
        p.setAlergias(alergias.getText());
        p.setLimitacoes(limitacoes.getText());
        p.setTelefones(telefone.getText()+"||"+telefone2.getText());
        p.setTipoSanguinio((String)tipoSanguineo.getValue());
        p.setDoadorDeOrgaos(((String)doador.getValue()).equalsIgnoreCase("Sim"));
        p.setFatorRh(((String)fatorRh.getValue()).equalsIgnoreCase("Positivo"));
        
        Endereco e = new Endereco();
        e.setBairro(bairro.getText());
        e.setCep(Integer.parseInt(cep.getText().replaceAll("-", "")));
        e.setBairro(bairro.getText());
        e.setComplemento(complemento.getText());
        e.setDescricao(logradouro.getText());
        e.setNumero(numero.getText());
        
        List<Municipio> municipios = Controlador.FACHADA.municipioBuscarPorNome((String)cidade.getValue());
        Municipio m;
        if(municipios.size() > 0)
            m = municipios.get(0);
        else
            m =  new Municipio();
        m.setDescricao((String)cidade.getValue());
        m.setEstado(Controlador.FACHADA.estadoBuscarPorNome((String)estado.getValue()).get(0));
        Controlador.FACHADA.municipioSalvarOuAtualizar(m);
        
        e.setMunicipio(m);
        Controlador.FACHADA.enderecoSalvarOuAtualizar(e);
        p.setEndereco(e);
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(dataNasc.getValue()));
        p.setDataDeNascimento(data);
        return p;
    }
    public static CadastrarPacienteController get(){
        return controller;
    }

    private void carregarComponentes() {
        List auxList = new ArrayList();//,hrlist,doadorlist,tiposanguineolist;
        
        auxList.add("Masculino");
        auxList.add("Feminino");
        sexo.setItems(FXCollections.observableArrayList(auxList));
        auxList.clear();
        
        auxList.add("Positivo");
        auxList.add("Negativo");
        fatorRh.setItems(FXCollections.observableArrayList(auxList));
        auxList.clear();
        
        auxList.add("Sim");
        auxList.add("Não");
        doador.setItems(FXCollections.observableArrayList(auxList));
        auxList.clear();
        
        auxList.add("O");
        auxList.add("A");
        auxList.add("B");
        auxList.add("AB");             
        tipoSanguineo.setItems(FXCollections.observableArrayList(auxList));
        auxList.clear();
        
        for(Estado e: Controlador.FACHADA.estadoBuscarPorNome(""))
            auxList.add(e.getDescricao());
        estado.setItems(FXCollections.observableArrayList(auxList));
        auxList.clear();
        
        List<Municipio> municipios = Controlador.FACHADA.municipioBuscarPorNome("");
        if(municipios != null){
            for(Municipio m: municipios)
                auxList.add(m.getDescricao());
            cidade.setItems(FXCollections.observableArrayList(auxList));
        }
        
    }

    private void limparTela() {
        Controlador.limparPane(panePessoa);
        Controlador.limparPane(paneMedico);
        Controlador.limparPane(paneEndereco);
        Controlador.limparPane(paneResp);
    }
    
}
