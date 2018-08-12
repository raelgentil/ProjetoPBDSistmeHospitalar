/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.beans;

import br.com.sistema_hospitalar.model.dao.DAO;
import br.com.sistema_hospitalar.model.dao.ProficionalSaudeDAO;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rafaelgentil
 */
public class ProficionalSaudeBEANS {
    DAO<ProfissionalSaude> dao;
    ProficionalSaudeDAO daoP;
    FuncionarioBEANS beansF;
    EspecializacaoBEANS beansE;
    public ProficionalSaudeBEANS(FuncionarioBEANS funcionarioBEANS, EspecializacaoBEANS beansE) {
        this.dao = new DAO<>();
        this.daoP = new ProficionalSaudeDAO();
        this.beansF = funcionarioBEANS;
        this.beansE = beansE;
    }
    
     public boolean salvarOuAtualizar(EntityManagerFactory factory, ProfissionalSaude profissionalSaude) {
         
        if (profissionalSaude.getId() == null) {
                String login = beansF.criarLogin(factory, profissionalSaude);
                
            if (login !=null) {
                return dao.salvarOuAtualizar(factory, new ProfissionalSaude(profissionalSaude.getId(), profissionalSaude.getNome(), profissionalSaude.getCpf(),
                        profissionalSaude.getEmail(), profissionalSaude.getTelefones(), profissionalSaude.getSexo(), profissionalSaude.getDataDeNascimento(),
                        profissionalSaude.getEndereco(), login, profissionalSaude.getSenha(), profissionalSaude.getSalario(), profissionalSaude.getCargaHorariaMinimaMensal(),
                        profissionalSaude.getHoraextra(), profissionalSaude.isAtivo(), profissionalSaude.getApelido(), converterEspecializacoes(profissionalSaude.getEspecializacoess()), profissionalSaude.getPacientesMarcados()));
            } else {
                System.err.println("Erro Atendente ja existe");
            }
        } else {
            return dao.salvarOuAtualizar(factory, profissionalSaude);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, ProfissionalSaude profissionalSaude) {
        return dao.remover(factory, ProfissionalSaude.class, profissionalSaude);
    }

    public ProfissionalSaude getPorId(EntityManagerFactory factory, ProfissionalSaude profissionalSaude) {

        return dao.getPorId(factory, ProfissionalSaude.class, profissionalSaude.getId());
    }

    public List<ProfissionalSaude> buscarPorNome(EntityManagerFactory factory, String nome) {
        List<ProfissionalSaude> profissionalSaudes = daoP.buscarPorNome(factory, nome);
        for (ProfissionalSaude profissionalSaude : profissionalSaudes) {
           profissionalSaude = new ProfissionalSaude(profissionalSaude.getId(), profissionalSaude.getNome(), profissionalSaude.getCpf(),
                        profissionalSaude.getEmail(), profissionalSaude.getTelefones(), profissionalSaude.getSexo(), profissionalSaude.getDataDeNascimento(),
                        profissionalSaude.getEndereco(), profissionalSaude.getLogin(), profissionalSaude.getSenha(), profissionalSaude.getSalario(), profissionalSaude.getCargaHorariaMinimaMensal(),
                        profissionalSaude.getHoraextra(), profissionalSaude.isAtivo(), profissionalSaude.getApelido(), carregarEspecializacoes(factory, profissionalSaude.getEspecializacoes()), profissionalSaude.getPacientesMarcados());
        }
        return profissionalSaudes;
    }

    public ProfissionalSaude buscarPorCpf(EntityManagerFactory factory, String cpf) {
        ProfissionalSaude profissionalSaude = (ProfissionalSaude) daoP.buscarPorCpf(factory, cpf);
        profissionalSaude = new ProfissionalSaude(profissionalSaude.getId(), profissionalSaude.getNome(), profissionalSaude.getCpf(),
                        profissionalSaude.getEmail(), profissionalSaude.getTelefones(), profissionalSaude.getSexo(), profissionalSaude.getDataDeNascimento(),
                        profissionalSaude.getEndereco(), profissionalSaude.getLogin(), profissionalSaude.getSenha(), profissionalSaude.getSalario(), profissionalSaude.getCargaHorariaMinimaMensal(),
                        profissionalSaude.getHoraextra(), profissionalSaude.isAtivo(), profissionalSaude.getApelido(), carregarEspecializacoes(factory, profissionalSaude.getEspecializacoes()), profissionalSaude.getPacientesMarcados());
        return profissionalSaude;
    }
    
    private String converterEspecializacoes(List<Especializacao> especializacoes){
        String especializacoess = "";
        for (Especializacao especializacao : especializacoes) {
            especializacoess += especializacao.getConselho() + "/" + especializacao.getCodigo() + ";";
        }
        return especializacoess;
    }
    
    private List<Especializacao> carregarEspecializacoes(EntityManagerFactory factory, String especializacoes){
        List<Especializacao> especializacoess = new ArrayList<>();
        try{
        String [] especializacoesPrimeiraQuebra = especializacoes.split(";");
        for (int i = 0; i < especializacoesPrimeiraQuebra.length; i++) {
            String [] especializacoesSegundaQuebra = especializacoesPrimeiraQuebra[i].split("/");
            Especializacao especializacao = beansE.buscarPorConselho(factory, especializacoesSegundaQuebra[0]).get(0);
            especializacoess.add(new Especializacao(especializacao.getId(), especializacao.getNome(), especializacao.getValor(), especializacao.getConselho(), especializacoesSegundaQuebra[1]));
        }
        }catch(Exception e){}
        
        return especializacoess;
    }
    
    
    
    
    
    
}
