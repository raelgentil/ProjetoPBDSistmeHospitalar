/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.sistema_hospitalar.model.beans.EstadoBEANS;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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

   

    
    
    private static CadastrarPacienteController controller;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
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
        Estado est = new Estado();
        est.setDescricao((String)estado.getValue());
        
        m.setEstado(est);
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
    
}
