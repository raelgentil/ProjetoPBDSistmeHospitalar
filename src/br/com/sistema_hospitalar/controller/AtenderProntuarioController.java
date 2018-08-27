package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class AtenderProntuarioController implements Initializable {

      @FXML
    private DatePicker retorno;

    @FXML
    private TextArea observacoes;

    @FXML
    private TextField cidCod;

    @FXML
    private TextField cidDescricao;

    @FXML
    private ComboBox<Insumo> insumo;

    @FXML
    private Button adicionar;

    @FXML
    private TableView<Insumo> tabela;

    @FXML
    private TableColumn<Insumo, String> descricao;

    @FXML
    private TableColumn<Insumo, Integer> estoque;

    @FXML
    private TableColumn<Insumo, Double> valor;

    @FXML
    private Button remover;

    @FXML
    private Button salvarBotao;

    @FXML
    private Button voltarBotao;
    private Prontuario prontuario;
    private List<CategoriaCID> cids ;//= new ArrayList();
    private static AtenderProntuarioController c;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c = this;
        descricao.setCellValueFactory( new PropertyValueFactory("descricao"));
        estoque.setCellValueFactory( new PropertyValueFactory("quantidadeTotal"));
        valor.setCellValueFactory( new PropertyValueFactory("valor"));
        cidCod.setOnAction((event) -> {
            cids = Controlador.FACHADA.categoriaCIDBucarPorCodigoCategoriaCID(cidCod.getText());
            if(cids != null)
                cidDescricao.setText(cids.get(0).getDescricao());
        });
        voltarBotao.setOnMouseClicked((event) -> {
            Controlador.fecharTelaAux();
        });
        adicionar.setOnMouseClicked((event) -> {
            if(insumo.getSelectionModel().getSelectedItem() != null){
               tabela.getItems().add(insumo.getSelectionModel().getSelectedItem());
            }
        });
        remover.setOnMouseClicked((event) -> {
            if(tabela.getSelectionModel().getSelectedItem() != null){
               tabela.getItems().remove(tabela.getSelectionModel().getSelectedItem());
            }
        });
        salvarBotao.setOnMouseClicked((event) -> {
            if(prontuario != null){
                if(Controlador.FACHADA.prontuarioSalvarOuAtualizar(getProntuarioTela())){
                    Controlador.fecharTelaAux();
                }else
                    Mensagens.erro("Erro ao Salvar", "preencha todos os campos!");
            }else
                Mensagens.erro("Erro ao Salvar", "Prontuario não carregado");
        });
    }    

    public static AtenderProntuarioController get() {
        return c;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }
    public void atualizar(){
        insumo.setItems(FXCollections.observableArrayList(Controlador.FACHADA.insumoBuscarDescricao("")));
    }
    private Prontuario getProntuarioTela(){
        if(prontuario == null)
            return null;
        prontuario.setObservacoes(observacoes.getText());
        
        Calendar data = Calendar.getInstance();
        data.setTime(Date.valueOf(retorno.getValue()));
        prontuario.setDataPrevistaRetorno(data);
        prontuario.setCidss(Controlador.FACHADA.categoriaCIDBucarPorCodigoCategoriaCID(cidCod.getText()));
        prontuario.setPrescricaoo(getPrescricao());
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    private List<Lote> getPrescricao() {
        List<Lote> a = new ArrayList();
        for(Insumo i:tabela.getItems()){
            a.add(Controlador.FACHADA.loteBuscarPorInsumo(i).get(0));
        }
        
        return a;
    }
    
}
