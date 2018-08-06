/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade.interfaces;

import br.com.sistema_hospitalar.model.entidade.Municipio;

/**
 *
 * @author rafaelgentil
 */
public interface IEndereco extends IEntidadeBase{
    
    public int getCep();
    public String getDescricao();
    public String getNumero();
    public String getBairro();
    public String getComplemento();
    public Municipio getMunicipio();
    
}
