package gov.pr.seab.sga.bean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_setor database table.
 * 
 */
@Entity
@Table(name="tb_setor")
public class Setor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_SETOR_CODIGO_GENERATOR", sequenceName="TB_SETOR_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_SETOR_CODIGO_GENERATOR")
	private Integer codigo;

	private String descricao;

	private String sigla;

	public Setor() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}