/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.principal;

import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Municipio;
import br.com.sistema_hospitalar.model.entidade.ProfissionalSaude;
import br.com.sistema_hospitalar.model.fachada.CoreFacade;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author rafaelgentil
 */
public class App {
    
//    public static void main(String[] args) {
//        
////        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPBDPU");
//        
//    }

    
    
    public static void salvarProfissionalSaude(CoreFacade coreFacade){
//        
//        Estado estado = new Estado();
//        estado.setDescricao("Pernambuco");
//        estado.setUf("PE");
//        coreFacade.estadoSalvarOuAtualizar(estado);
//        
//        Municipio municipio = new Municipio();
//        municipio.setDescricao("Floresta");
//        municipio.setEstado(estado);
//        coreFacade.municipioSalvarOuAtualizar(municipio);
//        
//        Endereco endereco = new Endereco();
//        endereco.setBairro("Centro");
//        endereco.setCep(6540000);
//        endereco.setComplemento("Casa");
//        endereco.setDescricao("Rua Padre Noberto");
//        endereco.setNumero("205");
//        endereco.setMunicipio(municipio);
//        coreFacade.enderecoSalvarOuAtualizar(endereco);
//        
//        Especializacao especializacao = new Especializacao();
//        especializacao.setNome("Enfermagem");
//        especializacao.setConselho("CRM");
//        especializacao.setValor(200);
//        coreFacade.especializacaoSalvarOuAtualizar(especializacao);
//        
//        List<Especializacao> especializacoess =  new ArrayList<>();
//        especializacoess.add(especializacao);
//
//        ProfissionalSaude profissionalSaude = new ProfissionalSaude();
//        profissionalSaude.setAtivo(true);
//        profissionalSaude.setCargaHorariaMinimaMensal(60);
//        profissionalSaude.setCpf("1234567891");
//        Calendar dataDeNascimento = Calendar.getInstance();
//        dataDeNascimento.set(1996, 2, 19);
//        profissionalSaude.setDataDeNascimento(dataDeNascimento);
//        profissionalSaude.setEmail("raelgentil@gmail.com");
//        profissionalSaude.setEndereco(endereco);
//        profissionalSaude.setEspecializacoess(especializacoess);
//        profissionalSaude.setHoraextra(0);
//        profissionalSaude.setNome("Rafael Gentil de Barros Santos");
//        profissionalSaude.setSalario(2000);
//        profissionalSaude.setSexo("M");
//        profissionalSaude.setTelefones("96345157");
//        coreFacade.profissionalSaudeSalvarOuAtualizar(profissionalSaude);

        
        Endereco endereco1 = coreFacade.enderecoBuscarPorId(1L);
        
        Administrador a = new Administrador();

        a.setAtivo(true);
        a.setCargaHorariaMinimaMensal(60);
        a.setCpf("1224612888");
        Calendar dataDeNascimento1 = Calendar.getInstance();
        dataDeNascimento1.set(1976, 2, 19);
        a.setDataDeNascimento(dataDeNascimento1);
        a.setEmail("raelho22ana@gmail.com");
        a.setEndereco(endereco1);
        a.setHoraextra(0);
        a.setNome("Rafaela Hosana de Barros Santos");
        a.setSalario(2000);
        a.setSexo("F");
        a.setTelefones("96345157");
        a.setSuperUsuario(true);
        
        coreFacade.administradorSalvarOuAtualizar(a);
        
    }
    
}
