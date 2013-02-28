package gov.pr.seab.sga.dao.factory;

import gov.pr.seab.sga.dao.ProtocoloDAO;
import gov.pr.seab.sga.dao.implementation.ProtocoloMainFrameDAO;


public class MainFrameDAOFactory extends DAOFactory {
	
	public ProtocoloDAO getProtocoloDAO() {
		return new ProtocoloMainFrameDAO();
	}

}