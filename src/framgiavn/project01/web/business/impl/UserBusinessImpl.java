package framgiavn.project01.web.business.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		try {
			/* Encode password */
			String password = user.getPassword();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			user.setPassword(hashedPassword);
			
			/* Set create at and role for user */
			user.setCreated_at(new Date());
			user.setRole("ROLE_USER");
			userDAO.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(User user) {
		try {
			User userDB = userDAO.findById(user.getUser_id(), true);
			
			userDB.setName(user.getName());
			userDB.setEmail(user.getEmail());
			if(user.getPassword()!=null)
				userDB.setPassword(user.getPassword());
			userDB.setRole(user.getRole());
			userDB.setUpdated_at(new Date());
			userDAO.update(userDB);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public ArrayList<User> checkEmailExist(User user) {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<User>) userDAO.findByProperty("email", user.getEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> listAllUser() {
		// TODO Auto-generated method stub
		try {
			return userDAO.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			userDAO.delete(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User activeUser(User user) {
		// TODO Auto-generated method stub
		try {
			User userDB = userDAO.findById(user.getUser_id(), true);
			userDB.setUser_id(user.getUser_id());
			userDB.setEnabled(true);
			
			userDAO.update(userDB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User deactiveUser(User user) {
		// TODO Auto-generated method stub
		try {
			User userDB = userDAO.findById(user.getUser_id(), true);
			userDB.setUser_id(user.getUser_id());
			userDB.setEnabled(false);
			
			userDAO.update(userDB);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findById(Integer user_id, boolean lock) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.findById(user_id);
	}
}
