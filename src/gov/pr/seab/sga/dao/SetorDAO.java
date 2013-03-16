package gov.pr.seab.sga.dao;

import gov.pr.seab.sga.bean.Setor;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

/*@Stateless
public class SetorDAO extends GenericDAO<Setor> {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(SetorDAO.class);
	
	public SetorDAO() {
		super(Setor.class);
	}
	
}*/

public class SetorDAO extends GenericDAO<Setor> {

	private static final long serialVersionUID = 1L;
	
	private static final Logger LOGGER = Logger.getLogger(SetorDAO.class);
	
	private static EntityManagerFactory factory;
	
	public SetorDAO() {
		super(Setor.class);
	}
	
	public List<Setor> listar(Setor setor) {
		//Criteria criteria = null;
		List<Setor> setores = null;
		try{
			LOGGER.info("# Iniciando método de dao SetorDAO.listar(setor");
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Setor> cq = cb.createQuery(Setor.class);
			Root<Setor> setorConsulta = cq.from(Setor.class);
			cq.select(setorConsulta);
			TypedQuery<Setor> q = em.createQuery(cq);
			setores = q.getResultList();
			
			
			
			
			
			
			/*Session session = (Session) HibernateUtil.getSessionFactory();
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
									
			session.close();*/
		
		}catch(Exception e){
			LOGGER.error(e);
			LOGGER.error("# Erro ao executar método de dao SetorHibernateDAO.listar(setor, paginaAtual, quantidade) : List<Setor> ");
		}
		finally{
			try {
				
			} catch (Exception e) {
				LOGGER.error(e);
				LOGGER.error("# Erro ao fechar sessão SetorHibernateDAO.listar(setor, paginaAtual, quantidade) : List<Setor> ");
			}
		}
		//return criteria.list();
		return setores;
	}
}
	

	

