package gov.pr.seab.sga.facade;

import gov.pr.seab.sga.dao.SetorDAO;
import gov.pr.seab.sga.bean.Setor;

import java.io.Serializable;
import java.util.List;


 
public class SetorFacade implements Serializable{
    private static final long serialVersionUID = 1L;
 
    private SetorDAO setorDAO = new SetorDAO();
 
    public void createSetor(Setor setor) {
        setorDAO.beginTransaction();
        setorDAO.save(setor);
        setorDAO.commitAndCloseTransaction();
    }
 
    public void updateSetor(Setor setor) {
        setorDAO.beginTransaction();
        Setor persistedSetor = setorDAO.find(setor.getCodigo());
        persistedSetor.setDescricao(setor.getDescricao());
        setorDAO.update(persistedSetor);
        setorDAO.commitAndCloseTransaction();
    }
 
    public Setor findSetor(int setorId) {
        setorDAO.beginTransaction();
        Setor setor = setorDAO.find(setorId);
        setorDAO.closeTransaction();
        return setor;
    }
 
    public List<Setor> listAll() {
        setorDAO.beginTransaction();
        List<Setor> result = setorDAO.findAll();
        setorDAO.closeTransaction();
        return result;
    }
 
    public void deleteSetor(Setor setor) {
        setorDAO.beginTransaction();
        Setor persistedSetor = setorDAO.findReferenceOnly(setor.getCodigo());
        setorDAO.delete(persistedSetor);
        setorDAO.commitAndCloseTransaction();
    }
    
    public List<Setor> listarSetores(Setor setor) {
    	return setorDAO.listar(setor);
    }
    
}
