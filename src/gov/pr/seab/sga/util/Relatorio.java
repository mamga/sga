package gov.pr.seab.sga.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class Relatorio {
	
    public static void imprimir(JRBeanCollectionDataSource ds, String reportUrl, Map<String, Object> parametros){  
        FacesContext facesContext = FacesContext.getCurrentInstance();  
          
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();  
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();  
        OutputStream os = null;  
          
        try {  
            String reportUrlReal = request.getSession().getServletContext().getRealPath("relatorios" + File.separator + reportUrl);  
              
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportUrlReal, parametros, ds);  
            byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);  
              
            os = response.getOutputStream();  
            response.setContentType("application/pdf");  
            response.setContentLength(pdf.length);  
            response.setHeader("Content-disposition","attachment; filename=\""+ reportUrl.substring(0, reportUrl.length() - 7)+ ".pdf\"");  
            os.write(pdf);  
            os.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally{  
            try {  
                if(os != null){  
                    os.close();  
                }  
                facesContext.responseComplete();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    
    
//    Eu tenho uma Classe Relatorio no pacote util e é vc so chamar o metodo no seu ManagedBean e desse jeito.


  //      JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);//lista é uma arraylist com os dados que apareçam no meu relatorio  
                  
  //      Relatorio.imprimir(ds, "relatorio.jasper", new HashMap<String, Object>());//o arquivo .jasper se encontra na pasta relatorio dentro da pasta WebContent  

}
