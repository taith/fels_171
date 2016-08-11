package framgiavn.project01.web.dao.impl;

import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Logit2;

public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	private static final Logit2 log = Logit2.getInstance(UserDAOImpl.class);
	public static final String NAME = "customerName";

	public UserDAOImpl() {
		super(User.class);
	}

	protected void initDAO() {
		// Do nothing
	}
}
