package gov.pr.seab.sga.bean;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the tb_protocolo database table.
 * 
 */
@Entity
@Table(name="tb_protocolo")
public class Protocolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PROTOCOLO_CODIGO_GENERATOR", sequenceName="TB_PROTOCOLO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PROTOCOLO_CODIGO_GENERATOR")
	private Integer codigo;

	private String anexo;

	private String anodocumento;

	private String assunto;

	private String cidade;

	private String conclusao;

	private Timestamp datacadastro;

	private Timestamp dataenvio;

	private String detalhamento;

	private String dvanexo;

	private String especie;

	private String estado;

	private String interessadonome1;

	private String interessadonome2;

	private String interessadoqtd1;

	private String interessadoqtd2;

	private String interessadorg1;

	private String interessadorg2;

	private String interessadotipo1;

	private String interessadotipo2;

	private String localde;

	private String localpara;

	private String motivo;

	private String numerodocumento;

	private String numeroprotocolo;

	private String orgaocadastro;

	private String origem;

	private String palavra1;

	private String palavra2;

	private String protocoloanteriorano;

	private String protocoloanteriornumero;

	private String protocoloanteriororgao;

	private String protocolosigiloso;

	private String temconclusao;

	//bi-directional many-to-one association to ProtocoloAnexado
	@OneToMany(mappedBy="protocolo")
	private List<ProtocoloAnexado> protocolosAnexados;

	//bi-directional many-to-one association to Tramitacao
	@OneToMany(mappedBy="protocolo")
	private List<Tramitacao> tramitacoes;

	public Protocolo() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getAnexo() {
		return this.anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getAnodocumento() {
		return this.anodocumento;
	}

	public void setAnodocumento(String anodocumento) {
		this.anodocumento = anodocumento;
	}

	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getConclusao() {
		return this.conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public Timestamp getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Timestamp datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Timestamp getDataenvio() {
		return this.dataenvio;
	}

	public void setDataenvio(Timestamp dataenvio) {
		this.dataenvio = dataenvio;
	}

	public String getDetalhamento() {
		return this.detalhamento;
	}

	public void setDetalhamento(String detalhamento) {
		this.detalhamento = detalhamento;
	}

	public String getDvanexo() {
		return this.dvanexo;
	}

	public void setDvanexo(String dvanexo) {
		this.dvanexo = dvanexo;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getInteressadonome1() {
		return this.interessadonome1;
	}

	public void setInteressadonome1(String interessadonome1) {
		this.interessadonome1 = interessadonome1;
	}

	public String getInteressadonome2() {
		return this.interessadonome2;
	}

	public void setInteressadonome2(String interessadonome2) {
		this.interessadonome2 = interessadonome2;
	}

	public String getInteressadoqtd1() {
		return this.interessadoqtd1;
	}

	public void setInteressadoqtd1(String interessadoqtd1) {
		this.interessadoqtd1 = interessadoqtd1;
	}

	public String getInteressadoqtd2() {
		return this.interessadoqtd2;
	}

	public void setInteressadoqtd2(String interessadoqtd2) {
		this.interessadoqtd2 = interessadoqtd2;
	}

	public String getInteressadorg1() {
		return this.interessadorg1;
	}

	public void setInteressadorg1(String interessadorg1) {
		this.interessadorg1 = interessadorg1;
	}

	public String getInteressadorg2() {
		return this.interessadorg2;
	}

	public void setInteressadorg2(String interessadorg2) {
		this.interessadorg2 = interessadorg2;
	}

	public String getInteressadotipo1() {
		return this.interessadotipo1;
	}

	public void setInteressadotipo1(String interessadotipo1) {
		this.interessadotipo1 = interessadotipo1;
	}

	public String getInteressadotipo2() {
		return this.interessadotipo2;
	}

	public void setInteressadotipo2(String interessadotipo2) {
		this.interessadotipo2 = interessadotipo2;
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

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNumerodocumento() {
		return this.numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getNumeroprotocolo() {
		return this.numeroprotocolo;
	}

	public void setNumeroprotocolo(String numeroprotocolo) {
		this.numeroprotocolo = numeroprotocolo;
	}

	public String getOrgaocadastro() {
		return this.orgaocadastro;
	}

	public void setOrgaocadastro(String orgaocadastro) {
		this.orgaocadastro = orgaocadastro;
	}

	public String getOrigem() {
		return this.origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getPalavra1() {
		return this.palavra1;
	}

	public void setPalavra1(String palavra1) {
		this.palavra1 = palavra1;
	}

	public String getPalavra2() {
		return this.palavra2;
	}

	public void setPalavra2(String palavra2) {
		this.palavra2 = palavra2;
	}

	public String getProtocoloanteriorano() {
		return this.protocoloanteriorano;
	}

	public void setProtocoloanteriorano(String protocoloanteriorano) {
		this.protocoloanteriorano = protocoloanteriorano;
	}

	public String getProtocoloanteriornumero() {
		return this.protocoloanteriornumero;
	}

	public void setProtocoloanteriornumero(String protocoloanteriornumero) {
		this.protocoloanteriornumero = protocoloanteriornumero;
	}

	public String getProtocoloanteriororgao() {
		return this.protocoloanteriororgao;
	}

	public void setProtocoloanteriororgao(String protocoloanteriororgao) {
		this.protocoloanteriororgao = protocoloanteriororgao;
	}

	public String getProtocolosigiloso() {
		return this.protocolosigiloso;
	}

	public void setProtocolosigiloso(String protocolosigiloso) {
		this.protocolosigiloso = protocolosigiloso;
	}

	public String getTemconclusao() {
		return this.temconclusao;
	}

	public void setTemconclusao(String temconclusao) {
		this.temconclusao = temconclusao;
	}

	public List<ProtocoloAnexado> getProtocolosAnexados() {
		return this.protocolosAnexados;
	}

	public void setProtocolosAnexados(List<ProtocoloAnexado> protocolosAnexados) {
		this.protocolosAnexados = protocolosAnexados;
	}

	public List<Tramitacao> getTramitacoes() {
		return this.tramitacoes;
	}

	public void setTramitacoes(List<Tramitacao> tramitacoes) {
		this.tramitacoes = tramitacoes;
	}

}