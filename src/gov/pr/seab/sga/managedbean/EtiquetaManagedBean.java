package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Setor;
import gov.pr.seab.sga.util.Relatorio;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

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
	
	
	
	

	@PostConstruct
    public void construct(){            
    }
    
    protected void redirect(String page){

        FacesContext ctx = FacesContext.getCurrentInstance();
        ExternalContext ec = ctx.getExternalContext();
        
        try {
            ec.redirect(ec.getRequestContextPath() + page);
        } catch (IOException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ex.getMessage()));
        }
        
    }
    
    public void imprimirRelatorio() throws Exception{  

         try
         {                                         
             
            List<Setor> listaSetor = new ArrayList<Setor>();
            
            Setor setor = new Setor();
            setor.setDescricao("Descricao");
            setor.setSigla("Sigla");
            
            listaSetor.add(setor);
 
            FacesContext ctx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);                         
            session.setAttribute("listaSetor", listaSetor);
            session.setAttribute("relatorio", "etoqueta.jasper");
            redirect("/ExemploRelatorioServlet");
            
         }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ex.getMessage()));   
         }         
    }   
	
	

}
