/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.principal;

import br.com.sistema_hospitalar.model.dao.FuncionarioResetSenhaDAO;
import br.com.sistema_hospitalar.model.entidade.Administrador;
import br.com.sistema_hospitalar.model.entidade.Atendente;
import br.com.sistema_hospitalar.model.entidade.CategoriaCID;
import br.com.sistema_hospitalar.model.entidade.Endereco;
import br.com.sistema_hospitalar.model.entidade.Especializacao;
import br.com.sistema_hospitalar.model.entidade.Estado;
import br.com.sistema_hospitalar.model.entidade.Funcionario;
import br.com.sistema_hospitalar.model.entidade.ResetSenha;
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
 * 
 * usar a função  pra trazer a quantidade de paciente de cada medico ou seja qual sera o proximo numero do codigo medico paciente
 * 
 * 
 * da pra criar um gatilho pra calcular o salario quando inserir ou atualizar e pegar o valor antigo do salario pra saber 
 * 
 * utilizar o Old. salario pra ele pegar uma coluna especifica
 * 
 * 
 * criar dois logs um a nivel de banco e outro a nivel de sistema pra resolver o problema de quem atualizou a nivel de banco e a nossa
 */


public class App {

    public static void main(String[] args) {
        CoreFacade coreFacade = new CoreFacade();
//        salvarProfissionalSaude(coreFacade);
EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPBDPU");
//        FuncionarioResetSenhaDAO funcionarioResetSenhaDAO = new FuncionarioResetSenhaDAO();
//        List<ResetSenha> resetSenhas = funcionarioResetSenhaDAO.getFuncionariosAResetarSenha(factory);
//        
//        for (ResetSenha resetSenha : resetSenhas) {
//            System.out.println(resetSenha.getNome());
//        }

       

    }
    
//    public static void salvarprontuario(CoreFacade coreFacade){
//        
//       List<Paciente> pacientes = null;
//       int id_prof = 0;
//       int total_paceinte;
//       int total_prontuario_paciente;
//       
//       // abastercer o total
//        for (Paciente paciente : pacientes) {
//            if (paciente.getId()) {
//                
//            }
//        }
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
        
        
        
        Estado estado1 = new Estado();
        estado1.setDescricao("Bahia");
        estado1.setUf("BA");
        coreFacade.estadoSalvarOuAtualizar(estado1);
        
        Municipio municipio1 = new Municipio();
        municipio1.setDescricao("Serra Negra");
        municipio1.setEstado(estado1);
        coreFacade.municipioSalvarOuAtualizar(municipio1);
        
        Endereco endereco1 = new Endereco();
        endereco1.setBairro("Centro");
        endereco1.setCep(6540000);
        endereco1.setComplemento("Casa");
        endereco1.setDescricao("Rua Padre Joaquim");
        endereco1.setNumero("200");
        endereco1.setMunicipio(municipio1);
        coreFacade.enderecoSalvarOuAtualizar(endereco1);
        
        Especializacao especializacao1 = new Especializacao();
        especializacao1.setNome("Enfermagem");
        especializacao1.setConselho("CRM");
        especializacao1.setValor(200);
        especializacao1.setConselho("COREM");
        coreFacade.especializacaoSalvarOuAtualizar(especializacao1);
        
        List<Especializacao> especializacoess1 =  new ArrayList<>();
        especializacoess1.add(especializacao1);

        ProfissionalSaude profissionalSaude1 = new ProfissionalSaude();
        profissionalSaude1.setAtivo(true);
        profissionalSaude1.setCargaHorariaMinimaMensal(60);
        profissionalSaude1.setCpf("1234657891");
        Calendar dataDeNascimento1 = Calendar.getInstance();
        dataDeNascimento1.set(1996, 2, 19);
        profissionalSaude1.setDataDeNascimento(dataDeNascimento1);
        profissionalSaude1.setEmail("raelhosanabarros@gmail.com");
        profissionalSaude1.setEndereco(endereco1);
        profissionalSaude1.setEspecializacoess(especializacoess1);
        profissionalSaude1.setHoraextra(0);
        profissionalSaude1.setNome("Rafaela Hosana de Barros Santos");
        profissionalSaude1.setSalario(2000);
        profissionalSaude1.setSexo("F");
        profissionalSaude1.setTelefones("96345157");
        coreFacade.profissionalSaudeSalvarOuAtualizar(profissionalSaude1);
        
    }

}
