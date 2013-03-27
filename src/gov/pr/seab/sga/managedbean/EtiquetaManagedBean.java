package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Setor;
import gov.pr.seab.sga.util.Relatorio;

import java.io.IOException;
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

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ViewScoped
@ManagedBean
public class EtiquetaManagedBean extends AbstractManagedBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private String numeroProtocoloEtiquetaPos1;
	private String numeroProtocoloEtiquetaPos2;
	private String numeroProtocoloEtiquetaPos3;
	private String numeroProtocoloEtiquetaPos4;
	private String numeroProtocoloEtiquetaPos5;
	
 
	
	public String getNumeroProtocoloEtiquetaPos1() {
		return numeroProtocoloEtiquetaPos1;
	}
	public void setNumeroProtocoloEtiquetaPos1(String numeroProtocoloEtiquetaPos1) {
		this.numeroProtocoloEtiquetaPos1 = numeroProtocoloEtiquetaPos1;
	}
	public String getNumeroProtocoloEtiquetaPos2() {
		return numeroProtocoloEtiquetaPos2;
	}
	public void setNumeroProtocoloEtiquetaPos2(String numeroProtocoloEtiquetaPos2) {
		this.numeroProtocoloEtiquetaPos2 = numeroProtocoloEtiquetaPos2;
	}
	public String getNumeroProtocoloEtiquetaPos3() {
		return numeroProtocoloEtiquetaPos3;
	}
	public void setNumeroProtocoloEtiquetaPos3(String numeroProtocoloEtiquetaPos3) {
		this.numeroProtocoloEtiquetaPos3 = numeroProtocoloEtiquetaPos3;
	}
	public String getNumeroProtocoloEtiquetaPos4() {
		return numeroProtocoloEtiquetaPos4;
	}
	public void setNumeroProtocoloEtiquetaPos4(String numeroProtocoloEtiquetaPos4) {
		this.numeroProtocoloEtiquetaPos4 = numeroProtocoloEtiquetaPos4;
	}
	public String getNumeroProtocoloEtiquetaPos5() {
		return numeroProtocoloEtiquetaPos5;
	}
	public void setNumeroProtocoloEtiquetaPos5(String numeroProtocoloEtiquetaPos5) {
		this.numeroProtocoloEtiquetaPos5 = numeroProtocoloEtiquetaPos5;
	}
	
	public void gerarArquivoImpressao (ActionEvent actionEvent) {
		List<String> lista = new ArrayList<String>();
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);//lista é uma arraylist com os dados que apareçam no meu relatorio  
		Relatorio.imprimir(ds, "etiqueta.jasper", new HashMap<String, Object>());//o arquivo .jasper se encontra na pasta relatorio dentro da pasta WebContent 
	}
	
	
	

	public void gerarRelatorioTeste () throws IOException, JRException {
		
        List<Setor> listaSetor = new ArrayList<Setor>();
        Setor setor = new Setor();
        setor.setDescricao("Informática");
        setor.setSigla("NII");
        
        listaSetor.add(setor);
        
                
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaSetor);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/etiqueta.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=etiqueta.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
		
	}
	

}
