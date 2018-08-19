/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema_hospitalar.model.fachada;

import br.com.sistema_hospitalar.model.beans.AdministradorBEANS;
import br.com.sistema_hospitalar.model.beans.AtendenteBEANS;
import br.com.sistema_hospitalar.model.beans.CategoriCIDBEANS;
import br.com.sistema_hospitalar.model.beans.EnderecoBEANS;
import br.com.sistema_hospitalar.model.beans.EspecializacaoBEANS;
import br.com.sistema_hospitalar.model.beans.EstadoBEANS;
import br.com.sistema_hospitalar.model.beans.FuncionarioBEANS;
import br.com.sistema_hospitalar.model.beans.InsumoBEANS;
import br.com.sistema_hospitalar.model.beans.LoteBEANS;
import br.com.sistema_hospitalar.model.beans.MunicipioBEANS;
import br.com.sistema_hospitalar.model.beans.PacienteBEANS;
import br.com.sistema_hospitalar.model.beans.PessoaBEANS;
import br.com.sistema_hospitalar.model.beans.ProficionalSaudeBEANS;
import br.com.sistema_hospitalar.model.beans.ProntuarioBEANS;
import br.com.sistema_hospitalar.model.beans.FuncionarioResetSenhaBEANS;
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
import br.com.sistema_hospitalar.model.entidade.IEntidadeBase;
import br.com.sistema_hospitalar.model.entidade.FuncionarioResetSenha;
import com.sun.glass.ui.View;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


/**
 *
 * @author rafaelgentil
 */
public class CoreFacade {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoPBDPU");
    private EstadoBEANS estadoBEANS;
    private MunicipioBEANS municipioBEANS;
    private EnderecoBEANS enderecoBEANS;
    private PessoaBEANS pessoaBEANS;
    private PacienteBEANS pacienteBEANS;
    private FuncionarioBEANS funcionarioBEANS;
    private ProntuarioBEANS prontuarioBEANS;
    private EspecializacaoBEANS especializacaoBEANS;
    private ProficionalSaudeBEANS proficionalSaudeBEANS;
    private AtendenteBEANS atendenteBEANS;
    private AdministradorBEANS administradorBEANS;
    private InsumoBEANS insumoBEANS;
    private LoteBEANS loteBEANS;
    private CategoriCIDBEANS categoriCIDBEANS;
    private FuncionarioResetSenhaBEANS resetSenhaBEANS;
    
    public CoreFacade() {
        
        estadoBEANS = new EstadoBEANS();
        municipioBEANS = new MunicipioBEANS();
        enderecoBEANS = new EnderecoBEANS();
        pessoaBEANS = new PessoaBEANS();
        pacienteBEANS = new PacienteBEANS();
        funcionarioBEANS = new FuncionarioBEANS();
        prontuarioBEANS = new ProntuarioBEANS();
        especializacaoBEANS = new EspecializacaoBEANS();
        proficionalSaudeBEANS = new ProficionalSaudeBEANS(funcionarioBEANS, especializacaoBEANS);
        atendenteBEANS = new AtendenteBEANS(funcionarioBEANS);
        administradorBEANS = new AdministradorBEANS(funcionarioBEANS);
        insumoBEANS =  new InsumoBEANS();
        loteBEANS = new LoteBEANS(insumoBEANS);
        categoriCIDBEANS = new CategoriCIDBEANS();
        
    }
    
    public boolean estadoSalvarOuAtualizar(Estado estado) {
        return estadoBEANS.salvarOuAtualizar(factory, estado);
    }

    public boolean estadoRremover(Estado estado) {
       return estadoBEANS.remover(factory, estado);
    }

    public Estado estadoBuscarPorId(Long id) {
       return estadoBEANS.getPorId(factory, id);
    }
    
    public Estado estadoEncontrarPorUf(String uf) {
        return estadoBEANS.buscarPorUf(factory, uf);
    }
    
    public List<Estado> estadoBuscarPorNome( String descricao) {
        return estadoBEANS.buscarPorNome(factory, descricao);
    }
    
    

    /**
     * 
     * 
     * 
     * 
     */
    
    public void municipioSalvarOuAtualizar(Municipio Municipio) {
        municipioBEANS.salvarOuAtualizar(factory, Municipio);

    }

    public void municipioRemover(Municipio municipio) {
        municipioBEANS.remover(factory, municipio);
        
    }

