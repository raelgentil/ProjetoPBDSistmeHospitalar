/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.dao;


import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class ProntuarioDAO {
    
    
    public String buscarCodMedicoPaciente(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente){
        EntityManager em = null;
        String codigo = null;
        try {
            
            em = factory.createEntityManager();
            /**
             * Em tela vai funcionar como se o atendente pesquisasse o paciente e selecionasse o medico
             * q o paciente vai e depois verificava se esse paciente ja possui ou não vinculo com aquele medico
             */
            TypedQuery<Prontuario> q = em.createQuery("select p from Prontuario p where p.paciente.id = :id and p.codMedicoPaciente like :codMedicoPaciente", Prontuario.class);
            q.setParameter("id", idPaciente);
            q.setParameter("codMedicoPaciente", codMedicoPaciente + "%" );
            codigo = q.getSingleResult().getCodMedicoPaciente();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ProntuarioDAO.buscarPorCodMedicoPaciente()");
            System.out.println("erro ProntuarioDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return codMedicoPaciente;
    }
    
    
    public List<Prontuario> buscarPorCodMedicoPacient(EntityManagerFactory factory,String codMedicoPaciente){
        EntityManager em = null;
        List<Prontuario> prontuarios = null;
        try {
             
            em = factory.createEntityManager();
           
            TypedQuery<Prontuario> q = em.createQuery("select p from Prontuario p where p.codMedicoPaciente = :codMedicoPaciente", Prontuario.class);
            q.setParameter("codMedicoPaciente", codMedicoPaciente + "%");
            prontuarios = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ProntuarioDAO.buscarPorCodMedicoPaciente()");
            System.out.println("erro ProntuarioDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return prontuarios;
    }
//    
//    public int ultimoRegistroDeUmMedico(EntityManagerFactory factory, String codMedicoPaciente){
//        EntityManager em = null;
//        int quantidade = 0;
//        
//        try {
//
//            em = factory.createEntityManager();
//           
//            TypedQuery<Prontuario> q = em.createQuery("select p from Prontuario p where p.codMedicoPaciente like :codMedicoPaciente", Prontuario.class);
//            q.setParameter("codMedicoPaciente", codMedicoPaciente + "%");
//            quantidade = q.getResultList().size();
//
//        } catch (Exception e) {
//            System.out.println("br.com.sistema_hospitalar.model.dao.ProntuarioDAO.buscarPorCodMedicoPaciente()");
//            System.out.println("erro ProntuarioDAO: " + e.getMessage());
//
//        } finally {
//            em.close();
//        }
//        return quantidade;
//    }
    
    
    
    
}
