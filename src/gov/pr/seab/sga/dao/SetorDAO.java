package gov.pr.seab.sga.dao;

import gov.pr.seab.sga.bean.Setor;
import gov.pr.seab.sga.util.HibernateUtil;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class SetorDAO extends GenericDAO<Setor> {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(SetorDAO.class);
	
	private static EntityManagerFactory factory;
	
	public SetorDAO() {
		super(Setor.class);
	}
	
	public List<Setor> listar(Setor setor) {
		Criteria criteria = null;
		try{
			LOGGER.info("# Iniciando método de dao SetorDAO.listar(setor");
			Session session = (Session) HibernateUtil.getSessionFactory();
			criteria = session.createCriteria(Setor.class);
			if(setor!=null){
				if(setor.getCodigo() != null){
					criteria.add(Restrictions.eq("codigo", setor.getCodigo()));
				}
				if(StringUtils.isNotBlank(setor.getDescricao())){
					criteria.add(Restrictions.eq("descricao", setor.getDescricao()));
				}
			}
			
			criteria.addOrder(Order.asc("descricao"));
									
			session.close();
		
		}catch(Exception e){
			LOGGER.error(e);
			LOGGER.error("# Erro ao executar método de dao SetorHibernateDAO.listarPaginado(setor, paginaAtual, quantidade) : List<Setor> ");
		}
		/*finally{
			try {
				
			} catch (Exception e) {
				LOGGER.error(e);
				LOGGER.error("# Erro ao fechar sessão SetorHibernateDAO.listarPaginado(setor, paginaAtual, quantidade) : List<Setor> ");
			}
		}*/
		return criteria.list();
	}
	
	

	

}
