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
 * 
 * Usar as viws pra restrigir acesso acesso, usando pra verificar quem vai pooder visualizar determinadas coisas
 * 
 * da pra usar a view pra gerar as consultas marcadas pro dia, tb da pra usar a view pra reset senha e pra questão de medicamentos
 */


public class App {

    public static void main(String[] args) {
        CoreFacade coreFacade = new CoreFacade();
//        salvarProfissionalSaude(coreFacade);

    }
    
    
    public static void salvarProfissionalSaude(CoreFacade coreFacade){
        
        Estado estado = new Estado();
        estado.setDescricao("Pernambuco");
        estado.setUf("PE");
        coreFacade.estadoSalvarOuAtualizar(estado);
        
        Municipio municipio = new Municipio();
        municipio.setDescricao("Floresta");
        municipio.setEstado(estado);
        coreFacade.municipioSalvarOuAtualizar(municipio);
        
        Endereco endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCep(6540000);
        endereco.setComplemento("Casa");
        endereco.setDescricao("Rua Padre Noberto");
        endereco.setNumero("205");
        endereco.setMunicipio(municipio);
        coreFacade.enderecoSalvarOuAtualizar(endereco);
        
        Especializacao especializacao = new Especializacao();
        especializacao.setNome("Enfermagem");
        especializacao.setConselho("CRM");
        especializacao.setValor(200);
        coreFacade.especializacaoSalvarOuAtualizar(especializacao);
        
        List<Especializacao> especializacoess =  new ArrayList<>();
        especializacoess.add(especializacao);

        ProfissionalSaude profissionalSaude = new ProfissionalSaude();
        profissionalSaude.setAtivo(true);
        profissionalSaude.setCargaHorariaMinimaMensal(60);
        profissionalSaude.setCpf("1234567891");
        Calendar dataDeNascimento = Calendar.getInstance();
        dataDeNascimento.set(1996, 2, 19);
        profissionalSaude.setDataDeNascimento(dataDeNascimento);
        profissionalSaude.setEmail("raelgentil@gmail.com");
        profissionalSaude.setEndereco(endereco);
        profissionalSaude.setEspecializacoess(especializacoess);
        profissionalSaude.setHoraextra(0);
        profissionalSaude.setNome("Rafael Gentil de Barros Santos");
        profissionalSaude.setSalario(2000);
        profissionalSaude.setSexo("M");
        profissionalSaude.setTelefones("96345157");
        coreFacade.profissionalSaudeSalvarOuAtualizar(profissionalSaude);
        
    }

}
