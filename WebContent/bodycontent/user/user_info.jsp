<%@ taglib prefix="s" uri="/struts-tags"%>

<font color="red"><s:actionerror /></font>

<img src="../<s:property value="user.avatar"/>" style="width: 100px;height:auto;"/><br/>
<s:property value="user.name" /><br/>
Join in :<s:property value="user.created_at"/><br/>

<a class="btn btn-primary" role="button" data-toggle="collapse" href="#collapseEdit" 
		aria-expanded="false" aria-controls="collapseEdit">
  Edit
</a>
<s:url action="/admin/user/update" var="editUser">
	<s:param name="user.user_id">${user_id}</s:param>
</s:url>
<div class="collapse" id="collapseEdit">
  <div class="well">
  	<s:form action="/admin/user/update?user.user_id=%{user.user_id}" method="POST" >
	    <div class="form-group">
			<input type="text" required name="user.name" value="<s:property value="user.name"/>" class="form-control">
		</div>
		<div class="form-group">
			<input type="email" required name="user.email" value="<s:property value="user.email"/>" placeholder="Email" class="form-control">
		</div>
		<div class="form-group">
			<s:select name="user.role" list="#{'1':'ROLE_ADMIN', '2':'ROLE_USER'}" value="2" />
		</div>
		<div class="form-group">
			<input type="password" required="required" pattern=".{3,16}" name="user.password" placeholder="Current password" class="form-control">
		</div>
		<div class="form-group">
			<input type="password" name="newPassword"  placeholder="New password (if no input for this field for keeping the old password)" class="form-control">
		</div>
		<div class="form-group">
			<input type="password" name="confirmPassword"  placeholder="Confirm password" class="form-control">
		</div>		
		<div class="form-group">
			<input type="submit"  value="Save" class="btn btn-default">
		</div>
	</s:form>
  </div>
</div>
