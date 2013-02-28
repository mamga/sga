package gov.pr.seab.sga.dao.factory;

import gov.pr.seab.sga.dao.ProtocoloDAO;


public abstract class DAOFactory {
	public static final int MAINFRAME = 1;
	
	public static DAOFactory getDAOFactory(int whichFactory) {  
		switch (whichFactory) {
	    	case MAINFRAME: 
	    		return new MainFrameDAOFactory();
	    	default: 
	    		return null;
	    }
	}
	
	public abstract ProtocoloDAO getProtocoloDAO();
	
	
}