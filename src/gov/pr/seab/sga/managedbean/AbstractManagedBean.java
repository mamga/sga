package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.util.JSFMessageUtil;

import org.primefaces.context.RequestContext;


public class AbstractManagedBean {
	
	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	 
    public AbstractManagedBean() {
        super();
    }
 
    protected void displayErrorMessageToUsuario(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendErrorMessageToUsuario(message);
    }
 
    protected void displayInfoMessageToUsuario(String message) {
        JSFMessageUtil messageUtil = new JSFMessageUtil();
        messageUtil.sendInfoMessageToUsuario(message);
    }
 
    protected void closeDialog(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
    }
 
    protected void keepDialogOpen(){
        getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
    }
 
    protected RequestContext getRequestContext(){
        return RequestContext.getCurrentInstance();
    }

}
