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
    
    public boolean salvarOuAtualizarEstado(Estado estado) {
        return estadoBEANS.salvarOuAtualizar(factory, estado);
    }

    public boolean removerEstado(Estado estado) {
       return estadoBEANS.remover(factory, estado);
    }

    public Estado getPorIdEstado(Long id) {
       return estadoBEANS.getPorId(factory, id);
    }
    
    public Estado encontrarPorUfEstado(String uf) {
        return estadoBEANS.buscarPorUf(factory, uf);
    }
    
    public List<Estado> buscarPorNomeEstado( String descricao) {
        return estadoBEANS.buscarPorNome(factory, descricao);
    }
    public List<String> getAllEstadosName(){
        return estadoBEANS.getAllEstadosName(factory);
    }
    

    /**
     * 
     * 
     * 
     * 
     */
    
    public void salvarOuAtualizarMunicipio(Municipio Municipio) {
        municipioBEANS.salvarOuAtualizar(factory, Municipio);

    }

    public void removerMunicipio(Municipio municipio) {
        municipioBEANS.remover(factory, municipio);
        
    }

    public Municipio getPorIdMunicipio(Long id) {
       return municipioBEANS.getPorId(factory, id);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
     public boolean salvarOuAtualizarEndereco(Endereco endereco) {
        return enderecoBEANS.salvarOuAtualizar(factory, endereco);
    }

    public boolean removerEndereco(Endereco endereco) {
        return enderecoBEANS.remover(factory, endereco);

    }

    public Endereco getPorIdEndereco(Long id) {
        return enderecoBEANS.getPorId(factory, id);
    }

    public List<Endereco> buscarPorBairroEndereco(String bairro) {
        return enderecoBEANS.buscarPorBairro(factory, bairro);
    }


    public List<Endereco> buscarPordescricaoEndereco(String descricao) {
        return enderecoBEANS.buscarPordescricao(factory, descricao);
    }

    public Endereco getMunicipioEndereco(Endereco endereco) {
        return  enderecoBEANS.getMunicipio(factory,endereco);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
   public boolean salvarOuAtualizarPessoa(Pessoa pessoa) {
       return pessoaBEANS.salvarOuAtualizar(factory, pessoa);
    }

    public boolean removerPessoa(Pessoa pessoa) {
        return pessoaBEANS.remover(factory, pessoa);
    }

    public Pessoa getPorIdPessoa(Long id) {
        
       return pessoaBEANS.getPorId(factory, id);
    }
    
    public List<Pessoa> buscarPorNomePessoa(String nome) {
         return pessoaBEANS.buscarPorNome(factory, nome);
    }
    
    public Pessoa buscarPorCpfPessoa(EntityManagerFactory factory, String cpf) {
        return pessoaBEANS.buscarPorCpf(factory, cpf);
    }
    
/**
 * 
 * 
 * 
 */

    public boolean salvarOuAtualizarPaciente(Paciente paciente) {
        return pacienteBEANS.salvarOuAtualizar(factory, paciente);
    }

    public boolean removerPaciente(Paciente paciente) {
        return pacienteBEANS.remover(factory, paciente);
    }

    public Paciente getPorIdPaciente(Long id) {
       return pacienteBEANS.getPorId(factory, id);
    }
    
     public List<Paciente> buscarPorNomePaciente(String nome) {
         return pacienteBEANS.buscarPorNome(factory, nome);
    }
    
    public Paciente buscarPorCpfPaciente(String cpf) {
        return pacienteBEANS.buscarPorCpf(factory, cpf);
    }
    
    public List<Paciente> buscarPorTipoSanguinioPaciente(String tipoSanguinio) {
        return pacienteBEANS.buscarPorTipoSanguinio(factory, tipoSanguinio);
    }

    public List<Paciente> buscarPorFatoRHPaciente(boolean fatorRh) {
        return pacienteBEANS.buscarPorFatoRH(factory, fatorRh);
    }

    public List<Paciente> buscarPorLimitacoesPaciente(String limitacao) {
        return pacienteBEANS.buscarPorLimitacoes(factory, limitacao);
    }

    public List<Paciente> buscarPorAlergiasPaciente(String alergia) {
        return pacienteBEANS.buscarPorAlergias(factory, alergia);
    }

    public List<Paciente> buscarPorDataDeFalecimentoPaciente(Calendar date) {
        return pacienteBEANS.buscarPorDataDeFalecimento(factory, date);
    }
    
    public List<Paciente> buscarPorDoadorDeOrgaosPaciente(boolean alergia) {
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
    
    public boolean salvarOuAtualizarProntuario(Prontuario prontuario) {
        return prontuarioBEANS.salvarOuAtualizar(factory, prontuario);
    }

    public boolean removerProntuario(Prontuario prontuario) {
        return prontuarioBEANS.remover(factory, prontuario);
    }

    public Prontuario getPorIdProntuario(Long id) {
        return prontuarioBEANS.getPorId(factory, id);
    }

    public String buscarCodMedicoPacienteProntuario(Long idPaciente, String codMedicoPaciente) {
        return prontuarioBEANS.buscarCodMedicoPaciente(factory,idPaciente, codMedicoPaciente);
    }

    public List<Prontuario> buscarPorCodMedicoPacient(Long idPaciente, String codMedicoPaciente) {
        return prontuarioBEANS.buscarPorCodMedicoPacient(factory, idPaciente, codMedicoPaciente);
    }
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    
    public Funcionario buscarUsuario(String login, String senha) {
        return funcionarioBEANS.buscarUsuario(factory, login, senha);

    }

    public List<Funcionario> buscarPorAtivosFuncionario(boolean ativo) {
        return funcionarioBEANS.buscarPorAtivos(factory, ativo);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    
     public boolean salvarOuAtualizarEspecializacao(Especializacao especializacao) {
        return especializacaoBEANS.salvarOuAtualizar(factory, especializacao);
    }

    public boolean removerEspecializacao(Especializacao especializacao) {
        return especializacaoBEANS.remover(factory, especializacao);
    }

    public Especializacao getPorIdEspecializacao(Long id) {
        return especializacaoBEANS.getPorId(factory, id);
    }
    
    public List<Especializacao> buscarPorNomeEspecializacao(String nome) {
         return especializacaoBEANS.buscarPorNome(factory, nome);
    }
    
    public List<Especializacao> buscarPorConselhoEspecializacao(String conselho) {
        return especializacaoBEANS.buscarPorConselho(factory, conselho);
    }
    
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    public boolean salvarOuAtualizarProfissionalSaude(ProfissionalSaude profissionalSaude) {
         return proficionalSaudeBEANS.salvarOuAtualizar(factory, profissionalSaude);
    }

    public boolean removerProfissionalSaude(ProfissionalSaude profissionalSaude) {
        return proficionalSaudeBEANS.remover(factory, profissionalSaude);
    }

    public ProfissionalSaude getPorIdProfissionalSaude(ProfissionalSaude profissionalSaude) {
        return proficionalSaudeBEANS.getPorId(factory, profissionalSaude);
    }

    public List<ProfissionalSaude> buscarPorNomeProfissionalSaude(String nome) {
        return proficionalSaudeBEANS.buscarPorNome(factory, nome);
    }

    public ProfissionalSaude buscarPorCpfProfissionalSaude(String cpf) {
        return proficionalSaudeBEANS.buscarPorCpf(factory, cpf);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    public boolean salvarOuAtualizarAtendente(Atendente atendente) {
         return atendenteBEANS.salvarOuAtualizar(factory, atendente);
    }

    public boolean removerAtendente(Atendente atendente) {
        return atendenteBEANS.remover(factory, atendente);
    }

    public Atendente getPorIdAtendente(Long id) {
        return atendenteBEANS.getPorId(factory, id);
    }

    public List<Atendente> buscarPorNomeAtendente(String nome) {
        return atendenteBEANS.buscarPorNome(factory, nome);
    }

    public Atendente buscarPorCpfAtendente(String cpf) {
        return atendenteBEANS.buscarPorCpf(factory, cpf);
    }
    
    
    
    
    /**
     * 
     * 
     * 
     * 
     */
    
    
    public boolean salvarOuAtualizarAdministrador(Administrador administrador) {
         
        return administradorBEANS.salvarOuAtualizar(factory, administrador);
        
    }

    public boolean removerAdministrador(Administrador administrador) {
        return administradorBEANS.remover(factory, administrador);
    }

    public Administrador getPorIdAdministrador(Long id) {
        return administradorBEANS.getPorId(factory, id);
    }

    public List<Administrador> buscarPorNomeAdministrador(String nome) {
        return administradorBEANS.buscarPorNome(factory, nome);
    }

    public Administrador buscarPorCpfAdministrador(String cpf) {
        return administradorBEANS.buscarPorCpf(factory, cpf);
    }
    
    
    
    
    /**
     * 
     * 
     * 
     * 
     * 
     */
    
    
    
    public boolean salvarOuAtualizarInsumo(Insumo insumo) {
        return insumoBEANS.salvarOuAtualizar(factory, insumo);
    }

    public boolean removerInsumo( Insumo insumo) {
        return insumoBEANS.remover(factory, insumo);
    }

    public Insumo getPorIdInsumo(Long id) {
        return insumoBEANS.getPorId(factory, id);
    }
    public List<Insumo> buscarDescricaoInsumo(String descricao){
        return insumoBEANS.buscarDescricao(factory, descricao);
    }
    
    /**
     * 
     * 
     * 
     * 
     */
    
    public boolean salvarOuAtualizarLote( Lote lote) {
        return loteBEANS.salvarOuAtualizar(factory, lote);
    }

    public boolean removerLote(Lote lote) {
        return loteBEANS.remover(factory, lote);
    }

    public Lote getPorIdLote(Long id) {
        
       return loteBEANS.buscarPorId(factory, id);
    }
    
    public Lote buscarPorCodigoLote(Long codigo){
       return loteBEANS.buscarPorCodigo(factory, codigo);
    }
    
    public List<Lote> buscarPorInsumoLote(Insumo insumo){
       return loteBEANS.buscarPorInsumo(factory, insumo);
    }
    
    
    /**
     * 
     * 
     * 
     */
    
    public List<CategoriaCID> bucarPorCodigoCategoriaCID(String codigo) {
        return categoriCIDBEANS.bucarPorCodigo(factory, codigo);
    }
    
    public List<CategoriaCID> bucarPorDescricaoCategoriaCID(String descricao) {
        return categoriCIDBEANS.bucarPorDescricao(factory, descricao);
    }
    
    public CategoriaCID getPorIdCategoriaCID(Long id) {
        return categoriCIDBEANS.getPorId(factory, id);
    }
    
    
    
    
}
