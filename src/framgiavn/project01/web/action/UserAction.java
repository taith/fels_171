package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import javax.mail.internet.NewsAddress;
import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import java.text.ParseException;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import framgiavn.project01.web.business.RelationshipBusiness;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.Relationship;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;

public class UserAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private RelationshipBusiness relationshipBusiness;

	private User user = null;
	private List<User> userAllList = new ArrayList<User>();
	private List<User> listFollowingUser = new ArrayList<User>();
	private List<User> listUserFollower = new ArrayList<User>();

	private boolean followed;

	public boolean isFollowed() {
		return followed;
	}

	public void setFollowed(boolean followed) {
		this.followed = followed;
	}

	public List<User> getListFollowingUser() {
		return listFollowingUser;
	}

	public void setListFollowingUser(List<User> listFollowingUser) {
		this.listFollowingUser = listFollowingUser;
	}

	public List<User> getListUserFollower() {
		return listUserFollower;
	}

	public void setListUserFollower(List<User> listUserFollower) {
		this.listUserFollower = listUserFollower;
	}

	public List<User> getUserAllList() {
		return userAllList;
	}

	public void setUserAllList(List<User> userAllList) {
		this.userAllList = userAllList;
	}

	private String userImageFileName;
	private HttpServletRequest servletRequest;
	private File userImage;

	private String newName;

	private String password;
	private String newPassword;
	private String confirmPassword;

	public void setRelationshipBusiness(RelationshipBusiness relationshipBusiness) {
		this.relationshipBusiness = relationshipBusiness;
	}

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

		User currentUser = getUserFromSession();

		user = userBusiness.findByUserId(user);

		/* Declare list following and follower */
		List<Relationship> listFollowing, listFollower = new ArrayList<Relationship>();

		if (Helpers.isExist(user)) {
			
			/* Check if has relationship return true */
			followed = relationshipBusiness.checkFollowed(
					currentUser.getUser_id(), user.getUser_id());

			listFollowing = relationshipBusiness.findFollowingById(user);

			/* Add following user to list */
			Iterator<Relationship> iteratorFollowing = listFollowing.iterator();
			while (iteratorFollowing.hasNext()) {
				try {
					User following = userBusiness.findById(iteratorFollowing.next().getFollowing_id(), false);
					listFollowingUser.add(following);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					addActionError("Cannot find following user");
					e.printStackTrace();
				}

			}

			listFollower = relationshipBusiness.findFollowerById(user);

			/* Add follower user to list */
			Iterator<Relationship> iteratorFollower = listFollower.iterator();
			while (iteratorFollower.hasNext()) {
				try {
					User follower = userBusiness.findById(iteratorFollower.next().getFollower_id(), false);
					listUserFollower.add(follower);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					addActionError("Cannot find follower user");
					e.printStackTrace();
				}
			}

			return SUCCESS;
		}

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
				String password = user.getPassword();
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(password);
				user.setPassword(hashedPassword);

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

	public String addNewUser() {

		if (Helpers.isExist(user)) {

			/* Check if email exist then add user */
			if (Helpers.isEmpty(userBusiness.checkEmailExist(user))) {
				userBusiness.addNewUser(user);
				if (Helpers.isExist(user)) {
					return SUCCESS;
				}
			} else {
				addActionError("Email exist");
				return ERROR;
			}

		} else
			return INPUT;
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
			String fileName = user.getUser_id() + ".png";
			String filePath = servletRequest.getSession().getServletContext().getRealPath("/") + "fileUpload";
			File destFile = new File(filePath, fileName);
			FileUtils.copyFile(userImage, destFile);
			user.setAvatar("fileUpload/" + fileName);
			userBusiness.update(user);
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
		userBusiness.update(user);
		return SUCCESS;
	}

	public String changePassword() {
		user = getUserFromSession();
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		boolean isMatch = passwordEncoder.matches(password, user.getPassword());
		if (isMatch) {
			if (newPassword.equals(confirmPassword) && !newPassword.equals("")) {
				user.setPassword(convertBcryptPassword(newPassword));
				userBusiness.update(user);
				return SUCCESS;
			} else {
				addActionError("New password mismatch");
				return ERROR;
			}
		}
		addActionError("Wrong current password");
		return ERROR;
	}

	public String convertBcryptPassword(String password) {
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

	public String userAllPage() {
		userAllList = userBusiness.listAllUser();

		return SUCCESS;
	}

	public String activeUser() {
		userBusiness.activeUser(user);
		return SUCCESS;
	}

	public String deactiveUser() {
		userBusiness.deactiveUser(user);
		return SUCCESS;
	}

	public String adminEditUser() {
		try {
			userBusiness.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			addActionError("Update falied");
			return ERROR;
		}

		return SUCCESS;
	}

	public String followUser() {
		
		User currentUser = getUserFromSession();
		try {
			relationshipBusiness.followUser(currentUser.getUser_id(), user.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError("Follow Failed");
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String unFollowUser() {
		
		User currentUser = getUserFromSession();
		
		try {
			relationshipBusiness.unFollowUser(currentUser.getUser_id(), user.getUser_id());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			addActionError("UnFollow Failed");
			e.printStackTrace();
		}

		return SUCCESS;
	}
}
