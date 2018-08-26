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
import br.com.sistema_hospitalar.model.entidade.Reserva;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class ReservaDAO {
    
    public  List<Reserva> getReservasPaciente(EntityManagerFactory factory, Long idPaciente){
        EntityManager em = null;
        List<Reserva> reservas = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r where r.idPacientes = :idPaciente", Reserva.class);
            q.setParameter("idPaciente",idPaciente);
            reservas = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ReservaDAO.getReservasPaciente()");
            System.out.println("erro ReservaDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return reservas;
    }
    
    public  List<Reserva> getReservasProntuario(EntityManagerFactory factory, Long idProntuario){
        EntityManager em = null;
        List<Reserva> reservas = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r where r.idProntuario = :idProntuario", Reserva.class);
            q.setParameter("idProntuario",idProntuario);
            reservas = q.getResultList();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ReservaDAO.getReservasProntuario()");
            System.out.println("erro ReservaDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return reservas;
    }
    
    public  Long getReservaVazia(EntityManagerFactory factory){
        EntityManager em = null;
        Long id = null;
        try {
            
            em = factory.createEntityManager();
            TypedQuery<Reserva> q = em.createQuery("SELECT r FROM Reserva r where r.idPacientes = :0 end r.idProntuario = :0 and r.liberado = :true", Reserva.class);
            id = q.getResultList().get(0).getId();

        } catch (Exception e) {
            System.out.println("br.com.sistema_hospitalar.model.dao.ReservaDAO.getReservaVazia()");
            System.out.println("erro ReservaDAO: " + e.getMessage());

        } finally {
            em.close();
        }
        return id;
    }
    
    
}
