package framgiavn.project01.web.business;

import java.util.ArrayList;
import java.util.List;

import framgiavn.project01.web.model.User;

public interface UserBusiness {
	public User findByUserId(User user);
	public User findByEmail(User user);
	public List<User> findByEmail(String email);
	public User signUp(User user);

	public User findById(Integer user_id, boolean lock) throws Exception;

	public void update(User user);
	
	public List<User> listAllUser();
	
	public User deleteUser(User user);
	
	public User activeUser(User user);
	
	public User deactiveUser(User user);
	
	public User addNewUser(User user);

	public ArrayList<User> checkEmailExist(User user);
}
