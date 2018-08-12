/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.FuncionarioDAO;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class FuncionarioBEANS {

    FuncionarioDAO daoF;
    DAO<Funcionario> dao;

    public FuncionarioBEANS() {
        daoF = new FuncionarioDAO();
        dao = new DAO<>();
    }

    public Funcionario buscarUsuario(EntityManagerFactory factory, String login, String senha) {
        Funcionario funcionario = daoF.buscarUsuario(factory, login);
        if (funcionario.getSenha().equals(senha)) {
            return funcionario;
        } else {
            return null;
        }
    }

    public List<Funcionario> buscarPorAtivos(EntityManagerFactory factory, boolean ativo) {
        return daoF.buscarPorAtivos(factory, ativo);
    }

    public String criarLogin(EntityManagerFactory factory, Pessoa pessoa) {
        String[] nomes = pessoa.getNome().split(" ");
        String login = "";
        
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                if (!(nomes[i].equals(nomes[j]))) {
                    login = nomes[i] + "." + nomes[j];
                    if (daoF.buscarUsuario(factory, login) == null) {
                        return login;
                    }
                }
            }
        }
        
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < nomes.length; j++) {
                if (!(nomes[i].equals(nomes[j]))) {
                    login = nomes[i] + "." + nomes[j];
                     if (daoF.buscarUsuario(factory, login + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH)) == null) {
                        return login + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH);
                    }
                }
            }
        }
        
        return null;
    }
    
    public void resetSenha(){
        
        
    }

}
