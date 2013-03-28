package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Protocolo;
import gov.pr.seab.sga.dto.EtiquetaDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.facade.ProtocoloFacade;
import gov.pr.seab.sga.util.Relatorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ViewScoped
@ManagedBean
public class EtiquetaManagedBean extends AbstractManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String numeroProtocoloEtiqueta1;
	private String numeroProtocoloEtiqueta2;
	private String numeroProtocoloEtiqueta3;
	private String numeroProtocoloEtiqueta4;
	private String numeroProtocoloEtiqueta5;
	
	
	public String getNumeroProtocoloEtiqueta1() {
		return numeroProtocoloEtiqueta1;
	}
	public void setNumeroProtocoloEtiqueta1(String numeroProtocoloEtiqueta1) {
		this.numeroProtocoloEtiqueta1 = numeroProtocoloEtiqueta1;
	}
	public String getNumeroProtocoloEtiqueta2() {
		return numeroProtocoloEtiqueta2;
	}
	public void setNumeroProtocoloEtiqueta2(String numeroProtocoloEtiqueta2) {
		this.numeroProtocoloEtiqueta2 = numeroProtocoloEtiqueta2;
	}
	public String getNumeroProtocoloEtiqueta3() {
		return numeroProtocoloEtiqueta3;
	}
	public void setNumeroProtocoloEtiqueta3(String numeroProtocoloEtiqueta3) {
		this.numeroProtocoloEtiqueta3 = numeroProtocoloEtiqueta3;
	}
	public String getNumeroProtocoloEtiqueta4() {
		return numeroProtocoloEtiqueta4;
	}
	public void setNumeroProtocoloEtiqueta4(String numeroProtocoloEtiqueta4) {
		this.numeroProtocoloEtiqueta4 = numeroProtocoloEtiqueta4;
	}
	public String getNumeroProtocoloEtiqueta5() {
		return numeroProtocoloEtiqueta5;
	}
	public void setNumeroProtocoloEtiqueta5(String numeroProtocoloEtiqueta5) {
		this.numeroProtocoloEtiqueta5 = numeroProtocoloEtiqueta5;
	}
	
	public void gerarArquivoImpressao (ActionEvent actionEvent) {
		List<String> lista = new ArrayList<String>();
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);//lista é uma arraylist com os dados que apareçam no meu relatorio  
		Relatorio.imprimir(ds, "etiqueta.jasper", new HashMap<String, Object>());//o arquivo .jasper se encontra na pasta relatorio dentro da pasta WebContent 
	}
	
	
	

	public void gerarRelatorioTeste () throws Exception {
		
		try {
	        List<EtiquetaDTO> listaEtiqueta = new ArrayList<EtiquetaDTO>();
	        Protocolo protocolo = null;
	        ProtocoloDTO protocoloDTO = null;
	        EtiquetaDTO etiqueta = null;
	        
	        if ((numeroProtocoloEtiqueta1 != null) || (numeroProtocoloEtiqueta1 != "")) {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta1);
	        	
	        	//protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	protocolo = new Protocolo();
	        	protocolo.setDataCadastro("01/01/1950 10:50");
	        	protocolo.setNumeroProtocolo("11.399.905-5");
	        	protocolo.setInteressadoNome1("Nome Interessado 1");
	        	protocolo.setInteressadoNome2("Nome Interessado 2");
	        	protocolo.setAssunto("Assunto Etiqueta 1");
	        	protocolo.setCidade("Curitiba");
	        	protocolo.setOrigem("Prefeitura");
	        	protocolo.setPalavra1("Palavra Chave 1");
	        	protocolo.setPalavra2("Palavra Chave 2");
	        	protocolo.setNumeroDocumento("009");
	        	protocolo.setAnoDocumento("2013");
	        	
	        	
	        	
	        	if (protocolo != null) {
	        		etiqueta = new EtiquetaDTO();
	        		etiqueta.setOrgaoEtiqueta1("<b>Órgão:</b>" + " SEAB");
	        		etiqueta.setDataCadastroEtiqueta1("<b>Em:</b> " + protocolo.getDataCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta1(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta1("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta1("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta1("<b>Assunto:</b> " + protocolo.getAssunto());
	        		etiqueta.setMunicipioEtiqueta1("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta1("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta1("<b>Palavras Chaves:</b> " + protocolo.getPalavra1() + " / " + protocolo.getPalavra2());
	        		etiqueta.setDocumentoEtiqueta1("<b>Número/Ano Documento:</b> " + protocolo.getNumeroDocumento()+ "/" + protocolo.getAnoDocumento());
	        		etiqueta.setAssuntoComplementoEtiqueta1("<b>Assunto/Complemento:</b> " + "??????????????");
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta1 + " não encontrado." );
	        	}
	        	
	        	
	        }
	        
	        
	        
	        if (!listaEtiqueta.isEmpty() ) {
		        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaEtiqueta);
		        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/etiquetaa4.jasper");
		        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
		        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		        httpServletResponse.addHeader("Content-disposition", "attachment; filename=etiqueta.pdf");
		        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
		        FacesContext.getCurrentInstance().responseComplete();
	        } else {
	        	displayInfoMessageToUsuario("- Nenhum protocolo informado foi encontrado." );
	        }
	        
		} catch (Exception e) {
			displayInfoMessageToUsuario("- Erro não tratado: " + e );
		}
	}
	

}
