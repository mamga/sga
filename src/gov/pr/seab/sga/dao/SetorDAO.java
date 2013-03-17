package gov.pr.seab.sga.dao;

import gov.pr.seab.sga.bean.Setor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
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
		List<Setor> setores = null;
		try{
			LOGGER.info("# Iniciando método de dao SetorDAO.listar(setor)");

			em = emf.createEntityManager();
	        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	        CriteriaQuery<Setor> query = criteriaBuilder.createQuery(Setor.class);
			Root<Setor> root = query.from(Setor.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			
			if ((setor.getCodigo() != null) && (setor.getCodigo() != 0)) {
				predicates.add(criteriaBuilder.equal(root.<Integer>get("codigo"), setor.getCodigo()));
			}
			if ((setor.getDescricao() != null) && (setor.getDescricao() != "")){
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("descricao")), "%" + setor.getDescricao().toLowerCase() + "%"));
			}
			
			TypedQuery<Setor> typedQuery = em.createQuery(
				    query.select(root )
				    .where( predicates.toArray(new Predicate[]{}) )
				    .orderBy(criteriaBuilder.asc(root.get("descricao")))
				);
			
	        setores = typedQuery.getResultList();
	        
		}catch(Exception e){
			LOGGER.error(e);
			LOGGER.error("# Erro ao executar método de dao SetorDAO.listar(setor)");
		}
		finally{
			try {
				em.close();
			} catch (Exception e) {
				LOGGER.error(e);
				LOGGER.error("# Erro ao executar método de dao SetorDAO.listar(setor)");
			}
		}
		return setores;
	}
}
	

	

