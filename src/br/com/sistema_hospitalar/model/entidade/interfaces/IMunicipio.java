/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade.interfaces;

import br.com.sistema_hospitalar.model.entidade.Estado;

/**
 *
 * @author rafaelgentil
 */
public interface IMunicipio extends IEntidadeBase{

    public int getCep();
    public String getDescricao();
    public Estado getEstado();
    
}
