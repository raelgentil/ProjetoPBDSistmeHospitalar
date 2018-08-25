package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    private ComboBox<?> paciente;

    @FXML
    private DatePicker dataAtendimento;

    @FXML
    private Button salvarBotao;

    @FXML
    private Button voltarBotao;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
