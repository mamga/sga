package gov.pr.seab.sga.facade;

import gov.pr.seab.sga.dao.factory.DAOFactory;
import gov.pr.seab.sga.dto.ComboPesquisaDTO;
import gov.pr.seab.sga.dto.ParecerTramitacaoDTO;
import gov.pr.seab.sga.dto.ProtocoloDTO;
import gov.pr.seab.sga.dto.TramitacaoProtocoloDTO;
import gov.pr.seab.sga.bean.Protocolo;
import gov.pr.seab.sga.util.TxtFile;
import gov.pr.seab.sga.util.Dominios.Tabela;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

public class ProtocoloFacade {
	
	private static DAOFactory mainFrameFactory = DAOFactory.getDAOFactory(DAOFactory.MAINFRAME);
	
	private static Logger log = Logger.getLogger(ProtocoloFacade.class);
	
	private static Collection<ComboPesquisaDTO> txtAssunto = null;
	private static Collection<ComboPesquisaDTO> txtEspecie = null;
	private static Collection<ComboPesquisaDTO> txtLocal = null;
	private static Collection<ComboPesquisaDTO> txtMunicipio = null;
	private static Collection<ComboPesquisaDTO> txtOrgao = null;
	private static Collection<ComboPesquisaDTO> txtPalavraChave = null;
	private static Collection<ComboPesquisaDTO> txtTipoInteressado = null;
	private static Collection<ComboPesquisaDTO> txtSetor = null;

	
	
	public static Collection<Protocolo> listarProtocolo(ProtocoloDTO protocoloDTO) throws Exception {
		return mainFrameFactory.getProtocoloDAO().listar(protocoloDTO);
	}
	
	public static Protocolo obterProtocolo(ProtocoloDTO protocoloDTO) throws Exception{
		return mainFrameFactory.getProtocoloDAO().obter(protocoloDTO);
	}
	
	public static List<TramitacaoProtocoloDTO> listarTramitacaoProtocolo(ProtocoloDTO protocoloDTO) throws Exception {
		return mainFrameFactory.getProtocoloDAO().listarTramitacao(protocoloDTO);
	}
	
	public static ParecerTramitacaoDTO listarParecer(String parecerId) {
		return mainFrameFactory.getProtocoloDAO().listarParecer(parecerId);
	}			
	
	
	
	
	
	
	
	
	public static Collection<ComboPesquisaDTO> obterComboPesquisa( Tabela arquivo ) {
		return obterComboPesquisa( arquivo, null);	
	}
	
	public static Collection<ComboPesquisaDTO> obterComboPesquisa( Tabela arquivo, String filtro ){
		log.info("Obter tabela: "+ arquivo.getArquivo() +" com o filtro: "+ ( filtro!=null?filtro:"" ) );
		Collection<ComboPesquisaDTO> combo = null;
		switch (arquivo) {
			case TB_ASSUNTO:
				combo = txtAssunto;
				break;
			case TB_ESPECIE:
				combo = txtEspecie;
				break;
			case TB_TIPO_INTERESSADO:
				combo = txtTipoInteressado;
				break;
			case TB_LOCAL:
				combo = txtLocal;
				break;
			case TB_MUNICIPIO:
				combo = txtMunicipio;
				break;
			case TB_ORGAO:
				combo = txtOrgao;
				break;
			case TB_PALAVRA_CHAVE:
				combo = txtPalavraChave;
				break;
			case TB_SETOR:
				combo = txtSetor;
				break;
		}		
		if( combo==null ){
			log.info("Abrir arquivo!!!! tabela: "+ arquivo.getArquivo() );
			combo = new ArrayList<ComboPesquisaDTO>();
			try {
				File pathTabelas = caminhoDiretorioTabelas();
				File file = new File(pathTabelas.getPath() + "/" + arquivo.getArquivo());
				if(file.exists() && file.isFile()){
					String conteudo = new TxtFile( file.getPath() ).getConteudo();
					if(conteudo!=null){
						String[] linhas  = conteudo.split("\n");
						for (String linha : linhas) {
							String[] colunas = linha.split("\t");
							ComboPesquisaDTO item = new ComboPesquisaDTO();
							item.setValor( colunas[0].trim() );
							item.setTexto( colunas[ colunas.length>1 ? 1 : 0 ].trim() );							
							combo.add( item );
						}
						Collections.sort( (List<ComboPesquisaDTO>) combo );
					}
				}
			} catch (Exception e) {
				log.error("Erro ao obter tabela txt.", e);
			}
			switch (arquivo) {
				case TB_ASSUNTO:
					txtAssunto = combo;
					break;
				case TB_ESPECIE:
					txtEspecie = combo;
					break;
				case TB_TIPO_INTERESSADO:
					txtTipoInteressado = combo;
					break;
				case TB_LOCAL:
					txtLocal = combo;
					break;
				case TB_MUNICIPIO:
					txtMunicipio = combo;
					break;
				case TB_ORGAO:
					txtOrgao = combo;
					break;
				case TB_PALAVRA_CHAVE:
					txtPalavraChave = combo;
					break;
				case TB_SETOR:
					txtSetor = combo;
					break;
			}	
		}
		if (filtro!=null){
			//log.debug(">"+item.getValor()+"<--"+ ">" + filtro +"< - "+ item.getValor().equals( filtro ) );
			//if( filtro==null || item.getValor().equals( filtro ) ) {
			Collection<ComboPesquisaDTO> listaFiltrada = new ArrayList<ComboPesquisaDTO>();
			for (ComboPesquisaDTO item : combo) {
				if( filtro.equals(  item.getValor() ) ) {
					ComboPesquisaDTO itemNovo = new ComboPesquisaDTO();
					itemNovo.setValor( item.getValor() );
					itemNovo.setTexto( item.getTexto() );					
					if( Tabela.TB_PALAVRA_CHAVE.equals( arquivo ) ){
						itemNovo.setValor( itemNovo.getTexto() );
					}
					listaFiltrada.add( itemNovo );
				}
			}
			return listaFiltrada;
		}
		return combo;
	}
	
	
	public static Collection<ComboPesquisaDTO> obterComboAssunto( boolean logado ) {
		if(logado){
			return obterComboPesquisa( Tabela.TB_ASSUNTO );
		}else{
			//somente dados do detran
			Collection<ComboPesquisaDTO> combo = new ArrayList<ComboPesquisaDTO>();
			combo.add( new ComboPesquisaDTO("PTRA" , "TRANSITO" ) );
			combo.add( new ComboPesquisaDTO("PVEI" , "VEICULOS" ) );
			return combo;
		}

	}	
	
	public static Collection<ComboPesquisaDTO> obterComboPalavraChave( String assunto ) {
		return obterComboPesquisa( Tabela.TB_PALAVRA_CHAVE, assunto );
	}
	
	public static File caminhoDiretorioTabelas() {
		String pathTemp = new ProtocoloFacade().getClass().getResource("/").getPath();
		return new File( pathTemp.substring(0, pathTemp.indexOf("WEB-INF") ) + "tabelas/" );
	}	
	
	
}