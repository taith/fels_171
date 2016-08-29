package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;

public class Relationship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int relationship_id;
	private int following_id;
	private int follower_id;
	private Date created_at;
	private Date updated_at;
	
	public int getRelationship_id() {
		return relationship_id;
	}
	public void setRelationship_id(int relationship_id) {
		this.relationship_id = relationship_id;
	}
	public int getFollowing_id() {
		return following_id;
	}
	public void setFollowing_id(int following_id) {
		this.following_id = following_id;
	}
	public int getFollower_id() {
		return follower_id;
	}
	public void setFollower_id(int follower_id) {
		this.follower_id = follower_id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}


}
