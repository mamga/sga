package gov.pr.seab.sga.util;

public class Dominios {
	
	/** Quantidade de objetos por p�gina **/
	public final static int QTD_PAGINA = 20;
	
	public final static String USUARIO_MAINFRAME = "000249"; //manter 6 posi��es!!

	
	public enum Tabela {
		TB_ASSUNTO( "tb_assunto.txt" ),
		TB_ESPECIE( "tb_especie.txt" ),
		TB_TIPO_INTERESSADO( "tb_tipo_interessado.txt" ),
		TB_LOCAL( "tb_local.txt" ),
		TB_MUNICIPIO( "tb_municipio.txt" ),
		TB_ORGAO( "tb_orgao.txt" ),
		TB_PALAVRA_CHAVE( "tb_palavra_chave.txt" ),
		TB_SETOR( "tb_setor.txt" );
		
		private String txt;
		public String getArquivo(){ return this.txt; };
		Tabela(String txt){ this.txt = txt; };
		
	}
	
}

