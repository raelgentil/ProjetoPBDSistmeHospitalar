package br.com.sistema_hositalar.util;

import br.com.sistema_hospitalar.controller.Controlador;
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

public class Util {
    
    public static void atualizarBanco(){
        preencherEstados();
//        verificarSU();
    }
//    private static void verificarSU(){
//        List<Administrador> adms = Controlador.FACHADA.administradorBuscarPorNome("");
//        Administrador su = null;
//        for(Administrador a: adms){
//            if(a.isSuperUsuario())
//                su = a;
//        }
//        if(su == null){
//            su = new Administrador();
//            su.setAtivo(true);
//            su.setSuperUsuario(true);
//            su.setCpf("0");
//            su.setNome("admin");
//            su.setNome("login");
//            su.setSenha("admin");
//            Controlador.FACHADA.administradorSalvarOuAtualizar(su);
//        }
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
    private static void preencherEstados(){
        List<Estado> estadosBD = Controlador.FACHADA.estadoBuscarPorNome("");
        List<Estado> estados = new ArrayList<>();
        if(estadosBD.size() < 27){
           estados.add(new Estado("AC", "Acre"));
           estados.add(new Estado("AL", "Alagoas"));
           estados.add(new Estado("AP", "Amapá"));
           estados.add(new Estado("AM", "Amazonas"));
           estados.add(new Estado("BA", "Bahia"));
           estados.add(new Estado("CE", "Ceará"));
           estados.add(new Estado("DF", "Distrito Federal"));
           estados.add(new Estado("ES", "Espírito Santo"));
           estados.add(new Estado("GO", "Goiás"));
           estados.add(new Estado("MA", "Maranhão"));
           estados.add(new Estado("MT", "Mato Grosso"));
           estados.add(new Estado("MS", "Mato Grosso do Sul"));
           estados.add(new Estado("MG", "Minas Gerais"));
           estados.add(new Estado("PA", "Pará"));
           estados.add(new Estado("PB", "Paraíba"));
           estados.add(new Estado("PR", "Paraná"));
           estados.add(new Estado("PE", "Pernambuco"));
           estados.add(new Estado("PI", "Piauí"));
           estados.add(new Estado("RJ", "Rio de Janeiro"));
           estados.add(new Estado("RN", "Rio Grande do Norte"));
           estados.add(new Estado("RS", "Rio Grande do Sul"));
           estados.add(new Estado("RO", "Rondônia"));
           estados.add(new Estado("RR", "Roraima"));
           estados.add(new Estado("SC", "Santa Catarina"));
           estados.add(new Estado("SP", "São Paulo"));
           estados.add(new Estado("SE", "Sergipe"));
           estados.add(new Estado("TO", "Tocantins"));
           
           for(Estado e: estadosBD)
               for(Estado est: estados)
                   if(e.getUf().equalsIgnoreCase(est.getUf()))
                       estados.remove(est);
           for(Estado e: estados)
               Controlador.FACHADA.estadoSalvarOuAtualizar(e);
           
           
        }
    }
    
    
    
//    CREATE VIEW reset_senha
//AS SELECT p.nome, f.id FROM funcionario f, pessoa p WHERE p.id = f.id and f.resetar = TRUE
    
    
//    CREATE OR REPLACE FUNCTION calc_sala_ext(funcionario)
//	RETURNS NUMERIC
//	AS '
//		DECLARE
//			funcionario ALIAS FOR $1;
//			salario NUMERIC = 0;
//			contador INTEGER = 0;
//		BEGIN
//			WHILE contador < funcionario.hora_extra LOOP
//				contador:= contador + 1;
//				
//				salario := ((1* funcionario.salario)/100) + salario; 
//
//			END LOOP;
//			
//				salario := salario + funcionario.salario;
//			
//			RETURN salario;
//	END '
//LANGUAGE plpgsql;

    
    
//CREATE VIEW salario_hora_extra
//AS SELECT p.nome,p.cpf, calc_sala_ext(f) "salario com Hora extra"  FROM funcionario f INNER JOIN pessoa p on p.id = f.id
           
}
