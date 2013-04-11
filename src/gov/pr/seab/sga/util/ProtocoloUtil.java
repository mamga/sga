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
	
	
	public enum SetorSeab {
		
		AJUR("SEAB/AJUR", "ASSESSORIA JURIDICA"),                                
		CL("SEAB/CL", "COMISSAO DE LICITACAO"),                              
		DEAGRO("SEAB/DEAGRO", "DEPTO. DESENVOLVIMENTO AGRARIO"),                                
		DERAL("SEAB/DERAL", "DEPARTAMENTO DE ECONOMIA RURAL"),                              
		DG("SEAB/DG", "DIRECAO GERAL"),                                
		GAS("SEAB/GAS", "GRUPO ADMINISTRATIVO SETORIAL"),                                
		GFS("SEAB/GFS", "GRUPO FINANCEIRO SETORIAL"),                            
		GPS("SEAB/GPS", "GRUPO PLANEJAMENTO SETORIAL"),                                
		GRHS("SEAB/GRHS", "GRUPO DE REC. HUMANOS SETORIAL"),                                
		GS("SEAB/GS", "GABINETE DO SECRETARIO"),                                
		NII("SEAB/NII", "NUCLEO INFORMATICA INFORMACOES"),                                
		PTG("SEAB/PTG", "PROTOCOLO GERAL");
		
		private String codigo;
		private String descricao;

		private SetorSeab(String codigo, String descricao) {
		    this.setCodigo(codigo);
		    this.setDescricao(descricao);
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
		
		
		
		
		/*private final String codigo;
		private final String descricao;

		private SetorSeab(String codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}

		public boolean is(String codigo) {
			return this.codigo.equals(codigo);
		}
	    	    
		public static SetorSeab getSetorSeab(String codigo){	    	
	       	for (SetorSeab setorSeab : SetorSeab.values()){
	       		if(setorSeab.codigo.equals(codigo)){
	       			return setorSeab;
	       		}
	    	}
	       	return null;
	    }
		
		public String getCodigo(){
			return codigo;
		}
		
	    public static String getDescricao(String codigo){	    	
	       	for (SetorSeab setorSeab : SetorSeab.values()){
	       		if(setorSeab.codigo.equals(codigo.trim())){
	       			return setorSeab.descricao;
	       		}
	    	}
	       	return null;
	    }*/
		
	}
	
	public enum Municipio {
		
		ABATIA("ABATIA"),                        
		ADRIANOPOLIS("ADRIANOPOLIS"),
		AGUDOS_DO_SUL("AGUDOS DO SUL"),
		ALMIRANTE_TAMANDARE("ALMIRANTE TAMANDARE"),           
		ALTAMIRA_DO_PARANA("ALTAMIRA DO PARANA"),            
		ALTO_PARAISO("ALTO PARAISO"),                  
		ALTO_PARANA("ALTO PARANA"),                   
		ALTO_PIQUIRI("ALTO PIQUIRI"),                  
		ALTONIA("ALTONIA"),                       
		ALVORADA_DO_SUL("ALVORADA DO SUL"),               
		AMAPORA("AMAPORA"),                       
		AMPERE("AMPERE"),                       
		ANAHY("ANAHY"),                        
		ANDIRA("ANDIRA"),                       
		ANGULO("ANGULO"),                       
		ANTONINA("ANTONINA"),                     
		ANTONIO_OLINTO("ANTONIO OLINTO"),                
		APUCARANA("APUCARANA"),                     
		ARAPONGAS("ARAPONGAS"),                     
		ARAPORI("ARAPOTI"),                       
		ARAPUA("ARAPUA"),                        
		ARARUNA("ARARUNA"),                       
		ARAUCARIA("ARAUCARIA"),                     
		ARIRANHA_DO_IVAI("ARIRANHA DO IVAI"),              
		ASSAI("ASSAI"),                         
		ASSIS_CHATEAUBRIAND("ASSIS CHATEAUBRIAND"),           
		ASTORGA("ASTORGA"),                       
		ATALAIA("ATALAIA"),                       
		BALSA_NOVA("BALSA NOVA"),                    
		BANDEIRANTES("BANDEIRANTES"),                  
		BARBOSA_FERRAZ("BARBOSA FERRAZ"),                
		BARRA_DO_JACARE("BARRA DO JACARE"),        
		BARRACAO("BARRACAO"),                      
		BELA_VISTA_DA_CAROBA("BELA VISTA DA CAROBA"),          
		BELA_VISTA_DO_PARAISO("BELA VISTA DO PARAISO"),
		BITURUNA("BITURUNA"),                      
		BOA_ESPERANCA("BOA ESPERANCA"),                 
		BOA_ESPERANCA_DO_IGUACU("BOA ESPERANCA DO IGUACU"),       
		BOA_AVENTURA_DE_SAO_ROQUE("BOA VENTURA DE SAO ROQUE"),      
		BOA_VISTA_DA_APARECIDA("BOA VISTA DA APARECIDA"),        
		BOCAIUVA_DO_SUL("BOCAIUVA DO SUL"),               
		BOM_JESUS_DO_SUL("BOM JESUS DO SUL"),              
		BOM_SUCESSO("BOM SUCESSO"),                   
		BOM_SUCESSO_DO_SUL("BOM SUCESSO DO SUL"),            
		BORRAZOPOLIS("BORRAZOPOLIS"),                  
		BRAGANEY("BRAGANEY"),                      
		BRASILANDIA_DO_SUL("BRASILANDIA DO SUL"),            
		CAFEARA("CAFEARA"),                       
		CAFELANDIA("CAFELANDIA"),                    
		CAFEZAL_DO_SUL("CAFEZAL DO SUL"),                
		CALIFORNIA("CALIFORNIA"),                    
		CAMBARA("CAMBARA"),                       
		CAMBE("CAMBE"),                         
		CAMBIRA("CAMBIRA"),                       
		CAMPINA_DA_LAGOA("CAMPINA DA LAGOA"),              
		CAMPINA_DO_SIMAO("CAMPINA DO SIMAO"),              
		CAMPINA_GRANDE_DO_SUL("CAMPINA GRANDE DO SUL"),         
		CAMPO_BONITO("CAMPO BONITO"),                  
		CAMPO_DO_TENENTE("CAMPO DO TENENTE"),              
		CAMPO_LARGO("CAMPO LARGO"),                   
		CAMPO_MAGRO("CAMPO MAGRO"),                  
		CAMPO_MOURAO("CAMPO MOURAO"),                  
		CANDIDO_DE_ABREU("CANDIDO DE ABREU"),              
		CANDOI("CANDOI"),                        
		CANTAGALO("CANTAGALO"),                     
		CAPANEMA("CAPANEMA"),                      
		CAPITAO_LEONIDAS_MARQUES("CAPITAO LEONIDAS MARQUES"),      
		CARAMBEI("CARAMBEI"),                      
		CARLOPOLIS("CARLOPOLIS"),                    
		CASCAVEL("CASCAVEL"),                      
		CASTRO("CASTRO"),                        
		CATANDUVAS("CATANDUVAS"),                    
		CENTENARIO_DO_SUL("CENTENARIO DO SUL"),             
		CERRO_AZUL("CERRO AZUL"),                    
		CEU_AZUL("CEU AZUL"),                      
		CHOPINZINHO("CHOPINZINHO"),                   
		CIANORTE("CIANORTE"),                      
		CIDADE_GAUCHA("CIDADE GAUCHA"),                 
		CLEVELANDIA("CLEVELANDIA"),                   
		COLOMBO("COLOMBO"),                  
		COLORADO("COLORADO"),                      
		CONGONHINHAS("CONGONHINHAS"),                  
		CONSELHEIRO_MAIRINCK("CONSELHEIRO MAIRINCK"),          
		CONTENDA("CONTENDA"),                      
		CORBELIA("CORBELIA"),                      
		CORNELIO_PROCOPIO("CORNELIO PROCOPIO"),             
		CORONEL_DOMINGOS_SOARES("CORONEL DOMINGOS SOARES"),       
		CORONEL_VIVIDA("CORONEL VIVIDA"),                
		CORUMBATAI_DO_SUL("CORUMBATAI DO SUL"),             
		CRUZ_MACHADO("CRUZ MACHADO"),                  
		CRUZEIRO_DO_IGUACU("CRUZEIRO DO IGUACU"),            
		CRUZEIRO_DO_OESTE("CRUZEIRO DO OESTE"),             
		CRUZEIRO_DO_SUL("CRUZEIRO DO SUL"),               
		CRUZMALTINA("CRUZMALTINA"),                   
		CURITIBA("CURITIBA"),                      
		CURIUVA("CURIUVA"),                       
		DIAMANTE_DO_NORTE("DIAMANTE DO NORTE"),             
		DIAMANTE_DO_OESTE("DIAMANTE DO OESTE"),            
		DIAMENTE_DO_SUL("DIAMANTE DO SUL"),               
		DOIS_VIZINHOS("DOIS VIZINHOS"),                 
		DOURADINA("DOURADINA"),                     
		DOUTOR_CAMARDO("DOUTOR CAMARGO"),                
		DOUTOR_ULYSSES("DOUTOR ULYSSES"),                
		ENEAS_MARQUES("ENEAS MARQUES"),                 
		ENGENHEIRO_BELTRAO("ENGENHEIRO BELTRAO"),            
		ENTRE_RIOS_DO_OESTE("ENTRE RIOS DO OESTE"),
		ESPERENCA_NOVA("ESPERANCA NOVA"),                
		ESPIGAO_ALTO_DO_IGUACU("ESPIGAO ALTO DO IGUACU"),        
		FAROL("FAROL"),                         
		FAXINAL("FAXINAL"),                       
		FAZENDA_RIO_GRANDE("FAZENDA RIO GRANDE"),            
		FENIX("FENIX"),                         
		FERNANDES_PINHEIRO("FERNANDES PINHEIRO"),            
		FIGUEIRA("FIGUEIRA"),                      
		FLOR_DA_SERRA_DO_SUL("FLOR DA SERRA DO SUL"),          
		FLORAI("FLORAI"),                        
		FLORESTA("FLORESTA"),                      
		FLORESTOPOLIS("FLORESTOPOLIS"),                 
		FLORIDA("FLORIDA"),                       
		FORMOSA_DO_OESTE("FORMOSA DO OESTE"),              
		FOZ_DO_IGUACU("FOZ DO IGUACU"),                 
		FOZ_DO_JORDAO("FOZ DO JORDAO"),                 
		FRANCISCO_ALVES("FRANCISCO ALVES"),               
		FRANCISCO_BELTRAO("FRANCISCO BELTRAO"),             
		GENERAL_CARNEIRO("GENERAL CARNEIRO"),              
		GODOY_MOREIRA("GODOY MOREIRA"),                 
		GOIOERE("GOIOERE"),                       
		GOIOXIM("GOIOXIM"),                       
		GRANDES_RIOS("GRANDES RIOS"),                  
		GUAIRA("GUAIRA"),                 
		GUAIRACA("GUAIRACA"),                      
		GUAMIRANGA("GUAMIRANGA"),                    
		GUAPIRAMA("GUAPIRAMA"),                     
		GUAPOREMA("GUAPOREMA"),                     
		GUARACI("GUARACI"),                       
		GUARANIACU("GUARANIACU"),                    
		GUARAPUAVA("GUARAPUAVA"),                    
		GUARAQUECABA("GUARAQUECABA"),                  
		GUARATUBA("GUARATUBA"),                     
		HONORIO_SERPA("HONORIO SERPA"),                 
		IBAITI("IBAITI"),                        
		IBEMA("IBEMA"),                         
		IBIPORA("IBIPORA"),                       
		ICARAIMA("ICARAIMA"),
		IGUARACU("IGUARACU"),                      
		IGUATU("IGUATU"),                        
		IMBAU("IMBAU"),                         
		IMBITUVA("IMBITUVA"),                      
		INACIO_MARTINS("INACIO MARTINS"),                
		INAJA("INAJA"),                         
		INDIANOPOLIS("INDIANOPOLIS"),                  
		IPIRANGA("IPIRANGA"),                      
		IPORA("IPORA"),                         
		IRACEMA_DO_OESTE("IRACEMA DO OESTE"),              
		IRATI("IRATI"),                         
		IRETAMA("IRETAMA"),                       
		ITAGUAJE("ITAGUAJE"),
		ITAIPULANDIA("ITAIPULANDIA"),
		ITAMBARACA("ITAMBARACA"),                    
		ITAMBE("ITAMBE"),                        
		ITAPEJARA_DO_OESTE("ITAPEJARA DO OESTE"),            
		ITAPERUCU("ITAPERUCU"),                     
		ITAUNA_DO_SUL("ITAUNA DO SUL"),                 
		IVAI("IVAI"),                          
		IVAIPORA("IVAIPORA"),                      
		IVATE("IVATE"),                         
		IVATUBA("IVATUBA"),                       
		JABOTI("JABOTI"),                        
		JACAREZINHO("JACAREZINHO"),                   
		JAGUAPITA("JAGUAPITA"),                     
		JAGUARIAIVA("JAGUARIAIVA"),                   
		JANDAIA_DO_SUL("JANDAIA DO SUL"),                
		JANIOPOLIS("JANIOPOLIS"),                    
		JAPIRA("JAPIRA"),                        
		JAPURA("JAPURA"),                        
		JARDIM_ALEGRE("JARDIM ALEGRE"),                 
		JARDIM_OLINDA("JARDIM OLINDA"),                 
		JATAIZINHO("JATAIZINHO"),                    
		JESUITAS("JESUITAS"),                      
		JOAQUIM_TAVORA("JOAQUIM TAVORA"),                
		JUNDIAI_DO_SUL("JUNDIAI DO SUL"),                
		JURANDA("JURANDA"),                       
		JUSSARA("JUSSARA"),                       
		KALORE("KALORE"),                       
		LAPA("LAPA"),                          
		LARANJAL("LARANJAL"),                      
		LARANJEIRAS_DO_SUL("LARANJEIRAS DO SUL"),            
		LEOPOLIS("LEOPOLIS"),                      
		LIDIANOPOLIS("LIDIANOPOLIS"),                  
		LINDOESTE("LINDOESTE"),                     
		LOANDA("LOANDA"),                        
		LOBATO("LOBATO"),                        
		LONDRINA("LONDRINA"),                      
		LUIZIANA("LUIZIANA"),
		LUNARDELLI("LUNARDELLI"),                    
		LUPIONOPOLIS("LUPIONOPOLIS"),                  
		MALLET("MALLET"),                        
		MAMBORE("MAMBORE"),                       
		MANDAGUACU("MANDAGUACU"),                    
		MANDAGUARI("MANDAGUARI"),                    
		MANDIRITUBA("MANDIRITUBA"),                   
		MANFRINOPOLIS("MANFRINOPOLIS"),                 
		MANGUEIRINHA("MANGUEIRINHA"),                  
		MANOEL_RIBAS("MANOEL RIBAS"),                  
		MARECHAL_CANDIDO_RONDON("MARECHAL CANDIDO RONDON"),       
		MARIA_HELENA("MARIA HELENA"),                  
		MARIALVA("MARIALVA"),                      
		MARILANDIA_DO_SUL("MARILANDIA DO SUL"),             
		MARILENA("MARILENA"),                      
		MARILUZ("MARILUZ"),                       
		MARINGA("MARINGA"),                       
		MARIOPOLIS("MARIOPOLIS"),                    
		MARIPA("MARIPA"),                        
		MARMELEIRO("MARMELEIRO"),                    
		MARQUINHO("MARQUINHO"),                     
		MARUMBI("MARUMBI"),                       
		MATELANDIA("MATELANDIA"),                    
		MARINHOS("MATINHOS"),                      
		MATO_RICO("MATO RICO"),                     
		MAUA_DA_SERRA("MAUA DA SERRA"),                 
		MEDIANEIRA("MEDIANEIRA"),                    
		MERCEDES("MERCEDES"),                      
		MIRADOR("MIRADOR"),                       
		MIRASEL("MIRASELVA"),                     
		MISSAL("MISSAL"),                        
		MOREIRA_SALES("MOREIRA SALES"),                 
		MORRETES("MORRETES"),                      
		MUNHOZ_DE_MELLO("MUNHOZ DE MELLO"),               
		NOSSA_SENHORA_DAS_GRACAS("NOSSA SENHORA DAS GRACAS"),      
		NOSSA_ALIANCA_DO_IVAI("NOVA ALIANCA DO IVAI"),          
		NOVA_AMERICA_DA_COLINA("NOVA AMERICA DA COLINA"),        
		NOVA_AURORA("NOVA AURORA"),                   
		NOVA_CANTU("NOVA CANTU"),                    
		NOVA_ESPERANCA("NOVA ESPERANCA"),                
		NOVA_ESPERANCA_DO_SUDOESTE("NOVA ESPERANCA DO SUDOESTE"),    
		NOVA_FATIMA("NOVA FATIMA"),                   
		NOVA_LARANJEIRAS("NOVA LARANJEIRAS"),              
		NOVA_LONDRINA("NOVA LONDRINA"),                 
		NOVA_OLIMPIA("NOVA OLIMPIA"),                  
		NOVA_PRATA_DO_IGUACU("NOVA PRATA DO IGUACU"),          
		NOVA_SANTA_BARBARA("NOVA SANTA BARBARA"),            
		NOVA_SANTA_ROSA("NOVA SANTA ROSA"),               
		NOVA_TEBAS("NOVA TEBAS"),                    
		NOVO_ITACOLOMI("NOVO ITACOLOMI"),                
		ORTIGUEIRA("ORTIGUEIRA"),                    
		OURIZONA("OURIZONA"),                      
		OURO_VERDE_DO_OESTE("OURO VERDE DO OESTE"),           
		PAICANDU("PAICANDU"),                      
		PALMAS("PALMAS"),                        
		PALMEIRAS("PALMEIRA"),                      
		PALMITAL("PALMITAL"),                      
		PALOTINA("PALOTINA"),                      
		PARAISO_DO_NORTE("PARAISO DO NORTE"),              
		PARANACITY("PARANACITY"),                    
		PARANAGUA("PARANAGUA"),                     
		PARANAPOEMA("PARANAPOEMA"),                   
		PARANAVAI("PARANAVAI"),                     
		PATO_BRAGADO("PATO BRAGADO"),                  
		PATO_BRANCO("PATO BRANCO"),                   
		PAULA_FREITAS("PAULA FREITAS"),                 
		PAULO_FRONTIN("PAULO FRONTIN"),                 
		PEABIRU("PEABIRU"),                       
		PEROBAL("PEROBAL"),                       
		PEROLA("PEROLA"),                        
		PEROLA_DO_OESTE("PEROLA DO OESTE"),               
		PIEN("PIEN"),                          
		PINHAIS("PINHAIS"),                       
		PINHAL_DE_SAO_BENTO("PINHAL DE SAO BENTO"),           
		PINHALAO("PINHALAO"),                      
		PINHAO("PINHAO"),                        
		PIRAI_DO_SUL("PIRAI DO SUL"),                  
		PIRAQUARA("PIRAQUARA"),                     
		PITANGA("PITANGA"),                       
		PITANGUEIRAS("PITANGUEIRAS"),                  
		PLANALTINA_DO_PARANA("PLANALTINA DO PARANA"),          
		PLANALTO("PLANALTO"),                      
		PONTA_GROSSA("PONTA GROSSA"),                  
		PONTAL_DO_PARANA("PONTAL DO PARANA"),              
		PORECATU("PORECATU"),                      
		PORTO_AMAZONAS("PORTO AMAZONAS"),                
		PORTO_BARREIRO("PORTO BARREIRO"),                
		PORTO_RICO("PORTO RICO"),                    
		PORTO_VITORIA("PORTO VITORIA"),                 
		PRADO_FERREIRA("PRADO FERREIRA"),                
		PRANCHITA("PRANCHITA"),                     
		PRESIDENTE_CASTELO_BRANCO("PRESIDENTE CASTELO BRANCO"),     
		PRIMEIRO_DE_MAIO("PRIMEIRO DE MAIO"),              
		PRUDENTOPOLIS("PRUDENTOPOLIS"),                 
		QUARTO_CENTENARIO("QUARTO CENTENARIO"),             
		QUATIGUA("QUATIGUA"),                      
		QUATRO_BARRAS("QUATRO BARRAS"),                 
		QUATRO_PONTES("QUATRO PONTES"),                 
		QUEDAS_DO_IGUACU("QUEDAS DO IGUACU"),              
		QUERENCIA_DO_NORTE("QUERENCIA DO NORTE"),            
		QUINTA_DO_SOL("QUINTA DO SOL"),                 
		QUITANDINHA("QUITANDINHA"),                   
		RAMILANDIA("RAMILANDIA"),                    
		RANCHO_ALEGRE("RANCHO ALEGRE"),                 
		RANCHO_ALEGRE_D0_OESTE("RANCHO ALEGRE DO OESTE"),        
		REALEZA("REALEZA"),                       
		REBOUCAS("REBOUCAS"),                      
		RENASCENCA("RENASCENCA"),                    
		RESERVA("RESERVA"),                       
		RESERVA_DO_IGUACU("RESERVA DO IGUACU"),             
		RIBEIRAO_CLARO("RIBEIRAO CLARO"),                
		RIBEIRAO_DO_PINHAL("RIBEIRAO DO PINHAL"),            
		RIO_AZUL("RIO AZUL"),                      
		RIO_BOM("RIO BOM"),                      
		RIO_BONITO_DO_IGUACU("RIO BONITO DO IGUACU"),          
		RIO_BRANCO_DO_IVAI("RIO BRANCO DO IVAI"),            
		RIO_BRANCO_DO_SUL("RIO BRANCO DO SUL"),             
		RIO_NEGRO("RIO NEGRO"),                     
		ROLANDIA("ROLANDIA"),                      
		RONCADOR("RONCADOR"),                      
		RONDON("RONDON"),                        
		ROSARIO_DO_IVAI("ROSARIO DO IVAI"),               
		SABAUDIA("SABAUDIA"),                      
		SALGADO_FILHO("SALGADO FILHO"),                 
		SALTO_DO_ITARATE("SALTO DO ITARARE"),              
		SALTO_DO_LONTRA("SALTO DO LONTRA"),               
		SANTA_AMELIA("SANTA AMELIA"),                  
		SANTA_CECILIA_DO_PAVAO("SANTA CECILIA DO PAVAO"),        
		SANTA_CRUZ_DO_MONTE_CASTELO("SANTA CRUZ DO MONTE CASTELO"),   
		SANTA_FE("SANTA FE"),                      
		SANTA_HELENA("SANTA HELENA"),                  
		SANTA_INES("SANTA INES"),                    
		SANTA_ISABEL_DO_IVAI("SANTA ISABEL DO IVAI"),          
		SANTA_IZABEL_DO_OESTE("SANTA IZABEL DO OESTE"),         
		SANTA_LUCIA("SANTA LUCIA"),                  
		SANTA_MARIA_DO_OESTE("SANTA MARIA DO OESTE"),          
		SANTA_MARIANA("SANTA MARIANA"),                 
		SANTA_MONICA("SANTA MONICA"),                  
		SANTA_TEREZA_DO_OESTE("SANTA TEREZA DO OESTE"),         
		SANTA_TEREZINHA_DE_ITAIPU("SANTA TEREZINHA DE ITAIPU"),     
		SANTANA_DO_ITARARE("SANTANA DO ITARARE"),            
		SANTO_ANTONIO_DA_PLATINA("SANTO ANTONIO DA PLATINA"),      
		SANTO_ANTONIO_DO_CAIUA("SANTO ANTONIO DO CAIUA"),        
		SANTO_ANTONIO_DO_PARAISO("SANTO ANTONIO DO PARAISO"),      
		SANTO_ANTONIO_DO_SUDOESTE("SANTO ANTONIO DO SUDOESTE"),     
		SANTO_INACIO("SANTO INACIO"),                  
		SAO_CARLOS_DO_IVAI("SAO CARLOS DO IVAI"),            
		SAO_JERONIMO_DA_SERRA("SAO JERONIMO DA SERRA"),         
		SAO_JOAO("SAO JOAO"),                      
		SAO_JOAO_DO_CAIUA("SAO JOAO DO CAIUA"),             
		SAO_JOAO_DO_IVAI("SAO JOAO DO IVAI"),              
		SAO_JOAO_DO_TRIUNFO("SAO JOAO DO TRIUNFO"),           
		SAO_JORGE_DO_IVAI("SAO JORGE DO IVAI"),             
		SAO_JORGE_DO_OESTE("SAO JORGE DO OESTE"),            
		SAO_JORGE_DO_PATROCINIO("SAO JORGE DO PATROCINIO"),       
		SAO_JOSE_DA_BOA_VISTA("SAO JOSE DA BOA VISTA"),         
		SAO_JOSE_DAS_PALMEIRAS("SAO JOSE DAS PALMEIRAS"),        
		SAO_JOSE_DOS_PINHAIS("SAO JOSE DOS PINHAIS"),          
		SAO_MANOEL_DO_PARANA("SAO MANOEL DO PARANA"),          
		SAO_MATEUS_DO_SUL("SAO MATEUS DO SUL"),             
		SAO_MIGUEL_DO_IGUACU("SAO MIGUEL DO IGUACU"),          
		SAO_PEDRO_DO_IGUACU("SAO PEDRO DO IGUACU"),           
		SAO_PEDRO_DO_IVAI("SAO PEDRO DO IVAI"),             
		SAO_PEDRO_DO_PARANA("SAO PEDRO DO PARANA"),           
		SAO_SEBASTIAO_DA_AMOREIRA("SAO SEBASTIAO DA AMOREIRA"),     
		SAO_TOME("SAO TOME"),                      
		SAPOPEMA("SAPOPEMA"),                      
		SARANDI("SARANDI"),                       
		SAUDADE_DO_IGUACU("SAUDADE DO IGUACU"),             
		SENGES("SENGES"),                        
		SERRANOPOLIS_DO_IGUACU("SERRANOPOLIS DO IGUACU"),        
		SERTANEJA("SERTANEJA"),                     
		SERTANOPOLIS("SERTANOPOLIS"),                  
		SIQUEIRA_CAMPOS("SIQUEIRA CAMPOS"),               
		SULINA("SULINA"),                        
		TAMARANA("TAMARANA"),                      
		TAMBOARA("TAMBOARA"),                      
		TAPEJARA("TAPEJARA"),                      
		TAPIRA("TAPIRA"),                        
		TEIXEIRA_SOARES("TEIXEIRA SOARES"),               
		TELEMACO_BORBA("TELEMACO BORBA"),                
		TERRA_BOA("TERRA BOA"),                     
		TERRA_RICA("TERRA RICA"),                    
		TERRA_ROXA("TERRA ROXA"),                    
		TIBAGI("TIBAGI"),                        
		TIJUCAS_DO_SUL("TIJUCAS DO SUL"),                
		TOLEDO("TOLEDO"),                        
		TOMAZINA("TOMAZINA"),                      
		TRES_BARRAS_DO_PARANA("TRES BARRAS DO PARANA"),         
		TUNAS_DO_PARANA("TUNAS DO PARANA"),               
		TUNEIRAS_DO_OESTE("TUNEIRAS DO OESTE"),             
		TUPASSI("TUPASSI"),                       
		TURVO("TURVO"),                         
		UBIRATA("UBIRATA"),                       
		UMUARAMA("UMUARAMA"),                      
		UNIAI_DA_VITORIA("UNIAO DA VITORIA"),              
		UNIFLOR("UNIFLOR"),                       
		URAI("URAI"),                          
		VENTANIA("VENTANIA"),                      
		VERA_CRUZ_DO_OESTE("VERA CRUZ DO OESTE"),            
		VERE("VERE"),                          
		VIRMOND("VIRMOND"),                       
		VITORINO("VITORINO"),                      
		WENCESLAU_BRAZ("WENCESLAU BRAZ"),                
		XAMBRE("XAMBRE");
		
		private String municipio;

		private Municipio(String municipio) {
		    this.setMunicipio(municipio);
		}

		public String getMunicipio() {
			return municipio;
		}

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}
		
		
		
	}
	
	
	
}
