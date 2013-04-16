package gov.pr.seab.sga.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_protocoloanexado database table.
 * 
 */
@Entity
@Table(name="tb_protocoloanexado")
public class ProtocoloAnexado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PROTOCOLOANEXADO_CODIGO_GENERATOR", sequenceName="TB_PROTOCOLOANEXADO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PROTOCOLOANEXADO_CODIGO_GENERATOR")
	private Integer codigo;

	private String numeroprotocolo;

	//bi-directional many-to-one association to Protocolo
	@ManyToOne
	@JoinColumn(name="codigoprotocolo")
	private Protocolo protocolo;

	public ProtocoloAnexado() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNumeroprotocolo() {
		return this.numeroprotocolo;
	}

	public void setNumeroprotocolo(String numeroprotocolo) {
		this.numeroprotocolo = numeroprotocolo;
	}

	public Protocolo getProtocolo() {
		return this.protocolo;
	}

	public void setProtocolo(Protocolo protocolo) {
		this.protocolo = protocolo;
	}

}