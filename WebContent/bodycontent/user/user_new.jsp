<%@ taglib prefix="s" uri="/struts-tags"%>

<font color=""><s:actionerror/></font>
<h2>Imput User Info</h2>
<div>
	<form action="new" method="post">
		E-mail :<input type="email" name="user.email" required="required" ></input><br/>
		Password :<input type="password" name="user.password" required="required"></input><br/>
		Name :<input name="user.name" required="required"></input><br/>
		<input type="submit" value="Add" onclick="myFunction()"></input>
		<input type="reset" value="Reset"></input>
	</form>
</div>
