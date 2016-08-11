package framgiavn.project01.web.action;

import java.util.Collection;
import java.util.Iterator;

import com.opensymphony.xwork2.ActionSupport;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import framgiavn.project01.web.action.LoginAction;

public class LoginAction extends ActionSupport {
	
	public String homePage() {
		
		return SUCCESS;
	}

	
	public String welcomePage() {
					
		return SUCCESS;
	}
	
	public String adminPage() {
		
		return SUCCESS;
	}
	
	public String accessDeniedPage() {
		
		return SUCCESS;
	}
}
