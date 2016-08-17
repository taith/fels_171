package framgiavn.project01.web.business.impl;

import java.util.List;

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

	@Override
	public List<User> findByEmail(String email) {
		try {
			return userDAO.findByProperty("email", email);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void upadte(User user) {
		try {
			userDAO.update(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
