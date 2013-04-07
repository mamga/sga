package gov.pr.seab.sga.managedbean;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.MethodExpressionActionListener;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;



@ManagedBean
@SessionScoped
public class MenuManagedBean {

	private MenuModel model;
	
	public MenuManagedBean() {
		
		model = new DefaultMenuModel();  
        
        Submenu submenu = new Submenu();  
        submenu.setLabel("Sistema AAX");  
          
        MenuItem item = new MenuItem();  
        item.setValue("Impressão de Etiquetas");  
        item.setUrl("/pages/manterEtiqueta/indexManterEtiqueta.xhtml");  
        //item.addActionListener(processAction());
        //item.addActionListener(createMethodActionListener("#{menuManagedBean.changePage('1')}", Void.TYPE, new Class[]{String.class}));
        //item.setUpdate("content");
        submenu.getChildren().add(item);  
          
        model.addSubmenu(submenu);
          
        //Second submenu  
        /*submenu = new Submenu();  
        submenu.setLabel("Dynamic Submenu 2");  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.1");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.2");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        model.addSubmenu(submenu);*/
			
	}
	
	public MenuModel getModel() {  
        return model;  
    }
	
	private MethodExpression createMethodExpression(String valueExpression, Class<?> valueType, Class<?>[] expectedParamTypes) {
        MethodExpression methodExpression = null;
        try {
            ExpressionFactory factory = FacesContext.getCurrentInstance().getApplication().getExpressionFactory();
            methodExpression = factory.createMethodExpression(FacesContext.getCurrentInstance().getELContext(), valueExpression, valueType, expectedParamTypes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return methodExpression;
    }

    private MethodExpressionActionListener createMethodActionListener(String valueExpression, Class<?> valueType, Class<?>[] expectedParamTypes) {
        MethodExpressionActionListener actionListener = null;
        try {
            actionListener = new MethodExpressionActionListener(createMethodExpression(valueExpression, valueType, expectedParamTypes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actionListener;
    }
	
	
}




/*Prezados(as),

Para facilitar o processo de implantação do Sistema AAX nos núcleos regionais da SEAB, foi desenvolvido um módulo, dentro do sistema de acompanhamento de processos que está em construção pelo NII, para impressão das etiquetas.

Após o cadastro no AAX, seguir as intruções abaixo para impressão das etiquetas:

- Acessar o endereço: http://10.36.1.13/sga/
- Menu "Sistema AAX -> Impressão de Etiquetas".
- Digitar o número do protocolo no campo correspondente a posição da etiqueta.
- Clicar no botão "Gerar Arquivo para Impressão".
- Imprimir o PDF.

Na folha, a etiqueta 1 é a que está mais próximo da margem maior.

Qualquer dúvida estamos à disposição nos seguintes telefones:

41 3313 4164
41 3313 4057

Att.

Marcelo Andrade Amadeu
Secretaria da Agricultura e do Abastecimento - SEAB
Núcleo de Informática e Informações - NII

Esta mensagem pode conter informações   confidenciais e/ou privilegiadas.Se você não for o destinatário ou a  pessoa autorizada a recebe-la, não pode usar, copiar ou divulgar as  informações nela contidas ou tomar qualquer ação baseada nelas. Se  você recebeu esta mensagem por engano,por favor, avise imediatamente o  remetente, e em seguida, apague-a. Comunicações pela Internet não  podem ser garantidas quanto à segurança ou inexistência de erros ou  de vírus. O remetente, por esta razão, não aceita responsabilidade  por qualquer erro ou omissão no contexto da mensagem decorrente da  transmissão via Internet.

*/