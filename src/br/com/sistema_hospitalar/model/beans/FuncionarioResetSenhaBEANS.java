/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.InsumoDAO;
import br.com.sistema_hospitalar.model.dao.LoteDAO;
import br.com.sistema_hospitalar.model.dao.FuncionarioResetSenhaDAO;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.FuncionarioResetSenha;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class FuncionarioResetSenhaBEANS {
    private FuncionarioResetSenhaDAO dao;

    public FuncionarioResetSenhaBEANS(InsumoBEANS insumoBEANS) {
        dao =new FuncionarioResetSenhaDAO();
        
    }
    
    public  List<FuncionarioResetSenha> getFuncionariosAResetarSenha(EntityManagerFactory factory){
       return dao.getFuncionariosAResetarSenha(factory);
    }
    
}
