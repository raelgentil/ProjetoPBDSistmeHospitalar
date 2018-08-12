/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.principal;

import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.Insumo;
import br.com.sistema_hospitalar.model.entidade.Lote;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.Paciente;
import br.com.sistema_hospitalar.model.entidade.Pessoa;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.entidade.Prontuario;
import br.com.sistema_hospitalar.model.fachada.CoreFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rafaelgentil
 *
 *
 * Colocar no metodo delete uma verificação pra ver se o tabela tem um vinculo
 * com outra tabela se não tiver deleta
 */
public class App {

    public static void main(String[] args) {
        CoreFacade coreFacade = new CoreFacade();
//Estado estado = new Estado("BA", "Bahia");
//        coreFacade.salvarOuAtualizarEstado(estado);
//
//        Municipio municipio = new Municipio("Serra", estado);
//        coreFacade.salvarOuAtualizarMunicipio(municipio);
//
//        Endereco endereco = new Endereco(564852, "Av Sao francisco", "2427", "Coabe", "Ap", municipio);
//        coreFacade.salvarOuAtualizarEndereco(endereco);
        
        
//        Insumo insumo1 = new Insumo("Dipirona", 10, 10);
//        Insumo insumo2 = new Insumo("Paracetemol", 10, 15);
//        coreFacade.salvarOuAtualizarInsumo(insumo1);
//        coreFacade.salvarOuAtualizarInsumo(insumo2);
////            Insumo insumo = coreFacade.getPorIdInsumo(new Insumo(1L, null, 0, 0, 0));
//            Calendar dataValidade = Calendar.getInstance();
//                        dataValidade.set(2019, 7, 12);
//            Calendar dataFabricacao = Calendar.getInstance();
//                        dataFabricacao.set(2017, 10, 20);
//          Lote lote1 = new Lote(123560556L, 15, dataValidade, dataFabricacao, true, insumo1);
//          Lote lote2 = new Lote(321560556L, 10, dataValidade, dataFabricacao, true, insumo1);
//          coreFacade.salvarOuAtualizarLote(lote1);
//          coreFacade.salvarOuAtualizarLote(lote2);
////            Lote lote = coreFacade.getPorId(new Lote(1L, null, 0, null, null, true, null));
////            lote = new Lote(lote.getId(), lote.getCodigo(), 5, lote.getDataValidade(), lote.getDataFabricacao(), lote.isGenerico(), lote.getInsumo());
////            coreFacade.salvarOuAtualizar(lote);
//        Insumo insumo = coreFacade.getPorIdInsumo(new Insumo(1L, null, 0, 0, 0));
//        System.out.println(insumo.toString());
//        Lote lote = coreFacade.buscarPorInsumoLote(insumo).get(0);
//        coreFacade.removerLote(lote);
//
//        Estado estado = new Estado("PE", "Pernambuco");
//        coreFacade.salvarOuAtualizarEstado(estado);
//
//        Municipio municipio = new Municipio("Floresta", estado);
//        coreFacade.salvarOuAtualizarMunicipio(municipio);
//
//        Endereco endereco = new Endereco(564852, "Av Belem do Sao francisco", "247", "Centro", "Casa", municipio);
//        coreFacade.salvarOuAtualizarEndereco(endereco);
//
//        Calendar dataDeNascimento = Calendar.getInstance();
//        dataDeNascimento.set(1994, 7, 28);
////        Pessoa pessoa = new Pessoa("Rafaela Barros", "12345678912", "rafaelaBarros@gmail.com", "96345157", "F", dataDeNascimento, endereco);
////        coreFacade.salvarOuAtualizarPessoa(pessoa);
//
////        Estado estado1 = new Estado("BA", "Bahia");
////        coreFacade.salvarOuAtualizarEstado(estado);
////
////        Municipio municipio1 = new Municipio("Salvador", estado);
////        coreFacade.salvarOuAtualizarMunicipio(municipio);
////
////        Endereco endereco1 = new Endereco(564852, "Av Belem do Sao francisco", "247", "Centro", "Casa", municipio);
////        coreFacade.salvarOuAtualizarEndereco(endereco1);
//
//        dataDeNascimento.set(1996, 1, 26);
//
//        List<Pessoa> pessoas = new ArrayList<>();
////        pessoas.add(pessoa);;
//        Paciente paciente = new Paciente("Andre Batista  Silva", "98765432178", "batista@gmail.com", "96345157", "M", dataDeNascimento, endereco, "A", true, "", "", null, true, pessoas);
//        coreFacade.salvarOuAtualizarPaciente(paciente);
//
//        Especializacao especializacao = new Especializacao("Enfermeira", 60, "COREM");
//        coreFacade.salvarOuAtualizarEspecializacao(especializacao);
//
//        Especializacao especializacao1 = new Especializacao("Ortopedia", 200, "SBOT");
//        coreFacade.salvarOuAtualizarEspecializacao(especializacao);
//
//        List<Especializacao> especializacaos = new ArrayList<>();
//        especializacaos.add(especializacao);
//        especializacaos.add(especializacao1);
//        ProfissionalSaude profissionalSaude = new ProfissionalSaude("Claudinei Batista da Silva", "96354157", "claudineisilva@gmail.com", "93645158", "M", dataDeNascimento, endereco, null, 2000, 60, 0, "CB", especializacaos);
//        coreFacade.salvarOuAtualizarProfissionalSaude(profissionalSaude);
//        profissionalSaude = coreFacade.buscarPorCpfProfissionalSaude("96354157");
//        List<CategoriaCID> cIDs = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            cIDs.add(new CategoriaCID(Long.parseLong((i+1)+ ""), null, null, null));
//        }
//        
//        
//        
//        
//        Calendar dataAbertura = Calendar.getInstance();
//        
//        Calendar dataRetorno = Calendar.getInstance();
//        dataRetorno.set(2018, 8, 20);
//        
//        Prontuario prontuario = new Prontuario(dataAbertura, dataRetorno, null, cIDs, null, "com problemas ", null, paciente, profissionalSaude);
//        coreFacade.salvarOuAtualizarProntuario(prontuario);
//        
//        Administrador administrador = new Administrador(false, "Daniel Pereira da Silva", "12345678934", "dp@gmail.com", "96345157", "M", dataDeNascimento, endereco, null, 10000, 30, 0);
//        coreFacade.salvarOuAtualizarAdministrador(administrador);
//        Atendente atendente = new Atendente("Gabriel Almeira da Silva", "65498732112", "ga@gmail.com", "896523174", "M", dataDeNascimento, endereco, null, 1500, 60, 0);
//        coreFacade.salvarOuAtualizarAtendente(atendente);

   

        Endereco endereco1 = coreFacade.getPorIdEndereco(new Endereco(1L, 0, null, null, null, null, null));
//        coreFacade.salvarOuAtualizarEndereco(endereco1);
        Calendar dataDeNascimento = Calendar.getInstance();
        dataDeNascimento.set(1996, 1, 26);

        List<Pessoa> pessoas = new ArrayList<>();
//        pessoas.add(pessoa);;
        Paciente paciente = coreFacade.buscarPorCpfPaciente("98765432178");

//        Especializacao especializacao1 = new Especializacao("Ortopedia", 200, "SBOT");
//        coreFacade.salvarOuAtualizarEspecializacao(especializacao1);

        List<Especializacao> especializacaos = new ArrayList<>();
        especializacaos.add(coreFacade.getPorIdEspecializacao(new Especializacao(1L, null, 0, null)));
//        especializacaos.add(especializacao1);
//        ProfissionalSaude profissionalSaude = new ProfissionalSaude("Claudinei Batista da Silva", "9632587412", "claudineisilva@gmail.com", "93645158", "M", dataDeNascimento, endereco1, null, 2000, 60, 0, "Cs", especializacaos);
//        coreFacade.salvarOuAtualizarProfissionalSaude(profissionalSaude);
        ProfissionalSaude profissionalSaude = coreFacade.buscarPorCpfProfissionalSaude("96354157");
        List<CategoriaCID> cIDs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cIDs.add(new CategoriaCID(Long.parseLong((i+1)+ ""), null, null, null));
        }
        
        Calendar dataAbertura = Calendar.getInstance();
        
        Calendar dataRetorno = Calendar.getInstance();
        dataRetorno.set(2018, 8, 20);
        
        Prontuario prontuario = new Prontuario(dataAbertura, dataRetorno, null, cIDs, null, "com problemas ", null, paciente, profissionalSaude);
        coreFacade.salvarOuAtualizarProntuario(prontuario);
    }

}
