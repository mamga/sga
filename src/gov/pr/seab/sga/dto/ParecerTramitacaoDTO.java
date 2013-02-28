package gov.pr.seab.sga.dto;

import java.util.Collection;

public class ParecerTramitacaoDTO {
	
	private Collection<String> pareceres;
	private Integer qtdeRegistro;
	private String localDe;
	private String localPara;
	private String historicoTramitacao;
	private String dataEnvio;
	public Collection<String> getPareceres() {
		return pareceres;
	}
	public void setPareceres(Collection<String> pareceres) {
		this.pareceres = pareceres;
	}
	public Integer getQtdeRegistro() {
		return qtdeRegistro;
	}
	public void setQtdeRegistro(Integer qtdeRegistro) {
		this.qtdeRegistro = qtdeRegistro;
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
	public String getHistoricoTramitacao() {
		return historicoTramitacao;
	}
	public void setHistoricoTramitacao(String historicoTramitacao) {
		this.historicoTramitacao = historicoTramitacao;
	}
	public String getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	
	

}
