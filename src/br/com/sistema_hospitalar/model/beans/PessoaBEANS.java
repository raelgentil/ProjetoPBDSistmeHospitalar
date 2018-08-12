/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.PessoaDAO;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class PessoaBEANS {
    PessoaDAO daoP;
    DAO<Pessoa> dao;

    public PessoaBEANS() {
        daoP = new PessoaDAO();
        dao = new DAO<>();
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Pessoa pessoa) {
        if (pessoa.getId() ==null) {
            if (daoP.buscarPorCpf(factory, pessoa.getCpf()) == null) {
                return dao.salvarOuAtualizar(factory, pessoa);
            }
        }else{
            return dao.salvarOuAtualizar(factory, pessoa);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Pessoa pessoa) {
        return dao.remover(factory, Pessoa.class, pessoa);
    }

    public Pessoa getPorId(EntityManagerFactory factory,  Pessoa pessoa) {
        
       return dao.getPorId(factory, Pessoa.class, pessoa.getId());
    }
    
     public List<Pessoa> buscarPorNome(EntityManagerFactory factory, String nome) {
         return daoP.buscarPorNome(factory, nome);
    }
    
    public Pessoa buscarPorCpf(EntityManagerFactory factory, String cpf) {
        return daoP.buscarPorCpf(factory, cpf);
    }
    
    
    
}
