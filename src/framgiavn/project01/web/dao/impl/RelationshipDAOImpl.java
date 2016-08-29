package framgiavn.project01.web.dao.impl;

import org.hibernate.Query;

import framgiavn.project01.web.dao.RelationshipDAO;
import framgiavn.project01.web.model.Relationship;
import framgiavn.project01.web.ulti.Logit2;

public class RelationshipDAOImpl extends GenericDAOImpl<Relationship, Integer> implements RelationshipDAO {

	private static final Logit2 log = Logit2.getInstance(RelationshipDAO.class);

	public RelationshipDAOImpl() {
		super(Relationship.class);
		// TODO Auto-generated constructor stub
	}

	protected void initDAO() {
		// Do nothing
	}

	@Override
	public Relationship checkFollowed(Integer follower_id, Integer following_id) {

		log.debug("Check if exist");
		try {
			Query query = getSession().getNamedQuery("Relationship.ExistFollow");
			query.setParameter("follower_id", follower_id);
			query.setParameter("following_id", following_id);
			return (Relationship) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("Check failed");
			throw re;
		}

	}
}
