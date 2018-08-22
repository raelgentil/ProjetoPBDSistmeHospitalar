package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hositalar.util.Util;
import br.com.sistema_hospitalar.enums.Enums;
import br.com.sistema_hospitalar.enums.Panes;
import static br.com.sistema_hospitalar.enums.Panes.gerenciarFunc;
import static br.com.sistema_hospitalar.enums.Panes.inicioSU;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.fachada.CoreFacade;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author João Emerson
 */
public class Controlador extends Application{
    
    private static Stage janela, janelaAUX;
    private static Scene login,principal, aux;
    private static Pane principalPane,inicioSUPane, gerenciarFuncPane, visualizar, cadastrarPaciente,cadastrarFuncionario;
    private static ArrayList<Pane> pilha;
    public  static CoreFacade FACHADA = new CoreFacade();
    private static Funcionario usuarioLogado;
    public static void main(String[] args){
        launch(args);    
       
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Util.atualizarBanco();
        janela = stage;
        pilha = new ArrayList<>();
        Pane loginPane = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/login.fxml"));
        inicioSUPane = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/inicioSuperUser.fxml"));
        principalPane = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/home.fxml"));
        gerenciarFuncPane = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/gerenciarFuncionarios.fxml"));
        visualizar = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/visualizar.fxml"));
        cadastrarPaciente = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/cadastrarPaciente.fxml"));
        cadastrarFuncionario = FXMLLoader.load(getClass().getResource("/br/com/sistema_hospitalar/view/cadastrarFuncionario.fxml"));
        
        login = new Scene(loginPane);
        principal = new Scene(principalPane);
        if(!FACHADA.administradorVerificarSU()){
            Mensagens.informacao("Super Usuario não cadastrado!", "Pressione OK para ir para tela de Cadastro");
            CadastrarFuncionarioController.get().setOpcao(Enums.adm);
            aux = new Scene(cadastrarFuncionario);
            janela.setScene(aux);
        }else
            janela.setScene(login);
        janela.show();
        
        
              
    }
    public static void trocarTela(String nomeTela){        
        switch(nomeTela){
            case "login":{ janela.setScene(login); break; }
            case "principal":{ janela.setScene(principal); janela.setMaximized(true); break; }
        }
        
    }
    public static void trocarPane(Panes pane){
        if(HomeController.get().getPane() != null)
            pilha.add(HomeController.get().getPane());
        switch(pane){
            case inicioSU:{HomeController.get().alterarPane(inicioSUPane);break;}
            case gerenciarFunc:{HomeController.get().alterarPane(gerenciarFuncPane);break;}
            case cadastrarPaciente:{HomeController.get().alterarPane(cadastrarPaciente);break;}
            case cadastrarFuncionario:{HomeController.get().alterarPane(cadastrarFuncionario);break;}
            default:{System.out.println("O próxima tela não foi encontrada");break;}
        }
    }
    public static void trocarPane(Panes pane, Enums opcao){
        if(HomeController.get().getPane() != null)
            pilha.add(HomeController.get().getPane());
        switch(pane){
            case visualizar:{HomeController.get().alterarPane(visualizar); VisualizarController.get().atualizar(opcao); break;}
        }
    }
    public static void irHome(){
        HomeController.get().alterarPane(inicioSUPane);
    }
    public static void voltar(){
        if(pilha.size() > 0){
            limparPane(pilha.get(pilha.size()-1));
        HomeController.get().alterarPane(pilha.get(pilha.size()-1));
        pilha.remove(pilha.size()-1);
        }
    }

    public static Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Funcionario usuarioLogado) {
        HomeController.get().atualizar(usuarioLogado);
        Controlador.usuarioLogado = usuarioLogado;
    }
    public static void limparPane(Pane p){
        for(Node n: p.getChildren()){
            if(n instanceof TextField)
                ((TextField) n).clear();
            else if (n instanceof PasswordField)
                ((PasswordField) n).clear();
            else if (n instanceof TabPane)
                limparPane((Pane) n);
            else if (n instanceof Pane)
                limparPane((Pane) n);
            else if (n instanceof ComboBox)
                ((ComboBox) n).getSelectionModel().select(null);
            else if (n instanceof TableView)
                ((TableView) n).setItems(null);
//            else if (n instanceof DatePicker)
//                ((((TableView) n).setItems(null);) n).setItems(null);
        }
    }
 
}
