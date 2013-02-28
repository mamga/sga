package gov.pr.seab.sga.dto;

import java.io.Serializable;

public class ComboPesquisaDTO implements Comparable,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2752569460107910528L;
	
	
	private String valor;
	private String texto;
		
	
	public ComboPesquisaDTO(){		
	}
	
	public ComboPesquisaDTO(String valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public int compareTo(Object o) {
		ComboPesquisaDTO item = (ComboPesquisaDTO) o;
		return this.getTexto().compareTo( item.getTexto() );
	}
	
	
}
