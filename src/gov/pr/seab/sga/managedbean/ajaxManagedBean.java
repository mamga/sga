package gov.pr.seab.sga.managedbean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
* Created by JBoss Tools
*/
@ManagedBean
@RequestScoped
public class ajaxManagedBean {
	
	private int count;

	public int getCount() {
		 return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
		 
	public void increment() {
		count++;
	}

   
}
