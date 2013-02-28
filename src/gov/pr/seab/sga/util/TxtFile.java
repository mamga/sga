/*
 * Created on 01/08/2005
 * GUILHERME EDUARDO M. MENDES
 */
package gov.pr.seab.sga.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;

/**
 * @author tuy
 */
public class TxtFile {

	  private StringBuilder conteudo;
	    private File txt;
	    
	    public TxtFile(String dire, String arquivo,String conteud) throws Exception{
	        this(dire + File.separator + arquivo,conteud);
	    }

	    public TxtFile(String arquivo) throws Exception{
	    	this(arquivo,null);
	    }
	    
	    public TxtFile(String arquivo, String conteud) throws Exception{
	    	if( conteud!=null ){
	    		conteudo = new StringBuilder(conteud);
	    	}
	        txt = new File(arquivo);
	        if (conteud==null && txt.exists() && txt.isFile()) { 
	            Reader reader = null;
	            BufferedReader buffer = null;
	            try {	
	            	reader = new FileReader(txt);
		        	buffer = new BufferedReader(reader);
		        	//loadBuffer( buffer );
		        	String linha = null;	
					conteudo = new StringBuilder();
					while (true) {		  	  
					   linha = buffer.readLine();
					   if (linha==null) break;
					   if (!"".equals( conteudo.toString() )) {
					  	  conteudo.append("\r\n");
					   }
					   conteudo.append(linha);
					} 
	            } finally {
	            	if(reader!=null){
	            		reader.close();
	            	}
	            	if(buffer!=null){
	            		buffer.close();
	            	}
	            }
	        } 
	    }    
	    
	    
	    public void gravar() throws Exception{   
	        FileOutputStream fos = new FileOutputStream(txt.getAbsoluteFile());
	        try{	           
	            fos.write(conteudo.toString().getBytes());
	        }finally{
	            fos.close();
	            fos = null;
	        }
	    }
	        
	    public boolean exists() throws Exception{                    
	        return txt.exists() && txt.isFile();
	    }
	 
		public String getConteudo() {
			return conteudo.toString();
		}
		public void setConteudo(String conteudo) {
			this.conteudo = new StringBuilder( conteudo );
		}
		public File getTxt() {
			return txt;
		}
		public void setTxt(File txt) {
			this.txt = txt;
		}
}
