package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;

public class UserBusinessImpl implements UserBusiness {

	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findByUserId(User user) {
		try {
			return userDAO.findById(user.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User signUp(User user) {
		try {
			userDAO.save(user);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByEmail(User user) {
		try {
			return (User) userDAO.findByProperty("email", user.getEmail()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
