package gov.pr.seab.sga.dao.implementation;

import gov.celepar.adabas.Natural;

import gov.pr.seab.sga.dao.ProtocoloDAO;
import gov.pr.seab.sga.dto.ParecerTramitacaoDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.dto.TramitacaoProtocoloDTO;
import gov.pr.seab.sga.bean.ProtocoloAAX;
import gov.pr.seab.sga.util.Dominios;
import gov.pr.seab.sga.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

public class ProtocoloMainFrameDAO implements ProtocoloDAO {
	 
	private static Logger log = Logger.getLogger(ProtocoloMainFrameDAO.class);
		
	
	public Collection<ProtocoloAAX> listar(ProtocoloDTO protocoloDTO) throws Exception {

		log.info("Procedimento listar protocolo processando...");
		
		Collection<ProtocoloAAX> listaProtocolos = new ArrayList<ProtocoloAAX>();
		
				
		String cpfCnpj = Util.strNull( protocoloDTO.getCpfCnpjInteressado());
		
		if (cpfCnpj.length() == 0){
			cpfCnpj = "000000000000000";
		}else if (cpfCnpj.length() == 11){
			cpfCnpj = new StringBuilder("0000").append(cpfCnpj).toString();
		}else if (cpfCnpj.length() == 14){
			cpfCnpj = new StringBuilder("0").append(cpfCnpj).toString();
		}
		
		
		StringBuilder pEntrada = new StringBuilder();
		pEntrada.append(String.format("%-40s", Util.limitarString( Util.formataStringSemAcento(protocoloDTO.getNomeInteressado()), 40) ) )			
				.append(String.format("%-12s", Util.limitarString( protocoloDTO.getTipoInteressado(), 12) ) )
				.append(cpfCnpj)
				.append(String.format("%-12s", Util.limitarString( protocoloDTO.getOrgaoCadastrado(), 12) ))
				.append(String.format("%8s", Util.limitarString( Util.strNull( protocoloDTO.getDataInicio() ).replaceAll("[/\\.]", ""), 8) ))
				.append(String.format("%8s", Util.limitarString( Util.strNull( protocoloDTO.getDataFim() ).replaceAll("[/\\.]", ""), 8) ))
				.append(String.format("%-5s", Util.limitarString( protocoloDTO.getCodigoAssunto(), 5) ))
				.append(String.format("%-20s", Util.limitarString( protocoloDTO.getPalavraChave(), 20) ))
				.append(String.format("%02d", "".equals( Util.strNull( protocoloDTO.getCodigoEspecie() ) ) ? 0 : Integer.parseInt( Util.limitarString( protocoloDTO.getCodigoEspecie(), 2) )))
				.append(String.format("%-12s", Util.limitarString( protocoloDTO.getOrigem(), 12) ))
				.append(String.format("%09d", 0))
				.append(String.format("%-4s", Util.limitarString( protocoloDTO.getAnoDocumentoOriginal(), 4) ))
				.append(String.format("%-30s", Util.limitarString( protocoloDTO.getMunicipio(), 30) ))
				.append(String.format("%-2s", Util.limitarString( protocoloDTO.getUf(), 2) ) )
				.append(String.format("%-12s", Util.limitarString( protocoloDTO.getLocalOriginal(), 12) ));
		
		log.debug(new StringBuilder(">>>>").append( pEntrada.toString() ));
		
		Natural natural = new Natural("AAXBG800", pEntrada.toString());
		
		if (natural.getRC() == 0) {			
			String retorno;
			retorno = natural.getDataParameter().substring(191);
			List<String> list = new ArrayList<String>();
			for (int i = 0 ; i <= 345; i++){
				log.debug( i * 85 );
				String item = retorno.substring( retorno.length() < i * 85 ? retorno.length() : i * 85 , ( retorno.length() > (i * 85) + 85 ) ? (i * 85) + 85 : retorno.length() );
				if ( !"".equals(item.trim()) ){
					list.add(item);	
				}
			}
			log.info("*** Criando lista de objetos ***");
			for (String item : list){
				int idx = 0;
				ProtocoloAAX protocolo = new ProtocoloAAX();
				protocolo.setNumeroProtocolo(item.substring(idx, idx+=9).trim());
				protocolo.setInteressadoNome1(item.substring(idx, idx+=40).trim());
				if(item.length() >= idx+35){
					protocolo.setAssunto( item.substring(idx, idx+=35).trim() );
					if(item.length() >= idx+1){
						protocolo.setProtocoloSigiloso( "N".equals( item.substring(idx, idx+=1) ) ? "Não" : "Sim");
					}else{
						protocolo.setProtocoloSigiloso("");
					}
				}else{
					protocolo.setAssunto("");
				}

				if ( (!"".equals(protocolo.getNumeroProtocolo())) && (Integer.parseInt(protocolo.getNumeroProtocolo()) > 0) ) {
					protocolo.setInteressadoNome1(protocolo.getInteressadoNome1().replaceAll("\\.\\.", "").replaceAll("\\.$", ""));
					protocolo.setAssunto(protocolo.getAssunto().replaceAll("\\.\\.", "").replaceAll("\\.$", ""));
					protocolo.setNumeroProtocolo(Util.formatarProtocolo(protocolo.getNumeroProtocolo()));
					listaProtocolos.add(protocolo);
				}
			}				
		} else {				
			/*throw new ApplicationException("AVISO.101", new String[]{ natural.getMSG() }, ApplicationException.ICON_AVISO);*/
			// Criar um campo para a mensagem. retornar o protocolo.
		}
		return listaProtocolos;
	}


