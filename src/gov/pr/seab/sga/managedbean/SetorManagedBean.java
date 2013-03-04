package gov.pr.seab.sga.managedbean;

import gov.pr.seab.sga.bean.Setor;
import gov.pr.seab.sga.facade.SetorFacade;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class SetorManagedBean extends AbstractManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	 
    private Setor setor;
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
    }
 
    public List<Setor> getSetores() {
        if (setores == null) {
            loadSetores();
        }
 
        return setores;
    }
 
    private void loadSetores() {
        //setores = getSetorFacade().listAll();
    	if (getDescricao() != null) {
    		Setor setorConsulta =  new Setor();
    		setor.setDescricao(getSetor().getDescricao());
    		setores = getSetorFacade().listarSetores(setorConsulta);
    	}
    }
 
    public void resetSetor() {
        setor = new Setor();
    }

}
