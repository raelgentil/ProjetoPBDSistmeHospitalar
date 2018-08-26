package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
public class AgendarController implements Initializable {
    @FXML
    private ComboBox<ProfissionalSaude> medico;
    
    @FXML
    private TextField numeroProntuario;
    
    @FXML
    private ComboBox<Paciente> paciente;
    
    @FXML
    private DatePicker dataAtendimento;
    
    @FXML
    private Button salvarBotao;
    
    @FXML
    private Button voltarBotao;
    @FXML
    private Pane pane;
    private static AgendarController controller;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        salvarBotao.setOnMouseClicked((event) -> {
            if(Controlador.FACHADA.prontuarioSalvarOuAtualizar(getProntuario())){
            Controlador.voltar();
            Controlador.limparPane(pane);
            }else
                Mensagens.erro("Erro ao Salvar","Verifique se todos os Campos estão preechdos!");
        });
        voltarBotao.setOnMouseClicked((event) -> {
            Controlador.voltar();
            Controlador.limparPane(pane);
        });
    }
    public void atualizar(){
                medico.setItems(FXCollections.observableArrayList(Controlador.FACHADA.profissionalSaudeBuscarPorNome("")));
                paciente.setItems(FXCollections.observableArrayList(Controlador.FACHADA.pacienteBuscarPorNome("")));
    }
    private Prontuario getProntuario(){
        Prontuario p = new Prontuario();
        Calendar atual = Calendar.getInstance();
        atual.setTimeInMillis(System.currentTimeMillis());
        p.setDataAbertura(atual);
        p.setMedico(medico.getItems().get(medico.getSelectionModel().getSelectedIndex()));
        p.setPaciente(paciente.getItems().get(paciente.getSelectionModel().getSelectedIndex()));
        p.setNumero(Long.getLong(numeroProntuario.getText()));
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(dataAtendimento.getValue()));
        p.setDataAtendimento(data);
        return p;
    }
    public static AgendarController get(){
        return controller;
    }
    
}
