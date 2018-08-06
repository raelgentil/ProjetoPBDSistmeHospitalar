/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao.interfaces;

import br.com.sistema_hospitalar.model.entidade.Estado;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public interface IEstadoDAO {
    public Estado encontrarPorUf(EntityManagerFactory factory, String uf);
    
    public List<Estado> buscarPorNome(EntityManagerFactory factory, String descricao);
    
    public Estado getMunicipios(Estado estadoVo, EntityManagerFactory factory);
}