    public Municipio municipioBuscarPorId(Long id) {
       return municipioBEANS.getPorId(factory, id);
    }
    public List<Municipio> municipioBuscarPorNome(String string) {
        return municipioBEANS.buscarPorDescricao(factory, string);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
     public boolean enderecoSalvarOuAtualizar(Endereco endereco) {
        return enderecoBEANS.salvarOuAtualizar(factory, endereco);
    }

    public boolean enderecoRemover(Endereco endereco) {
        return enderecoBEANS.remover(factory, endereco);

    }

    public Endereco enderecoBuscarPorId(Long id) {
        return enderecoBEANS.getPorId(factory, id);
    }

    public List<Endereco> enderecoBuscarPorBairro(String bairro) {
        return enderecoBEANS.buscarPorBairro(factory, bairro);
    }


    public List<Endereco> enderecoBuscarPordescricao(String descricao) {
        return enderecoBEANS.buscarPordescricao(factory, descricao);
    }

    public Endereco enderecoGetMunicipio(Endereco endereco) {
        return  enderecoBEANS.getMunicipio(factory,endereco);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
   public boolean pessoaSalvarOuAtualizar(Pessoa pessoa) {
       return pessoaBEANS.salvarOuAtualizar(factory, pessoa);
    }

    public boolean pessoaRemover(Pessoa pessoa) {
        return pessoaBEANS.remover(factory, pessoa);
    }

    public Pessoa pessoaBuscarPorId(Long id) {
        
       return pessoaBEANS.getPorId(factory, id);
    }
    
    public List<Pessoa> pessoaBuscarPorNome(String nome) {
         return pessoaBEANS.buscarPorNome(factory, nome);
    }
    
    public Pessoa pessoaBuscarPorCpf(EntityManagerFactory factory, String cpf) {
        return pessoaBEANS.buscarPorCpf(factory, cpf);
    }
    
/**
 * 
 * 
 * 
 */

    public boolean pacienteSalvarOuAtualizar(Paciente paciente) {
        return pacienteBEANS.salvarOuAtualizar(factory, paciente);
    }

    public boolean pacienteRemover(Paciente paciente) {
        return pacienteBEANS.remover(factory, paciente);
    }

    public Paciente pacientesBuscarPorId(Long id) {
       return pacienteBEANS.getPorId(factory, id);
    }
    
     public List<Paciente> pacienteBuscarPorNome(String nome) {
         return pacienteBEANS.buscarPorNome(factory, nome);
    }
    
    public Paciente pacienteBuscarPorCpf(String cpf) {
        return pacienteBEANS.buscarPorCpf(factory, cpf);
    }
    
    public List<Paciente> pacienteBuscarPorTipoSanguinio(String tipoSanguinio) {
        return pacienteBEANS.buscarPorTipoSanguinio(factory, tipoSanguinio);
    }

    public List<Paciente> pacienteBuscarPorFatoRH(boolean fatorRh) {
        return pacienteBEANS.buscarPorFatoRH(factory, fatorRh);
    }

    public List<Paciente> pacienteBuscarPorLimitacoes(String limitacao) {
        return pacienteBEANS.buscarPorLimitacoes(factory, limitacao);
    }

    public List<Paciente> pacienteBuscarPorAlergias(String alergia) {
        return pacienteBEANS.buscarPorAlergias(factory, alergia);
    }

    public List<Paciente> pacienteBuscarPorDataDeFalecimento(Calendar date) {
        return pacienteBEANS.buscarPorDataDeFalecimento(factory, date);
    }
    
    public List<Paciente> pacienteBuscarPorDoadorDeOrgaos(boolean alergia) {
        return pacienteBEANS.buscarPorDoadorDeOrgaos(factory, alergia);
    }
// 
//    public Paciente getProntuariosPaciente(Paciente paciente) {
//        return pacienteBEANS.getProntuarios(factory, paciente);
//    }
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    
    public boolean prontuarioSalvarOuAtualizar(Prontuario prontuario) {
        return prontuarioBEANS.salvarOuAtualizar(factory, prontuario);
    }

    public boolean prontuarioRemover(Prontuario prontuario) {
        return prontuarioBEANS.remover(factory, prontuario);
    }

    public Prontuario prontuarioBuscarPorId(Long id) {
        return prontuarioBEANS.getPorId(factory, id);
    }

    public String prontuarioBuscarCodMedicoPaciente(Long idPaciente, String codMedicoPaciente) {
        return prontuarioBEANS.buscarCodMedicoPaciente(factory,idPaciente, codMedicoPaciente);
    }

    public List<Prontuario> prontuarioBuscarPorCodMedicoPacient(Long idPaciente, String codMedicoPaciente) {
        return prontuarioBEANS.buscarPorCodMedicoPacient(factory, idPaciente, codMedicoPaciente);
    }
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    
    public Funcionario funcionarioBuscarUsuario(String login, String senha) {
        return funcionarioBEANS.buscarUsuario(factory, login, senha);

    }

    public List<Funcionario> funcionarioBuscarPorAtivos(boolean ativo) {
        return funcionarioBEANS.buscarPorAtivos(factory, ativo);
    }
    
    public boolean funcionarioResetSenha( Long id){
        return funcionarioBEANS.resetSenha(factory, id);
    }
    
    public  List<FuncionarioResetSenha> funcionarioGetAResetarSenha(){
        return resetSenhaBEANS.getFuncionariosAResetarSenha(factory);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    
     public boolean especializacaoSalvarOuAtualizar(Especializacao especializacao) {
        return especializacaoBEANS.salvarOuAtualizar(factory, especializacao);
    }

    public boolean especializacaoRemover(Especializacao especializacao) {
        return especializacaoBEANS.remover(factory, especializacao);
    }

    public Especializacao especializacaoBuscarPorId(Long id) {
        return especializacaoBEANS.getPorId(factory, id);
    }
    
    public List<Especializacao> especializacaoBuscarPorNome(String nome) {
         return especializacaoBEANS.buscarPorNome(factory, nome);
    }
    
    public List<Especializacao> especializacaoBuscarPorConselho(String conselho) {
        return especializacaoBEANS.buscarPorConselho(factory, conselho);
    }
    
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    public boolean profissionalSaudeSalvarOuAtualizar(ProfissionalSaude profissionalSaude) {
         return proficionalSaudeBEANS.salvarOuAtualizar(factory, profissionalSaude);
    }

    public boolean profissionalSaudeRemover(ProfissionalSaude profissionalSaude) {
        return proficionalSaudeBEANS.remover(factory, profissionalSaude);
    }

    public ProfissionalSaude profissionalSaudeBuscarPorId(ProfissionalSaude profissionalSaude) {
        return proficionalSaudeBEANS.getPorId(factory, profissionalSaude);
    }

    public List<ProfissionalSaude> profissionalSaudeBuscarPorNome(String nome) {
        return proficionalSaudeBEANS.buscarPorNome(factory, nome);
    }

    public ProfissionalSaude profissionalSaudeBuscarPorCpf(String cpf) {
        return proficionalSaudeBEANS.buscarPorCpf(factory, cpf);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    public boolean atendenteSalvarOuAtualizar(Atendente atendente) {
         return atendenteBEANS.salvarOuAtualizar(factory, atendente);
    }

    public boolean atendenteRemover(Atendente atendente) {
        return atendenteBEANS.remover(factory, atendente);
    }

    public Atendente atendenteBuscarPorId(Long id) {
        return atendenteBEANS.getPorId(factory, id);
    }

    public List<Atendente> atendenteBuscarPorNome(String nome) {
        return atendenteBEANS.buscarPorNome(factory, nome);
    }

    public Atendente atendenteBuscarPorCpf(String cpf) {
        return atendenteBEANS.buscarPorCpf(factory, cpf);
    }
    
    
    
    
    /**
     * 
     * 
     * 
     * 
     */
    
    
    public boolean administradorSalvarOuAtualizar(Administrador administrador) {
         
        return administradorBEANS.salvarOuAtualizar(factory, administrador);
        
    }

    public boolean administradorRemover(Administrador administrador) {
        return administradorBEANS.remover(factory, administrador);
    }

    public Administrador administradorBuscarPorId(Long id) {
        return administradorBEANS.getPorId(factory, id);
    }

    public List<Administrador> administradorBuscarPorNome(String nome) {
        return administradorBEANS.buscarPorNome(factory, nome);
    }

    public Administrador administradorBuscarPorCpf(String cpf) {
        return administradorBEANS.buscarPorCpf(factory, cpf);
    }
    
    
    
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    
    
    
    public boolean insumoSalvarOuAtualizar(Insumo insumo) {
        return insumoBEANS.salvarOuAtualizar(factory, insumo);
    }

    public boolean insumoRemover( Insumo insumo) {
        return insumoBEANS.remover(factory, insumo);
    }

    public Insumo insumoBuscarPorId(Long id) {
        return insumoBEANS.getPorId(factory, id);
    }
    public List<Insumo> insumoBuscarDescricao(String descricao){
        return insumoBEANS.buscarDescricao(factory, descricao);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    public boolean loteSalvarOuAtualizar( Lote lote) {
        return loteBEANS.salvarOuAtualizar(factory, lote);
    }

    public boolean loteRemover(Lote lote) {
        return loteBEANS.remover(factory, lote);
    }

    public Lote loteBuscarPorId(Long id) {
        
       return loteBEANS.buscarPorId(factory, id);
    }
    
    public Lote loteBuscarPorCodigo(Long codigo){
       return loteBEANS.buscarPorCodigo(factory, codigo);
    }
    
    public List<Lote> loteBuscarPorInsumo(Insumo insumo){
       return loteBEANS.buscarPorInsumo(factory, insumo);
    }
    
    
    /**
     * 
     * 
     * 
     */
    
    public List<CategoriaCID> categoriaCIDBucarPorCodigoCategoriaCID(String codigo) {
        return categoriCIDBEANS.bucarPorCodigo(factory, codigo);
    }
    
    public List<CategoriaCID>categoriaCIDBucarPorDescricao(String descricao) {
        return categoriCIDBEANS.bucarPorDescricao(factory, descricao);
    }
    
    public CategoriaCID categoriaCIDBuscarPorId(Long id) {
        return categoriCIDBEANS.getPorId(factory, id);
    }

    
    
    
    
    
}
