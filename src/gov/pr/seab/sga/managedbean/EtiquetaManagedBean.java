package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Protocolo;
import gov.pr.seab.sga.dto.EtiquetaDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.facade.ProtocoloFacade;
import gov.pr.seab.sga.util.ProtocoloUtil;
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
	

	public void gerarRelatorioTeste () throws Exception {
		
		try {
	        List<EtiquetaDTO> listaEtiqueta = new ArrayList<EtiquetaDTO>();
	        Protocolo protocolo = null;
	        ProtocoloDTO protocoloDTO = null;
	        EtiquetaDTO etiqueta = new EtiquetaDTO();
	        String detalhamentoEtiqueta = "";
	        
	        //Etiqueta 1
	        if (numeroProtocoloEtiqueta1 != "") {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta1.replace(".", "").replace("-", ""));
	        	
	        	protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	if (protocolo != null) {
	        		etiqueta.setOrgaoEtiqueta1("<b>Órgão:</b> " + protocolo.getOrgaoCadastro());
	        		etiqueta.setDataCadastroEtiqueta1("<b>Em:</b> " + protocolo.getDataCadastro() + " " + protocolo.getHoraHHCadastro() + ":" + protocolo.getHoraMMCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta1(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta1("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta1("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta1("<b>Assunto:</b> " + ProtocoloUtil.Assunto.getDescricao(protocolo.getAssunto()));
	        		etiqueta.setMunicipioEtiqueta1("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta1("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta1("<b>Palavras Chaves:</b> " + protocolo.getPalavra1());
	        		etiqueta.setDocumentoEtiqueta1("<b>Documento:</b> " + Integer.valueOf(protocolo.getNumeroDocumento()) + "/" + protocolo.getAnoDocumento());
	        		
	        		detalhamentoEtiqueta = "";
	        		for (String detalhamento : protocolo.getDetalhamento() ) {
	        			detalhamentoEtiqueta = detalhamentoEtiqueta +  detalhamento;
	        		}
	        		etiqueta.setAssuntoComplementoEtiqueta1("<b>Assunto/Complemento:</b> " + detalhamentoEtiqueta);
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta1 + " não encontrado." );
	        	}
	        } else {
        		etiqueta.setOrgaoEtiqueta1("");
        		etiqueta.setDataCadastroEtiqueta1("");
        		etiqueta.setNumeroProtocoloEtiqueta1("");
        		etiqueta.setNomeInteressado1Etiqueta1("");
        		etiqueta.setNomeInteressado2Etiqueta1("");
        		etiqueta.setAssuntoEtiqueta1("");
        		etiqueta.setMunicipioEtiqueta1("");
        		etiqueta.setOrigemEtiqueta1("");
        		etiqueta.setPalavraChaveEtiqueta1("");
        		etiqueta.setDocumentoEtiqueta1("");
        		etiqueta.setAssuntoComplementoEtiqueta1("");
        		
        		listaEtiqueta.add(etiqueta);
	        }
	        
	        //Etiqueta 2
	        if (numeroProtocoloEtiqueta2 != "") {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta2.replace(".", "").replace("-", ""));
	        	
	        	protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	if (protocolo != null) {
	        		etiqueta.setOrgaoEtiqueta2("<b>Órgão:</b> " +  protocolo.getOrgaoCadastro());
	        		etiqueta.setDataCadastroEtiqueta2("<b>Em:</b> " + protocolo.getDataCadastro() + " " + protocolo.getHoraHHCadastro() + ":" + protocolo.getHoraMMCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta2(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta2("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta2("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta2("<b>Assunto:</b> " + ProtocoloUtil.Assunto.getDescricao(protocolo.getAssunto()));
	        		etiqueta.setMunicipioEtiqueta2("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta2("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta2("<b>Palavras Chaves:</b> " + protocolo.getPalavra1());
	        		etiqueta.setDocumentoEtiqueta2("<b>Documento:</b> " + Integer.valueOf(protocolo.getNumeroDocumento()) + "/" + protocolo.getAnoDocumento());
	        		
	        		detalhamentoEtiqueta = "";
	        		for (String detalhamento : protocolo.getDetalhamento() ) {
	        			detalhamentoEtiqueta = detalhamentoEtiqueta +  detalhamento;
	        		}
	        		etiqueta.setAssuntoComplementoEtiqueta2("<b>Assunto/Complemento:</b> " + detalhamentoEtiqueta);
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta2 + " não encontrado." );
	        	}
	        } else {
        		etiqueta.setOrgaoEtiqueta2("");
        		etiqueta.setDataCadastroEtiqueta2("");
        		etiqueta.setNumeroProtocoloEtiqueta2("");
        		etiqueta.setNomeInteressado1Etiqueta2("");
        		etiqueta.setNomeInteressado2Etiqueta2("");
        		etiqueta.setAssuntoEtiqueta2("");
        		etiqueta.setMunicipioEtiqueta2("");
        		etiqueta.setOrigemEtiqueta2("");
        		etiqueta.setPalavraChaveEtiqueta2("");
        		etiqueta.setDocumentoEtiqueta2("");
        		etiqueta.setAssuntoComplementoEtiqueta2("");
        		
        		listaEtiqueta.add(etiqueta);
	        }
	        
	      //Etiqueta 3
	        if (numeroProtocoloEtiqueta3 != "") {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta3.replace(".", "").replace("-", ""));
	        	
	        	protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	if (protocolo != null) {
	        		etiqueta.setOrgaoEtiqueta3("<b>Órgão:</b> "  + protocolo.getOrgaoCadastro());
	        		etiqueta.setDataCadastroEtiqueta3("<b>Em:</b> " + protocolo.getDataCadastro() + " " + protocolo.getHoraHHCadastro() + ":" + protocolo.getHoraMMCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta3(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta3("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta3("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta3("<b>Assunto:</b> " + ProtocoloUtil.Assunto.getDescricao(protocolo.getAssunto()));
	        		etiqueta.setMunicipioEtiqueta3("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta3("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta3("<b>Palavras Chaves:</b> " + protocolo.getPalavra1());
	        		etiqueta.setDocumentoEtiqueta3("<b>Documento:</b> " + Integer.valueOf(protocolo.getNumeroDocumento()) + "/" + protocolo.getAnoDocumento());
	        		
	        		detalhamentoEtiqueta = "";
	        		for (String detalhamento : protocolo.getDetalhamento() ) {
	        			detalhamentoEtiqueta = detalhamentoEtiqueta +  detalhamento;
	        		}
	        		etiqueta.setAssuntoComplementoEtiqueta3("<b>Assunto/Complemento:</b> " + detalhamentoEtiqueta);
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta3 + " não encontrado." );
	        	}
	        } else {
        		etiqueta.setOrgaoEtiqueta3("");
        		etiqueta.setDataCadastroEtiqueta3("");
        		etiqueta.setNumeroProtocoloEtiqueta3("");
        		etiqueta.setNomeInteressado1Etiqueta3("");
        		etiqueta.setNomeInteressado2Etiqueta3("");
        		etiqueta.setAssuntoEtiqueta3("");
        		etiqueta.setMunicipioEtiqueta3("");
        		etiqueta.setOrigemEtiqueta3("");
        		etiqueta.setPalavraChaveEtiqueta3("");
        		etiqueta.setDocumentoEtiqueta3("");
        		etiqueta.setAssuntoComplementoEtiqueta3("");
        		
        		listaEtiqueta.add(etiqueta);
	        }
	        
	      //Etiqueta 4
	        if (numeroProtocoloEtiqueta4 != "") {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta4.replace(".", "").replace("-", ""));
	        	
	        	protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	if (protocolo != null) {
	        		etiqueta.setOrgaoEtiqueta4("<b>Órgão:</b> "  + protocolo.getOrgaoCadastro());
	        		etiqueta.setDataCadastroEtiqueta4("<b>Em:</b> " + protocolo.getDataCadastro() + " " + protocolo.getHoraHHCadastro() + ":" + protocolo.getHoraMMCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta4(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta4("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta4("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta4("<b>Assunto:</b> " + ProtocoloUtil.Assunto.getDescricao(protocolo.getAssunto()));
	        		etiqueta.setMunicipioEtiqueta4("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta4("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta4("<b>Palavras Chaves:</b> " + protocolo.getPalavra1());
	        		etiqueta.setDocumentoEtiqueta4("<b>Documento:</b> " + Integer.valueOf(protocolo.getNumeroDocumento()) + "/" + protocolo.getAnoDocumento());
	        		
	        		detalhamentoEtiqueta = "";
	        		for (String detalhamento : protocolo.getDetalhamento() ) {
	        			detalhamentoEtiqueta = detalhamentoEtiqueta +  detalhamento;
	        		}
	        		etiqueta.setAssuntoComplementoEtiqueta4("<b>Assunto/Complemento:</b> " + detalhamentoEtiqueta);
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta4 + " não encontrado." );
	        	}
	        } else {
        		etiqueta.setOrgaoEtiqueta4("");
        		etiqueta.setDataCadastroEtiqueta4("");
        		etiqueta.setNumeroProtocoloEtiqueta4("");
        		etiqueta.setNomeInteressado1Etiqueta4("");
        		etiqueta.setNomeInteressado2Etiqueta4("");
        		etiqueta.setAssuntoEtiqueta4("");
        		etiqueta.setMunicipioEtiqueta4("");
        		etiqueta.setOrigemEtiqueta4("");
        		etiqueta.setPalavraChaveEtiqueta4("");
        		etiqueta.setDocumentoEtiqueta4("");
        		etiqueta.setAssuntoComplementoEtiqueta4("");
        		
        		listaEtiqueta.add(etiqueta);
	        }
	       
	      //Etiqueta 5
	        if (numeroProtocoloEtiqueta5 != "") {
	        	protocoloDTO = new ProtocoloDTO();
	        	protocoloDTO.setNumeroProtocolo(numeroProtocoloEtiqueta5.replace(".", "").replace("-", ""));
	        	
	        	protocolo = ProtocoloFacade.obterProtocolo(protocoloDTO);
	        	
	        	if (protocolo != null) {
	        		etiqueta.setOrgaoEtiqueta5("<b>Órgão:</b> " + protocolo.getOrgaoCadastro());
	        		etiqueta.setDataCadastroEtiqueta5("<b>Em:</b> " + protocolo.getDataCadastro() + " " + protocolo.getHoraHHCadastro() + ":" + protocolo.getHoraMMCadastro());
	        		etiqueta.setNumeroProtocoloEtiqueta5(protocolo.getNumeroProtocolo());
	        		etiqueta.setNomeInteressado1Etiqueta5("<b>Interessado 1:</b> " + protocolo.getInteressadoNome1());
	        		etiqueta.setNomeInteressado2Etiqueta5("<b>Interessado 2:</b> " + protocolo.getInteressadoNome2());
	        		etiqueta.setAssuntoEtiqueta5("<b>Assunto:</b> " + ProtocoloUtil.Assunto.getDescricao(protocolo.getAssunto()));
	        		etiqueta.setMunicipioEtiqueta5("<b>Cidade:</b> " + protocolo.getCidade());
	        		etiqueta.setOrigemEtiqueta5("<b>Origem:</b> " + protocolo.getOrigem());
	        		etiqueta.setPalavraChaveEtiqueta5("<b>Palavras Chaves:</b> " + protocolo.getPalavra1());
	        		etiqueta.setDocumentoEtiqueta5("<b>Documento:</b> " + Integer.valueOf(protocolo.getNumeroDocumento()) + "/" + protocolo.getAnoDocumento());
	        		
	        		detalhamentoEtiqueta = "";
	        		for (String detalhamento : protocolo.getDetalhamento() ) {
	        			detalhamentoEtiqueta = detalhamentoEtiqueta +  detalhamento;
	        		}
	        		etiqueta.setAssuntoComplementoEtiqueta5("<b>Assunto/Complemento:</b> " + detalhamentoEtiqueta);
	        		
	        		listaEtiqueta.add(etiqueta);
	        		
	        	} else {
	        		displayInfoMessageToUsuario("- Protocolo " + numeroProtocoloEtiqueta5 + " não encontrado." );
	        	}
	        } else {
        		etiqueta.setOrgaoEtiqueta5("");
        		etiqueta.setDataCadastroEtiqueta5("");
        		etiqueta.setNumeroProtocoloEtiqueta5("");
        		etiqueta.setNomeInteressado1Etiqueta5("");
        		etiqueta.setNomeInteressado2Etiqueta5("");
        		etiqueta.setAssuntoEtiqueta5("");
        		etiqueta.setMunicipioEtiqueta5("");
        		etiqueta.setOrigemEtiqueta5("");
        		etiqueta.setPalavraChaveEtiqueta5("");
        		etiqueta.setDocumentoEtiqueta5("");
        		etiqueta.setAssuntoComplementoEtiqueta5("");
        		
        		listaEtiqueta.add(etiqueta);
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
