package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Setor;
import gov.pr.seab.sga.facade.SetorFacade;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ViewScoped
@ManagedBean
public class SetorManagedBean extends AbstractManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
    private Setor setor;
    private Setor setorSelecionado;
    private List<Setor> setores;
    private SetorFacade setorFacade;
    
    private Integer codigo;
    private String descricao;
 
    public SetorFacade getSetorFacade() {
        if (setorFacade == null) {
            setorFacade = new SetorFacade();
        }
        return setorFacade;
    }
 
    public Setor getSetor() {
        if (setor == null) {
            setor = new Setor();
        }
 
        return setor;
    }
 
    public void setSetor(Setor setor) {
        this.setor = setor;
    }
 
    public Setor getSetorSelecionado() {
    	setorSelecionado = new Setor();
    	setorSelecionado.setCodigo(30);
    	setorSelecionado.setDescricao("Setor de Teste");
		return setorSelecionado;
	}

	public void setSetorSelecionado(Setor setorSelecionado) {
		this.setorSelecionado = setorSelecionado;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    public List<Setor> getSetores() {
        if (setores == null) {
           // loadSetores();
        }
 
        return setores;
    }
    
    public void loadSetores(ActionEvent actionEvent) {
    	
    	getSetor().setCodigo(codigo);
    	getSetor().setDescricao(descricao);
    	        
    	setores = getSetorFacade().listarSetores(setor);
    	
    	if (setores.isEmpty()) {
    		setores = null;
    		sendInfoMessageToUser("Nenhum Registro Encontrado.");
    	}
    	
    	
    	//if (descricao != "") {
    		//Setor setorConsulta =  new Setor();
    		//setor.setDescricao(getSetor().getDescricao());
    		//setores = getSetorFacade().listarSetores(setorConsulta);
    		//setores = getSetorFacade().findAll();
    	//} else {
    		//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nenhum Registro Encontrado."));
    	//}
    	
    	//try {
    		//setores = getSetorFacade().findAll();
    	/*} catch (EJBException ejbException) {
    		sendErrorMessageToUser("EJBException:" + ejbException);
    	} catch (Exception exception) {
    		sendErrorMessageToUser("Exception:" + exception);
		}*/
    	
    }
    
    public void resetSetor() {
        setor = new Setor();
    }
    
    private void sendInfoMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
	}
	
	private void sendErrorMessageToUser(String message){
		FacesContext context = getContext();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}
	
	private FacesContext getContext() {
		FacesContext context = FacesContext.getCurrentInstance();
		return context;
	}

}

/*

public void createSetor() {
    try {
        getSetorFacade().createSetor(setor);
        closeDialog();
        displayInfoMessageToUsuario("Created With Sucess");
        loadSetores();
        resetSetor();
    } catch (Exception e) {
        keepDialogOpen();
        displayErrorMessageToUsuario("Ops, we could not create. Try again later");
        e.printStackTrace();
    }
}

public void updateSetor() {
    try {
        getSetorFacade().updateSetor(setor);
        closeDialog();
        displayInfoMessageToUsuario("Updated With Sucess");
        loadSetores();
        resetSetor();
    } catch (Exception e) {
        keepDialogOpen();
        displayErrorMessageToUsuario("Ops, we could not create. Try again later");
        e.printStackTrace();
    }
}

public void deleteSetor() {
    try {
        getSetorFacade().deleteSetor(setor);
        closeDialog();
        displayInfoMessageToUsuario("Deleted With Sucess");
        loadSetores();
        resetSetor();
    } catch (Exception e) {
        keepDialogOpen();
        displayErrorMessageToUsuario("Ops, we could not create. Try again later");
        e.printStackTrace();
    }
}*/