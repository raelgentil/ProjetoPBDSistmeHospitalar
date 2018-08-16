/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Paciente;
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
public class FuncionarioResetSenhaDAO {
    
    public  List<FuncionarioResetSenha> getFuncionariosAResetarSenha(EntityManagerFactory factory){
        EntityManager em = null;
        List<FuncionarioResetSenha> resetSenhas = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<FuncionarioResetSenha> q = em.createQuery("SELECT r FROM ResetSenha r ", FuncionarioResetSenha.class);
            resetSenhas = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ResetSenhaDAO.getFuncionariosAResetarSenha()");
            System.out.println("erro ResetSenhaDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return resetSenhas;
    }
    
    
}
