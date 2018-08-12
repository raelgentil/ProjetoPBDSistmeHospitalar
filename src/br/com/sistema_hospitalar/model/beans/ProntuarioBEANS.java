/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProntuarioDAO;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author rafaelgentil
 */
public class ProntuarioBEANS {

    DAO<Prontuario> dao;
    DAO<CategoriaCID> daoC;
    ProntuarioDAO daoP;

    public ProntuarioBEANS() {
        this.dao = new DAO<>();
        this.daoC = new DAO<>();
        this.daoP = new ProntuarioDAO();
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Prontuario prontuario) {
        if (prontuario.getId() == null) {
            return dao.salvarOuAtualizar(factory, prontuario);
        } else {
            return dao.salvarOuAtualizar(factory, prontuario);
        }
    }

    public boolean remover(EntityManagerFactory factory, Prontuario prontuario) {
        return dao.remover(factory, Prontuario.class, prontuario);
    }

    public Prontuario getPorId(EntityManagerFactory factory, Prontuario prontuario) {
        prontuario = dao.getPorId(factory, Prontuario.class, prontuario.getId());
        return buscarCIDs(factory, prontuario);
    }

    public String buscarCodMedicoPaciente(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente) {
        return daoP.buscarCodMedicoPaciente(factory, idPaciente, codMedicoPaciente);
    }

    public List<Prontuario> buscarPorCodMedicoPacient(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente) {
        List<Prontuario> prontuarios = daoP.buscarPorCodMedicoPacient(factory, idPaciente, codMedicoPaciente);
        for (Prontuario prontuario : prontuarios) {
            prontuario = buscarCIDs(factory, prontuario);
        }
        return prontuarios;
    }

    public int ultimoRegistroDeUmMedico(EntityManagerFactory factory, String codMedicoPaciente) {
        return daoP.ultimoRegistroDeUmMedico(factory, codMedicoPaciente);
    }

    private Prontuario buscarCIDs(EntityManagerFactory factory, Prontuario prontuario) {
        String[] ids = prontuario.getCids().split(";");
        List<CategoriaCID> categorias = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            categorias.add(daoC.getPorId(factory, CategoriaCID.class, Long.parseLong(ids[i])));

        }
        return new Prontuario(prontuario.getId(), prontuario.getNumero(), prontuario.getDataAbertura(), prontuario.getDataRetorno(),
                prontuario.getDataRetorno(), categorias, prontuario.getCodMedicoPaciente(), prontuario.getObservacoes(),
                prontuario.getPrescricao(), prontuario.getPaciente(), prontuario.getMedico());
    }
    
    private Prontuario atualizarCIDs(Prontuario prontuario){
        String cids= "";
        for (CategoriaCID cID : prontuario.getCidss()) {
            cids += cID.getId() + ";";
        }
        return new Prontuario(prontuario.getId(), prontuario.getNumero(), prontuario.getDataAbertura(), prontuario.getDataRetorno(),
                prontuario.getDataRetorno(), cids, prontuario.getCodMedicoPaciente(), prontuario.getObservacoes(),
                prontuario.getPrescricao(), prontuario.getPaciente(), prontuario.getMedico());
    }

}
