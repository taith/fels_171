package framgiavn.project01.web.action;

import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.action.LoginAction;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

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
