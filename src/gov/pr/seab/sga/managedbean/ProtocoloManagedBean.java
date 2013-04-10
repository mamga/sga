package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Protocolo;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.facade.ProtocoloFacade;
import gov.pr.seab.sga.util.ProtocoloUtil.SetorSeab;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProtocoloManagedBean {

	private String numeroProtocolo;
	private String nomeInteressado;
	private String dataInicial;
	private String dataFinal;
	private String cidade;
	private List<Protocolo> listaProtocolos;
	private SetorSeab setorSeab;
	private List<SetorSeab> setoresSeab;
	

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	
	public String getNomeInteressado() {
		return nomeInteressado;
	}

	public void setNomeInteressado(String nomeInteressado) {
		this.nomeInteressado = nomeInteressado;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Protocolo> getListaProtocolos() {
		return listaProtocolos;
	}

	public void setListaProtocolos(List<Protocolo> listaProtocolos) {
		this.listaProtocolos = listaProtocolos;
	}

	public void consultar() throws Exception {
		
		List<Protocolo> lista = new ArrayList<Protocolo>();
		ProtocoloDTO protocoloDTO = new ProtocoloDTO();
		protocoloDTO.setNumeroProtocolo(getNumeroProtocolo());

		Protocolo protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
			
		if (protocolo != null) {
			lista.add(protocolo);
			setListaProtocolos(lista);			
		}
				
	}

	public SetorSeab getSetorSeab() {
		return setorSeab;
	}

	public void setSetorSeab(SetorSeab setorSeab) {
		this.setorSeab = setorSeab;
	}

	public List<SetorSeab> getSetoresSeab() {
		return SetorSeab.getSetores();
	}

	public void setSetoresSeab(List<SetorSeab> setoresSeab) {
		this.setoresSeab = setoresSeab;
	}
		
	
	
}
