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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	private String descricao;

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

}