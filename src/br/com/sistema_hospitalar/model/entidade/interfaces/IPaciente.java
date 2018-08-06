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
public interface IPaciente extends Pessoa {

    public String getTipoSanguinio();

    public boolean isFatorRh();

    public String getLimitacoes();

    public String getAlergias();

    public Date getDataDeFalecimento();

    public Boolean getDoadorDeOrgaos();
}
