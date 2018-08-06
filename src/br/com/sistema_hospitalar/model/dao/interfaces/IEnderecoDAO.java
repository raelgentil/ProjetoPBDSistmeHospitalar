/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao.interfaces;

import br.com.sistema_hospitalar.model.entidade.Endereco;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public interface IEnderecoDAO {

    public List<Endereco> listarPorBairro(EntityManagerFactory factory, String bairro);

    public List<Endereco> listarPordescricao(EntityManagerFactory factory, String descricao);

    public Endereco getMunicipio(Endereco enderecoVo, EntityManagerFactory factory);
}
