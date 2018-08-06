/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;


import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.EnderecoDAO;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class EnderecoBEANS{

    EnderecoDAO daoE;
    DAO<Endereco> dao;

    public EnderecoBEANS() {
        daoE = new EnderecoDAO();
        dao = new DAO<>();
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Endereco endereco) {
        if (endereco.getId() == null) {
            List<Endereco> enderecos = daoE.buscarPordescricao(factory, endereco.getDescricao());
            boolean igual = false;
            for (Endereco endereco1 : enderecos) {
                if (endereco.getBairro().equals(endereco1.getBairro()) && endereco.getNumero().equals(endereco1.getNumero())) {
                    igual = true;
                }
            }
            if (!igual) {
                return dao.salvarOuAtualizar(factory, endereco);
            }
        } else {
            return dao.salvarOuAtualizar(factory, endereco);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, Endereco endereco) {
        return dao.remover(factory, endereco);

    }

    public Endereco getPorId(EntityManagerFactory factory, Endereco endereco) {

        return dao.getPorId(factory, Endereco.class, endereco.getId());
    }

    public List<Endereco> buscarPorBairro(EntityManagerFactory factory, String bairro) {
        return daoE.buscarPorBairro(factory, bairro);
    }


    public List<Endereco> buscarPordescricao(EntityManagerFactory factory, String descricao) {
        return daoE.buscarPordescricao(factory, descricao);
    }

    public Endereco getMunicipio(EntityManagerFactory factory, Endereco endereco) {
        return  daoE.getMunicipio(factory, endereco);
    }

}
