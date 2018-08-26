/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProntuarioDAO;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import br.com.sistema_hospitalar.model.entidade.Reserva;
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
    DAO<Lote> daoL;
    ProntuarioDAO daoP;
    ReservaBEANS reservaBEANS;

    public ProntuarioBEANS( ReservaBEANS reservaBEANS) {
        this.dao = new DAO<>();
        this.daoC = new DAO<>();
        this.daoL = new DAO<>();
        this.daoP = new ProntuarioDAO();
        this.reservaBEANS = reservaBEANS;
    }

    public boolean salvarOuAtualizar(EntityManagerFactory factory, Prontuario prontuario) {
        if(prontuario.getCidss() != null)
            prontuario.setCids(atualizarCIDs(prontuario.getCidss()));
        if(prontuario.getPrescricaoo() != null)
            prontuario.setPrescricao(atualizarPrescricao(factory, prontuario));
        String codigo = buscarCodMedicoPaciente(factory, prontuario.getPaciente().getId(), prontuario.getMedico().getApelido());
        if (codigo != null) {
            prontuario.setCodMedicoPaciente(codigo);
        }
        if (codigo == null) {

            prontuario.setCodMedicoPaciente(prontuario.getMedico().getApelido()+ prontuario.getPaciente().getId());

        }
        if (prontuario.getId() == null) {
            return dao.salvarOuAtualizar(factory, prontuario);
        } else {
            return dao.salvarOuAtualizar(factory, prontuario);
        }
    }

    public boolean remover(EntityManagerFactory factory, Prontuario prontuario) {
        return dao.remover(factory, Prontuario.class, prontuario);
    }

    public Prontuario getPorId(EntityManagerFactory factory, Long id) {
        Prontuario prontuario = dao.getPorId(factory, Prontuario.class, id);
        prontuario.setCidss(buscarCIDs(factory, prontuario.getCids()));
         prontuario.setPrescricaoo(buscarPrescricao(factory, prontuario.getPrescricao()));
        return prontuario;
    }

    public String buscarCodMedicoPaciente(EntityManagerFactory factory, Long idPaciente, String codMedicoPaciente) {
        return daoP.buscarCodMedicoPaciente(factory, idPaciente, codMedicoPaciente);
    }

    public List<Prontuario> buscarPorCodMedicoPacient(EntityManagerFactory factory, String codMedicoPaciente) {
        List<Prontuario> prontuarios = daoP.buscarPorCodMedicoPacient(factory,codMedicoPaciente);
        for (Prontuario prontuario : prontuarios) {
            if(prontuario.getCids() != null)
                prontuario.setCidss(buscarCIDs(factory, prontuario.getCids()));
            if(prontuario.getPrescricao()!= null)
                prontuario.setPrescricaoo(buscarPrescricao(factory, prontuario.getPrescricao()));
        }
        return prontuarios;
    }


    private List<CategoriaCID> buscarCIDs(EntityManagerFactory factory, String cids) {
        String[] ids = cids.split(";");
        List<CategoriaCID> categorias = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            categorias.add(daoC.getPorId(factory, CategoriaCID.class, Long.parseLong(ids[i])));
        }
        return categorias;
    }
    
    private String atualizarCIDs(List<CategoriaCID> categorias){
        String cids= "";
        for (CategoriaCID cID : categorias) {
            cids += cID.getId() + ";";
        }
        return cids;
    }
    
     private List<Lote> buscarPrescricao(EntityManagerFactory factory, String prescricao) {
        String[] ids = prescricao.split(";");
        List<Lote> lotes = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            String[] SegundaQuebra = ids[i].split("/");
            Lote lote = daoL.getPorId(factory, Lote.class, Long.parseLong(SegundaQuebra[0]));
            if (SegundaQuebra[0].equals("s")) {
                lote.setInsumoPego(true);
            }else{
                lote.setInsumoPego(false);
            }
            
            lotes.add(lote);
   
        }
        return lotes;
    }
    
    private String atualizarPrescricao(EntityManagerFactory factory, Prontuario prontuario){
        String lotess= "";
        boolean reservar = false;
        if (reservaBEANS.getReservasProntuario(factory, Long.MIN_VALUE) == null) {
            reservar = true;
        }
        for (Lote lote : prontuario.getPrescricaoo()) {
            if (reservar) {
                Reserva reserva = new Reserva();
                reserva.setIdPacientes(prontuario.getPaciente().getId());
                reserva.setIdProntuario(prontuario.getId());
                reserva.setId(reservaBEANS.getReservaVazia(factory));
                if (lote.getInsumo().getQuantidadeTotal()<= lote.getInsumo().getQuantidadeMinima()) {
                    reserva.setLiberado(false);
                }
                
                    reservaBEANS.salvarOuAtualizar(factory, reserva);
               
            }
            if (lote.isInsumoPego()) {
                lotess +=  "s/" + lote.getId() + ";";
            }else{
                 lotess +=  "n/" + lote.getId() + ";";
            }
            
            //lembrar de atualizar a parte do banco pra saber se o paciente ta levando o medicamento
            //receitado pelo medico
        }
        return lotess;
    }

}