	public ProtocoloAAX obter(ProtocoloDTO param) throws Exception {
		
		log.info("*** Procedimento obter processando... ***");
		
		ProtocoloAAX obj = null;
		
		
		log.info("*** Formatando par�metros de entrada ***");
		
		String protocolo = param.getNumeroProtocolo();
		
		StringBuilder pEntrada = new StringBuilder();
		
		pEntrada 
		// 2 #PR-CADASTRO             	(A217)                                     
		//2 REDEFINE #PR-CADASTRO                                               
			.append("AAX") //3 #PR-APLICACAO          (A003)                                     
			.append( Dominios.USUARIO_MAINFRAME ) // 3 #PR-USUARIO            	(N006)                                     
				// 3 REDEFINE #PR-USUARIO
				 //4 #PR-USUARIO-A     		(A006)                                     
	    	.append("C") //	3 #PR-FUNCAO             	(A001)                                     
	    	.append( String.format("%9s", protocolo) ) //	3 #PR-NUM-DV            	(A009)                                     
	    		 //3 REDEFINE #PR-NUM-DV                                               
	      			//4 #PR-NUM            (N008)                                     
	      			//4 #PR-DV               (A001)                                     
	    	.append(String.format("%12s", "")) //	3 #PR-ORG-CAD            	(A012)                                     
	    	.append(String.format("%08d", 0)) //	3 #PR-DT-CAD             	(N008)                                     
	    	.append(String.format("%04d", 0)) //	3 #PR-HORA               	(N004)                                     
	    		//3 REDEFINE #PR-HORA                                                 
	      			//4 #PR-HH               (N002)                                     
	      			//4 #PR-MM              (N002)                                     
	    	.append(" ") //	3 #PR-SIGI               		(A001)                                     
	    	.append(String.format("%25s", "")) //	3 #PR-PROTOCOLO-ANT      	(A025)                                     
	    		//3 REDEFINE #PR-PROTOCOLO-ANT                                        
	      			//4 #PR-NUM-ANT   		(N009)                                     
	      			//4 #PR-ANO-ANT    	(N004)                                     
	      			//4 #PR-ORG-ANT          	(A012)                                     
	    	.append(String.format("%08d", 0)) //	3 #PR-ANEXO              		(N008)                                     
	    	.append(" ") //	3 #PR-DV-ANEXO           		(A001)
	    	.append(String.format("%02d", 0)) //	3 #PR-ESPECIE            		(N002)                                     
	     	.append(String.format("%12s", "")) //	3 #PR-ORIGEM             		(A012)                                     
	     	.append(String.format("%09d", 0)) //	3 #PR-NUM-DOCTO          	(N009)                                     
	     	.append(String.format("%04d", 0)) //	3 #PR-ANO-DOCTO          	(N004)                                     
	     	.append(String.format("%30s", "")) //	3 #PR-CIDADE             		(A030)                                     
	     	.append("PR") //	3 #PR-ESTADO             		(A002)                                     
	     	.append(String.format("%5s", "")) //	3 #PR-ASSUNTO            		(A005)                                     
	     		//3 REDEFINE #PR-ASSUNTO                                              
	       		//	4 #PR-ASSUNTO-1        	(A001)                                     
	     	.append(String.format("%20s", "")) //	3 #PR-PALAVRA1           		(A020)                                     
	     	.append(String.format("%20s", "")) //	3 #PR-PALAVRA2           		(A020)
	     	.append(String.format("%08d", 0)) //	3 #PR-DT-ENVIO           		(N008)                                     
	     	.append(String.format("%12s", "")) //	3 #PR-LOC-DE             		(A012)                                     
	     	.append(String.format("%12s", "")) //	3 #PR-LOC-PARA           		(A012)                                     
	     	.append(String.format("%02d", 0)) //	3 #PR-MOTIVO             		(N002)                                     
	     	.append(" ") //	3 #PR-TEM-CONCLUSAO     	(A001)         
	     	;
			
			//.append(String.format("%140s", ""))
			//.append(String.format("%69s", ""))
			//.append(String.format("%750s", ""));
		
		Natural natural = new Natural("AAXCG810", pEntrada.toString() );
		
		log.debug( "natural.getRC(): " + natural.getRC() );
		
		if (natural.getRC() == 0) {
			String ret = natural.getDataParameter();
			log.debug( "*ini***************************************************" );
			log.debug( ret );
			log.debug( "*fim***************************************************" );
			
						
			int idx = 10;
			obj = new ProtocoloAAX();
			obj.setNumeroProtocolo( Util.formatarProtocolo( ret.substring(idx, idx+=9) ) );
			obj.setOrgaoCadastro( ret.substring(idx, idx+=12) );
			obj.setDataCadastro( Util.formatarData( ret.substring(idx, idx+=8) ) );
			obj.setHoraHHCadastro( ret.substring(idx, idx+=2) );
			obj.setHoraMMCadastro( ret.substring(idx, idx+=2) );
			obj.setProtocoloSigiloso( ret.substring(idx, idx+=1) );
			obj.setProtocoloAnteriorNumero( ret.substring(idx, idx+=9) );
			obj.setProtocoloAnteriorAno( ret.substring(idx, idx+=4) );
			obj.setProtocoloAnteriorOrgao( ret.substring(idx, idx+=12) );
			obj.setAnexo( ret.substring(idx, idx+=8).trim() );				
			obj.setDvAnexo( ret.substring(idx, idx+=1).trim() );
			if(!"".equals( obj.getAnexo() ) && !"00000000".equals( obj.getAnexo() ) ){
				log.debug(new StringBuilder("Formatar protocolo anexo.").append( obj.getDvAnexo() ));
				obj.setAnexo( Util.formatarProtocolo( new StringBuilder( obj.getAnexo() ).append(obj.getDvAnexo()).toString() ) );
			}else{
				obj.setAnexo("");
			}
			obj.setEspecie( ret.substring(idx, idx+=2) );
			obj.setOrigem( ret.substring(idx, idx+=12) );
			obj.setNumeroDocumento( ret.substring(idx, idx+=9) );
			obj.setAnoDocumento( ret.substring(idx, idx+=4) );
			obj.setCidade( ret.substring(idx, idx+=30) );
			obj.setEstado( ret.substring(idx, idx+=2) );
			obj.setAssunto( ret.substring(idx, idx+=5) );
			obj.setPalavra1( ret.substring(idx, idx+=20) );
			obj.setPalavra2( ret.substring(idx, idx+=20) );
			obj.setDataEnvio( Util.formatarData( ret.substring(idx, idx+=8) ) );
			obj.setLocalDe( ret.substring(idx, idx+=12) );
			obj.setLocalPara( ret.substring(idx, idx+=12) );
			obj.setMotivo( ret.substring(idx, idx+=2) );
			obj.setTemConclusao( ret.substring(idx, idx+=1).trim() );
							
			obj.setInteressadoTipo1( ret.substring(idx, idx+=12) );
			obj.setInteressadoNome1( ret.substring(idx, idx+=40).trim() );
			obj.setInteressadoRG1( ret.substring(idx, idx+=15).trim() );
			obj.setInteressadoRG1( "000000000000000".equals( obj.getInteressadoRG1() ) ? "" : obj.getInteressadoRG1() );
			obj.setInteressadoQtd1( ret.substring(idx, idx+=3) ); 
			
			obj.setInteressadoTipo2( ret.substring(idx, idx+=12) );
			obj.setInteressadoNome2( ret.substring(idx, idx+=40).trim() );
			obj.setInteressadoRG2( ret.substring(idx, idx+=15).trim() );
			obj.setInteressadoRG2( "000000000000000".equals( obj.getInteressadoRG2() ) ? "" : obj.getInteressadoRG2() );
			obj.setInteressadoQtd2( ret.substring(idx, idx+=3) );
			
			obj.setAnexoQuantidade( Integer.valueOf( ret.substring(idx, idx+=3) ) );
			obj.setAnexoProx( ret.substring(idx, idx+=3) );
			
			Collection<String> protAnexados = new ArrayList<String>();
			String protAnexado = ret.substring(idx, idx+=63);
			for (int i = 1; i <= 7; i++) {
				String item = protAnexado.substring( (i-1)*9 , i*9 );
				if( !"".equals( item.trim() ) ){
					protAnexados.add( Util.formatarProtocolo( item ) );
				}
			}
			obj.setProtocoloAnexado( protAnexados );				

			Collection<String> detalhamentos = new ArrayList<String>();
			String detalhamento = ret.substring(idx, idx+=750);
			for (int i = 1; i <= 15; i++) {
				String item = detalhamento.substring( (i-1)*50 , i*50 );
				if( !"".equals( item.trim() ) ){
					detalhamentos.add( item );
				}
			}
			obj.setDetalhamento( detalhamentos );
			
							
			obj.setPos( ret.substring(idx, idx+=2) );
			obj.setIsn( ret.substring(idx, idx+=10).trim() );
			obj.setCadastroAssunto( ret.substring(idx, idx+=50).trim() );
			obj.setCadastroLocalPara( ret.substring(idx, idx+=30).trim() );
			obj.setCadastroMotivo( ret.substring(idx, idx+=30).trim() );
			obj.setCadastroFunc( ret.substring(idx, idx+=40).trim() );
			obj.setCadastroDDDLocal( ret.substring(idx, idx+=4).trim() );
			obj.setCadastroTelefoneLocal( ret.substring(idx, idx+=8).trim() );
			obj.setCadastroRamalLocal( ret.substring(idx, idx+=4).trim() );
			obj.setCadastroEspecie( ret.substring(idx, idx+=20).trim() );
			obj.setCadastroFiller( ret.substring(idx, idx+=10) );
			
			Collection<String> conclusoes = new ArrayList<String>();
			String conclusao = ret.substring(idx, idx+=2400);
			for (int i = 1; i <= 48; i++) {
				String item = conclusao.substring( (i-1)*50 , i*50 );
				if( !"".equals( item.trim() ) ){
					conclusoes.add( item );
				}
			}
			obj.setConclusao( conclusoes );
			
			obj.setDataArquivo( ret.substring(idx, idx+=8) );
			obj.setIndLocal( ret.substring(idx, idx+=1) );
			obj.setSitProc( ret.substring(idx, idx+=1) );
			obj.setSitProcString( "B".equals( obj.getSitProc() )? "Conclu�do" : ( "D".equals( obj.getSitProc() )? "Deferido" : ( "I".equals( obj.getSitProc() ) ? "Indeferido" : "" ) ) );
			
			obj.setProHoraAtu( ret.substring(idx, idx+=4) );
			obj.setIndicativoArq( ret.substring(idx, idx+=1) );
			
			obj.setProDataAtualizacao( ret.substring(idx, idx+=8) );
			obj.setIndHis( ret.substring(idx, idx+=1) );
			obj.setNmLocDe( ret.substring(idx, idx+=30) );
			obj.setNmOrgCad( ret.substring(idx, idx+=30) );
			obj.setNmOrigem( ret.substring(idx, idx+=30) );
//				obj.setFiller1( ret.substring(idx, idx+=142) );
//'				obj.setFiller2( ret.substring(idx, idx+=30) );
		} else {
			/*throw new ApplicationException("AVISO.101", new String[]{ natural.getMSG() }, ApplicationException.ICON_AVISO);*/
		}
		
		return obj;	
	}



