/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.PacienteDAO;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;

/**
 *
 * @author rafaelgentil
 */
public class PacienteBEANS {

    private PacienteDAO daoP;
    private DAO<Paciente> dao;

    public PacienteBEANS() {
        this.daoP = new PacienteDAO();
        this.dao = new DAO<>();
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Paciente paciente) {
        if (paciente.getId() == null) {
                return dao.salvarOuAtualizar(factory, paciente);
            
        } else {
            return dao.salvarOuAtualizar(factory, paciente);
        }
    }

    public boolean remover(EntityManagerFactory factory, Paciente paciente) {
        return dao.remover(factory, Paciente.class, paciente);
    }

    public Paciente getPorId(EntityManagerFactory factory, Paciente paciente) {

        return dao.getPorId(factory, Paciente.class, paciente.getId());
    }

    public List<Paciente> buscarPorNome(EntityManagerFactory factory, String nome) {
        return daoP.buscarPorNome(factory, nome);
//        List<Pessoa> pessoas = daoP.buscarPorNome(factory, nome);
//        List<Paciente> pacientes = new ArrayList<>();
//        for (Pessoa pessoa : pessoas) {
//            pacientes.add((Paciente) pessoa);
//        }
//        return pacientes;
    }

    public Paciente buscarPorCpf(EntityManagerFactory factory, String cpf) {
        return (Paciente) daoP.buscarPorCpf(factory, cpf);
    }

    public List<Paciente> buscarPorTipoSanguinio(EntityManagerFactory factory, String tipoSanguinio) {
        return daoP.buscarPorTipoSanguinio(factory, tipoSanguinio);
    }

    public List<Paciente> buscarPorFatoRH(EntityManagerFactory factory, boolean fatorRh) {
        return daoP.buscarPorFatoRH(factory, fatorRh);
    }

    public List<Paciente> buscarPorLimitacoes(EntityManagerFactory factory, String limitacao) {
        return daoP.buscarPorLimitacoes(factory, limitacao);
    }

    public List<Paciente> buscarPorAlergias(EntityManagerFactory factory, String alergia) {
        return daoP.buscarPorAlergias(factory, alergia);
    }

    public List<Paciente> buscarPorDataDeFalecimento(EntityManagerFactory factory, Calendar date) {
        return daoP.buscarPorDataDeFalecimento(factory, date);
    }

    public List<Paciente> buscarPorDoadorDeOrgaos(EntityManagerFactory factory, boolean alergia) {
        return daoP.buscarPorDoadorDeOrgaos(factory, alergia);
    }

//    public Paciente getProntuarios(EntityManagerFactory factory, Paciente paciente) {
//       paciente = daoP.getProntuarios(factory, paciente);
//       
//       List<Prontuario> prontuarios = paciente.getProntuarios();
//       
//        for (Prontuario prontuario : prontuarios) {
//            if (prontuario.getCodMedicoPaciente().equals("trazer o medico por parametro ou apenas o seu apelido")) {
//                prontuarios.remove(prontuario);
//            }
//        }
//        
//        return new Paciente(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefones(), paciente.getSexo(), 
//                paciente.getDataDeNascimento(), paciente.getEndereco(), paciente.getTipoSanguinio(), paciente.isFatorRh(), paciente.getLimitacoes(), 
//                paciente.getAlergias(), paciente.getDataDeFalecimento(), paciente.getDoadorDeOrgaos(),paciente.getDependentes(), prontuarios);
//    };

}
