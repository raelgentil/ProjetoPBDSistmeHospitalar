package br.com.sistema_hospitalar.model.entidade;

import br.com.sistema_hospitalar.model.entidade.interfaces.IEntidadeBase;
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

    @Column(name = "cids", length = 50)
    private String cids;
    
    @Transient
    private List<CategoriaCID> cidss;

    @Column(name = "cod_medico_paciente", unique = true)
    private String codMedicoPaciente;

    @Column(name = "observacoes")
    private String observacoes;

    @Column(name = "prescricao")
    private String prescricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;
    
    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = true)
    private ProfissionalSaude medico;

    private Prontuario() {
    }

    
    public Prontuario(Long id, Long numero, Calendar dataAbertura, Calendar dataRetorno, Calendar dataPrevistaRetorno, List<CategoriaCID> cidss, String codMedicoPaciente, String observacoes, String prescricao, Paciente paciente) {
        this.id = id;
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataRetorno = dataRetorno;
        this.dataPrevistaRetorno = dataPrevistaRetorno;
        this.cidss = cidss;
        this.codMedicoPaciente = codMedicoPaciente;
        this.observacoes = observacoes;
        this.prescricao = prescricao;
        this.paciente = paciente;
    }
    public Prontuario(Calendar dataAbertura, Calendar dataRetorno, Calendar dataPrevistaRetorno, List<CategoriaCID> cidss, String codMedicoPaciente, String observacoes, String prescricao, Paciente paciente) {
        //old
        this.dataAbertura = dataAbertura;
        this.dataRetorno = dataRetorno;
        this.dataPrevistaRetorno = dataPrevistaRetorno;
        this.cidss = cidss;
        this.codMedicoPaciente = codMedicoPaciente;
        this.observacoes = observacoes;
        this.prescricao = prescricao;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAtendimento = dataAtendimento;
    }
    public Prontuario(Calendar dataAbertura, Calendar dataRetorno, Calendar dataPrevistaRetorno,Calendar dataAtendimento, List<CategoriaCID> cidss, String observacoes, String prescricao, Paciente paciente, ProfissionalSaude medico) {

        this.dataAbertura = dataAbertura;
        this.dataRetorno = dataRetorno;
        this.dataPrevistaRetorno = dataPrevistaRetorno;
        this.cidss = cidss;
        this.observacoes = observacoes;
        this.prescricao = prescricao;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAtendimento = dataAtendimento;
        gerarCodigoMedicoPaciente();
    }
    public Prontuario(Long id, Long numero, Calendar dataAbertura, Calendar dataRetorno, Calendar dataPrevistaRetorno, String cids, String codMedicoPaciente, String observacoes, String prescricao, Paciente paciente) {
        this.id = id;
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataRetorno = dataRetorno;
        this.dataPrevistaRetorno = dataPrevistaRetorno;
        this.cids = cids;
        this.codMedicoPaciente = codMedicoPaciente;
        this.observacoes = observacoes;
        this.prescricao = prescricao;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAtendimento = dataAtendimento;
    }
    private void gerarCodigoMedicoPaciente() {
        codMedicoPaciente = (medico.getApelido()+paciente.getId());
    }

    public Long getId() {
        return id;
    }

    public Long getNumero() {
        return numero;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public Calendar getDataAtendimento() {
        return dataAtendimento;
    }

    public ProfissionalSaude getMedico() {
        return medico;
    }

    public Calendar getDataRetorno() {
        return dataRetorno;
    }

    public Calendar getDataPrevistaRetorno() {
        return dataPrevistaRetorno;
    }

    public String getCids() {
        return cids;
    }

    public String getCodMedicoPaciente() {
        return codMedicoPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<CategoriaCID> getCidss() {
        return this.cidss;
    }

    

    
    
}
