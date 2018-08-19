package br.com.sistema_hospitalar.controller;

import br.com.sistema_hospitalar.enums.Enums;
import br.com.sistema_hospitalar.enums.Panes;
import static br.com.sistema_hospitalar.enums.Panes.gerenciarFunc;
import static br.com.sistema_hospitalar.enums.Panes.inicioSU;
import br.com.sistema_hospitalar.model.fachada.CoreFacade;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author João Emerson
 */
public class Controlador extends Application{
    
    private static Stage janela;
    private static Scene login,principal;
    private static Pane principalPane,inicioSUPane, gerenciarFuncPane, visualizar, cadastrarPaciente,cadastrarFuncionario;
    private static ArrayList<Pane> pilha;
    public  static CoreFacade FACHADA = new CoreFacade();
    
    public static void main(String[] args){
        launch(args);    
       
    }
    
    @Override
    public void start(Stage stage) throws Exception {
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
        stage.setScene(login);
        janela = stage;
        stage.show();
        
        
              
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
        HomeController.get().alterarPane(pilha.get(pilha.size()-1));
        pilha.remove(pilha.size()-1);
        }
    }
}
