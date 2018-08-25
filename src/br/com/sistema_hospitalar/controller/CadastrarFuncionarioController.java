/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.enums.Enums;
import br.com.sistema_hospitalar.enums.Panes;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class CadastrarFuncionarioController implements Initializable {

     @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private ComboBox<?> sexo;

    @FXML
    private TextField email;

    @FXML
    private TextField telefone;

    @FXML
    private DatePicker dataNasc;

    @FXML
    private TextField telefone2;

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
    private TextField cep;

    @FXML
    private TextField cargaHoraria;

    @FXML
    private TextField salario;

    @FXML
    private CheckBox ativo;

//    @FXML
//    private TextField login;

    @FXML
    private PasswordField  senha;

    @FXML
    private Tab saude;

    @FXML
    private TableView<?> tabela;

    @FXML
    private Button adicionarBotao;

    @FXML
    private Button removerBotao;

    @FXML
    private Button cadastrarBotao;

    @FXML
    private TextField apelido;

    @FXML
    private Button salvarBotao;

    @FXML
    private Button voltarBotao;
    private Enums opcao;
    
   private static CadastrarFuncionarioController controller;
   private Funcionario funcionario;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        carregarComponentes();
        
        salvarBotao.setOnMouseClicked((MouseEvent event) -> {
            cadastrar();
            Controlador.voltar();
        });
        voltarBotao.setOnMouseClicked((MouseEvent event) -> {
            Controlador.voltar();
           // Controlador.limparPane(p);
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
            Controlador.abrirTelaAux(Panes.cadastrarEsp);
//            Controlador.limparPane(p);
        });
    }
    public void setTela(Funcionario f){
        
    }
    private void cadastrar(){
        boolean msg= false;
        Funcionario fu = null;
        switch (opcao){
                case adm:{
                    Administrador a = getAdministrador();
                    fu = a;
                    if(!Controlador.FACHADA.administradorVerificarSU()){
                        a.setSuperUsuario(true);
                    }
                    msg = Controlador.FACHADA.administradorSalvarOuAtualizar(a);
                    if(a.isSuperUsuario())
                        Controlador.trocarTela("login");
                    break;
                }
                case ProfSaude:{fu = getProfissionalSaude();msg = Controlador.FACHADA.profissionalSaudeSalvarOuAtualizar((ProfissionalSaude) fu);break;}
                case atendente:{fu = getAtendente() ;msg = Controlador.FACHADA.atendenteSalvarOuAtualizar((Atendente) fu);break;}
            }
        if(msg && fu != null)
            Mensagens.informacao("Informação", "O login para o funcionário é: "+ fu.getLogin());
        funcionario = null;
    }
    private Endereco getEndereco(){
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
        return e;
    }
    public ProfissionalSaude getProfissionalSaude(){
        ProfissionalSaude p;
        if(funcionario != null)
            p = (ProfissionalSaude) funcionario;
        else
            p = new ProfissionalSaude();
        p.setNome(nome.getText());
        p.setCpf(cpf.getText());
        p.setEmail(email.getText());
        p.setSexo(((String)sexo.getValue()).substring(0, 1));
        p.setTelefones(telefone.getText()+"||"+telefone2.getText());
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(dataNasc.getValue()));
        p.setDataDeNascimento(data);
        
        p.setAtivo(ativo.isSelected());
        p.setCargaHorariaMinimaMensal(Double.parseDouble(cargaHoraria.getText()));
//        p.setLogin(login.getText());
        p.setSalario(Double.parseDouble(salario.getText()));
        String password = senha.getText();
//        if(password.length() > 6 && password.length() < 11){
//            if(password.contains("[ a-zA- Z0-9]"))//"^[0-9]*$[ a-zA- Z] * "))
//            else{
//                System.out.println("Senha só pode conter letras e números");
//                return null;
//            }
//        }else{
//            System.out.println("Senha só deve conter 6 a 11 caracteres alfanuméricos");
//                return null;
//        }
//        System.out.println("Encriptado: "+password);
//        System.out.println("Desencriptado: "+Controlador.desencriptar(password));
        p.setSenha(password);        
        p.setEndereco(getEndereco());
        
        p.setApelido(apelido.getText());
        
        return p;
    }
    
    public Atendente getAtendente(){
        Atendente p;
        if(funcionario != null)
            p = (Atendente) funcionario;
        else
            p = new Atendente();
        p.setNome(nome.getText());
        p.setCpf(cpf.getText());
        p.setEmail(email.getText());
        p.setSexo(((String)sexo.getValue()).substring(0, 1));
        p.setTelefones(telefone.getText()+"||"+telefone2.getText());
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(dataNasc.getValue()));
        p.setDataDeNascimento(data);
        
        p.setAtivo(ativo.isSelected());
        p.setCargaHorariaMinimaMensal(Double.parseDouble(cargaHoraria.getText()));
//        p.setLogin(login.getText());
        p.setSalario(Double.parseDouble(salario.getText()));
        String password = senha.getText();
//        if(password.length() > 6 && password.length() < 11){
//            if(password.contains("[ a-zA- Z0-9]"))//"^[0-9]*$[ a-zA- Z] * "))
//            else{
//                System.out.println("Senha só pode conter letras e números");
//                return null;
//            }
//        }else{
//            System.out.println("Senha só deve conter 6 a 11 caracteres alfanuméricos");
//                return null;
//        }
//        System.out.println("Encriptado: "+password);
//        System.out.println("Desencriptado: "+Controlador.desencriptar(password));
        p.setSenha(password);        
        p.setEndereco(getEndereco());
        
        
        return p;
    }
    
    public Administrador getAdministrador(){
        Administrador p;
        if(funcionario != null)
             p = (Administrador) funcionario;
        else
            p = new Administrador();
        p.setNome(nome.getText());
        p.setCpf(cpf.getText());
        p.setEmail(email.getText());
        p.setSexo(((String)sexo.getValue()).substring(0, 1));
        p.setTelefones(telefone.getText()+"||"+telefone2.getText());
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(dataNasc.getValue()));
        p.setDataDeNascimento(data);
        
        p.setAtivo(ativo.isSelected());
        p.setCargaHorariaMinimaMensal(Double.parseDouble(cargaHoraria.getText()));
//        p.setLogin(login.getText());
        p.setSalario(Double.parseDouble(salario.getText()));
        String password = senha.getText();
//        if(password.length() > 6 && password.length() < 11){
//            if(password.contains("//w"))//"^[0-9]*$[ a-zA- Z] * "))
//            else{
//                System.out.println("Senha só pode conter letras e números");
//                return null;
//            }
//        }else{
//            System.out.println("Senha só deve conter 6 a 11 caracteres alfanuméricos");
//                return null;
//        }
//        System.out.println("Encriptado: "+password);
//        System.out.println("Desencriptado: "+Controlador.desencriptar(password));
        p.setSenha(password);        
        p.setEndereco(getEndereco());
        
        
        return p;
    }
    public static CadastrarFuncionarioController get(){
        return controller;
    }

    public ComboBox<?> getSexo() {
        return sexo;
    }

    public void setSexo(ComboBox<?> sexo) {
        this.sexo = sexo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    

    private void carregarComponentes() {
        List auxList = new ArrayList();//,hrlist,doadorlist,tiposanguineolist;
        
        auxList.add("Masculino");
        auxList.add("Feminino");
        sexo.setItems(FXCollections.observableArrayList(auxList));
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


    public void setOpcao(Enums opcao) {
        this.opcao = opcao;
        saude.setDisable(opcao!=Enums.ProfSaude);
    }
    
}
