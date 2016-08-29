package framgiavn.project01.web.business.impl;

import java.util.ArrayList;
import java.util.Date;

import framgiavn.project01.web.business.RelationshipBusiness;
import framgiavn.project01.web.dao.RelationshipDAO;
import framgiavn.project01.web.model.Relationship;
import framgiavn.project01.web.model.User;

public class RelationshipBusinessImpl implements RelationshipBusiness {

	private RelationshipDAO relationshipDAO;
	private Relationship relationshipDB;

	public RelationshipDAO getRelationshipDAO() {
		return relationshipDAO;
	}

	public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
		this.relationshipDAO = relationshipDAO;
	}

	@Override
	public ArrayList<Relationship> findFollowingById(User user) {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<Relationship>) relationshipDAO.findByProperty("follower_id", user.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Relationship> findFollowerById(User user) {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<Relationship>) relationshipDAO.findByProperty("following_id", user.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean checkFollowed(Integer follower_id, Integer following_id) {
		// TODO Auto-generated method stub
		Relationship relationshipDB = relationshipDAO.checkFollowed(follower_id, following_id);
		if (relationshipDB == null)
			return false;
		return true;
	}

	@Override
	public Relationship followUser(Integer follower_id, Integer following_id) {
		// TODO Auto-generated method stub
		Relationship relationship = new Relationship();
		relationship.setFollower_id(follower_id);
		relationship.setFollowing_id(following_id);
		relationship.setCreated_at(new Date());
		try {
			relationshipDAO.save(relationship);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Relationship unFollowUser(Integer follower_id, Integer following_id) {
		
		Relationship relationshipDB = relationshipDAO.checkFollowed(follower_id, following_id);
		
		try {
			relationshipDAO.delete(relationshipDB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
