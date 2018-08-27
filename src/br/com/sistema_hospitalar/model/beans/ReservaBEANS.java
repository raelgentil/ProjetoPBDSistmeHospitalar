/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.*;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ResetSenha;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
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
public class ReservaBEANS {
    ReservaDAO daoR;
    DAO<Reserva> dao;

    public ReservaBEANS() {
        daoR = new ReservaDAO();
        dao = new DAO<>();
    }
    
    public boolean salvarOuAtualizar(EntityManagerFactory factory, Reserva reserva) {
        
            return dao.salvarOuAtualizar(factory, reserva);
    }

    public boolean remover(EntityManagerFactory factory, Reserva reserva) {
        reserva.setIdPacientes(0L);
        reserva.setIdProntuario(0L);
        reserva.setLiberado(true);
        return dao.salvarOuAtualizar(factory, reserva);
    }

    public Reserva getPorId(EntityManagerFactory factory, Long id) {
        return dao.getPorId(factory, Reserva.class, id);
    }
    public  List<Reserva> getReservasPaciente(EntityManagerFactory factory, Long idPaciente){
        return daoR.getReservasPaciente(factory, idPaciente);
    }
    
    public  List<Reserva> getReservasProntuario(EntityManagerFactory factory, Long idProntuario){
        return daoR.getReservasProntuario(factory, idProntuario);
    }
    
     public  Long getReservaVazia(EntityManagerFactory factory){
         return daoR.getReservaVazia(factory);
     }
    
}
