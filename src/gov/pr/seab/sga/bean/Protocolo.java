package gov.pr.seab.sga.bean;

import java.io.Serializable;
import java.util.Collection;

public class Protocolo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8823146428782373589L;
	
	
	private String numeroProtocolo;
	private String orgaoCadastro;
	private String dataCadastro;
	private String horaHHCadastro;
	private String horaMMCadastro;
	private String protocoloSigiloso;
	private String protocoloAnteriorNumero;
	private String protocoloAnteriorAno;
	private String protocoloAnteriorOrgao;
	private String anexo;
	private String dvAnexo;
	private String especie;
	private String origem;
	private String numeroDocumento;
	private String anoDocumento;
	private String cidade;
	private String estado;
	private String assunto;
	private String palavra1;
	private String palavra2;
	private String dataEnvio;
	private String localDe;
	private String localPara;
	private String motivo;
	private String temConclusao;
	
	private String interessadoTipo1;
	private String interessadoNome1;
	private String interessadoRG1;
	private String interessadoQtd1;
	
	
	private String interessadoTipo2;
	private String interessadoNome2;
	private String interessadoRG2;
	private String interessadoQtd2;
	
	
	private int anexoQuantidade;
	private String anexoProx;
	private Collection<String> protocoloAnexado;

	private Collection<String> detalhamento;
	
	private String pos;
	private String isn;
	private String cadastroAssunto;
	private String cadastroLocalPara;
	private String cadastroMotivo;
	private String cadastroFunc;
	private String cadastroDDDLocal;
	private String cadastroTelefoneLocal;
	private String cadastroRamalLocal;
	private String cadastroEspecie;
	private String cadastroFiller;
	
	private Collection<String> conclusao;
	private String dataArquivo;
	private String indLocal;
	
	private String sitProc;
	private String sitProcString;
	
	private String proHoraAtu;
	private String indicativoArq;
	
	private String proDataAtualizacao;
	private String indHis;
	private String nmLocDe;
	private String nmOrgCad;
	private String nmOrigem;
	
	
	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public String getOrgaoCadastro() {
		return orgaoCadastro;
	}
	public void setOrgaoCadastro(String orgaoCadastro) {
		this.orgaoCadastro = orgaoCadastro;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public String getHoraHHCadastro() {
		return horaHHCadastro;
	}
	public void setHoraHHCadastro(String horaHHCadastro) {
		this.horaHHCadastro = horaHHCadastro;
	}
	public String getHoraMMCadastro() {
		return horaMMCadastro;
	}
	public void setHoraMMCadastro(String horaMMCadastro) {
		this.horaMMCadastro = horaMMCadastro;
	}
	public String getProtocoloSigiloso() {
		return protocoloSigiloso;
	}
	public void setProtocoloSigiloso(String protocoloSigiloso) {
		this.protocoloSigiloso = protocoloSigiloso;
	}
	public String getProtocoloAnteriorNumero() {
		return protocoloAnteriorNumero;
	}
	public void setProtocoloAnteriorNumero(String protocoloAnteriorNumero) {
		this.protocoloAnteriorNumero = protocoloAnteriorNumero;
	}
	public String getProtocoloAnteriorAno() {
		return protocoloAnteriorAno;
	}
	public void setProtocoloAnteriorAno(String protocoloAnteriorAno) {
		this.protocoloAnteriorAno = protocoloAnteriorAno;
	}
	public String getProtocoloAnteriorOrgao() {
		return protocoloAnteriorOrgao;
	}
	public void setProtocoloAnteriorOrgao(String protocoloAnteriorOrgao) {
		this.protocoloAnteriorOrgao = protocoloAnteriorOrgao;
	}
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getDvAnexo() {
		return dvAnexo;
	}
	public void setDvAnexo(String dvAnexo) {
		this.dvAnexo = dvAnexo;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getAnoDocumento() {
		return anoDocumento;
	}
	public void setAnoDocumento(String anoDocumento) {
		this.anoDocumento = anoDocumento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getPalavra1() {
		return palavra1;
	}
	public void setPalavra1(String palavra1) {
		this.palavra1 = palavra1;
	}
	public String getPalavra2() {
		return palavra2;
	}
	public void setPalavra2(String palavra2) {
		this.palavra2 = palavra2;
	}
	public String getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public String getLocalDe() {
		return localDe;
	}
	public void setLocalDe(String localDe) {
		this.localDe = localDe;
	}
	public String getLocalPara() {
		return localPara;
	}
	public void setLocalPara(String localPara) {
		this.localPara = localPara;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getTemConclusao() {
		return temConclusao;
	}
	public void setTemConclusao(String temConclusao) {
		this.temConclusao = temConclusao;
	}
	public String getInteressadoTipo1() {
		return interessadoTipo1;
	}
	public void setInteressadoTipo1(String interessadoTipo1) {
		this.interessadoTipo1 = interessadoTipo1;
	}
	public String getInteressadoNome1() {
		return interessadoNome1;
	}
	public void setInteressadoNome1(String interessadoNome1) {
		this.interessadoNome1 = interessadoNome1;
	}
	public String getInteressadoRG1() {
		return interessadoRG1;
	}
	public void setInteressadoRG1(String interessadoRG1) {
		this.interessadoRG1 = interessadoRG1;
	}
	public String getInteressadoQtd1() {
		return interessadoQtd1;
	}
	public void setInteressadoQtd1(String interessadoQtd1) {
		this.interessadoQtd1 = interessadoQtd1;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getInteressadoTipo2() {
		return interessadoTipo2;
	}
	public void setInteressadoTipo2(String interessadoTipo2) {
		this.interessadoTipo2 = interessadoTipo2;
	}
	public String getInteressadoNome2() {
		return interessadoNome2;
	}
	public void setInteressadoNome2(String interessadoNome2) {
		this.interessadoNome2 = interessadoNome2;
	}
	public String getInteressadoRG2() {
		return interessadoRG2;
	}
	public void setInteressadoRG2(String interessadoRG2) {
		this.interessadoRG2 = interessadoRG2;
	}
	public String getInteressadoQtd2() {
		return interessadoQtd2;
	}
	public void setInteressadoQtd2(String interessadoQtd2) {
		this.interessadoQtd2 = interessadoQtd2;
	}
	public int getAnexoQuantidade() {
		return anexoQuantidade;
	}
	public void setAnexoQuantidade(int anexoQuantidade) {
		this.anexoQuantidade = anexoQuantidade;
	}
	public String getAnexoProx() {
		return anexoProx;
	}
	public void setAnexoProx(String anexoProx) {
		this.anexoProx = anexoProx;
	}
	public Collection<String> getProtocoloAnexado() {
		return protocoloAnexado;
	}
	public void setProtocoloAnexado(Collection<String> protocoloAnexado) {
		this.protocoloAnexado = protocoloAnexado;
	}
	public Collection<String> getDetalhamento() {
		return detalhamento;
	}
	public void setDetalhamento(Collection<String> detalhamento) {
		this.detalhamento = detalhamento;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getIsn() {
		return isn;
	}
	public void setIsn(String isn) {
		this.isn = isn;
	}
	public String getCadastroAssunto() {
		return cadastroAssunto;
	}
	public void setCadastroAssunto(String cadastroAssunto) {
		this.cadastroAssunto = cadastroAssunto;
	}
	public String getCadastroLocalPara() {
		return cadastroLocalPara;
	}
	public void setCadastroLocalPara(String cadastroLocalPara) {
		this.cadastroLocalPara = cadastroLocalPara;
	}
	public String getCadastroMotivo() {
		return cadastroMotivo;
	}
	public void setCadastroMotivo(String cadastroMotivo) {
		this.cadastroMotivo = cadastroMotivo;
	}
	public String getCadastroFunc() {
		return cadastroFunc;
	}
	public void setCadastroFunc(String cadastroFunc) {
		this.cadastroFunc = cadastroFunc;
	}
	public String getCadastroDDDLocal() {
		return cadastroDDDLocal;
	}
	public void setCadastroDDDLocal(String cadastroDDDLocal) {
		this.cadastroDDDLocal = cadastroDDDLocal;
	}
	public String getCadastroTelefoneLocal() {
		return cadastroTelefoneLocal;
	}
	public void setCadastroTelefoneLocal(String cadastroTelefoneLocal) {
		this.cadastroTelefoneLocal = cadastroTelefoneLocal;
	}
	public String getCadastroRamalLocal() {
		return cadastroRamalLocal;
	}
	public void setCadastroRamalLocal(String cadastroRamalLocal) {
		this.cadastroRamalLocal = cadastroRamalLocal;
	}
	public String getCadastroEspecie() {
		return cadastroEspecie;
	}
	public void setCadastroEspecie(String cadastroEspecie) {
		this.cadastroEspecie = cadastroEspecie;
	}
	public String getCadastroFiller() {
		return cadastroFiller;
	}
	public void setCadastroFiller(String cadastroFiller) {
		this.cadastroFiller = cadastroFiller;
	}
	public Collection<String> getConclusao() {
		return conclusao;
	}
	public void setConclusao(Collection<String> conclusao) {
		this.conclusao = conclusao;
	}
	public String getDataArquivo() {
		return dataArquivo;
	}
	public void setDataArquivo(String dataArquivo) {
		this.dataArquivo = dataArquivo;
	}
	public String getIndLocal() {
		return indLocal;
	}
	public void setIndLocal(String indLocal) {
		this.indLocal = indLocal;
	}
	public String getSitProc() {
		return sitProc;
	}
	public void setSitProc(String sitProc) {
		this.sitProc = sitProc;
	}
	public String getSitProcString() {
		return sitProcString;
	}
	public void setSitProcString(String sitProcString) {
		this.sitProcString = sitProcString;
	}
	public String getProHoraAtu() {
		return proHoraAtu;
	}
	public void setProHoraAtu(String proHoraAtu) {
		this.proHoraAtu = proHoraAtu;
	}
	public String getIndicativoArq() {
		return indicativoArq;
	}
	public void setIndicativoArq(String indicativoArq) {
		this.indicativoArq = indicativoArq;
	}
	public String getProDataAtualizacao() {
		return proDataAtualizacao;
	}
	public void setProDataAtualizacao(String proDataAtualizacao) {
		this.proDataAtualizacao = proDataAtualizacao;
	}
	public String getIndHis() {
		return indHis;
	}
	public void setIndHis(String indHis) {
		this.indHis = indHis;
	}
	public String getNmLocDe() {
		return nmLocDe;
	}
	public void setNmLocDe(String nmLocDe) {
		this.nmLocDe = nmLocDe;
	}
	public String getNmOrgCad() {
		return nmOrgCad;
	}
	public void setNmOrgCad(String nmOrgCad) {
		this.nmOrgCad = nmOrgCad;
	}
	public String getNmOrigem() {
		return nmOrigem;
	}
	public void setNmOrigem(String nmOrigem) {
		this.nmOrigem = nmOrigem;
	}
}
