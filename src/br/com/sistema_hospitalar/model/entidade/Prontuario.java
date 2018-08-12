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

    @Column(name = "cod_medico_paciente", unique = true, length = 20)
    private String codMedicoPaciente;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "prescricao", length = 100)
    private String prescricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = true)
    private ProfissionalSaude medico;

    public Prontuario() {
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

    
    
    
}
