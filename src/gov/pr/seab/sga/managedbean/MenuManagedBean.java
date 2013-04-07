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
        submenu = new Submenu();  
        submenu.setLabel("Dynamic Submenu 2");  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.1");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        item = new MenuItem();  
        item.setValue("Dynamic Menuitem 2.2");  
        item.setUrl("#");  
        submenu.getChildren().add(item);  
          
        model.addSubmenu(submenu);
			
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
