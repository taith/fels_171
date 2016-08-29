<%@ taglib prefix="s" uri="/struts-tags"%>

<a class="btn btn-default" href="<s:url value="/admin/user/new"/>">Add
	New User</a>
<div class="clear-fix" style="padding-bottom: 30px;"></div>
<s:if test="userAllList.size()>0">
	<s:iterator value="userAllList" status="courseStatus">
		<div class="panel panel-info">
			<div class="panel-heading">
				<a
					href="<s:url value="/user/findByUserId"/><s:property value="user_id"/>"><s:property
						value="name" /></a>
			</div>
			<div class="panel-body">
				<div>
					<s:url action="user/delete" var="deleteUser">
						<s:param name="user.user_id">${user_id}</s:param>
					</s:url>
					<a href="${deleteUser }"><i class="glyphicon glyphicon-trash"></i>Delete</a>
					<s:if test="enabled==true">
						<s:url action="user/deactive" var="deactiveUser">
							<s:param name="user.user_id">${user_id}</s:param>
						</s:url>
						<a href="${deactiveUser }"><i
							class="glyphicon glyphicon-minus"></i><font color="red">Deactive</font></a>
					</s:if>
					<s:else>
						<s:url action="user/active" var="activeUser">
							<s:param name="user.user_id">${user_id}</s:param>
						</s:url>
						<a href="${activeUser }"><i class="glyphicon glyphicon-plus"></i><font
							color="green">Active</font></a>
					</s:else>
				</div>
			</div>
		</div>
	</s:iterator>
</s:if>
<s:else>
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		<span class="sr-only">Error:</span> Nothing in DB :(
	</div>
</s:else>
