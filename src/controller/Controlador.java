package controller;

import enums.Panes;
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
    private static Pane ANTERIOR,principalPane,inicioSUPane, gerenciarFuncPane, visualizar;
    
    
    public static void main(String[] args){
        launch(args);    
       
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Pane loginPane = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
        inicioSUPane = FXMLLoader.load(getClass().getResource("/view/inicioSuperUser.fxml"));
        principalPane = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        gerenciarFuncPane = FXMLLoader.load(getClass().getResource("/view/gerenciarFuncionarios.fxml"));
        visualizar = FXMLLoader.load(getClass().getResource("/view/visualizar.fxml"));
        
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
        //ANTERIOR = HomeController.get().getPane();
        switch(pane){
            case inicioSU:{HomeController.get().alterarPane(inicioSUPane);break;}
            case gerenciarFunc:{HomeController.get().alterarPane(gerenciarFuncPane);break;}
            case visualizar:{HomeController.get().alterarPane(visualizar);break;}
        }
    }
    public static void irHome(){
        HomeController.get().alterarPane(inicioSUPane);
    }
//    public Pane getPane(Tela tela){//NÃO usado
//        switch(tela){
//            case inicioSU: {return inicioSUPane;}
//           
//        }
//    return null;
//    }
     
    
}
