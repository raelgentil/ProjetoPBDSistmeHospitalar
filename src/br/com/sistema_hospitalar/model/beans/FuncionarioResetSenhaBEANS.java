/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.FuncionarioResetSenhaDAO;
import br.com.sistema_hospitalar.model.entidade.FuncionarioResetSenha;
import java.util.List;
import javax.persistence.EntityManagerFactory;

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
