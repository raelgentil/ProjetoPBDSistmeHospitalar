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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Funcionario funcionario = null;
        String senhaCrip = criptografar(senha);
        if (login == null) {
            funcionario = daoF.buscarUsuarioPrimeiroAcesso(factory, senha, senhaCrip);
        } else {
            funcionario = daoF.buscarUsuario(factory, login);
            if (funcionario != null && funcionario.getSenha().equals(senhaCrip)) {

            } else {
                funcionario = null;
            }
        }
        return funcionario;
    }

    public List<Funcionario> buscarPorAtivos(EntityManagerFactory factory, boolean ativo) {
        return daoF.buscarPorAtivos(factory, ativo);
    }

//    public String criarLogin(EntityManagerFactory factory, Pessoa pessoa) {
//        String[] nomes = pessoa.getNome().split(" ");
//        String login = "";
//
//        
//        for (int i = 0; i < nomes.length; i++) {
//            for (int j = 0; j < nomes.length; j++) {
//                if (!(nomes[i].equals(nomes[j]))) {
//                    login = nomes[i] + "." + nomes[j];
//                    if (daoF.buscarUsuario(factory, login) == null) {
//                        return login;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < nomes.length; i++) {
//            for (int j = 0; j < nomes.length; j++) {
//                if (!(nomes[i].equals(nomes[j]))) {
//                    login = nomes[i] + "." + nomes[j];
//                    if (daoF.buscarUsuario(factory, login + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH)) == null) {
//                        return login + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH);
//                    }
//                }
//            }
//        }
//
//        return null;
//    }
    
      public String criarLogin(EntityManagerFactory factory, Pessoa pessoa) {
       String[] nomes = pessoa.getNome().split(" ");
        String apelido = "";

        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                apelido += nomes[i] + "."+  pessoa.getCpf().substring(0, 3);
            }
            if (i >= 1 ) {
                if (i==1) {
                   apelido =  apelido.replaceAll("."+pessoa.getCpf().substring(0, 3), "");
                }
                apelido += "." +  nomes[i] ;
            }

            if (daoF.buscarUsuario(factory, apelido ) == null) {
                return apelido;
            }
            System.out.println("Contador: " + i);
        }
        
        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                apelido += nomes[i] + "." + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH);
            }
            if (i >= 1 ) {
                apelido =  apelido.replace("." + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH)+ "", "");
                apelido += "." +  nomes[i] + pessoa.getDataDeNascimento().get(GregorianCalendar.DAY_OF_MONTH);
            }

            if (daoF.buscarUsuario(factory, apelido ) == null) {
                return apelido;
            }
            System.out.println("Contador: " + i);
        }
        
        for (int i = 0; i < 3; i++) {
            if (i < 1) {
                apelido += nomes[i] + "." + pessoa.getDataDeNascimento().get(GregorianCalendar.MONTH);
            }
            if (i >= 1 ) {
                apelido =  apelido.replace("." + pessoa.getDataDeNascimento().get(GregorianCalendar.MONTH)+ "", "");
                apelido += "." +  nomes[i] + pessoa.getDataDeNascimento().get(GregorianCalendar.MONTH);
            }
           

            if (daoF.buscarUsuario(factory, apelido ) == null) {
                return apelido;
            }
            System.out.println("Contador: " + i);
        }

        return null;
    }

    public boolean resetSenha(EntityManagerFactory factory, Long id) {
        Funcionario funcionario = dao.getPorId(factory, Funcionario.class, id);
        funcionario.setSenha(criptografar(funcionario.getCpf()));
        funcionario.setResetar(false);

        return dao.salvarOuAtualizar(factory, funcionario);

    }

    public boolean solicitarResetSenha(EntityManagerFactory factory, String cpf) {
        Funcionario funcionario = daoF.buscarCPF(factory, cpf);
        if (funcionario != null) {
        funcionario.setResetar(true);
            return dao.salvarOuAtualizar(factory, funcionario);

        } else {
            return false;

        }
    }

    protected String criptografar(String senha) {
        String senhaCrip = "";
        MessageDigest md;

        try {
            md = MessageDigest.getInstance("MD5");
            byte[] byteSenha = senha.getBytes();
//            for (int i = 0; i < byteSenha.length; i++) {
//                byte b = byteSenha[i];
//                
//            }
            BigInteger hash = new BigInteger(1, md.digest(byteSenha));
            senhaCrip = hash.toString(16);

        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return senhaCrip;
    }

}