	public List<TramitacaoProtocoloDTO> listarTramitacao(ProtocoloDTO protocoloDTO) {
		log.info("*** Procedimento listar hist�rico... ***");
		
		List<TramitacaoProtocoloDTO> listaProtocolos = new ArrayList<TramitacaoProtocoloDTO>();
		TramitacaoProtocoloDTO tramitacaoProtocoloDTO = new TramitacaoProtocoloDTO();
				
		log.info("*** Formatando par�metros de entrada ***");
		
		String protocolo = protocoloDTO.getNumeroProtocolo();
		
		StringBuilder pEntrada = new StringBuilder();
		pEntrada                                       
	    	.append( String.format("%9s", protocolo) )                                     
	    	.append( "999" );
			
		Natural natural = new Natural("AAXAG800", pEntrada.toString() );
		
		log.debug( "natural.getRC(): " + natural.getRC() );
		
		if (natural.getRC() == 0) {
			String ret = natural.getDataParameter();
			log.debug( "*ini***************************************************" );
			log.debug( ret );
			log.debug( "*fim***************************************************" );
			
			int idx = 15;
			
			//obj.setQtdeRegistro( Integer.valueOf( ret.substring(idx, idx+=3) ) );
			
			for (int i = 1; i <= 100; i++) {
				TramitacaoProtocoloDTO hist = new TramitacaoProtocoloDTO();
				
				hist.setParecer( ret.substring(idx, idx+=1).trim() );
				hist.setSequencia( ret.substring(idx, idx+=3) );
				hist.setData( ret.substring(idx, idx+=10) );
				hist.setLocalDe( ret.substring(idx, idx+=12) );
				hist.setLocalPara( ret.substring(idx, idx+=12) );
				hist.setTramitacao( ret.substring(idx, idx+=30) );
				
				hist.setId( new StringBuilder( protocolo ).append( hist.getSequencia() ).toString() );
				hist.setParecer( !"".equals( hist.getParecer() ) ? new StringBuilder( "<a href=\"javascript:parecer('" ).append( hist.getId() ).append( "','" ).append( hist.getLocalDe() ).append( "','" ).append(  hist.getData() ).append("');\" style=\"text-decoration: underline;\" ><b>Sim</b></a>").toString() : "Não" );
				
				if( !"".equals( hist.getSequencia().trim() )  ){
					listaProtocolos.add( hist );
				}
				
			}
			
		} else {
			//throw new ApplicationException("ERRO.PADRAO", new String[]{ natural.getMSG() }, ApplicationException.ICON_ERRO);
		}
		return listaProtocolos;	
	}


    
	public ParecerTramitacaoDTO listarParecer(String parecerId){
		log.info("*** Procedimento listar parecer... ***");
		
		
		ParecerTramitacaoDTO parecerTramitacaoDTO;
		
		Collection<String> parecer = new ArrayList<String>();
		
		log.info("*** Formatando par�metros de entrada ***");
					
		StringBuilder pEntrada = new StringBuilder();
		
		pEntrada                                      
			.append( Dominios.USUARIO_MAINFRAME )
	    	.append( String.format("%12s", parecerId) );
			
		Natural natural = new Natural("AAXAG801", pEntrada.toString() );
		
		log.debug( "natural.getRC(): " + natural.getRC() );
		
		if (natural.getRC() == 0) {
			String ret = natural.getDataParameter();
			log.debug( "*ini***************************************************" );
			log.debug( ret );
			log.debug( "*fim***************************************************" );
			
			int idx = 18;
			for (int i = 1 ; i <= 48; i++) {					
				String reg = ret.substring(idx, idx+=50);
				if( !"".equals( reg.trim() ) ){
					parecer.add( reg );
				}
			}
			
			parecerTramitacaoDTO = new ParecerTramitacaoDTO();
			parecerTramitacaoDTO.setPareceres(parecer);				
			
			parecerTramitacaoDTO.setLocalDe(ret.substring(idx, idx+=12).trim());
			parecerTramitacaoDTO.setLocalPara(ret.substring(idx, idx+=12).trim());				
			parecerTramitacaoDTO.setDataEnvio(ret.substring(idx, idx+=10).trim());
			parecerTramitacaoDTO.setHistoricoTramitacao(ret.substring(idx, idx+=30).trim());				

			
		} else {
			//throw new ApplicationException("AVISO.101", new String[]{ natural.getMSG() }, ApplicationException.ICON_AVISO);
			//MSG de Erro
			parecerTramitacaoDTO = null;
		}
		
		return parecerTramitacaoDTO;
	}

	
}