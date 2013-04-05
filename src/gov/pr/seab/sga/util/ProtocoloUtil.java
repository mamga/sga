package gov.pr.seab.sga.util;


public class ProtocoloUtil {
	
	
	public enum Assunto {

		PCTO("PCTO", "CONTRATO/CONVENIO"),
		PACF("PACF", "AREA CONTABIL FISCAL"),                                                      
		PAF("PAF", "PECUARIA"),
		PAGRO("PAGRO",	"AGRICULTURA,  PECUARIA E ABASTECIMENTO"),
		PAJ("PAJ", "AREA JURIDICA"),                                                             
		PATO("PATO", "ATOS"),                                                                      
		PCNG("PCNG", "CONGRESSOS/CURSOS/JOGOS/EVENTOS"),                                           
		PCOMU("PCOMU", "COMUNICADO/DOCUMENTACAO"),                                                   
		PCONS("PCONS", "CONSTRUCAO/OBRAS"),                                                          
		PDIA("PDIA", "DIVIDA ATIVA"),                                                              
		PESCO("PESCO", "AREA DE ENSINO"),                                                            
		PETUR("PETUR", "ESPORTE/TURISMO/CULTURA"),                                                   
		PFIR("PFIR", "FIRMAS/ENTIDADES"),                                                          
		PIMO("PIMO", "IMOVEIS"),                                                                   
		PIMP("PIMP", "IMPOSTOS/TAXAS"),                                                            
		PLEG("PLEG", "LEGISLATIVO"),                                                               
		PLIC("PLIC", "LICITACAO"),                                                                 
		PMAB("PMAB", "MEIO AMBIENTE"),                                                             
		PMAN("PMAN", "TESTE -ATUALIZA ARQUIVADO"),                                                 
		PMATE("PMATE", "MATERIAL DE CONSUMO E  BENS E EQUIPAMENTOS"),                                  
		PMLEG("PMLEG", "MEDICINA LEGAL"),                                                            
		PMUL("PMUL", "MULTA"),                                                                     
		PPASB("PPASB", "PEDIDO DE AUXILIO E/OU SUBVENCAO"),                                          
		PPLS("PPLS", "TESTE ATUALIZA ARQUIVADO"),                                                  
		PPPR("PPPR", "PROJETOS/PROGRAMAS"),                                                        
		PPREG("PPREG", "TESTE"),                                                                     
		PPROC("PPROC", "PROCESSO ADMINISTRATIVO DISCIPLINAR"),                                       
		PPUBL("PPUBL", "PUBLICACAO"),                                                                
		PRET("PRET", "RECLAMACAO/SUGESTAO"),                                                       
		PRH("PRH", "RECURSOS HUMANOS"),                                                          
		PSAUD("PSAUD", "AREA DE SAUDE"),                                                             
		PSEG("PSEG", "SEGURO"),                                                                    
		PSEGU("PSEGU", "AREA DA SEGURANCA"),                                                         
		PSERV("PSERV", "SERVICOS DE BENS MOVEIS E COMPLEMENTARES"),                                  
		PTERM("PTERM", "TERMOS"),                                                                    
		PTRA("PTRA", "TRANSITO"),                                                                  
		PTRAN("PTRAN", "TRANSPORTES"),                                                               
		PVEI("PVEI", "VEICULOS");

		
		private final String codigo;
		private final String descricao;

		private Assunto(String codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public boolean is(String codigo) {
			return this.codigo.equals(codigo);
		}
	    	    
		public static Assunto getAssunto(String codigo){	    	
	       	for (Assunto assunto : Assunto.values()){
	       		if(assunto.codigo.equals(codigo)){
	       			return assunto;
	       		}
	    	}
	       	return null;
	    }
		
		public String getCodigo(){
			return codigo;
		}
		
	    public static String getDescricao(String codigo){	    	
	       	for (Assunto assunto : Assunto.values()){
	       		if(assunto.codigo.equals(codigo.trim())){
	       			return assunto.descricao;
	       		}
	    	}
	       	return null;
	    }
	}
	
	
}
