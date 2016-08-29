package framgiavn.project01.web.business;

import java.util.ArrayList;
import java.util.List;

import framgiavn.project01.web.model.*;

public interface RelationshipBusiness {

	public ArrayList<Relationship> findFollowingById(User user);
	
	public ArrayList<Relationship> findFollowerById(User user);
	
	public boolean checkFollowed(Integer follower_id, Integer following_id);
	
	public Relationship followUser(Integer follower_id, Integer following_id);
	
	public Relationship unFollowUser(Integer follower_id, Integer following_id);
}
