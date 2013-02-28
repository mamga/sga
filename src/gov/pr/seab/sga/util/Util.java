package gov.pr.seab.sga.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

public class Util {

	private static final String TIMEOUT = "_comTimeOut";

	/**
	 * Envia Email com ou sem anexos
	 * @author jacquesotomaior
	 * @since 16/10/2008
	 * @param String assunto
	 * @param String remetente
	 * @param String texto
	 * @param String destinatarioPara
	 * @param String destinatarioCc
	 * @param String destinatarioBcc
	 * @param String nomeAnexo
	 * @param String textoAnexo
	 * @return void
	 * @throws ApplicationException
	 */	
	public static void enviarEmail(final String assunto, final String remetente, final String texto, final String destinatarioPara, final String destinatarioCc, String destinatarioBcc, String nomeAnexo, String textoAnexo) throws ApplicationException{
		try {
			if ("true".equals(Mensagem.getInstance().getMessage("email_enviar"))) {
				final Properties mailProps = new Properties();
				mailProps.put("mail.smtp.host", Mensagem.getInstance().getMessage("email_server"));
				final Session mailSession = Session.getInstance(mailProps, null);
				mailSession.setDebug(false);
	
				final Message email = new MimeMessage(mailSession);
				email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatarioPara));
	
				if (destinatarioCc != null && StringUtils.isNotEmpty(destinatarioCc.trim())) {
					email.setRecipients(Message.RecipientType.CC, InternetAddress.parse(destinatarioCc));
				}
				if (destinatarioBcc != null && StringUtils.isNotEmpty(destinatarioBcc.trim())) {
					email.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(destinatarioBcc));
				}
				if (StringUtils.isNotBlank(remetente) ){
					email.setFrom(new InternetAddress(remetente));	
				}
				
				email.setSubject(assunto);
				email.setContent(texto, "text/plain");
							
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(texto);
				
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				
				if (StringUtils.isNotBlank(textoAnexo) || StringUtils.isNotBlank(nomeAnexo)) {
					messageBodyPart = new MimeBodyPart();
					File file= File.createTempFile("mail", "anexo");
					file.deleteOnExit();
	
					BufferedWriter out = new BufferedWriter(new FileWriter(file));
					out.write(textoAnexo);
					out.close();
					DataSource source = new FileDataSource(file);
					email.setDataHandler(new DataHandler(source));
					email.setFileName(nomeAnexo);
					multipart.addBodyPart(messageBodyPart);
				}
	
