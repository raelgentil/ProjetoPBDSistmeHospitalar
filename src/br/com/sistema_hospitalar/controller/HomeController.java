/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package br.com.sistema_hospitalar.controller;

import br.com.sistema_hositalar.util.Mensagens;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author João Emerson
 */
public class HomeController implements Initializable {
    
    private static HomeController controller = null;
    private static Pane panel;
    private ArrayList<Pane> paineis;
    @FXML
    private StackPane pane;
    @FXML
    private Label nomeUsuario;
    
    @FXML
    private ImageView usuario;
    
    @FXML
    private ImageView sairSessao;
    
    @FXML
    private ImageView home;
    
    @FXML
    private ImageView voltar;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = this;
        paineis = new ArrayList<>();
        voltar.setOnMouseClicked((MouseEvent e)->{
            Controlador.voltar();
           // voltar();
        });
        home.setOnMouseClicked((MouseEvent e)->{
            Controlador.irHome();
        });
        sairSessao.setOnMouseClicked((MouseEvent e)->{
            Controlador.Logout();
        });
        usuario.setOnMouseClicked((event) -> {
            Funcionario f = Controlador.getUsuarioLogado();
            String senha;
            boolean valido = false;
            do{
                senha = Mensagens.inserirTexto("Insira Uma nova Senha", "Digite uma nova senha", "");
                if(senha.length() > 6 && senha.length() < 11)
                    valido = true;
                else
                    Mensagens.erro("Senha invalida", "Sua senha deve ter entre 6 a 11 caracteres alfanumericos!");
            }while(!valido);
            f.setSenha(senha);
            if(f instanceof Administrador)
                Controlador.FACHADA.administradorSalvarOuAtualizar((Administrador) f);
            else if(f instanceof ProfissionalSaude)
                Controlador.FACHADA.profissionalSaudeSalvarOuAtualizar((ProfissionalSaude) f);
            else if(f instanceof Atendente)
                Controlador.FACHADA.atendenteSalvarOuAtualizar((Atendente) f);
            Controlador.setUsuarioLogado(f);
            
        });
        
    }
    public  void atualizar(Funcionario f){
        if(f != null)
        nomeUsuario.setText(f.getNome().toUpperCase());
        else
            nomeUsuario.setText("NOME USUARIO");
        
    }
    public void alterarPane(Pane p){
//        paineis.add(p);
        panel = p;
        pane.getChildren().setAll(p);
    }
//    private void voltar(){        
//        if(paineis.size() > 0){
//            int lastIndex = paineis.size()-1;
//            pane.getChildren().setAll( paineis.get(lastIndex));
//            paineis.remove(lastIndex);
//            System.out.println("voltei  Tamanho: "+ paineis.size());
//        }else
//            System.out.println("Não volto  Tamanho: "+ paineis.size());
//    }
    public static HomeController get(){
        return controller;
    }
    

    public Pane getPane() {
        return panel;
    }
    
    
}
