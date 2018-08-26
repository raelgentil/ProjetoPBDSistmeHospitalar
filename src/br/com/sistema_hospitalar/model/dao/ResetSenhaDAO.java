/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;

import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ResetSenha;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class ResetSenhaDAO {
    
    public  List<ResetSenha> getFuncionariosAResetarSenha(EntityManagerFactory factory){
        EntityManager em = null;
        List<ResetSenha> resetSenhas = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<ResetSenha> q = em.createQuery("SELECT r FROM ResetSenha r", ResetSenha.class);
            resetSenhas = q.getResultList();
            
        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ResetSenhaDAO.getFuncionariosAResetarSenha()");
            System.out.println("erro ResetSenhaDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return resetSenhas;
    }

    
//    public  List<FuncionarioResetSenha> getFuncionariosAResetarSenha(EntityManagerFactory factory){
//        EntityManager em = null;
//        List<FuncionarioResetSenha> resetSenhas = null;
//        try {
//            
//            em = factory.createEntityManager();
//            Query q= em.createQuery("SELECT * FROM reset_senha");
////            TypedQuery<FuncionarioResetSenha> q = em.createQuery("SELECT r FROM reset_senha r ", ResetSenha.class);
//            resetSenhas = (List<FuncionarioResetSenha>) q.getResultList();
//
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.ResetSenhaDAO.getFuncionariosAResetarSenha()");
//            System.out.println("erro ResetSenhaDAO: " + e.getMessage());
//
//        } finally {
//            em.close();
//        }
//        return resetSenhas;
//    }
//    
    
}
