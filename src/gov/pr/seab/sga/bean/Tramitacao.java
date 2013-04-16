package gov.pr.seab.sga.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tb_tramitacao database table.
 * 
 */
@Entity
@Table(name="tb_tramitacao")
public class Tramitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_TRAMITACAO_CODIGO_GENERATOR", sequenceName="TB_TRAMITACAO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_TRAMITACAO_CODIGO_GENERATOR")
	private Integer codigo;

	private Timestamp data;

	private String localde;

	private String localpara;

	private String existeparecer;

	private String parecerid;

	private Integer sequencia;

	private String tramitacao;

	//bi-directional one-to-one association to Parecer
	@OneToOne(mappedBy="tramitacao")
	private Parecer parecer;

	//bi-directional many-to-one association to Protocolo
	@ManyToOne
	@JoinColumn(name="codigoprotocolo")
	private Protocolo protocolo;

	public Tramitacao() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getLocalde() {
		return this.localde;
	}

	public void setLocalde(String localde) {
		this.localde = localde;
	}

	public String getLocalpara() {
		return this.localpara;
	}

	public void setLocalpara(String localpara) {
		this.localpara = localpara;
	}

	public String getExisteparecer() {
		return this.existeparecer;
	}

	public void setExisteparecer(String existeparecer) {
		this.existeparecer = existeparecer;
	}

	public String getParecerid() {
		return this.parecerid;
	}

	public void setParecerid(String parecerid) {
		this.parecerid = parecerid;
	}

	public Integer getSequencia() {
		return this.sequencia;
	}

	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}

	public String getTramitacao() {
		return this.tramitacao;
	}

	public void setTramitacao(String tramitacao) {
		this.tramitacao = tramitacao;
	}

	public Parecer getParecer() {
		return this.parecer;
	}

	public void setParecer(Parecer parecer) {
		this.parecer = parecer;
	}

	public Protocolo getProtocolo() {
		return this.protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}

}