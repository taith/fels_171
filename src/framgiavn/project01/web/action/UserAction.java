package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.mail.internet.NewsAddress;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.text.ParseException;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;

public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;

	private String userImageFileName;
	private HttpServletRequest servletRequest;
	private File userImage;

	private String newName;

	private String password;
	private String newPassword;
	private String confirmPassword;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String findByUserId() {
		user = userBusiness.findByUserId(user);
		if (Helpers.isExist(user))
			return SUCCESS;
		return ERROR;
	}

	public String signUp() {
		/* check exist user */
		if (Helpers.isExist(user)) {
			/* check password */
			if (user.getPassword().equals(user.getPasswordConfirm())) {
				/* check email */
				if (Helpers.isExist(userBusiness.findByEmail(user))) {
					addActionError("Email exist");
					return INPUT;
				}

				/* set password */
				convertBcryptPassword(user.getPassword());

				/* set date */
				Date date = new Date();
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					date = dt.parse(dt.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
					return ERROR;
				}
				user.setCreated_at(date);

				/* signUp */
				userBusiness.signUp(user);
				return SUCCESS;
			}
			addActionError("Password mismatch");
			return INPUT;
		}
		return ERROR;
	}

	public String profile() {
		user = getUserFromSession();
		return SUCCESS;
	}

	/* Edit profile allows change avatar, name, password */
	public String editProfile() {
		return SUCCESS;
	}

	public String updateAvatar() {
		if (userImage == null) {
			return INPUT;
		}
		try {
			user = getUserFromSession();
			String fileName=user.getUser_id()+".png";
			String filePath = servletRequest.getSession().getServletContext().getRealPath("/") + "fileUpload";
			File destFile = new File(filePath, fileName);
			FileUtils.copyFile(userImage, destFile);
			user.setAvatar("fileUpload/" + fileName);
			userBusiness.upadte(user);
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Content type not allowed (only jpg, png, jpeg, pjpeg)");
			return INPUT;
		}
		return SUCCESS;
	}

	public String changeName() {
		user = getUserFromSession();
		System.out.println("New name : " + newName);
		if (newName.equals("")) {
			return ERROR;
		}
		user.setName(newName);
		userBusiness.upadte(user);
		return SUCCESS;
	}

	public String changePassword() {
		user=getUserFromSession();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isMatch = passwordEncoder.matches(password, user.getPassword());
		if (isMatch) {
			if (newPassword.equals(confirmPassword)&&!newPassword.equals("")) {
				user.setPassword(convertBcryptPassword(newPassword));
				userBusiness.upadte(user);
				return SUCCESS;
			}else
			{
				addActionError("New password mismatch");
				return ERROR;
			}
		}
		addActionError("Wrong current password");
		return ERROR;
	}

	public String convertBcryptPassword(String password){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	public User getUserFromSession() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String email = auth.getName(); // get logged in username
		return userBusiness.findByEmail(email).get(0);
	}

	public String homePage() {
		return SUCCESS;
	}
}
