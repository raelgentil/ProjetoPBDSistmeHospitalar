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
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import java.util.ArrayList;
import java.util.GregorianCalendar;
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
            String senha = beansF.criptografar(factory, profissionalSaude.getCpf());
            profissionalSaude.setSenha(senha);
            profissionalSaude.setApelido(criarApelido(factory, profissionalSaude));
            profissionalSaude.setLogin(login);
            if (login != null) {
                profissionalSaude.setLogin(login);
                profissionalSaude.setEspecializacoes(converterEspecializacoes(profissionalSaude.getEspecializacoess()));
                return dao.salvarOuAtualizar(factory, profissionalSaude);
            } else {
                System.err.println("Erro Profissional ja existe");
            }
        } else {
            if (!(profissionalSaude.getSenha().equals(dao.getPorId(factory, ProfissionalSaude.class, profissionalSaude.getId()).getSenha()))) {
                profissionalSaude.setSenha(beansF.criptografar(factory, profissionalSaude.getSenha()));
            }
            return dao.salvarOuAtualizar(factory, profissionalSaude);
        }
        return false;
    }

    public boolean remover(EntityManagerFactory factory, ProfissionalSaude profissionalSaude) {
        return dao.remover(factory, ProfissionalSaude.class, profissionalSaude);
    }

    public ProfissionalSaude getPorId(EntityManagerFactory factory, Long id) {

        return dao.getPorId(factory, ProfissionalSaude.class, id);
    }

    public List<ProfissionalSaude> buscarPorNome(EntityManagerFactory factory, String nome) {
        List<ProfissionalSaude> profissionalSaudes = daoP.buscarPorNome(factory, nome);
        for (ProfissionalSaude profissionalSaude : profissionalSaudes) {
            if(profissionalSaude.getEspecializacoes()!=null)
                if(!profissionalSaude.getEspecializacoes().isEmpty())
                profissionalSaude.setEspecializacoess(carregarEspecializacoes(factory, profissionalSaude.getEspecializacoes()));

        }
        return profissionalSaudes;
    }

    public ProfissionalSaude buscarPorCpf(EntityManagerFactory factory, String cpf) {
        ProfissionalSaude profissionalSaude = (ProfissionalSaude) daoP.buscarPorCpf(factory, cpf);
        profissionalSaude.setEspecializacoess(carregarEspecializacoes(factory, profissionalSaude.getEspecializacoes()));

        return profissionalSaude;
    }

    private String converterEspecializacoes(List<Especializacao> especializacoes) {
        String especializacoess = "";
        for (Especializacao especializacao : especializacoes) {
            especializacoess += especializacao.getConselho() + "/" + especializacao.getCodigo() + ";";
        }
        return especializacoess;
    }

    private List<Especializacao> carregarEspecializacoes(EntityManagerFactory factory, String especializacoes) {
        List<Especializacao> especializacoess = new ArrayList<>();
        String[] especializacoesPrimeiraQuebra = especializacoes.split(";");
        for (int i = 0; i < especializacoesPrimeiraQuebra.length; i++) {
            String[] especializacoesSegundaQuebra = especializacoesPrimeiraQuebra[i].split("/");
            Especializacao especializacao = beansE.buscarPorConselho(factory, especializacoesSegundaQuebra[0]).get(0);
            especializacao.setCodigo(especializacoesSegundaQuebra[1]);
            especializacoess.add(especializacao);
        }

        return especializacoess;
    }

    private String criarApelido(EntityManagerFactory factory, Pessoa pessoa) {
        String[] nomes = pessoa.getNome().split(" ");
        nomes[0].charAt(0);
        String apelido1 = "";
        
        String apelido2 = "";

        for (int i = 0; i < pessoa.getNome().length(); i++) {
            if (i < nomes.length) {
                apelido1 += nomes[i].charAt(0) + "";
            }
            if (i>= nomes.length) {
                apelido1 = "";
                apelido2+= nomes[i - nomes.length].charAt(0) + nomes[i - nomes.length].charAt(1) + "";
            }

            if (daoP.buscarPorApelido(factory, apelido1 + apelido2) == null) {
                return apelido1 + apelido2;
            }
            System.out.println("Contador: " + i);
            System.out.println("br.com.sistema_hospitalar.model.beans.ProficionalSaudeBEANS.criarApelido()");
        }

        return null;
    }
    
   

}
