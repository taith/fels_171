<%@ taglib prefix="s" uri="/struts-tags"%>

<font color="red"><s:actionerror /></font>

<div class="user-detail">
	<img src="../<s:property value="user.avatar"/>"
		style="width: 100px; height: auto;" /> <br />
	<s:property value="user.name" />
	<br /> Join in :
	<s:property value="user.created_at" />
</div>
<br>

<s:if test="followed">
	<s:url action="unfollow" var="unFollowUser">
		<s:param name="user.user_id">
			<s:property value="user.user_id" />
		</s:param>
	</s:url>
	<a href="${unFollowUser}"><button type="button"
			class="btn btn-danger">Unfollow</button></a>
</s:if>
<s:else>
	<s:url action="follow" var="followUser">
		<s:param name="user.user_id">
			<s:property value="user.user_id" />
		</s:param>
	</s:url>
	<a href="${followUser}"><button type="button"
			class="btn btn-success">Follow</button></a>
</s:else>
<div class="clear-fix" style="padding-bottom: 30px;"></div>

<div class="user-edit">
	<a class="btn btn-primary" role="button" data-toggle="collapse"
		href="#collapseEdit" aria-expanded="false"
		aria-controls="collapseEdit"> Edit </a>
	<s:url action="/admin/user/update" var="editUser">
		<s:param name="user.user_id">${user_id}</s:param>
	</s:url>
	<div class="collapse" id="collapseEdit">
		<div class="well">
			<s:form action="/admin/user/update?user.user_id=%{user.user_id}"
				method="POST">
				<div class="form-group">
					<input type="text" required name="user.name"
						value="<s:property value="user.name"/>" class="form-control">
				</div>
				<div class="form-group">
					<input type="email" required name="user.email"
						value="<s:property value="user.email"/>" placeholder="Email"
						class="form-control">
				</div>
				<div class="form-group">
					<select name="user.role">
						<option value="ROLE_USER" selected>ROLE_USER</option>
						<option value="ROLE_ADMIN">ROLE_ADMIN</option>
					</select>
				</div>
				<div class="form-group">
					<input type="submit" value="Save" class="btn btn-default">
				</div>
			</s:form>
		</div>
	</div>
</div>

<div class="clear-fix" style="padding-bottom: 30px;"></div>
<h3>Follow Info</h3>
<div class="follower-info col-md-5">
	<div class="panel panel-primary">
		<div class="panel-body">Follower</div>
		<div class="panel-footer">
			<s:if test="listUserFollower.size()>0">
				<s:iterator value="listUserFollower"
					status="listFollowingUserStatus">
					<img src="../<s:property value="user.avatar"/>"
						style="width: 100px; height: auto;" />
					<a
						href="<s:url value="/user/findByUserId"/><s:property value="user_id"/>"><s:property
							value="name" /></a>
				</s:iterator>
			</s:if>
			<s:else>
				<div class="alert alert-info" role="alert">Hasn't info</div>
			</s:else>
		</div>
	</div>
</div>
<div class="following-info col-md-5">
	<div class="panel panel-primary">
		<div class="panel-body">Following</div>
		<div class="panel-footer">
			<s:if test="listFollowingUser.size()>0">
				<s:iterator value="listFollowingUser"
					status="listUserFollowerStatus">
					<img src="../<s:property value="user.avatar"/>"
						style="width: 100px; height: auto;" />
					<a
						href="<s:url value="/user/findByUserId"/><s:property value="user_id"/>"><s:property
							value="name" /></a>
				</s:iterator>
			</s:if>
			<s:else>
				<div class="alert alert-info" role="alert">Hasn't info</div>
			</s:else>
		</div>
	</div>
</div>
