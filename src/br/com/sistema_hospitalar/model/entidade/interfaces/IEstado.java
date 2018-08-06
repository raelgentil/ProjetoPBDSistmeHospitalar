/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade.interfaces;

/**
 *
 * @author rafaelgentil
 */
public interface IEstado extends IEntidadeBase{
    public String getUf();
    public String getDescricao();
    public String toString();
    public Object getMunicipios();
}
