package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;
//import jdk.nashorn.internal.codegen.CompilerConstants.Call;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findByUserId() {
		user = userBusiness.findByUserId(user);
		if (Helpers.isExist(user))
			return SUCCESS;
		return ERROR;
	}

	public String signUpPage() {
		return SUCCESS;
	}

	public String signUp() {
		if (Helpers.isExist(user)) {
			// check password
			if (user.getPassword().equals(user.getPasswordConfirm())) {

				// check email
				if (Helpers.isExist(userBusiness.findByEmail(user))) {
					addActionError("Email exist");
					return ERROR;
				}

				// set password
				String password = user.getPassword();
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(password);
				user.setPassword(hashedPassword);

				// set date
				Date date = new Date();
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date = dt.parse(dt.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
					return ERROR;
				}
				user.setCreated_at(date);

				// signUp
				userBusiness.signUp(user);
				if (Helpers.isExist(user)) {
					return SUCCESS;
				}
			}
			addActionError("Password mismatch");
		}else{
			return INPUT;
		}
		return ERROR;
	}

	public String homePage() {

		return SUCCESS;
	}
}