				//log.info("Enviando e-mail...");
				try {
					Transport.send(email);
				} catch (MessagingException e) {
					//log.error(e.getMessage(), e);
					throw new ApplicationException("mensagem.email.erro");
				}
				//log.info("E-mail enviado.");
			} else {
				//log.info("Envio de e-mail desabilitado.");
			}
		} catch (javax.mail.SendFailedException e) {
			throw new ApplicationException("mensagem.email.erro");
		} catch (Exception e) {
			throw new ApplicationException("mensagem.email.erro");
		}
	
	}
	
	/**
	 * Testa se o valor informado e numerico ou nao.
	 * 
	 * @author desconhecido
	 * @since 20080408
	 * @param valor
	 * @return  Boolean
	 */
	public static Boolean isNumber( String valor ) {
		Boolean retorno;
		try {
			@SuppressWarnings("unused")
			Long teste = Long.valueOf(valor);
			retorno = Boolean.TRUE;
		} catch( Exception e ) {
			// Se ocorrer erro no parse, nao e numero
			retorno = Boolean.FALSE;
		}
		return retorno;
	}

	/**
	 * Testa se o valor informado é data ou não.
	 * 
	 * @author desconhecido
	 * @since 20080408
	 * @param valor (DD/MM/AA | DD/MM/AAAA)
	 * @return Boolean
	 */
	public static Boolean isDate( String valor ) {

		Integer dia = Integer.valueOf(valor.substring(0, 2));
		Integer mes = Integer.valueOf(valor.substring(3, 5));
		Integer ano = Integer.valueOf(valor.substring(6, 10));

		if (mes < 1 || mes > 12) {
			return false;
		}

		if (dia < 1 || dia > 31) {
			return false;
		}

		if ((mes==4 || mes==6 || mes==9 || mes==11) && dia==31) {
			return false;
		}

		if (mes == 2) {
			boolean isleap = (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
			if (dia>29 || (dia==29 && !isleap)) {
				return false;
			}
		}

		return true;

	}

	/**
	 * Converte um Date para uma String no formato dd/mm/yyyy hh:mm:ss<br>
	 * @author rogerio
	 * @since 0.1, 29/06/2007
	 * @version 0.1, 29/06/2007
	 * @param data - Data a ser convertida
	 * @return string - dd/mm/yyyy hh:mm:ss
	 **/      
	public static String formataDataHora(java.util.Date data) {
		String formatedDate = "";

		if( data != null ) {
			formatedDate = Util.formataData(data) + " " + Util.formataHora(data); 
		}

		return formatedDate;
	}

	/**
	 * Formata o nome do mes de acordo com o seu numero<br>
	 * 
	 * @author desconhecido
	 * @since 20080408
	 * @param numMes - Mes a ser convertido
	 * @return string - Nome do mes
	 **/	
	public static String nomeDoMes(int numMes) {
		if(numMes < 0 || numMes > 11) return "";

		String ret = "";
		switch(numMes) {
		case  0: ret = "Janeiro";   break;
		case  1: ret = "Fevereiro"; break;
		case  2: ret = "Março";     break;
		case  3: ret = "Abril";     break;
		case  4: ret = "Maio";      break;
		case  5: ret = "Junho";     break;
		case  6: ret = "Julho";     break;
		case  7: ret = "Agosto";    break;
		case  8: ret = "Setembro";  break;
		case  9: ret = "Outubro";   break;
		case 10: ret = "Novembro";  break;
		case 11: ret = "Dezembro";  break;
		}
		return ret;
	}

	/**
	 * Converte um Date para uma String no formato HH:mm:ss<br>
	 * @author geraldo
	 * @since 07/10/2005
	 * @param data - Data a ser convertida
	 * @return string - HH:mm:ss
	 */      
	public static String formataHora(java.util.Date data) {
		String formato = "HH:mm:ss";
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		return (data != null ? formatter.format(data) : ""); 
	}

	/**
	 * Converte um Date para uma String no formato HH:mm<br>
	 * @author geraldo
	 * @since 07/10/2005
	 * @param data - Data a ser convertida
	 * @return string - HH:mm
	 */      
	public static String formataHoraCurta(java.util.Date data) {
		String formato = "HH:mm";
		String strRetorno;
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		if ((data != null))
			strRetorno = formatter.format(data); 
		else
			strRetorno = "";
		return strRetorno;  
	}

	/**
	 * Converte um Date para uma String no formato dd/mm/yyyy<br>
	 * @author geraldo
	 * @since 07/10/2005
	 * @param data - Data a ser convertida
	 * @return string - dd/mm/yyyy
	 */      
	public static String formataData(java.util.Date data) {
		String formato = "dd/MM/yyyy";
		String strRetorno;
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		if ((data != null))
			strRetorno = formatter.format(data); 
		else
			strRetorno = "";
		return strRetorno;  
	}   

	/**
	 * Converte um Date para uma String no formato yyyy-mm-dd<br>
	 * @author geraldo
	 * @since 07/10/2005
	 * @param data - Data a ser convertida
	 * @return string - yyyy-mm-dd
	 */      
	public static String formataData2(java.util.Date data) {
		String formato = "yyyy-MM-dd";
		String strRetorno;
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		if ((data != null))
			strRetorno = formatter.format(data); 
		else
			strRetorno = "";
		return strRetorno;  
	}  

	/**
	 * Formata a data em (dd/MM/yyyy)
	 * 
	 * @author luis.paiva
	 * @since 14/07/2006
	 * @return Date
	 * @param data
	 */
	public static Date formataData(String data){
		if(data == null) return null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date ret = null;
		try {
			ret = sdf.parse(data);
		} catch (ParseException e) {
			return ret;
		}
		return ret;
	}

	/**
	 * Transforma String de data no formato norte-americano para Date
	 * @author EdemarSantos
	 * @since 11/12/2007
	 * @return Date
	 * @param data -  no formato MM/dd/yyyy
	 */
	public static Date formataDataInglesa(String data){
		if(data == null) return null;

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date ret;
		try {
			ret = sdf.parse(data);
		} catch (ParseException e) {
			ret = null;
		}
		return ret;
	}

	/**
	 * Formata o numero para String, preenchendo com '0' ate a tamanho.<br>
	 * @author geraldo
	 * @since 07/10/2005 
	 * @param numero
	 * @param tamanho
	 * @return StringBuffer do tamanho do numero.
	 */
	public static StringBuffer numeroToString(Long numero, int tamanho) {
		String str = numero.toString();
		StringBuffer strbf = new StringBuffer(tamanho+1);
		int len = str.length();
		// 12 fixo aqui hein geraldo!
		for(int i=0 ; i < tamanho-len; i++)
			strbf.append("0");
		strbf.append(str);                        
		return strbf;       
	}    

	/**
	 * Retorna a data atual por extenso.
	 * @author anderson.ferreira
	 * @since 28/04/2006
	 * @param date a ser formatada formato dd de mmmmmmm de yyyy.
	 * @return Retorna uma string representado a data passada como parametro.
	 */	
	public static String dataPorExtenso(Date date)
	{
		String[] meses={"Janeiro","Fevereiro","Março","Abril",
				"Maio","Junho","Julho","Agosto","Setembro",
				"Outubro","Novembro","Dezembro"};
		GregorianCalendar data = new GregorianCalendar();
		data.setTime(date);
		int mes = data.get(GregorianCalendar.MONTH);
		return data.get(GregorianCalendar.DATE)+" de "+meses[mes]+" de "+data.get(GregorianCalendar.YEAR);
	}

	/**
	 * Recebe o mes como inteiro e retorna escrito por extenso
	 * @author anderson.ferreira
	 * @param mes
	 * @return String
	 */
	public static String formataMes(int mes){
		String[] meses={"Janeiro","Fevereiro","Março","Abril",
				"Maio","Junho","Julho","Agosto","Setembro",
				"Outubro","Novembro","Dezembro"}; 
		if(mes>12 || mes <1)
			return "mês inexistente";
		else    	 
			return meses[mes];
	}

	/**
	 * Método para limpar todos os campos de um Bean qualquer.
	 * Procura por métodos que comecem com 'set' e passa valores
	 * 0, false ou null para eles, conforme o caso.
	 * @param bean : Object - Objeto padrão 'bean' (com getters, setters e atributos encapsulados...)
	 * @author Gabriel Ortiz
	 * @version 1.3, 29/05/2006
	 * @throws ApplicationException 
	 */
	public static void limpaBean(Object bean) throws ApplicationException{
		Short zeroShort = 0;
		char  zeroChar  = 0;
		byte  zeroByte  = 0;

		Method[] mets = bean.getClass().getMethods();
		for(Method m : mets) {
			if(m.getName().length() > 3 && "set".equals(m.getName().substring(0, 3))) {
				Class<?> parms[] = m.getParameterTypes();
				if(parms.length == 1) {
					Object[] args = new Object[1];

					String tipo = parms[0].toString();
					if("boolean".equals(tipo))
						args[0] = false;
					else if("int".equals(tipo) || "float".equals(tipo) ||
							"double".equals(tipo) || "long".equals(tipo))
						args[0] = 0;
					else if("short".equals(tipo))
						args[0] = zeroShort.shortValue();
					else if("char".equals(tipo))
						args[0] = zeroChar;
					else if("byte".equals(tipo))
						args[0] = zeroByte;
					else
						args[0] = null;

					try {
						m.invoke(bean, args);
					} catch (Exception e) {
						throw new ApplicationException("Util.limpaBean : Erro ao invocar método setter! obj: " + bean + " - metodo:" + m);
					}
				} else {
					throw new ApplicationException("Util.limpaBean : Método setter com 0 ou mais de um parametro! obj: " +
							bean + " - metodo:" + m);
				}
			}
		}
	}

	/**
	 * Recebe uma string str e uma máscara mask onde , da esquerda para a direita, 
	 * 		o caracter da máscara # é substituido por caracteres de str, enquanto
	 * 		os demais caracteres são adicionados é string de retorno. <br>
	 * 
	 * @author pdrvaz
	 * @since 21/06/2006
	 * @param str
	 * @param mask
	 * @return String
	 * @throws Exception 
	 */
	public static String mascaraGenerica(String str,String mask) throws Exception {
		if (str == null) return null;
		if (mask == null) return str;

		int i = str.length();
		int j = mask.length();
		Stack<String> pilha = new Stack<String>();

		for (/*nop;*/; i > 0 && j > 0; i--,j--) {
			if (mask.substring(j-1,j).equals("#")) {
				pilha.push(str.substring(i-1,i));
			} else {
				pilha.push(mask.substring(j-1,j));
				i++;
			}
		}
		if (i > j) {
			pilha.push(str.substring(0,i));
		}
		StringBuffer retorno = new StringBuffer("");
		while (!pilha.isEmpty()) {
			retorno.append(pilha.pop());
		}
		return retorno.toString();
	}

	/**
	 * Completar com caracteres a esquerda ou a direita. <br> 
	 * @author olivio
	 * @since 28/06/2006
	 * @param arg : valor a ser completado
	 * @param caracter : caracter usado no preenchimento
	 * @param tamanho : tamanho do retorno já preenchido
	 * @param esquerda : true - preencher a esquerda; false - preencher a direita
	 * @return String
	 * @throws Exception
	 */
	public static String completarComCaracter(String arg, String caracter, int tamanho, boolean esquerda) throws Exception {
		StringBuffer retorno = new StringBuffer(arg);

		int size = tamanho - arg.length();
		for(int i = 1; i <= size; i++)
			if(esquerda){
				retorno = retorno.insert(0, caracter);
			}
			else{
				retorno = retorno.append(caracter);
			}
		return retorno.toString();
	}

	/**
	 * Retorna um numero com formatado com 2 casas decimais.
	 * Formato de retorno 0000000,00
	 * @author pdrvaz
	 * @since 14/07/2006
	 * @param number : number valor monetario
	 * @return String valor monetario formatado
	 */
	public static String formataNumeroMonetario(double number){
		NumberFormat formatter = new DecimalFormat("###,###,###,###,###,###,##0.00");	     	    	   
		return formatter.format(number);
	}
	
	/**
	 * Faz a mesma coisa que a fun��o anterior, mas usa uma assinatura com um objeto ao inv�s de um tipo 
	 * primitivo, checando por nulos.
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 18/04/2012
	 * @param number
	 * @return
	 */
	public static String formataNumeroMonetario(Double number){
		if(number==null){
			return null;
		}
		NumberFormat formatter = new DecimalFormat("###,###,###,###,###,###,##0.00");	     	    	   
		return formatter.format(number);
	}

	/**
	 * Gera um objeto Date a partir do dia (java.util.Date) e hora (java.lang.String).
	 * @author pdrvaz
	 * @since 09/11/2005
	 * @param  dia
	 * @param  hora
	 * @return Date
	 * @throws ParseException 
	 */
	public static Date geraObjDate(Date dia,String hora) throws ParseException {
		SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy ");
		SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return sdfDataHora.parse(sdfData.format(dia) + hora);
	}

	/**
	 * Retorna uma coleção com os elementos de col1 que estão em col2
	 * (col1 e col2 devem ser listas de objetos da mesma classe)
	 * @author evandro
	 * @since 14/02/2007 
	 * @param col1
	 * @param col2
	 * @return Collection
	 */
	@SuppressWarnings("unchecked")
	public static Collection intersecao(Collection col1, Collection col2){
		Collection a = new ArrayList(col1);
		Collection b = new ArrayList(col2);
		a.retainAll(b);
		return a;
	}

	/**
	 * Valida se é nulo ou se a string, depois de trim, é vazia 
	 * @author EdemarSantos
	 * @since 31/03/2008
	 * @return boolean
	 * @param s
	 */
	public static boolean isNullOrEmpty(String s){
		if(s == null) return true;
		for (int i=0; i < s.length(); i++) {
			if (! Character.isWhitespace( s.charAt(i) ) ) {
				return false;
			}
		}    	
		return true;
	}

	public static BigDecimal formataBigDecimal(String value) throws ApplicationException {
		Locale brasil = new Locale ("pt", "BR");  
		DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (brasil));  
		df.setParseBigDecimal (true);  
		try {  
			BigDecimal b1 = (BigDecimal) df.parse(value);  

			String s1 = df.format (b1);  
			Logger.getLogger(Util.class).debug(s1);

			return b1;
		} catch (Exception e) {  
			throw new ApplicationException("erro: ", e);
		}
	}

	/**
	 * Testa se uma lista não está vazia.
	 * 
	 * @author aleixo
	 * @since 01/09/2009
	 * @param lista
	 * @return
	 */
	public static boolean isListaNaoVazia(Collection lista) {
		return lista != null && !lista.isEmpty();
	}

	/**
	 * Testa se um código não é nulo, nem vazio, nem igual a "-1".
	 * 
	 * @author aleixo
	 * @since 10/09/2009
	 * @version 0.1
	 * @param codigo
	 * @return
	 */
	public static boolean isCodigoValido(String codigo){
		return codigo != null && !"".equals(codigo.trim()) && !"-1".equals(codigo.trim());
	}

	/**
	 * Formata uma string no formato do cep (999-99999)
	 * 
	 * @author aleixo
	 * @since 15/09/2009
	 * @version 0.1
	 * @param cep
	 * @return
	 */
	public static String formataCEP(String cep){
		try{
			return mascaraGenerica(cep, "#####-###");
		}catch (Exception e) {
			return cep;
		}
	}

	/**
	 * Formata uma string no formato do telefone (9999-9999)
	 * 
	 * @author Edson K.
	 * @since 15/09/2009
	 * @version 0.1
	 * @param numFone
	 * @return
	 */
	public static String formataTelefone(String numFone){
		try{
			if(numFone != null && numFone.length() == 8)
				return mascaraGenerica(numFone, "####-####");
			else if (numFone != null)
				return numFone;
			else
				return "";
		}catch (Exception e) {
			return numFone;
		}

	}

	/**
	 * Tenta converter um numero pra inteiro. Se não consegue, retorna nulo.<br>
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 23/12/2009
	 * @param numero
	 * @throws ApplicationException
	 * @return
	 */
	public static Integer safeInteger(String numero) throws ApplicationException{
		try{
			if(StringUtils.isNotBlank(numero) && Valores.isInteger(numero.trim()))
				return Integer.valueOf(StringUtils.trim(numero));			
			return null;
		}
		catch(NumberFormatException ne){
			throw new ApplicationException("erro.executaroperacao",new String[]{"Util.safeInteger(): O valor passado como parâmetro:"+numero+"Não pode ser convertido em um inteiro."},ne,ApplicationException.ICON_ERRO);
		}
	}

	/**
	 * Tenta converter um numero pra long. Se não consegue, retorna nulo.<br>
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 23/12/2009
	 * @param numero
	 * @throws ApplicationException
	 * @return
	 */
	public static Long safeLong(String numero) throws ApplicationException{
		try{
			if(StringUtils.isNotBlank(numero) && Valores.isInteger(numero.trim()))
				return Long.valueOf(StringUtils.trim(numero));			
			return null;
		}
		catch(NumberFormatException ne){
			throw new ApplicationException("erro.executaroperacao",new String[]{"Util.safeLong(): O valor passado como parâmetro:"+numero+"Não pode ser convertido em um inteiro."},ne,ApplicationException.ICON_ERRO);
		}
	}

	/**
	 * Adiciona um atributo na Sessão do Servidor de Aplicação.
	 * 
	 * @param nomeDoAtributo - nome do atributo na sessão
	 * @param obj - atributo a ser salvo na sessão
	 * @param sessao
	 * @see Util.limparAtributosDaSessao()
	 */
	public static void adicionarAtributoASessao(HttpServletRequest request,
			String nomeDoAtributo, Object obj) throws ApplicationException {

		if (nomeDoAtributo.endsWith(TIMEOUT)) {
			throw new ApplicationException("erro.executaroperacao",	new String[] { "Atributos não podem terminar com '-comTimeOut' !!" });
		}

		request.getSession().setAttribute(nomeDoAtributo, obj);
	}

	/**
	 * Adiciona atributo a sessão com time out.
	 * 
	 * @param request
	 * @param attrSessao
	 * @param obj
	 * @param timeOut
	 * @throws ApplicationException
	 */
	/*public static void adicionarAtributoASessao(HttpServletRequest request, String nomeDoAtributo, Object obj, int timeOut)
	throws ApplicationException {

		if (request == null || nomeDoAtributo == null || obj == null) {
			throw new ApplicationException("erro.executaroperacao",	new String[] { "" });
		}

		new AtributoSessaoTimeOut(request.getSession(), nomeDoAtributo	+ TIMEOUT, obj, timeOut);
	}*/

	/**
	 * Método Auxiliar que retira todos os Forms da sessão
	 * 
	 * @param request
	 * @author Ortiz
	 */
	public static void limpaSessao(HttpServletRequest request) {
		List<String> ls = null;
		limpaSessao(request, ls);
	}

	/**
	 * Metodo auxiliar que chama limpaSessao(request, List<String>) colocando
	 * exceto na lista de string do parametro
	 * 
	 * @param request
	 * @param exceto
	 */
	public static void limpaSessao(HttpServletRequest request, String exceto) {
		List<String> ls = null;
		if (exceto != null) {
			ls = new ArrayList<String>();
			ls.add(exceto);
		}
		limpaSessao(request, ls);
	}
	/**
	 * Metodo para retirar todos os atributos da sessao exceto o attributo de
	 * nome passado pelo parametro exceto. - Chamar no iniciarProcesso passando
	 * como exceto o nome do form bean da action de atual, exceto em casos de
	 * interacao entre 2 ou mais actions - Chamar no concluirProcesso passando
	 * exceto = null
	 * 
	 * @param request
	 * @param excecao -
	 *            Attributo exceaao para nao retirar da sessao, nulo para
	 *            retirar todos
	 * @author Ortiz
	 */
	public static void limpaSessao(HttpServletRequest request, List<String> excecao) {

		List<String> exceto = excecao;
		
		if (exceto == null) {
			exceto = new ArrayList<String>();
		}

		exceto.add("SENTINELA_LOGIN");
		exceto.add("SENTINELA_SECURITY_CODE");
		exceto.add("org.apache.struts.action.LOCALE");

		Enumeration<?> attrs = request.getSession().getAttributeNames();
		while (attrs.hasMoreElements()) {
			String atrName = (String) attrs.nextElement();
			if (exceto != null && !(exceto.contains(atrName))) {
				request.getSession().removeAttribute(atrName);
			}
		}
	}

	/**
	 * Obter atributo da sessao sem time out.
	 * 
	 * @author pellizari
	 * @param request
	 * @param attrSessao
	 * @param obj
	 * @param timeOut
	 * @throws ApplicationException
	 */
	public static Object obterAtributoASessao(HttpServletRequest request,
			String nomeDoAtributo) throws ApplicationException {

		return obterAtributoASessao(request, nomeDoAtributo, false);

	}

	/**
	 * Obter atributo da sessão com ou sem time out.
	 * 
	 * @author pellizari
	 * @param request
	 * @param attrSessao
	 * @param obj
	 * @param timeOut
	 * @throws ApplicationException
	 */
	public static Object obterAtributoASessao(HttpServletRequest request, String nomeDoAtributo, boolean isTimeOut)
	throws ApplicationException {
		if (request != null && nomeDoAtributo != null) {
			if (isTimeOut) {
				return request.getSession().getAttribute(nomeDoAtributo + TIMEOUT);
			} else {
				return request.getSession().getAttribute(nomeDoAtributo);
			}
		} else {
			throw new ApplicationException("erro.executaroperacao",	new String[] { "" });
		}

	}

	/**
	 * Obter atributo da sessao sem time out.
	 * 
	 * @author pellizari
	 * @param request
	 * @param attrSessao
	 * @param obj
	 * @param timeOut
	 * @throws ApplicationException
	 */
	public static void removerAtributoDaSessao(HttpServletRequest request,
			String nomeDoAtributo) throws ApplicationException {

		removerAtributoDaSessao(request, nomeDoAtributo, false);

	}

	/**
	 * Obter atributo da sessão com ou sem time out.
	 * 
	 * @author pellizari
	 * @param request
	 * @param attrSessao
	 * @param obj
	 * @param timeOut
	 * @throws ApplicationException
	 */
	public static void removerAtributoDaSessao(HttpServletRequest request,String nomeDoAtributo, boolean isTimeOut) throws ApplicationException {
		if (request != null && nomeDoAtributo != null) {
			if (isTimeOut) {
				request.getSession().removeAttribute(nomeDoAtributo + TIMEOUT);
			} else {
				request.getSession().removeAttribute(nomeDoAtributo);
			} 
		} else {
			throw new ApplicationException("erro.executaroperacao",	new String[] { "" });
		}

	}

	/**
	 * Tira acentuacao e cedilha de uma string
	 * @author ledann
	 * @since 26/05/2008
	 * @param texto : String
	 * @return String
	 * @throws ApplicationException
	 */
	public static String formataStringSemAcento(String texto) throws ApplicationException{
		if (StringUtils.isBlank(texto)){
			return texto;
		}
		try{
			String in  = "ÁÀÃÂÄÉÈÊËÍÌÎÏÓÒÕÔÖÚÙÛÜáàãâäéèêëíìîïóòõôöúùûüçÇ";
			String out = "AAAAAEEEEIIIIOOOOOUUUUaaaaaeeeeiiiiooooouuuucC";
			StringBuffer textoFormatado = new StringBuffer();
			for(int c=0; c< texto.length(); c++) {
				char ch = texto.charAt(c);
				int pos = in.indexOf(ch);
				String cat = (pos == -1) ? String.valueOf(ch) : out.substring(pos, pos+1);
				textoFormatado.append(cat);
			}
			return textoFormatado.toString();
		} catch (Exception e) {
			throw new ApplicationException("Erro na geração da string sem acento.", new String[] { "Util.formataStringSemAcento" }, e);
		}

	}

	/**
	 * Retorna um objeto Date a partir de uma String, de acordo com o padrao especificado.<br>
	 * <pre>
	 * Exemplos de Padrao:
	 * "HH:mm"                   = 14:30
	 * "HH:mm:ss"                = 14:30:35
	 * "dd/MM/yyyy"              = 10/04/2008
	 * "dd/MM/yyyy HH:mm"        = 10/04/2008 14:30
	 * "dd 'de' MMMM 'de' yyyy"  = 07 de Abril de 2008
	 * "yyyy-MM-dd HH:mm:ss.SSS" = 2008-04-07 18:16:43.991
	 * </pre> 
	 * @author Digam
	 * @since 07/04/2008
	 * @param String : data
	 * @param String : padrao
	 * @return Date
	 * @throws ApplicationException
	 * @throws Exception 
	 */
	public static Date gerarObjetoDate(String data, String padrao) throws ApplicationException{

		Date objeto = null;
		if (StringUtils.isBlank(data) || StringUtils.isBlank(padrao)) {
			return objeto;
		}
		try {
			objeto = new SimpleDateFormat(padrao).parse(data);
		} catch (Exception e) {
			throw new ApplicationException("Erro na geração do objeto Date.", new String[] { "Util.gerarObjetoDate" }, e);
		}
		return objeto;
	}

	/**
	 * Retorna um objeto Date no formato 'dd/MM/yyyy HH:mm' a partir de uma String.<br>
	 * @author Digam
	 * @since 07/04/2008
	 * @param String : data
	 * @param String : padrao
	 * @return Date
	 * @throws ApplicationException
	 * @throws Exception 
	 */
	public static Date gerarObjetoDate(String data) throws ApplicationException{

		Date objeto = null;
		if (StringUtils.isBlank(data)) {
			return objeto;
		}
		try {
			objeto = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
		} catch (Exception e) {
			throw new ApplicationException("Erro na geração do objeto Date.", new String[] { "Util.gerarObjetoDate" }, e);
		}
		return objeto;
	}

	/**
	 * Converte um Set em Lista.<br>
	 * @author ed_rodrigues
	 * @since 20/07/2007
	 * @param Set<T> : set, caso nulo retorna list vazio.
	 * @return List<T>
	 * @throws Exception
	 * @review Digam
	 */
	public static <T> List<T> setToList(Set<T> set){
		if(set == null || set.isEmpty()){
			return new ArrayList<T>(0);
		}
		return new ArrayList<T>(set);
	}

	/**
	 * Converte uma Lista em Set.<br>
	 * @author ed_rodrigues
	 * @since 20/07/2007
	 * @param List<T> : list, caso nulo retorna set vazio.
	 * @return Set<T>
	 * @throws Exception
	 * @review Digam
	 */
	public static <T> Set<T> listToSet(List<T> list) {
		if(list == null || list.isEmpty()){
			return new HashSet<T>(0);
		}
		return new HashSet<T>(list);
	}

	/**
	 * evita excessão por null pointer exception
	 * @author leandroaraujo
	 * @since 04/01/2011
	 * @param object
	 * @return
	 */
	public static String safeToString(Object object) {
		if(object != null){
			return object.toString();
		}
		return "";
	}

	/**
	 * Retorna TRUE se data 1 for posterior é data 2 (Despreza horas, minutos e segundos) <br>
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 03/02/2011
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static Boolean dataMaior(Date data1,Date data2){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		return fmt.format(data1).compareTo(fmt.format(data2)) > 0;
	}

	/**
	 * Retorna TRUE se data 1 for anterior é data 2 (Despreza horas, minutos e segundos)<br>
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 03/02/2011
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static Boolean dataMenor(Date data1,Date data2){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		return fmt.format(data1).compareTo(fmt.format(data2)) < 0;
	}

	/**
	 * Retorna TRUE se data1 for a mesma de data2 (Despreza horas, minutos e segundos).<br>
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 03/02/2011
	 * @param data1
	 * @param data2
	 * @return
	 */
	public static Boolean dataIgual(Date data1, Date data2){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		return fmt.format(data1).compareTo(fmt.format(data2)) == 0;
	}

	/**
	 * @author heliopiccinatto
	 * Faz a montagem no padrao de formato para parametro data exigido em expressoes de pesquisa XPath para o repositorio.<br/>
	 * @param parametroData
	 * @return String - (xs:dateTime(yyyy-MM-ddT00:00:00.000Z))
	 * @since 1.2.17.3
	 */
	public static String formatarFuncaoDataParaXPath(Calendar parametroData){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		StringBuilder ret = new StringBuilder(20);
		ret.append("xs:dateTime('")
		.append(df.format(parametroData.getTime()))
		.append("T00:00:00.000Z')");  //aqui se tiver detalhamente de hora deve ser tratado!!!!
		return ret.toString();
	}

	/**
	 * Arredonda um valor double.
	 * @author Juliano Jose da Silva
	 * @param valor : valor a ser arredondado.
	 * @param nrCasasDecimais: numero de casas decimais a serem preservadas.
	 * @return valor double arredondado.
	 */
	public static double arredondaValor(double valor, int nrCasasDecimais) {  

		Double valorDouble = Double.valueOf(valor);
		valorDouble = valorDouble.isNaN() ? 0 : valorDouble;
		BigDecimal bigDecimal = new BigDecimal(valorDouble);
		bigDecimal = bigDecimal.setScale(nrCasasDecimais, BigDecimal.ROUND_HALF_UP);  

		return bigDecimal.doubleValue(); 
	}

	/**
	 * Arredonda um valor double.
	 * @author Juliano Jose da Silva
	 * @param valor : valor a ser arredondado.
	 * @param nrCasasDecimais: numero de casas decimais a serem preservadas.
	 * @param roundMod: tipo de arredondamento. Por exemplo BigDecimal.ROUND_HALF_UP.
	 * @return valor double arredondado.
	 */
	public static double arredondaValor(double valor, int nrCasasDecimais, int roundMod) {  

		Double valorDouble = Double.valueOf(valor);
		valorDouble = valorDouble.isNaN() ? 0 : valorDouble;
		BigDecimal bigDecimal = new BigDecimal(valorDouble);  
		bigDecimal = bigDecimal.setScale(nrCasasDecimais, roundMod);  

		return bigDecimal.doubleValue();  
	}

	public static String removeMascara(String num) {
		if(num!=null){
			return num.replaceAll("\\D", "");
		}
		return null;
	}

	public static Boolean safeBoolean(String parameter) {
		if(StringUtils.isNotBlank(parameter)){
			return Boolean.valueOf(parameter);
		}
		return null;
	}

	/**
	 * 
	 * Tenta converter uma string para double de maneira segura, evitando nullpointeexception ou outra exce��o de formata��o,
	 * levando em considera��o a localiza��o de formata��o do n�mero, i.e, separadores de milhares e de casas decimais 
	 * que est�o de acordo com o sistema monet�rio local<br>
	 * 
	 * @author Rafael de Andrade Sousa - rafaelsousa@celepar.pr.gov.br
	 * @since 18/04/2012
	 * @param numero
	 * @return
	 * @throws ApplicationException 
	 */
	public static Double safeDouble(String numero) throws ApplicationException {
		try {
			if(numero!=null&&!"".equals(numero.trim())){
				Locale brasil = new Locale ("pt", "BR");  
				DecimalFormat df = new DecimalFormat ("#,##0.00", new DecimalFormatSymbols (brasil));  
				df.setParseBigDecimal (true);  
				
				Number num = df.parse(numero);
				return num.doubleValue();
			}
		} catch (ParseException e) {
			throw new ApplicationException("mensagem.generica",new String[]{"O formato do n�mero informado est� inv�lido"});
		}
		return null;
	}
	
	/**
	 * Retorna uma Integer que representa o número dado, retirando para isso
	 * caracteres não numéricos, se estiverem presentes.<br>
	 * 
	 * @author gabriel.ortiz
	 * @since 01/08/05
	 * @param num :
	 *            String Número mascarado com pontos, virgulas ou traços, etc...
	 * @return ret :Integer do numero dados ou -1 se a string não for um número
	 *         válido
	 * @throws NumberFormatException
	 */
	public static String desMascaraNumero(String num) {
		return desMascaraNumero(num, false, true);
	}

	public static String desMascaraNumero(String num, boolean isFloat,
			boolean isNegativo) {
		String check = "0123456789";
		StringBuffer aux = new StringBuffer();

		if (isFloat)
			check = "0123456789,.";

		if (num == null)
			return "0";

		for (int c = 0; c < num.length(); c++) {
			char ch = num.charAt(c);
			if (check.indexOf(ch) != -1
					|| (isNegativo && (aux.length() == 0 && ch == '-')))
				aux.append(ch);
		}
		return aux.toString();
	}
	
	public static String formatarProtocolo(String protocolo) throws Exception{
		if(protocolo.length()==9){
			protocolo = protocolo.substring(0,2).concat(".").concat( protocolo.substring(2,5) ).concat(".").concat(protocolo.substring( 5,8 )).concat("-").concat(protocolo.substring(8,9));
		}
		return protocolo;
	}
	
	public static String limitarString(String valor, int total) throws Exception {
		valor = strNull( valor );
		return valor.substring(0, valor.length()>total? total : valor.length() ); 
	}
	
	public static String strNull(String str) throws Exception {
	    return (str==null)?"":str;
	}
	
	public static String formatarData(String data) throws Exception{
		if(data.length()==8){
			String ano = data.substring(0,4);
			String mes = data.substring(4,6);
			String dia = data.substring(6,8);
			data = dia.concat("/").concat(mes).concat("/").concat(ano);
		}
		return data;
	}
	
	
}