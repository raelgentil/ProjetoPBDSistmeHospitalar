/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao.interfaces;

import br.com.sistema_hospitalar.model.entidade.Municipio;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public interface IMunicipioDAO {
     public List<Municipio> buscarPorDescricao(EntityManagerFactory factory, String descricao);
     
     public Municipio getEstado(Municipio mv, EntityManagerFactory factory);
    
}
