/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.entidade.interfaces;

import java.util.Date;

/**
 *
 * @author rafaelgentil
 */
public interface Pessoa extends IEntidadeBase {

    public String getNome();

    public String getCpf();

    public String getEmail();

    public String getTefones();

    public String getSexo();

    public Date getDataDeNascimento();

}
