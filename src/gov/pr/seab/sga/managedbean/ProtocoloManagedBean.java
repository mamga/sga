package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.ProtocoloAAX;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.facade.ProtocoloFacade;
import gov.pr.seab.sga.util.ProtocoloUtil.Municipio;
import gov.pr.seab.sga.util.ProtocoloUtil.SetorSeab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProtocoloManagedBean extends AbstractManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String numeroProtocolo;
	private String nomeInteressado;
	private String dataInicial;
	private String dataFinal;
	private String cidade;
	private Collection<ProtocoloAAX> listaProtocolos;
	private SetorSeab setorSeab;
	private Municipio municipio;
	

	public SetorSeab[] getSetoresSeab(){
	    return SetorSeab.values();
	}
	
	public Municipio[] getMunicipios(){
	    return Municipio.values();
	}
	

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

	public Collection<ProtocoloAAX> getListaProtocolos() {
		return listaProtocolos;
	}

	public void setListaProtocolos(Collection<ProtocoloAAX> listaProtocolos) {
		this.listaProtocolos = listaProtocolos;
	}

	public void consultar() {
		
		try {
			Collection<ProtocoloAAX> lista = new ArrayList<ProtocoloAAX>();
			ProtocoloDTO protocoloDTO = new ProtocoloDTO();
			
			
			if (numeroProtocolo == "") {
				protocoloDTO.setNumeroProtocolo(getNumeroProtocolo().replace(".", "").replace("-", ""));
				ProtocoloAAX protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
				
				if (protocolo != null) {
					lista.add(protocolo);
					setListaProtocolos(lista);			
				}
				
			} else {
				
				protocoloDTO.setNomeInteressado(nomeInteressado);
				protocoloDTO.setDataInicio(dataInicial);
				protocoloDTO.setDataFim(dataFinal);
				protocoloDTO.setMunicipio(cidade);
				
				setListaProtocolos(ProtocoloFacade.listarProtocolo(protocoloDTO));
				
			}
			
			if (lista.isEmpty()) {
				lista = null;
				displayInfoMessageToUsuario("Nenhum Registro Encontrado.");
			}
			
		} catch (Exception e) {
			displayErrorMessageToUsuario("Erro ao executar consulta: " + e);
		}
				
	}

	public SetorSeab getSetorSeab() {
		return setorSeab;
	}

	public void setSetorSeab(SetorSeab setorSeab) {
		this.setorSeab = setorSeab;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	
}
