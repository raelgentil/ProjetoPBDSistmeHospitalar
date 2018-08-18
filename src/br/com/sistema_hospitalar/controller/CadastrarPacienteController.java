/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

   
//Eu nao vou ser apagada
    
    
    private static CadastrarPacienteController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        dadosMedicos.setDisable(false);
        carregarComponentes();
        
        salvarBotao.setOnMouseClicked((event) -> {
            Controlador.FACHADA.pacienteSalvarOuAtualizar(getPaciente());
        });
        voltarBotao.setOnMouseClicked((event) -> {
            Controlador.voltar();
            limparTela();
        });
        estado.setItems(FXCollections.observableArrayList());
    }
    public Paciente getPaciente(){
        Paciente p = new Paciente();
        p.setNome(nome.getText());
        p.setCpf(cpf.getText());
        p.setEmail(email.getText());
        p.setSexo((String)sexo.getValue());
        p.setAlergias(alergias.getText());
        p.setLimitacoes(limitacoes.getText());
        p.setTelefones(telefone.getText());
        p.setTipoSanguinio((String)tipoSanguineo.getValue());
        p.setDoadorDeOrgaos(((String)doador.getValue()).equalsIgnoreCase("Sim"));
        p.setFatorRh(((String)fatorRh.getValue()).equalsIgnoreCase("Positivo"));
        
        Endereco e = new Endereco();
        e.setBairro(bairro.getText());
        e.setCep(Integer.parseInt(cep.getText().replaceAll("-", "")));
        e.setBairro(bairro.getText());
        e.setComplemento(complemento.getText());
        e.setDescricao(logradouro.getText());
        
        Municipio m = new Municipio();
        m.setDescricao((String)cidade.getValue());
        m.setEstado(Controlador.FACHADA.estadoBuscarPorNome((String)estado.getValue()).get(0));
        e.setMunicipio(m);
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
             ObservableList est = FXCollections.observableArrayList();
        for(Estado e: Controlador.FACHADA.estadoBuscarPorNome("")){
            est.add(""+e.getDescricao());
            System.out.println(" "+ est.size());
        }
        
        estado.setItems(est);
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
       
    }

    private void limparTela() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
