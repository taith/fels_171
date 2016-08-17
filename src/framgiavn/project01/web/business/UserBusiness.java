package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public User findByUserId(User user);
	public User findByEmail(User user);
	public List<User> findByEmail(String email);
	public User signUp(User user);
	public void upadte(User user);
}
