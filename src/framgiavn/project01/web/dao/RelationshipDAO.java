package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.Relationship;

public interface RelationshipDAO extends GenericDAO<Relationship, Integer> {
	
	public Relationship checkFollowed(Integer follower_id, Integer following_id);

}
