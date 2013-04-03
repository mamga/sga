package gov.pr.seab.sga.managedbean;

import java.awt.MenuBar;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menubar.Menubar;


@ManagedBean
@SessionScoped
public class MenuManagedBean {

	private Menubar menuBar = new Menubar();
	
	
	public MenuManagedBean() {
		
	}
	
	public MenuBar getMenuBar() {
        return menuBar;
    }

}
