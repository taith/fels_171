package framgiavn.project01.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class AccountDetails implements UserDetailsService {
	
	private framgiavn.project01.web.model.User user;
	private framgiavn.project01.web.dao.UserDAO userDAO;
	
	public framgiavn.project01.web.dao.UserDAO getUserDao() {
		return userDAO;
	}

	public framgiavn.project01.web.model.User getUser() {
		return user;
	}

	public void setUser(framgiavn.project01.web.model.User user) {
		this.user = user;
	}


	public framgiavn.project01.web.dao.UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(framgiavn.project01.web.dao.UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		try {
			user = userDAO.findByEmail(email);
			if(user == null)
				throw new UsernameNotFoundException("User Not Found");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String emails = user.getEmail();
		String password = user.getPassword();
		boolean enabled = user.isEnabled();
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new org.springframework.security.core.userdetails.User(
				emails, password, enabled, true, true, true, authorities);
	}

}
