<%@ taglib prefix="s" uri="/struts-tags"%>
<s:actionerror/>
<div>
	<form action="signup" method="post">
		E-mail :<input type="email" name="user.email" required="required" ></input><br/>
		Password :<input type="password" name="user.password" required="required"></input><br/>
		Confirm Password :<input type="password" name="user.passwordConfirm" required="required"></input><br/>
		Name :<input name="user.name" required="required"></input><br/>
		<input type="submit" value="Sign Up" onclick="myFunction()"></input>
	</form>
</div>
