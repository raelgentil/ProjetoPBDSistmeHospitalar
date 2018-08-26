package br.com.sistema_hospitalar.model.entidade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author rafaelgentil
 */
@Entity
@Table(name = "prontuario")
public class Prontuario implements Serializable, IEntidadeBase {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Long numero;

    @Column(name = "data_abertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAbertura;

    @Column(name = "data_atendimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAtendimento;
    
    @Column(name = "data_retorno")
    @Temporal(TemporalType.DATE)
    private Calendar dataRetorno;

    @Column(name = "data_prevista_retorno")
    @Temporal(TemporalType.DATE)
    private Calendar dataPrevistaRetorno;

    @Column(name = "cids", length = 100)
    private String cids;
    
    @Transient
    private List<CategoriaCID> cidss;

    @Column(name = "cod_medico_paciente", length = 50)
    private String codMedicoPaciente;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "prescricao", length = 100)
    private String prescricao;
    
    @Transient
    private List<Lote> prescricaoo;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = true)
    private ProfissionalSaude medico;
    
    private String especializacaoMedico;

    public Prontuario() {
    }

    public Prontuario(Long id, Long numero, Calendar dataAbertura, Calendar dataAtendimento, Calendar dataRetorno, Calendar dataPrevistaRetorno, String cids, List<CategoriaCID> cidss, String codMedicoPaciente, String observacoes, String prescricao, List<Lote> prescricaoo, Paciente paciente, ProfissionalSaude medico, String especializacaoMedico) {
        this.id = id;
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataAtendimento = dataAtendimento;
        this.dataRetorno = dataRetorno;
        this.dataPrevistaRetorno = dataPrevistaRetorno;
        this.cids = cids;
        this.cidss = cidss;
        this.codMedicoPaciente = codMedicoPaciente;
        this.observacoes = observacoes;
        this.prescricao = prescricao;
        this.prescricaoo = prescricaoo;
        this.paciente = paciente;
        this.medico = medico;
        this.especializacaoMedico = especializacaoMedico;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Calendar dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Calendar getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Calendar dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public Calendar getDataPrevistaRetorno() {
        return dataPrevistaRetorno;
    }

    public void setDataPrevistaRetorno(Calendar dataPrevistaRetorno) {
        this.dataPrevistaRetorno = dataPrevistaRetorno;
    }

    public String getCids() {
        return cids;
    }

    public void setCids(String cids) {
        this.cids = cids;
    }

    public List<CategoriaCID> getCidss() {
        return cidss;
    }

    public void setCidss(List<CategoriaCID> cidss) {
        this.cidss = cidss;
    }

    public String getCodMedicoPaciente() {
        return codMedicoPaciente;
    }

    public void setCodMedicoPaciente(String codMedicoPaciente) {
        this.codMedicoPaciente = codMedicoPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ProfissionalSaude getMedico() {
        return medico;
    }

    public void setMedico(ProfissionalSaude medico) {
        this.medico = medico;
    }

    public List<Lote> getPrescricaoo() {
        return prescricaoo;
    }

    public void setPrescricaoo(List<Lote> prescricaoo) {
        this.prescricaoo = prescricaoo;
    }

    public String getEspecializacaoMedico() {
        return especializacaoMedico;
    }

    public void setEspecializacaoMedico(String especializacaoMedico) {
        this.especializacaoMedico = especializacaoMedico;
    }

    @Override
    public String toString() {
        return "Prontuario{" + "id=" + id + ", numero=" + numero + ", dataAbertura=" + dataAbertura + ", dataAtendimento=" + dataAtendimento + ", dataRetorno=" + dataRetorno + ", dataPrevistaRetorno=" + dataPrevistaRetorno + ", cids=" + cids + ", cidss=" + cidss + ", codMedicoPaciente=" + codMedicoPaciente + ", observacoes=" + observacoes + ", prescricao=" + prescricao + ", prescricaoo=" + prescricaoo + ", paciente=" + paciente + ", medico=" + medico + ", especializacaoMedico=" + especializacaoMedico + '}';
    }

    
    
    
    
}
