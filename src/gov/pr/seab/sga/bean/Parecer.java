package gov.pr.seab.sga.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_parecer database table.
 * 
 */
@Entity
@Table(name="tb_parecer")
public class Parecer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PARECER_CODIGO_GENERATOR", sequenceName="TB_PARECER_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PARECER_CODIGO_GENERATOR")
	private Integer codigo;

	private String parecer;

	//bi-directional one-to-one association to Tramitacao
	@OneToOne
	@JoinColumn(name="coditotramitacao")
	private Tramitacao tramitacao;

	public Parecer() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getParecer() {
		return this.parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Tramitacao getTramitacao() {
		return this.tramitacao;
	}

	public void setTramitacao(Tramitacao tramitacao) {
		this.tramitacao = tramitacao;
	}

}