package framgiavn.project01.web.business;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public User findByUserId(User user);
	public User findByEmail(User user);
	public User signUp(User user);
}
