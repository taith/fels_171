<%@ taglib prefix="s" uri="/struts-tags"%>

<h2>
	${pageContext.request.userPrincipal.name} You are Admin<br>
	<a href="j_spring_security_logout">Logout</a>
</h2>

<a href="<s:url value="/admin/user"/>">Manage User</a>
